package com.es.dto;

public class User {
    private int id;
    private String password;
    private String name;
    private String college;
    private String collegeId;
    private String designation;
    private String email;
    private String contact;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;
    
  
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getCollegeId() {
        return collegeId;
    }
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getHouseNo() {
        return houseNo;
    }
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [Id=" + id + ", Name=" + name + ", password=" + password +",college=" + college
                + ", collegeId=" + collegeId + ", designation=" + designation + ", email=" + email + ", contact=" + contact +", houseNo=" + houseNo +", street =" + street +", city =" + city +", state=" + state +", pincode =" + pincode +"]";
    }
}


