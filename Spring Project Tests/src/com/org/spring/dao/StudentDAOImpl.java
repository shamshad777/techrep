package com.org.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.org.spring.hibernate.Student;
import com.org.spring.to.StudentTO;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public boolean insertStudents(List<StudentTO> list) {
		// TODO Auto-generated method stub
		
		System.out.println("Insert student method:"+list);
		System.out.println("Hibernate Temp:"+hibernateTemplate);
		
		Student student = new Student();
		student.setName("Sa");
		student.setPhone(9999999l);
		student.setEmail("sasa@gmail.com");
		student.setCourse("Java");
		student.setCounsellor("Abc");
		
		
		
		
		//System.out.println(list.get(1));
		
		
		//hibernateTemplate.save(student);
		System.out.println(" rows affected.");
		
		return true;
			
		}
		
	
	

}



