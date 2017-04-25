<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/static/scc/bootstrap.min.css" rel="stylesheet">
<link href="/static/scc/style.css" rel="stylesheet">
<title>Sign Up</title>

</head>
<style>

.jumbotron { 
font-family: Arial, Helvetica, sans-serif;    background-color:		#077E94; 
    color:#F2F2F2;
}
.table {
 background-color:		#F3F1F0; 
  color:	#077E94;
  text-align: left;
      padding: 50px 40px;
	 
  }
  
  .btn{
  color:	#077E94	  ;
   font-family: Arial, Helvetica, sans-serif;
   
  }
  
   .navbar{
      background-color: #F3F1F0; 
    color:	#077E94	;
     border-style: none;
      font-family: Arial, Helvetica, sans-serif;
     
  }
  
  .nav.navbar-nav li a{
   color:	#077E94	  ;
   font-family: Arial, Helvetica, sans-serif;
  }
  
  
</style>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">BWise</a>
    </div>
    <ul class="nav navbar-nav">
     <li><a href="login">Login</a></li>   
    </ul>
  </div>
  </nav>
  
  
  <!-- Retrieving the information which has just been passed through the 
  		registration form and been saved to database and printing it out -->
	<center>
	<h1>Welcome <b><i>${User1.firstName} ${User1.lastName} </i></b>to Bwise!</h1>
<div></div>
<h2>Thank you for creating an account with us using the username:<i><b> ${User1.username}</b></i> </h2>
	</center>
	
	
	
</body>
</html>
