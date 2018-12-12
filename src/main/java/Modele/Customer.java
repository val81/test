/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.List;

/**
 *
 * @author pedago
 */
public class Customer {
    
    private int id;
    private String discountCode;
    private String zip;
    private String name;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private int creditLimit;
    
    public Customer(int id, String discountCode, String zip, String name, String addr1, String addr2,
                    String city, String state, String phone, String fax, String email, int creditLimit)
    {
        this.id = id;
        this.discountCode = discountCode;
        this.zip = zip;
        this.name = name;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public Customer(int id)
    {
        this.id = id;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public int getId()
    {
        return this.id;
    }

    public String getDiscountCode()
    {
        return this.discountCode;
    }

    public String getZip()
    {
        return this.zip;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddr1()
    {
        return this.addr1;
    }

    public String getAddr2()
    {
        return this.addr2;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getState()
    {
        return this.state;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getFax()
    {
        return this.fax;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getCreditLimit()
    {
        return this.creditLimit;
    }
}
