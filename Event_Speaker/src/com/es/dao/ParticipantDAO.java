package com.es.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.es.dbutility.DBConnection;
import com.es.dto.Participant;

public class ParticipantDAO {
	public int add(Participant part){
		final String INSERT_QUERY="insert into participant(pName, mobileNumber, collegeName) values(?,?,?)";
		PreparedStatement pst = null;
		int status=0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, part.getName());
			pst.setString(2, part.getMobile());
			pst.setString(3, part.getCollege());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		}
	public List<Participant> getUserParticipants(String name,int userId){
        System.out.println("inside DAO" + name);
        System.out.println("inside DAO" + userId);
        
        List<Participant> li=new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rst = null;
        
    final String SELECT_QUERY = "select pName,mobileNumber,collegeName from participant  natural join registeredEvents re  where re.eventId = (select eventId from event where userId = ? and eventName = ?)";
    try(Connection con = DBConnection.getConnection();){
        pst = con.prepareStatement(SELECT_QUERY);
        
        pst.setInt(1, userId);
        pst.setString(2, name);
        
        
        rst = pst.executeQuery();
        
        while(rst.next()){
            Participant part = new Participant();
            part.setName(rst.getString(1));
            part.setMobile(rst.getString(2));
            part.setCollege(rst.getString(3));
            li.add(part);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    System.out.println(li);
    return li;
    }
	public int getId(){
        final String INSERT_QUERY="select max(pId) from participant";
        PreparedStatement pst = null;
        ResultSet rst = null;
        int status=0;
        int id = 0;
        try(Connection con=DBConnection.getConnection();) {
            pst=con.prepareStatement(INSERT_QUERY);
            rst=pst.executeQuery();
            if(rst.next()){
                Participant part = new Participant();
                part.setId(rst.getInt(1));    
            
            id = part.getId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
        }


}


