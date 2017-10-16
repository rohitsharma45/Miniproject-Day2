package com.cg.miniproject.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;
import com.cg.miniproject.service.IMiniprojectService;
import com.cg.miniproject.service.MiniprojectServiceImpl;

public class Controller {

	static Scanner sc=new Scanner(System.in);
	static MiniprojectBean bean=null;
	static MacBean mac=null;
	
	
	Date date=new Date();
	public static void main(String[] args) {
		Controller  c=new Controller();
		bean=new MiniprojectBean();
		mac=new MacBean();
		ArrayList<MacBean> list=new ArrayList<MacBean>();
		
		int res=0;
		IMiniprojectService service=new MiniprojectServiceImpl();
		
		
	
		System.out.println("Enter your role");
		System.out.println("\n 1.Applicant"
						  +"\n 2.MAC"
						  +"\n 3.Admin"
						  +"\n 4.Exit");
		int role=sc.nextInt();
		switch(role){
		
		case 1:
			System.out.println("\n 1.Mumbai"
						  	  +"\n 2.Pune"
						  	  +"\n 3.Delhi"
						  	  +"\n 4.Hyderabad"
						  	  +"\n 5.Exit");
			System.out.println("Enter your desired university:");
			int university=sc.nextInt();
			switch(university){
			case 1:
				System.out.println("\n 1.EXTC(E100)"
						+ "\n 2.IT(I100)"
						+ "\n 3.Exit");
				System.out.println("Enter your desired program course");
				int course=sc.nextInt();
				
				switch(course){
				
				case 1:
					System.out.println("Application form for EXTC course");
					bean=c.fillForm();
					//bean.setProgramId("E100");
					bean.setStatus("Applied");
					bean.setInterviewDate(null);
					res=service.insertData(bean);
					System.out.println("Your application id is:"+res);
					break;
					
				case 2:
					System.out.println("Application form for IT course");
					bean=c.fillForm();
					bean.setProgramId("I100");
					bean.setStatus("Applied");
					bean.setInterviewDate(null);
					res=service.insertData(bean);
					System.out.println("Your application id is:"+res);
					break;
					
				case 3:
					System.exit(0);
					break;
				}
				
				
			}
		break;
		case 2:
			boolean b=true;
			System.out.println("Enter the login id");
			String id=sc.next();
			System.out.println(id);
			mac.setLoginId(id);
			System.out.println(mac.getLoginId());
			System.out.println("Enter the password");
			mac.setPassword(sc.next());
			b=service.checkLogin(mac);
			
			if(b==true)
				System.out.println("authenticated");
			else
				System.out.println("Wrong credencials");
			
			
		}
		
			
	}
	
	public MiniprojectBean fillForm()
	{	
		bean=new MiniprojectBean();
		System.out.println("Enter your first name");
		String firstName=sc.next();
		System.out.println("Enter your last name");
		String lastName=sc.nextLine();
		String fullName=firstName.concat(" ").concat(lastName);
		bean.setFullName(fullName);
		sc.nextLine();
		System.out.println("Enter your date of birth in this dd-mm-yyyy format");
		String dob=sc.nextLine();
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		try {
			date=df.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setDateOfBirth(date);
		System.out.println("Enter the highest qualification");
		String qualification=sc.next();
		bean.setQualification(qualification);
		System.out.println("Enter the marks obtained");
		int marksObt=sc.nextInt();
		bean.setMarks(marksObt);
		sc.nextLine();
		System.out.println("Enter the goals");
		String goals=sc.nextLine();
		bean.setGoals(goals);
		System.out.println("Enter your emailid");
		String emailId=sc.next();
		bean.setEmail(emailId);
		return bean;
	}
}
