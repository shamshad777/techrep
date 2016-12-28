package com.org.spring.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.org.spring.to.StudentTO;

public interface AdminService {

	public File uploadFile(CommonsMultipartFile file);
	
	public List<StudentTO> processFile(File file);
	
	public Boolean addStudents(List<StudentTO> list);
	
}
