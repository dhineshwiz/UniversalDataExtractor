package com.technovanza.ude.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technovanza.ude.dao.ApplicationDao;
import com.technovanza.ude.dao.CategoryDao;
import com.technovanza.ude.dao.ConnectionDao;
import com.technovanza.ude.dao.ExtractDao;
import com.technovanza.ude.dao.ExtractDtlsDao;
import com.technovanza.ude.dao.ExtractOutputDtlsDao;
import com.technovanza.ude.model.Application;
import com.technovanza.ude.model.Category;
import com.technovanza.ude.model.ConnectionDtls;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Extract_Details;
import com.technovanza.ude.model.Extract_Output_Details1;
import com.technovanza.ude.model.User;
//import com.technovanza.ude.model.Application;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users= populateDummyUsers();
    }

    public List<Application> getAllApplication() {

List<Application> app;
    	ApplicationDao ApplicationDaoobj= new ApplicationDao();

    	app=ApplicationDaoobj.getallApplication();

    			return app;
    }

    public List<Category> getAllCategory()
    {
    	List<Category> catlst;

    	CategoryDao categoryDaoob = new CategoryDao();

    	catlst=categoryDaoob.getCaetory();

    	return catlst;


    }

    public List<Category> getAllCategoryapp(Integer application_id)
    {
    	List<Category> catlst;

    	CategoryDao categoryDaoob = new CategoryDao();

    	catlst=categoryDaoob.getCaetoryapp(application_id);

    	return catlst;


    }
    //getCaetoryapp

    public List<ConnectionDtls> getAllConnectionctg(Integer Catg_Id)
    {
    	List<ConnectionDtls> condetobj;

    	ConnectionDao con = new ConnectionDao();
    	condetobj=con.getConnectiondetailsctg(Catg_Id);

    	return condetobj;

    }

    public ConnectionDtls getconbyid(Integer conn_id)
    {
    	ConnectionDao con = new ConnectionDao();

    	ConnectionDtls conecction_dtl=con.getConnectiondetailsid(conn_id);


    	return conecction_dtl;

    }

    public List<Extract> getAllExtractName()
    {
    	List<Extract> Extlst;

    	ExtractDao ext = new ExtractDao();
    	Extlst=ext.getextract();


    	return Extlst;

    }

    public Extract getAllExtractName(Integer Extract_id)
    {

    	Extract Extlst;

    	ExtractDao ext = new ExtractDao();
    	Extlst=ext.getextract(Extract_id);


    	return Extlst;


    }
    public List<Extract> getAllExtractNamebycategid(Integer category_id)
    {

    	List<Extract> Extlst;

    	ExtractDao ext = new ExtractDao();
    	Extlst=ext.getextractbycategid(category_id);


    	return Extlst;


    }

    public Extract getAllExtractdetailsbyName(String Extract_name)
    {

       List<Extract_Details> extdetobj = new ArrayList<Extract_Details>();

    	List<Extract_Output_Details1> extdetoutobj = new ArrayList<Extract_Output_Details1>();


    	Extract Extlst;

    	Integer Extract_ID;

    	ExtractDao ext = new ExtractDao();

    	Extlst=ext.getfullextract(Extract_name);

    	Extract_ID=Extlst.getExtract_id();

    	extdetobj=getAllExtractDetails(Extract_ID);

    	extdetoutobj=getAllExtractoutDetails(Extract_ID);


    	Extlst.setExtract_details(extdetobj);


    	Extlst.setExtract_output_details1(extdetoutobj);





    	return Extlst;


    }

    public Extract getAllExtractdetailsbyid(Integer Extract_id)
    {

       List<Extract_Details> extdetobj = new ArrayList<Extract_Details>();

    	List<Extract_Output_Details1> extdetoutobj = new ArrayList<Extract_Output_Details1>();


    	Extract Extlst;

    	Integer Extract_ID;

    	ExtractDao ext = new ExtractDao();

    	Extlst=ext.getextract(Extract_id);

    	Extract_ID=Extract_id;

    	extdetobj=getAllExtractDetails(Extract_ID);

    	extdetoutobj=getAllExtractoutDetails(Extract_ID);


    	Extlst.setExtract_details(extdetobj);


    	Extlst.setExtract_output_details1(extdetoutobj);





    	return Extlst;


    }


    public List<Extract_Details> getAllExtractDetails(Integer Extract_id)
    {
    	List<Extract_Details> extdtlst;

    	ExtractDtlsDao Extldao = new ExtractDtlsDao();

    	extdtlst=Extldao.getExtractDetails(Extract_id);

    	return extdtlst;
    }

    public List<Extract_Output_Details1> getAllExtractoutDetails(Integer Extract_id)
    {
    	List<Extract_Output_Details1> extdtlst;

    	ExtractOutputDtlsDao Extldao = new ExtractOutputDtlsDao();

    	extdtlst=Extldao.getExtractoutputdtls(Extract_id);

    	return extdtlst;
    }

    public void insertApplication(Application app)
    {
    	ApplicationDao appdao = new ApplicationDao();

    	appdao.insertApplication(app);


    }
    public void insertCategory(Category cat)
    {
    	CategoryDao catg = new CategoryDao();

    	catg.insertCategory(cat);


    }


    public void insertconnection(ConnectionDtls con)
    {

    	ConnectionDao condao = new ConnectionDao();


    	condao.insertConnectionDtls(con);


    }

    public Extract insertextract(Extract ext)
    {
    	ExtractDao extdao = new ExtractDao();

    	Integer Extract_id=extdao.InsertExtract(ext);


    	insertextractdet(ext.getExtract_details(),Extract_id);

    	insertextractoutdet(ext.getExtract_output_details1(),Extract_id);

    	return ext;


    }

    public void insertextractdet(List<Extract_Details> ext_det, Integer Extract_id)
    {
    	ExtractDtlsDao Extldao = new ExtractDtlsDao();





    	Extldao.insertextractdtls(ext_det,Extract_id);

    }

    public void insertextractoutdet(List<Extract_Output_Details1> ext_out_det, Integer Extract_Id)
    {
    	//System.out.println(ext_out_det.get(1).getOutput_alias_name());

    	ExtractOutputDtlsDao Extldao = new ExtractOutputDtlsDao() ;

         Extldao.insertExtractoutputdtls(ext_out_det, Extract_Id);

    }


    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isUserExist(User user) {
        return findByName(user.getUsername())!=null;
    }

    public void deleteAllUsers(){
        users.clear();
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
        users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
        users.add(new User(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
        return users;
    }

}