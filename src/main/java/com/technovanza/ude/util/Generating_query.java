package com.technovanza.ude.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.technovanza.ude.dao.Dynamic_customer_query;
import com.technovanza.ude.model.Customer_output_type_matching;
import com.technovanza.ude.model.Excell_rows;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Extract_Details;
import com.technovanza.ude.model.Multiple_details;
import com.technovanza.ude.service.UserService;
import com.technovanza.ude.service.UserServiceImpl;

public class Generating_query {

	private final static Logger LOGGER = Logger.getLogger(Generating_query.class.getName());


	UserService userService = new UserServiceImpl();

@SuppressWarnings("unchecked")
public Map<String,Customer_output_type_matching> getextract_det_cust(Map<Object,Object> obj)
{



	Integer Extract_id;

	Extract_id=(Integer)obj.get("extract_id");



	Extract ext;

	ext=userService.getAllExtractdetailsbyid(Extract_id);



	List<Extract_Details> extdetlst=ext.getExtract_details();
	Map<String,String> typemapping = new HashMap<String,String>();
	List<String> lstkeys = new ArrayList<String>();

	Map<String,Customer_output_type_matching> custoutmat = new HashMap<String,Customer_output_type_matching>();


	//Map<Integer,Map<String,Customer_output_type_matching>> custoutextidobj = new HashMap<Integer,Map<String,Customer_output_type_matching>>();

	for(Extract_Details extdetobj:extdetlst)
	{


		if(extdetobj.getInput_required())
		{

			//System.out.println("inside iput req");
			//System.out.println("inside string"+extdetobj.getParam_datatype());
			//System.out.println("inside string_template"+extdetobj.getTemplate_datatype());
			if((extdetobj.getParam_datatype().equals("input")) && (extdetobj.getTemplate_datatype().equals("text")))
					{
			typemapping.put(extdetobj.getParam_name(),"String");
			//System.out.println(" strin_casted_matched" + extdetobj.getParam_name());
			//System.out.println("inside string"+extdetobj.getParam_datatype());


					}

			if((extdetobj.getParam_datatype().equals("input")) && (extdetobj.getTemplate_datatype().equals("number")))
			{

				typemapping.put(extdetobj.getParam_name(),"Integer");

				LOGGER.info("Setting type integer");


			}

			if((extdetobj.getParam_datatype().equals("input")) && (extdetobj.getTemplate_datatype().equals("date")))
			{

				typemapping.put(extdetobj.getParam_name(),"Date");


			}


			if((extdetobj.getParam_datatype().equals("multiCheckbox")))
			{

				typemapping.put(extdetobj.getParam_name(),"multiCheckbox");
				//System.out.println("checkbox_completed");


			}


			lstkeys.add(extdetobj.getParam_name());

		}
	}

	Customer_output_type_matching cust_out_obj;
for(String keyobj:lstkeys)
{
	cust_out_obj= new Customer_output_type_matching();



	if(typemapping.get(keyobj).equals("String"))
	{

		cust_out_obj.setString((String)obj.get(keyobj));

		//System.out.println((String)obj.get(keyobj)+" strin_casted");

		//System.out.println(obj.get(keyobj));


		if((cust_out_obj.getString()==null)||(cust_out_obj.getString().trim().isEmpty())||(cust_out_obj.getString().trim()==null))
		{
			System.out.println("Setting string options null");

			LOGGER.info("Setting string options null");
		cust_out_obj.setType(null);
		}
		else
		{
			cust_out_obj.setType(typemapping.get(keyobj));


		}


	}



	if(typemapping.get(keyobj).equals("Integer"))
	{

		cust_out_obj.setInteger((Integer)obj.get(keyobj));

		if(cust_out_obj.getInteger()==null)
		{
		cust_out_obj.setType(null);
		System.out.println("integer setting to null");

		LOGGER.info("integer setting to null");
		}
		else
		{
			cust_out_obj.setType(typemapping.get(keyobj));


		}



	}


	if(typemapping.get(keyobj).equals("Date"))
	{



		//System.out.println((String)obj.get(keyobj));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String full_dat=(String)obj.get(keyobj);

		if(!((full_dat==null)||(full_dat.isEmpty())))
		{
		String partial_dat=full_dat.substring(0,10);


		try {

			Date dt =sdf.parse(partial_dat);

			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DATE, 1);
			dt = c.getTime();

			System.out.println(dt);

			cust_out_obj.setDate(dt);



		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			LOGGER.info(e.getMessage());
		}

		}


		if(cust_out_obj.getDate()==null)
		{

			System.out.println("Date setting to null");

			LOGGER.info("Date setting to null");

			cust_out_obj.setType(null);
		}
		else
		{
			cust_out_obj.setType(typemapping.get(keyobj));


		}



	}

	if(typemapping.get(keyobj).equals("multiCheckbox"))
	{

if(obj.get(keyobj)==null)
{
	List<Multiple_details> lstmut1 = new ArrayList<Multiple_details>();

	System.out.println("mutiple object setting to null");

	LOGGER.info("mutiple object setting to null");

	cust_out_obj.setMulticheckbox(lstmut1);

}
else
{

		ArrayList<Object> lt = (ArrayList<Object>)obj.get(keyobj);
		List<Multiple_details> lstmut = new ArrayList<Multiple_details>();

		Multiple_details multiple_details_obj;

		for(Object ob:  lt)
		{

			multiple_details_obj= new Multiple_details();
			multiple_details_obj.setKey((Integer)ob);

			lstmut.add(multiple_details_obj);



		}


		cust_out_obj.setMulticheckbox(lstmut);
}









		if(cust_out_obj.getMulticheckbox().isEmpty())
		{
		cust_out_obj.setType(null);
		}
		else
		{
			cust_out_obj.setType(typemapping.get(keyobj));


		}



	}

	custoutmat.put(keyobj,cust_out_obj);




}

//custoutextidobj.put(Extract_id, custoutmat);

LOGGER.info("custoutmat generated");

return custoutmat;

}

