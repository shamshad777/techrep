package com.org.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.spring.hibernate.Student;
import com.org.spring.to.StudentTO;

@Repository
@Transactional 
public class StudentDAOImp implements StudentDAO {

	@Autowired
	HibernateTemplate hTemp;
	
	
	
	@Override
	public boolean insertStudents(List<StudentTO> list) {
		// TODO Auto-generated method stub
		
		Integer i;
		for(StudentTO sto : list)
		{
			
			Student student = new Student(sto.getName(), sto.getPhone(), sto.getEmail(), sto.getCourse(), sto.getCounsellor());
			
			
			
			i = (Integer) hTemp.save(student);
			System.out.println("Row inserted: pk-"+i);
			
			
		}
		
		hTemp.flush();
		hTemp.clear();
		
		return true;
	}

}
