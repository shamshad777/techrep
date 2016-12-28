package com.org.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.spring.to.StudentTO;

@Repository
@Transactional
public class StudentDAOImp implements StudentDAO {

	@Autowired
	HibernateTemplate hTemp;
	
	{
		
		
		System.out.println("Inside dao:"+hTemp);	
		
	}
	
	
	
	@Override
	public boolean insertStudents(List<StudentTO> list) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside dao:"+hTemp);
		
		
/*		System.out.println("Insert student method:"+list);
		
		
		Student student = new Student();
		student.setName("Sa");
		student.setPhone(9999999l);
		student.setEmail("sasa@gmail.com");
		student.setCourse("Java");
		student.setCounsellor("Abc");
		
		
		
		
		//System.out.println(list.get(1));
		
		
		Integer n = (Integer)hTemp.save(student);
		System.out.println(n+" rows affected.");*/
		
		
		return false;
	}

}
