package com.org.spring.mvc;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.org.spring.service.AdminServiceImpl;
import com.org.spring.to.StudentTO;

@Controller
public class AdminController {

	@Autowired
	private FileValidator validator;

	@Autowired
	private AdminServiceImpl service;

	@RequestMapping(value = { "/showupload.do" })
	public String showUploadPage() {

		return "upload";

	}

	@RequestMapping(value = { "/upload.do" }, method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute(value = "uploadCommand") UploadCommand command, BindingResult errors,
			HttpServletRequest req, @RequestParam("file") CommonsMultipartFile file) {
		System.out.println("This is uploadFile method");

		System.out.println(file.getSize());

		validator.validate(command, errors);

		if (errors.hasErrors()) {
			 req.setAttribute("MSG", "Error occured.");
			System.out.println(errors.getErrorCount());
			return "upload";

		} else {

			File uploadedFile = service.uploadFile(file);
			List<StudentTO> students = service.processFile(uploadedFile);
			Boolean flag = service.addStudents(students);
			
			System.out.println(students);
			
			System.out.println("--" + uploadedFile + "--");

			if (uploadedFile != null) {
				System.out.println("Done");
				return "success";

			} else {
				req.setAttribute("MSG", "File was not able to upload.");
				return "upload";

			}

		}

	}

}
