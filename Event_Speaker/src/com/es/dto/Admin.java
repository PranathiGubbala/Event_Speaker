
package com.es.dto;

public class Admin {
    private String name;
    private String password;
    private int id;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public String toString() {
        return "Admin [Id=" + id + ", Name=" + name + ", password=" + password + "]";
    }
}

