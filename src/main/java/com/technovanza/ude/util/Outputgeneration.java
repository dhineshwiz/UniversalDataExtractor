package com.technovanza.ude.util;

import java.util.ArrayList;
import java.util.List;

import com.technovanza.ude.model.Customer_Output;
import com.technovanza.ude.model.Customer_Output_Template;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Extract_Details;
import com.technovanza.ude.service.UserService;
import com.technovanza.ude.service.UserServiceImpl;



public class Outputgeneration {


	UserService userService = new UserServiceImpl();

public List<Customer_Output> getoutputforms(Integer extract_id )
{


Extract extractobj = new Extract();


List<Extract_Details> extract_details_lst_obj= new  ArrayList<Extract_Details>();

List<Customer_Output> customer_output_lst_obj = new ArrayList<Customer_Output>();

Customer_Output_Template customer_output_template_obj = new Customer_Output_Template();






extractobj=userService.getAllExtractdetailsbyid(extract_id);

extract_details_lst_obj=extractobj.getExtract_details();

Customer_Output customer_output_obj = new Customer_Output();

customer_output_obj.setTemplate("<h1>"+"</h1><br>");

customer_output_lst_obj.add(customer_output_obj);



for(Extract_Details obj:extract_details_lst_obj)
{

	customer_output_obj = new Customer_Output();


	customer_output_obj.setKey(obj.getParam_name());

	customer_output_obj.setType(obj.getParam_datatype());

	customer_output_template_obj = new Customer_Output_Template();

	customer_output_template_obj.setLabel(obj.getAlias_name());

	customer_output_template_obj.setPlaceholder("Enter "+obj.getAlias_name());

	customer_output_template_obj.setRequired(obj.getMandotary_indc());

	customer_output_template_obj.setOptions(obj.getMultiple_details());

	customer_output_template_obj.setLabelProp("value");

	customer_output_template_obj.setValueProp("key");


	customer_output_template_obj.setType(obj.getTemplate_datatype());

	customer_output_obj.setTemplateOptions(customer_output_template_obj);



	customer_output_lst_obj.add(customer_output_obj);


}





	return customer_output_lst_obj;


}



}
