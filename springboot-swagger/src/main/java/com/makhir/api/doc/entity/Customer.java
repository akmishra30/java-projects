package com.makhir.api.doc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "This customer model with customer specific properties to store and retreive information.", reference="Customer")
public class Customer {

	//@ApiParam(name = "Customer Id", required = true, format = "Numerical value")
	@ApiModelProperty(name="Customer Id", 
			dataType = "Numeric", 
			notes = "This is customer id which is system generated.", 
			required=true, 
			hidden=false,
			position=1)
	private long id;
	
	@ApiModelProperty(name="Customer Name", 
			dataType = "String", 
			notes = "This is customer name which consumer supposed to provide.", 
			required=true, 
			hidden=false,
			example="Ashish Mishra",
			allowEmptyValue = false,
			position=2
			)
	private String name;
	
	@ApiModelProperty(name="Customer Mobile no.", 
			dataType = "Numeric", 
			notes = "This is customer mobile no. which consumer supposed to provide.", 
			required=true, 
			hidden=false,
			example="9999999999",
			allowEmptyValue = false,
			position=3)
	private String contact;
	
	@ApiModelProperty(name="Customer email", 
			dataType = "String", 
			notes = "This is customer email which consumer supposed to provide.", 
			required=true, 
			hidden=false,
			example="abc@test.com",
			allowEmptyValue = false,
			position=4)
	private String email;
	
	@ApiModelProperty(name="Customer city", 
			dataType = "Numeric", 
			notes = "This is customer city which consumer supposed to provide.", 
			required=true, 
			hidden=false,
			example="Anand",
			allowEmptyValue = false,
			position=5)
	private String city;
	
	public Customer(){}

	public Customer(long id, String name, String contact, String email, String city) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.city = city;
	}
}
