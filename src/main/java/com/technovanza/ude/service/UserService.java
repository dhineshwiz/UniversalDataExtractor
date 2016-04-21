package com.technovanza.ude.service;

import java.util.List;

import com.technovanza.ude.model.Application;
import com.technovanza.ude.model.Category;
import com.technovanza.ude.model.ConnectionDtls;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Extract_Details;
import com.technovanza.ude.model.Extract_Output_Details1;
import com.technovanza.ude.model.User;



public interface UserService {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<Application> getAllApplication();


    List<Category> getAllCategory();

    void deleteAllUsers();

    public boolean isUserExist(User user);

    public void insertextractoutdet(List<Extract_Output_Details1> ext_out_det, Integer Extract_Id);

    public void insertextractdet(List<Extract_Details> ext_det, Integer Extract_id);

    public Extract insertextract(Extract ext);
    public void insertCategory(Category cat);

    public void insertApplication(Application app);

    public List<Extract_Output_Details1> getAllExtractoutDetails(Integer Extract_id);

    public List<Extract_Details> getAllExtractDetails(Integer Extract_id);

    public Extract getAllExtractName(Integer Extract_id);

    public List<Extract> getAllExtractName();

   // public List<ConnectionDtls> getAllConnection();


    public List<Category> getAllCategoryapp(Integer application_id);

    public List<ConnectionDtls> getAllConnectionctg(Integer Catg_Id);

    public void insertconnection(ConnectionDtls con);

    public Extract getAllExtractdetailsbyName(String Extract_name);
    public List<Extract> getAllExtractNamebycategid(Integer category_id);

    public Extract getAllExtractdetailsbyid(Integer Extract_id);

    public ConnectionDtls getconbyid(Integer conn_id);




}