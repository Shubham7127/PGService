package com.pg.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Properties")
public class Properties extends CommonEntity{
	
	@Column	
	private String name;
	@Column(length = 800)
	private String description;
	@Column
	private String address;
	@Column
	@Enumerated(EnumType.STRING) 
	private Gender gender;
	@Column
	private double rent;
	@Column
	private	float ratingClean;
	@Column
	private float ratingFood;
	@Column
	private float ratingSafety;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="city_id")
	private Cities myCity;
	
//	@Override
//	public String toString() {
//		return "Properties "+getId()+"[name=" + name + ", description=" + description + ", address=" + address + ", gender="
//				+ gender + ", rent=" + rent + ", ratingClean=" + ratingClean + ", ratingFood=" + ratingFood
//				+ ", ratingSafety=" + ratingSafety + ", myCity=" + myCity + "]";
//	}
	
	
}
