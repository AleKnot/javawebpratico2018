<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SALVA PESSOA COM JSP</title>
</head>
<body>
	<h1>SALVA PESSOA COM JSP</h1>


	<form action="setPessoa" method="POST">

		<div>
			<label>Name:</label><input id="txfName" type="text" size="30"
				maxlength="100" id="name" />
		</div>
		<div>
			<label>B-Day:</label><input id="txfBirthDate" type="Date"
				value="2018-02-25" size="12" name="birthDate"/>
		</div>
		<div>
			<label>Identification:</label><input id="txfIdentification"
				type="text" name="identification"/>
		</div>
		<div>
			<label>Picture:</label><input id="txfPicture" type="url" size="80"
				value="https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg" name="picture"/>
		</div>
		<div>
			 <input type="submit" value="Submit">
		</div>
	</form>

</body>
</html>