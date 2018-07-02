package com.es.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.es.dbutility.DBConnection;
import com.es.dto.*;

public class RegisteredEventDAO {
    public int register(RegisteredEvents part){
        final String INSERT_QUERY="insert into registeredEvents(eventId,pId) values(?,?)";
        PreparedStatement pst = null;
        int status=0;
        
        try(Connection con=DBConnection.getConnection();) {
            pst=con.prepareStatement(INSERT_QUERY);
            pst.setInt(1, part.getEventId().getId());
            pst.setInt(2, part.getParticipantId().getId());
            status=pst.executeUpdate();
            System.out.println("update over");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
        
    }
}

