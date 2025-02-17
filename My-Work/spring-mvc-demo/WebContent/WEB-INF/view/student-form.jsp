<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	
	
	<body>
		<form:form action="processForm" modelAttribute="student">
		
			First name: <form:input path="firstName"/>
			<br><br>
			Last name: <form:input path="lastName"/>
			<br><br>
			
			Country:
			<form:select path="country">
				<form:options items="${student.countryOptions}"></form:options>
			</form:select>
			
			<br><br>	
			
			Favorite Language: 	
			<form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}"/>
			
			<br><br>
			
			Operating Systems:
			<form:checkboxes items="${student.OsOptions}" path="operatingSystems"/>
			
			<br><br>
			<input type="submit" value="submit">
		</form:form>
	
	</body>

</html>