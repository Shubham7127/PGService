package com.pg.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cities")
public class Cities extends CommonEntity {
	
	@Column
	private String name;
	@OneToMany(mappedBy ="myCity",fetch= FetchType.EAGER)
	private List<Properties> properties = new ArrayList<>();
	
//	@Override
//	public String toString() {
//		return "Cities "+getId()+"[name=" + name + ", properties=" + properties + "]";
//	}
	
}