public List<Excell_rows> generating_query(Map<Object,Object> obj)
{

	Integer Extract_id= (Integer) obj.get("extract_id");
//System.out.println(Extract_id);

Map<String,Customer_output_type_matching>customer_param_type=getextract_det_cust(obj);



Extract ext=userService.getAllExtractdetailsbyid(Extract_id);

List<Extract_Details> ext_det=ext.getExtract_details();

Map<String,String> extract_details=new HashMap<String,String>();


for(Extract_Details ext_obj:ext_det)
{

	extract_details.put(ext_obj.getParam_name(),ext_obj.getParam_value());

}


List<Excell_rows> workbook=param_string_repalce(extract_details,customer_param_type,ext);







return workbook;
}

public List<Excell_rows> param_string_repalce(Map<String,String>extract_values,Map<String,Customer_output_type_matching> customer_values,Extract ext)
{

	LOGGER.info("Entered param_string_repalce method");
List<String> param_with_null_values = new ArrayList<String>();

	for(String param_name :customer_values.keySet())
	{
		LOGGER.info("Entered for loop customer_values iterations"+param_name);
		//System.out.println(customer_values.get(param_name).getType()+"   "+param_name);

		if(customer_values.get(param_name).getType()==null)
          {

			LOGGER.info("replacing checking param details is null");
			//cmted for cloud dep
			//extract_values.replace(param_name, null);


			//for cloud deployment
			extract_values.remove(param_name);
			extract_values.put(param_name, null);


			//if(extract_values.get(param_name)==null)
			//{
			//
			//}
			//System.out.println(customer_values.get(param_name).getString());

			//System.out.println(customer_values.get(param_name).getDate());

			//System.out.println(customer_values.get(param_name).getMulticheckbox());

			//System.out.println(customer_values.get(param_name).getInteger());

			//System.out.println("isempty");
			param_with_null_values.add(param_name);



		}
		else
		{
			LOGGER.info("Entering else part of the null checking");

			if(customer_values.get(param_name).getType()=="multiCheckbox")
			{
				String question_mark_index= new String();

				for(Multiple_details muttty:customer_values.get(param_name).getMulticheckbox())
				{

					question_mark_index=question_mark_index.concat("?,");

				}

				question_mark_index=question_mark_index.substring(0, question_mark_index.length()-1);



				//cmted for cloud dep
				//extract_values.replace(param_name, question_mark_index);



				//for cloud deployment
				extract_values.remove(param_name);
				extract_values.put(param_name, question_mark_index);


			}
			else
			{
				LOGGER.info("Entering else part of multicheckbox the extract details is"+param_name);
				try{

					//cmted for cloud dep
					//extract_values.replace(param_name, "?");

					//for cloud deployment
				extract_values.remove(param_name);

				extract_values.put(param_name,"?");
				}
				catch(Exception e)
				{
					LOGGER.info("Replacing map value exception"+e.getMessage());
				}
				LOGGER.info("adding ? to param query");

			}

		}



	}

	//replacing (1=1) values for null values entered by customers

	Map<String,String> repalcing_param=new HashMap<String,String>();

	for(String param :param_with_null_values )
		{

		//System.out.println("inside nul value loop"+param);

		for(String param_name :extract_values.keySet())
		{


			String param_value = new String();

			String replaced_param_value = new String();

			param_value=extract_values.get(param_name);

			//System.out.println("ppppp   "+param_value+"kkkkk "+ param_name);
			if(param_value!=null)
			{

			//replaced_param_value=param_value.replace(param,"(1=1)" );


			//System.out.println("replaced1=1"+replaced_param_value+"  "+ param);

			if(param_value.contains(param))
			{

				//param_value=replaced_param_value;

				//extract_values.replace(param_name, param_value);

				replaced_param_value="(1=1)";
				repalcing_param.put(param_name,replaced_param_value);

				//System.out.println("replaced1=1"+replaced_param_value);
				break;

			}

			}




		}


	}

	for(String replaced_param:repalcing_param.keySet())
	{
		//cmted for cloud dep
		//extract_values.replace(replaced_param,repalcing_param.get(replaced_param));

		//for cloud deployment
		extract_values.remove(replaced_param);

		extract_values.put(replaced_param,repalcing_param.get(replaced_param));

	}

	//testing the code
	for(String param_name:extract_values.keySet())
	{

		//System.out.println("The param_name is "+param_name+" value is "+extract_values.get(param_name));



	}







String query_skeleton=ext.getQuery_skeleton();

LOGGER.info("query skeleton before replacement "+query_skeleton);

//System.out.println(query_skeleton);


List<String> keys= new ArrayList<String>(extract_values.keySet());

Collections.sort(keys);

for(String key:keys)
{

	if(extract_values.get(key)!=null)
	{

		String st =new String();

		 st = (extract_values.get(key));

		//String query_skeleton_replacement;

		 //System.out.println("sorted keys" +key);

		query_skeleton=query_skeleton.replace(key,st);



	//System.out.println(query_skeleton);
	}
	else
	{

		//System.out.println("11");

	}

}

System.out.println(query_skeleton);

LOGGER.info("query skeleton is "+query_skeleton);

Dynamic_customer_query dynamic_customer_query_obj = new Dynamic_customer_query();



List<Excell_rows> workbook=dynamic_customer_query_obj.fetch_customer_extract(ext, customer_values, query_skeleton);

return workbook;

}




}
