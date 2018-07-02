package com.es.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.es.dbutility.DBConnection;
import com.es.dto.Event;
import com.es.dto.User;



public class UserDAO {
	public User getUser(String name,String password){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		User user=null;
	final String SELECT_QUERY = "select * from user where name = ? and password = ?";
	try{
		con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, name);
		pst.setString(2, password);
		System.out.println(name);
		rst = pst.executeQuery();
		if(rst.next()){
			 user = new User();
			 user.setId(rst.getInt(1));
			 user.setName(rst.getString(2));
			 user.setPassword(rst.getString(3));
			 user.setCollege(rst.getString(4));
			 user.setCollegeId(rst.getString(5));
			 user.setDesignation(rst.getString(6));
			 user.setEmail(rst.getString(7));
			 user.setContact(rst.getString(8));
			 user.setHouseNo(rst.getString(9));
			 user.setStreet(rst.getString(10));
			 user.setCity(rst.getString(11));
			 user.setState(rst.getString(12));
			 user.setPincode(rst.getString(13));
			 
			 
			 
		System.out.println("Inside DAO" + user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	}
	public int add(User user){
		
		final String INSERT_QUERY="insert into user(name,password,college,collegeId,designation,email,contact,houseNo,street,city,state,pincode) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getCollege());
			pst.setString(4, user.getCollegeId());
			pst.setString(5, user.getDesignation());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getContact());
			pst.setString(8, user.getHouseNo());
			pst.setString(9, user.getStreet());
			pst.setString(10, user.getCity());
			pst.setString(11, user.getState());
			pst.setString(12, user.getPincode());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		}
	
	public List<User> displayAll(){
		List<User> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		
	    final String SELECT_QUERY = "select * from user ";
	    try(Connection con = DBConnection.getConnection();) {
		    pst = con.prepareStatement(SELECT_QUERY);
		    rst = pst.executeQuery();
		    while(rst.next()){
			    User user=new User();
			    user.setId(rst.getInt(1));
			    user.setName(rst.getString(2));
			    user.setPassword(rst.getString(3));
			    user.setCollege(rst.getString(4));
			    user.setCollegeId(rst.getString(5));
			    user.setDesignation(rst.getString(6));
			    user.setEmail(rst.getString(7));
			    user.setContact(rst.getString(8));
			    user.setHouseNo(rst.getString(9));
			    user.setStreet(rst.getString(10));
			    user.setCity(rst.getString(11));
			    user.setState(rst.getString(12));
			    user.setPincode(rst.getString(13));
			    list.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	    System.out.println(list);
	return list;
	}
	
	public void delete(int userId){
	    Connection con = null;
		PreparedStatement pst = null;
	
		final String SELECT_QUERY = "delete from user where userId = ?";
	 try{
         
		 con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, userId);
		pst.executeUpdate();
}
catch (Exception e){
System.out.println(e);
}
 }
	
}
