package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends CommonEntity 
{   
		@Column
		private String email;
		@Column
		private String password;
		@Column
		private String fullName;
		@Column
		private long mobNo;
		@Column
		@Enumerated(EnumType.STRING) 
		private Gender gender;
		@Column(length=100)
		private String address;
		@Column
		private String role;
	
		@OneToMany(mappedBy ="user", cascade = CascadeType.ALL,orphanRemoval = true,fetch= FetchType.EAGER)
		private List<Reviews> reviews = new ArrayList<>();	
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name ="interested_users_properties",
				joinColumns = @JoinColumn(name ="user_id"),
				inverseJoinColumns = @JoinColumn(name="property_id"))
		
		private List<Properties> properties = new ArrayList<>();
}
