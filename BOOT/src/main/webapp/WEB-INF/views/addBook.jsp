<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="book" action="addBook" method="post">
		<fieldset>
			<legend>Add Book details</legend>
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
				<label for="title">Title: </label>
				<form:input path="title" id="title" /> <form:errors path="title" cssStyle="color : red;" />


			</p>

			<p>
				<label for="isbn">ISBN: </label>
				<form:input path="isbn" id="isbn" /> <form:errors path="isbn" cssStyle="color : red;" />


			</p>
			<p>
				<label for="author">Author: </label>
				<form:input path="author" id="author" /> <form:errors path="author" cssStyle="color : red;" />


			</p>
			<p>
				<label for="price">Price: </label>
				<form:input path="price" id="price" /> <form:errors path="price" cssStyle="color : red;" />



			</p>
			<p id="buttons">
				<input id="submit" type="submit" value="Add Book">
			</p>

		</fieldset>
	</form:form>



</body>
</html>