package com.jobs.application;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {	

	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		try {
			Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
			EmployeeRepository.addMember(boss);
		}catch (Exception e){
			e.getStackTrace();
		}

	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{	
		try {
			Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
			EmployeeRepository.addMember(employee);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		try {
			Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
			EmployeeRepository.addMember(manager);	
		} catch (Exception e) {
			e.getStackTrace();
		}

	}


	public double payAllEmployeers() {
		
		double totalPaid;
		double payslip=0;
		
		for (AbsStaffMember m:EmployeeRepository.getAllMembers()){
			
			m.pay();
			
			payslip+=m.getTotalPaid();
		}
		return payslip;
	}

	public String getAllEmployees() {
		
		StringBuilder membersInList= new StringBuilder();
		membersInList.append("\n");
		
		for(AbsStaffMember m:EmployeeRepository.getAllMembers()) {
			
			membersInList.append(m.getId());
			membersInList.append("\t");
			membersInList.append(m.getName());
			membersInList.append("\n");
		}
		return membersInList.toString();
	}

	public void createVolunteer(String name, String address, String phone) throws Exception {
		try {
			Volunteer volunteer = new Volunteer(name, address, phone);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
}
