package com.org.spring.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.org.spring.dao.StudentDAOImpl;
import com.org.spring.to.StudentTO;

@Component
public class AdminServiceImpl implements AdminService {

	
	// HibernateTemplate working
	
	@Autowired
	HibernateTemplate hTemp;
	
	
	
	
	@Override
	public File uploadFile(CommonsMultipartFile file) {
		
		System.out.println("hTemp:"+hTemp);
		// TODO Auto-generated method stub
		String filePath = System.getProperty("user.home") + "/Desktop/Uploaded Files/" + file.getOriginalFilename();

		try (FileOutputStream outputStream = new FileOutputStream(new File(filePath));) {

			CommonsMultipartFile f = new CommonsMultipartFile(file.getFileItem());
			System.out.println(filePath);
			outputStream.write(f.getFileItem().get());

			// System.out.println(outputStream);

			File uploadedFile = new File(filePath);
			return uploadedFile;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StudentTO> processFile(File file) {
		// TODO Auto-generated method stub
		
		Workbook workbook;
		List<StudentTO> ls = new ArrayList<>();

		try (ByteArrayInputStream bis = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));) {

			if (file.getName().endsWith("xls")) {
			//	System.out.println("xls");
				workbook = new HSSFWorkbook(bis);
			} else if (file.getName().endsWith("xlsx")) {

				System.out.println("xlsx");
				workbook = new XSSFWorkbook(bis);

				XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

				Iterator<Row> rowIterator = sheet.iterator();
				System.out.println(rowIterator.hasNext());

				while (rowIterator.hasNext()) {

					Row row = rowIterator.next();

				//	System.out.println("Row number:" + row.getRowNum());
					if (row.getRowNum() == 0) {

						continue;
					} else {

					//	System.out.println("inside rowiterator");
						Iterator<Cell> cellIterator = row.cellIterator();
						StudentTO to = new StudentTO();

						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							//System.out.println("inside celliterator");
							// System.out.println(cell.getColumnIndex());
							switch (cell.getColumnIndex()) {
							case 0:
							//	System.out.println("case 0");
								Double id = cell.getNumericCellValue();

								to.setId(id.intValue());
								break;

							case 1:
						//		System.out.println("case 1");
								to.setName(cell.getStringCellValue());

								break;

							case 2:
							//	System.out.println("case 2");
								Double phone = cell.getNumericCellValue();

								to.setPhone(phone.longValue());

								break;

							case 3:
						//		System.out.println("case 3");
								to.setEmail(cell.getStringCellValue());
								break;

							case 4:
						//		System.out.println("case 4");
								to.setCourse(cell.getStringCellValue());
								break;

							case 5:
						//		System.out.println("case 5");
								to.setCounsellor(cell.getStringCellValue());
						//		System.out.println("hello");
								ls.add(to);

								
								break;

							}
							
							

						//	System.out.println("done it");

						}

					}

				}

			//	System.out.println("Number of sheets:" + workbook.getNumberOfSheets());

				

			} else {
				
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");

			}
			System.out.println("Number of sheets:" + workbook.getNumberOfSheets());
		} catch (IOException ex) {
			ex.printStackTrace();
			

		} catch (IllegalArgumentException ex) {

			ex.printStackTrace();
			

		}

		return ls;
		
	}

	@Override
	public Boolean addStudents(List<StudentTO> list) {
		// TODO Auto-generated method stub
		return new StudentDAOImpl().insertStudents(list);
	}

}
