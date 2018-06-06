package com.cybo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cybo.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "user", indexes = @Index(columnList = "email, last_name"))
@Getter @Setter
public class UserEntity extends BaseEntity {
	
	private String email;
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	private int age;
	
	@Column(name = "image_path")
	private String imagePath;
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	private String token;
	@Column(name="is_activated")
	private boolean isActivated;
	
	@OneToMany(mappedBy="user", cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List<Custom> custom;

}
