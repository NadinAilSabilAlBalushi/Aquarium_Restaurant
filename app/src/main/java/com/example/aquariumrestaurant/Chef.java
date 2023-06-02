package com.example.aquariumrestaurant;

public class Chef {

    private String Area,City,House,Lname,
            Mobile,Password, ConfirmPassword,
            EmailID,Fname, Postcode, State,Suburban;

    public Chef(String Area, String city,  String fname, String house,
                String lname, String confirmPassword,
                String emailID,String mobile, String password,
                String postcode, String state, String suburban)


    {
        this.Area = Area;
        City = city;
        ConfirmPassword = confirmPassword;
        Lname = lname;
        Mobile = mobile;
        Password = password;
        Postcode = postcode;
        State = state;
        Suburban = suburban;
        EmailID = emailID;
        Fname = fname;
        House = house;

    }

    public Chef() {
    }

    public String getArea() {
        return Area;
    }

    public String getCity() {
        return City;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    public String getLname() {
        return Lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getFname() {
        return Fname;
    }
    public String getPostcode() {
        return Postcode;
    }

    public String getState() {
        return State;
    }


    public String getHouse() {
        return House;
    }

    public String getSuburban() {
        return Suburban;
    }
}
