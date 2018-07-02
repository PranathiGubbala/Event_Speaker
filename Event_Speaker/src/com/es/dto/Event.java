package com.es.dto;
import java.util.Date;
public class Event {
	private int id;
	private String name;
	private Date dateOfEvent;
	private String startTime;
	private String endTime;
	private double fee;
	private String venue;
	private String eventPic;
	private User userId;
	private EventCategory categoryId;
	private String details;
	private String status;
	
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
	public Date getDate() {
		return dateOfEvent;
	}
	public void setDate(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getEventPic() {
		return eventPic;
	}
	public void setEventPic(String eventPic) {
		this.eventPic = eventPic;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public EventCategory getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(EventCategory categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Event [Id=" + id + ", Name=" + name + ", date=" + dateOfEvent
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", fee="+ fee +", venue=" + venue + ", eventPic=" + eventPic + ", details=" + details + ",status=" + status + ",userId=" + userId + ", categoryId=" + categoryId + ", details=" + details + ",status=" + status + "]";
	}
}
