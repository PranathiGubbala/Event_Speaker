package com.es.dto;

public class EventCategory {
	private int id;
	private String name;
	private Admin adminId;
	
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
	public Admin getAdminId() {
		return adminId;
	}
	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "EventCategory [Id=" + id + ", Name=" + name + ", adminId=" + adminId
				+ "]";
	}

}
