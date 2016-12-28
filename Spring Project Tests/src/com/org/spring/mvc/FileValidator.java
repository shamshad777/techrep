package com.org.spring.mvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clas) {
		// TODO Auto-generated method stub
		return UploadCommand.class.equals(clas);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub

		UploadCommand command = (UploadCommand) obj;

		CommonsMultipartFile file = command.getFile();
		
	
System.out.println("validate");
		if (file.getSize() > 100000) {
			System.out.println("Inside validate:"+file.getSize());
			errors.rejectValue("file", "errors.file.size", "File is too large");

		}
		else if(!file.getOriginalFilename().endsWith("xls") && !file.getOriginalFilename().endsWith("xlsx") )
		{
			
			errors.rejectValue("file", "errors.file.type", "Not an excel file");
			
			
		}
			
		
	
	}

}
