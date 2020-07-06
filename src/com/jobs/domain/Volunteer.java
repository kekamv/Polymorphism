package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
		if(description.contentEquals("")) throw new Exception();
		
		this.description = description;
	}
	
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
	}
	
	@Override
	public void pay() {
		
		totalPaid=0;
		
	}

}
