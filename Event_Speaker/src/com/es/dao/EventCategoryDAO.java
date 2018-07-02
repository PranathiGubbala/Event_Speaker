package com.es.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.es.dbutility.DBConnection;
import com.es.dto.EventCategory;
import com.es.dto.User;
import com.es.dto.Admin;
import javax.servlet.http.HttpSession;
public class EventCategoryDAO {
public int add(EventCategory ec){
		
		final String INSERT_QUERY="insert into eventCategory(categoryName,adminId) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			 
			pst.setString(1, ec.getName());
			pst.setInt(2, ec.getAdminId().getId());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		}
public List<EventCategory> displayAll(){
	List<EventCategory> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	
    final String SELECT_QUERY = "select categoryId,categoryName from eventCategory ";
    try(Connection con = DBConnection.getConnection();) {
	    pst = con.prepareStatement(SELECT_QUERY);
	    rst = pst.executeQuery();
	    Admin a = new Admin();
	    a.setId(1);
	    while(rst.next()){
		    EventCategory ec = new EventCategory();
		    ec.setId(rst.getInt(1));
		    ec.setName(rst.getString(2));
		    ec.setAdminId(a);
		    
		    list.add(ec);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
    System.out.println(list);
return list;
}
public void delete(int categoryId){
    Connection con = null;
	PreparedStatement pst = null;

	final String SELECT_QUERY = "delete from eventCategory where categoryId = ?";
 try{
     
	 con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, categoryId);
	pst.executeUpdate();
}
catch (Exception e){
System.out.println(e);
}
}
	

}
