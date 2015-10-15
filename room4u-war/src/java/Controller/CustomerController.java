/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.room4u.dao.CustomerFacade;
import com.room4u.dao.CustomerFacadeLocal;
import com.room4u.model.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nick
 */
@ManagedBean
@SessionScoped
public class CustomerController {
    @EJB
    private CustomerFacadeLocal customerFacade;
    
    private String accName;
    private String password;
    private String mail;
   
    private Customer c = new Customer();
    
    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
        
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }
    
    public List<Customer> getCustList(){
        return this.customerFacade.findAll();
    }
    
    public String add (){
        this.customerFacade.create(this.c);
        this.c = new Customer();
        return "index";
    }
    
    public void delete(Customer c){
        this.customerFacade.remove(c);
    }
    
    public String edit(Customer c){
        this.c = c;
        return "edit";
    }
    
    public String edit(){
        this.customerFacade.edit(this.c);
        this.c = new Customer();
        return "index";
    }
    
    public String validateRegisterAccount(){
        return this.customerFacade.validateRegusterAccount(accName, mail) ? "index" : "registerFail";
    }
    
    public String checkLogin(){
        return customerFacade.checkLogin(accName, password) ? "index" : "loginFail";
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
