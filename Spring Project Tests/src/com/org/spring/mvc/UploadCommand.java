package com.org.spring.mvc;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadCommand {

	

	private String name = null;
	
	
	private CommonsMultipartFile file = null;

	
	


	/**
	 * @param name the name to set
	 */


	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		
		this.name = name;
	}


	/**
	 * @return the file
	 */
	public CommonsMultipartFile getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}


	
	
	
	
}
