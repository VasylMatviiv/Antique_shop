package com.cybo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cybo.domain.CreateItemRequest;
import com.cybo.domain.EditItemRequest;
import com.cybo.entity.Custom;
import com.cybo.entity.ItemMake;
import com.cybo.entity.ItemModel;
import com.cybo.entity.Type;
import com.cybo.entity.UserEntity;
import com.cybo.entity.enumeration.BodyType;
import com.cybo.entity.enumeration.Material;
import com.cybo.mail.Mail;
import com.cybo.mapper.ItemModelMapper;
import com.cybo.service.CustomService;
import com.cybo.service.EmailService;
import com.cybo.service.ItemService;
import com.cybo.service.MakeService;
import com.cybo.service.TypeService;
import com.cybo.service.UserService;


@Controller
@RequestMapping("/admin")
@SessionAttributes("editItemsModel")
public class AdminController {
	
	@Autowired
	private ItemService itemService; 
	@Autowired
	private MakeService makeService;
	@Autowired
	private TypeService typeService;
	@Autowired 
	private CustomService customService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;

	@GetMapping("/admin")
	public String showprofile(Principal priytipal, Model model) {
		UserEntity entity = userService.findUserByEmail(priytipal.getName());
		model.addAttribute("user", entity);
		return"admin/admin-profile";
	}
	
	@GetMapping("/additem")
	public String showAddItem(Model model) {

		
		model.addAttribute("modelRequest", new CreateItemRequest() );
		List<Type> typeList = typeService.findAllType();
		model.addAttribute("listType", typeList);
		
		List<ItemMake> make = makeService.findAllItemMake();
		model.addAttribute("makers", make);
		
		model.addAttribute("typeMaterial", Material.values());
		model.addAttribute("bodyModel", BodyType.values());
		model.addAttribute("itemModel", new ItemModel());
		
		
		
		return"admin/add_item";
	}
	@PostMapping("/addItem")
	public String  saveItem(@ModelAttribute("modelRequest") CreateItemRequest request) throws IOException{

		if(result.hasErrors()) {
			System.out.println(request.toString());
			return"admin/add_item";
		}
		System.out.println("dfhvsuedirhfoesdhfiseolhfisef;isoehj;");
		System.out.println(request.toString());
		ItemModel itemModel = new ItemModel();
		itemModel = ItemModelMapper.addRequestToItemModel(request);
		System.out.println(itemModel.toString());
		
		itemService.saveItem(itemModel);
		
		CustomFileUtils.createFolder("item_"+itemModel.getId());
		CustomFileUtils.createImage("item_"+itemModel.getId(), request.getItemImage());
		
		return"redirect:/admin/admin";
	}
	@GetMapping("/addMaker")
	public String showAddMaker(Model model) {
		model.addAttribute("itemMake", new ItemMake());
		return"admin/add_maker";
	}
	@PostMapping("/addMaker")
	public String addMaker(@RequestParam("maker") @Valid String title, BindingResult result) {

		if(result.hasErrors()) {
			return "admin/add-maker";
		}

		ItemMake make = new ItemMake();
		make.setTitle(title);
		makeService.saveMaker(make);
		return"redirect:/admin/admin";

	}
	@PostMapping("/addMaker")
	public String addMaker(@ModelAttribute("itemMake") @Valid ItemMake itemMake, BindingResult result) {
		
		if(result.hasErrors()) {
			return"admin/add_maker";
		}
		
		makeService.saveMaker(itemMake);
		return"redirect:/admin/admin";
		
	}
	
	
	@GetMapping("/addType")
	public String showAddEngine() {
		return"admin/add_type";
	}
	@PostMapping("/addType")
	public String saveType(@ModelAttribute("typeModel") Type type) {
		Type type = new Type();
		type.setTitle(title);
		type.setCapacity(capacity);
		type.setPower(power);
		typeService.saveType(type);
		return"redirect:/admin/admin";
	}

	
	@GetMapping("/custom")
	public String showCustonPage(Model model) {
		List<Custom> customList = customService.findAllCustomByStatus(false);
		model.addAttribute("customListModel", customList);
		return"admin/custom";
	}
	@PostMapping("/custom")
	public String confirmedCuston() {
		return"redirect:/admin/custom";
	}
	@GetMapping("/edit/{itemId}")
	public String editItem(@PathVariable("itemId") int itemId, Model model, Principal pritipal ) {
		ItemModel itemModel = itemService.getItemById(itemId);
		
		if(itemId!=itemModel.getId()) {
			return"redirect:/admin/itemList";
		}
		EditItemRequest request = ItemModelMapper.itemToRequest(itemModel);
		List<Type> type = typeService.findAllType();
		model.addAttribute("typeList", type);
		model.addAttribute("editItemModel", request);
		
		return"admin/edit_item";
	}
	
	@PostMapping("/edit/{itemId}")
	public String saveEditItemModel(@ModelAttribute("editItemModel") EditItemRequest request, @PathVariable("itemId") int itemId ) {
		
		ItemModel itemModel = ItemModelMapper.editItemToEntity(request);
		
		itemService.saveItem(itemModel);
		return"redirect:/admin/admin";
	}
	
	@GetMapping("/confirm/{customId}")
	public String confirmOrder(@PathVariable("customId") int customId) {
		Custom custom = customService.findOneCustonById(customId);
		
		if(customId!=custom.getId()) {
			return"redirect:/admin/custom";
		}
		
		custom.setStatus(true);
		customService.saveCustom(custom);
		UserEntity user = custom.getUser();
		ItemModel modelItem = custom.getModel();
		Mail mail = new Mail();
		mail.setTo(user.getEmail());
		mail.setSubject("Custom");
		mail.setContent("your item " + modelItem.getItemMake().getTitle() +modelItem.getModel()+"  is available  "+"  item cost  "+ modelItem.getPrice()+"$");
		emailService.sendMessage(mail);
		return"redirect:/admin/custom";
	}
	
	@GetMapping("/itemlist")
	private String showItemListAdmin(Model model ) {
		List<ItemModel> itemModelList = itemService.findAllItem();
		model.addAttribute("itemList", itemModelList);

		return"item_list";
	}

}
