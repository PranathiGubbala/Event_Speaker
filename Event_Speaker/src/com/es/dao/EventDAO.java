package com.es.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.es.dbutility.DBConnection;
import com.es.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class EventDAO {
	public List<Event> getImages(){
		List<Event> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		Event event =null;
		
	final String SELECT_QUERY = "select eventId,date,eventPic from event order by date ASC";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			 event = new Event();
			 
			 event.setId(rst.getInt(1));
			 event.setName(rst.getString(2));
			 event.setEventPic(rst.getString(3));
			 list.add(event);

		System.out.println(event);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}

	public Event getEvent(int eventId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Event event =null;
		
	final String SELECT_QUERY = "select eventName,date,startTime,endTime,fee,venue,details from event where eventId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, eventId);
		rst = pst.executeQuery();
		if(rst.next()){
			 event = new Event();
			 
			 event.setName(rst.getString(1));
			 event.setDate(rst.getDate(2));
			 event.setStartTime(rst.getString(3));
			 event.setEndTime(rst.getString(4));
			 event.setFee(rst.getDouble(5));
			 event.setVenue(rst.getString(6));
			 event.setDetails(rst.getString(7));
			 
		System.out.println(event);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return event;
	}
	public List<Event> displayAllUser(int userId){
		List<Event> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		
	    final String SELECT_QUERY = "select eventId,eventName,venue,details from event where userId = ? ";
	    try(Connection con = DBConnection.getConnection();) {
		    pst = con.prepareStatement(SELECT_QUERY);
		    pst.setInt(1, userId);
		    rst = pst.executeQuery();
		    
		    while(rst.next()){
			    Event events = new Event();
			    events.setId(rst.getInt(1));
			    events.setName(rst.getString(2));
			    events.setVenue(rst.getString(3));
			    events.setDetails(rst.getString(4));
			   
			    list.add(events);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	    System.out.println(list);
	return list;
	}
	
	public List<Event> displayAll(){
		List<Event> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		
	    final String SELECT_QUERY = "select eventId,eventName,venue,details from event";
	    try(Connection con = DBConnection.getConnection();) {
		    pst = con.prepareStatement(SELECT_QUERY);
		    rst = pst.executeQuery();
		    
		    while(rst.next()){
			    Event events=new Event();
			    events.setId(rst.getInt(1));
			    events.setName(rst.getString(2));
			    events.setVenue(rst.getString(3));
			    events.setDetails(rst.getString(4));
			   
			    list.add(events);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	    System.out.println(list);
	return list;
	}
	 public void delete(int eventId){
		 System.out.println("the delete inside dao is"+ eventId);
		    Connection con = null;
			PreparedStatement pst = null;
			PreparedStatement pst1 = null;
			int status = 0;
	
			final String example = "delete from registeredEvents where eventId = ?";
			final String SELECT_QUERY = "delete from event where eventId = ?";
		 try{
	         
			 con = DBConnection.getConnection();
			pst1 = con.prepareStatement(example);
			pst1.setInt(1, eventId);
			status = pst1.executeUpdate();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, eventId);
			status = pst.executeUpdate();
			
	}
	catch (Exception e){
	System.out.println(e);
	}
		 System.out.println(status);
	 }
	 public Event getEventDetails(int eventId){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			Event event =null;
			
		final String SELECT_QUERY = "select eventId,eventName,date,startTime,endTime,fee,venue,details,eventPic,categoryId from event where eventId = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, eventId);
			rst = pst.executeQuery();
			if(rst.next()){
				 event = new Event();
				 EventCategory ec = new EventCategory();
				 ec.getId();
				 event.setId(rst.getInt(1));
				 event.setName(rst.getString(2));
				 event.setDate(rst.getDate(3));
				 event.setStartTime(rst.getString(4));
				 event.setEndTime(rst.getString(5));
				 event.setFee(rst.getDouble(6));
				 event.setVenue(rst.getString(7));
				 event.setDetails(rst.getString(8));
				 event.setEventPic(rst.getString(9));
				 event.setCategoryId(ec);
				 
			System.out.println(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
		}
	 public void insert(Event event) {
	        PreparedStatement pst = null;
	        Connection con = null;
	       
	        final String SQL_INSERT = "insert into event(eventName,date,startTime,endTime,fee,venue,eventPic,details,status,categoryId,userId) values(?,?,?,?,?,?,?,?,?,?,?)";
	        try {
	            con = DBConnection.getConnection();
	            pst = con.prepareStatement(SQL_INSERT);
	            pst.setString(1,event.getName());
	            pst.setDate(2, new java.sql.Date(event.getDate().getTime()));
	            pst.setString(3,event.getStartTime());
	            pst.setString(4,event.getEndTime());
	            pst.setDouble(5,event.getFee());
	            pst.setString(6,event.getVenue());
	            pst.setString(7, event.getEventPic());
	            pst.setString(8,event.getDetails());
	            pst.setString(9,event.getStatus());
	            pst.setInt(10, event.getCategoryId().getId());
	            pst.setInt(11, event.getUserId().getId());
	        
	           
	            pst.executeUpdate();
	            System.out.println("the record is updated");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }    
public int Edit(Event eve) {
     System.out.println(eve);
       Connection con = null;
       PreparedStatement pst = null;
       int x = 0;
           try {
               con = DBConnection.getConnection();
               System.out.println("inside edit" + con);
               pst = con.prepareStatement("update event set eventName=?, date=?, startTime=?, endTime=?, fee=?, venue=?, eventPic=?, details=?, status=?, categoryId=? where eventId = ?");

               pst.setString(1, eve.getName());
               pst.setDate(2, new java.sql.Date(eve.getDate().getTime()));
               pst.setString(3, eve.getStartTime());
               pst.setString(4, eve.getEndTime());
               pst.setDouble(5, eve.getFee());
               pst.setString(6, eve.getVenue());
               pst.setString(7, eve.getEventPic());
               pst.setString(8, eve.getDetails());
               pst.setString(9, eve.getStatus());
               pst.setInt(10,   eve.getCategoryId().getId());
               pst.setInt(11,   eve.getId());
               
               System.out.println("Going to update");
               x = pst.executeUpdate();
               System.out.println("Inside Update....."+eve);
           } catch (SQLException e) {               
               e.printStackTrace();
           }   
           finally{
               try {
                   con.close();
               } catch (SQLException e) {               
                   e.printStackTrace();
               }
           }
           return x;
       }
}