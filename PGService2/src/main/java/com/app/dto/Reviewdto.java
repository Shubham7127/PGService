package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reviewdto {
	private Long id;
	private String content;
	private String fullName;
	private Long propertyid;
	private Long Userid;
}
