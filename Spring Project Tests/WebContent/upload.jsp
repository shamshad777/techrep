<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
</head>
<body>
<body>

        <h1>File Upload Form</h1><br />

        <form action="upload.do" enctype="multipart/form-data" method="POST">

        <table>

         <tr><td colspan="2" style="color: red;"><form:errors path="*" cssStyle="color : red;"/>

         ${errors}

         </td></tr>

         
 	     <tr><td>Select File : </td><td><input type="file" name="file" /></td>
 	     
 	     <td><font color="red" size="5"><form:errors path="file" cssStyle="color : red;" />${MSG} </font></td>
 	     </tr>
        </br>
         <tr><td></td><td colspan="2"><input type="submit" value="Upload File" /></td></tr>
		
		
        </table>

        </form>

    </body>

</body>
</html>