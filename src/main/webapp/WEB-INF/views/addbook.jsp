	<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>add book</title>
</head>
<body>
<form action="addbook" method="POST">
	<label>Book Name:</label> 
	<input type="text" name="bookName">
	<br/>
	<input type="submit" value="Add To App" name="op"/>
	<input type="submit" value="Add To Session" name="op"/>
	<input type="submit" value="Add To Request" name="op"/>
</form>
</body>
</html>