package com.cybo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cybo.entity.ItemMake;
import com.cybo.entity.Type;
import com.cybo.entity.UserEntity;
import com.cybo.entity.enumeration.Role;
import com.cybo.repository.MakerRepository;
import com.cybo.repository.TypeRepository;
import com.cybo.repository.UserRepository;

@SpringBootApplication
public class SpringBootProjectApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Main.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		addAdmin(context);
		addItemMake(context);
		addType(context);
	}
	
	private static void addType(ConfigurableApplicationContext context) {
		
		
	}

	private static void addItemMake(ConfigurableApplicationContext context) {
		
		
	}

	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	static void addCarMake(ConfigurableApplicationContext context) {
		String title = "commode";
		MakerRepository makerRepository = context.getBean(MakerRepository.class);
		ItemMake make = makerRepository.findMakerByName(title);
		if(make==null) {
			make = new ItemMake();
			make.setTitle(title);
			makerRepository.save(make);
		}
	}
	static void addCar(ConfigurableApplicationContext context) {
		String title = "v6"; 
		String capacity = "2.1"; 
		String power = "150"; 
		TypeRepository typeRepository = context.getBean(TypeRepository.class);
		Type type = typeRepository.findTypeByTitle(title);
		if(type==null) {
			type = new Type();
			type.setTitle(title);
			type.setCapacity(capacity);
			type.setPower(power);
			typeRepository.save(type);
		}
	}
	
	

}