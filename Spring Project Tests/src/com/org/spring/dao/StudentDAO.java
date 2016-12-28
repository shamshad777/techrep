package com.org.spring.dao;

import java.util.List;

import com.org.spring.to.StudentTO;

public interface StudentDAO {

	
	public boolean insertStudents(List<StudentTO> list);
	
}
