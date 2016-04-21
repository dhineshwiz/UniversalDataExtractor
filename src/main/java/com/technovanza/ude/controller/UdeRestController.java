package com.technovanza.ude.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.technovanza.ude.dao.ApplicationDao;
import com.technovanza.ude.model.Application;
import com.technovanza.ude.model.Category;
import com.technovanza.ude.model.ConnectionDtls;
import com.technovanza.ude.model.Customer_Output;
import com.technovanza.ude.model.Excell_rows;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Login;
import com.technovanza.ude.service.UserService;
import com.technovanza.ude.util.Generating_query;
import com.technovanza.ude.util.Outputgeneration;

@RestController
public class UdeRestController {
	private final static Logger LOGGER = Logger.getLogger(UdeRestController.class.getName());

    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work


    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> listAllApplication() {
        List<Application> applications = userService.getAllApplication();


return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }



    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllcategory() {
        List<Category> category = userService.getAllCategory();

        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/categoryapp/", method = RequestMethod.POST)
    public ResponseEntity<List<Category>> listAllcategoryinapplication(@RequestBody Integer application_Id   ) {

    	System.out.println("categoryapp"+application_Id );
        List<Category> category = userService.getAllCategoryapp(application_Id);

        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }


    @RequestMapping(value = "/connectionapp/", method = RequestMethod.POST)
    public ResponseEntity<List<ConnectionDtls>> listallconnection(@RequestBody Integer Category_Id   ) {

    	System.out.println("categoryapp"+Category_Id );
        List<ConnectionDtls> connectiondtls = userService.getAllConnectionctg(Category_Id);



        return new ResponseEntity<List<ConnectionDtls>>(connectiondtls, HttpStatus.OK);
    }



    @RequestMapping(value = "/connbyid/", method = RequestMethod.POST)
    public ResponseEntity<ConnectionDtls> listAllconnby_id(@RequestBody Integer conn_id) {
    	ConnectionDtls extrtact = new ConnectionDtls();

    	extrtact=userService.getconbyid(conn_id);

        return new ResponseEntity<ConnectionDtls>(extrtact, HttpStatus.OK);
    }



    @RequestMapping(value = "/extract/", method = RequestMethod.GET)
    public ResponseEntity<List<Extract>> listAllExtract() {
        List<Extract> extracts = userService.getAllExtractName();

        return new ResponseEntity<List<Extract>>(extracts, HttpStatus.OK);
    }

    @RequestMapping(value = "/extractbycategid/", method = RequestMethod.POST)
    public ResponseEntity<List<Extract>> listAllExtractbycatg_id(@RequestBody Integer caegory_id) {
        List<Extract> extrtact = userService.getAllExtractNamebycategid(caegory_id);

        return new ResponseEntity<List<Extract>>(extrtact, HttpStatus.OK);
    }

    @RequestMapping(value = "/extractbyid/", method = RequestMethod.POST)
    public ResponseEntity<Extract> listAllExtractby_id(@RequestBody Integer Extract_id) {
        Extract extrtact = userService.getAllExtractdetailsbyid(Extract_id);

        return new ResponseEntity<Extract>(extrtact, HttpStatus.OK);
    }



    @RequestMapping(value = "/insrapplication/", method = RequestMethod.POST)
    public ResponseEntity<Void> addApplication(@RequestBody Application application,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + application.getApplication_name() );


        userService.insertApplication(application);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/application/{application_name}").buildAndExpand(application.getApplication_name()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }




    @RequestMapping(value = "/insrcategory/", method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + category.getCategory_Name() );


        userService.insertCategory(category);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{Category_Name}").buildAndExpand(category.getCategory_Name()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/insrconnection/", method = RequestMethod.POST)
    public ResponseEntity<Void> addConnection(@RequestBody ConnectionDtls con,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating connection " + con.getConnection_name() + con.getCategory_Id() );


        userService.insertconnection(con);

        HttpHeaders headers = new HttpHeaders();
       headers.setLocation(ucBuilder.path("/connection/{Category_Name}").buildAndExpand(con.getConnection_name()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/insrextract/", method = RequestMethod.POST)
    public ResponseEntity<Extract> addExtract(@RequestBody Extract ext) {
        System.out.println("Creating connection " + ext.getExtract_name() );



        Extract ext1=userService.insertextract(ext);
        //Boolean a=true;
        Customer_Output aaa = new Customer_Output();

        List<Customer_Output> a = new ArrayList<Customer_Output>();
        a.add(aaa);

        //HttpHeaders headers = new HttpHeaders();
       //headers.setLocation(ucBuilder.path("/connection/{Category_Name}").buildAndExpand(ext.getExtract_name()).toUri());
        return new ResponseEntity<Extract>(ext1, HttpStatus.OK);
    }

    @RequestMapping(value = "/getcustomerout/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer_Output>> getcustomerdet(@PathVariable("id") Integer id,    UriComponentsBuilder ucBuilder) {
        System.out.println("extract output details created" +id);

         Outputgeneration output = new Outputgeneration();

         List<Customer_Output> cust_out = new ArrayList<Customer_Output>();
         cust_out=output.getoutputforms(id);


        return new ResponseEntity<List<Customer_Output>>(cust_out, HttpStatus.OK);
    }

    @RequestMapping(value="/insrcustdet",method = RequestMethod.POST)
    public ModelAndView insrcustomerdet(@RequestBody Map<Object,Object> obj, UriComponentsBuilder ucBuilder)
    {
    	LOGGER.info("entered into inscustdet method");


    	Generating_query gen_query = new Generating_query();

    	List<Excell_rows> workbook=gen_query.generating_query(obj);

    	//XSSFWorkbook workbook1= new XSSFWorkbook();

    	System.out.println("gott work book");

    	LOGGER.info("gott work book");
    	//excell_downloading ecel= new excell_downloading();

    	return new ModelAndView("excell", "final_list", workbook);

    }


    @RequestMapping(value="/insrcustdet_test",method = RequestMethod.GET)
    public ModelAndView insrcustomerdet_test()
    {



    	//Generating_query gen_query = new Generating_query();

    	//XSSFWorkbook workbook=gen_query.generating_query(obj);

    	XSSFWorkbook workbook1= new XSSFWorkbook();

    	System.out.println("gott work book");
    	//excell_downloading ecel= new excell_downloading();

    	return new ModelAndView("excell", "final_list", workbook1);

    }


    @RequestMapping(value="/dologin/", method=RequestMethod.POST)
    public ResponseEntity<Login> login_page(@RequestBody String user_name) {

    	//String name=(String)user_name.get("name");

    	Login route = new Login();
    	System.out.println(user_name);
    	if(user_name.equals("technical_team@ude.com"))
    	{
    		route.setRedirect("index");

    	}
    	else if(user_name.equals("client_team@ude.com"))
    	{

    		route.setRedirect("welcome");

    	}
  	  System.out.println(route.getRedirect());

        return new ResponseEntity<Login>(route, HttpStatus.OK);
    }
    @RequestMapping(value = "/connectionapp1/", method = RequestMethod.POST)
    public ResponseEntity<List<ConnectionDtls>> listallconnection1(@RequestBody Integer Category_Id   ) {

    	System.out.println("categoryapp"+Category_Id );
        List<ConnectionDtls> users = userService.getAllConnectionctg(Category_Id);



        return new ResponseEntity<List<ConnectionDtls>>(users, HttpStatus.OK);
    }




	//@RequestMapping(value = "/export", method = RequestMethod.GET)
	//public ModelAndView getExcel() {


		//List animalList = animalService.getAnimalList();




	//}







}