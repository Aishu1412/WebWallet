<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>h1{text-align:center;}
input[type=submit] {
    background-color: grey;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    padding-right:30px;
}
input[type=submit]:hover {
    background-color: silver;
}</style> 
<meta charset="ISO-8859-1">
<title>QR READER</title>
</head>
<body>


<div class="alert alert-success center" role="alert">
				<p>${Validation}</p>
			</div>
		
			<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>
<form action="<%=request.getContextPath()%>/WebcamServlet" method="post">
<h1> The details are fetched!</h1>
<br>

<input type="submit" name="action" value="ReadQr">
</form>
</body>
</html>