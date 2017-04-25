<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
  <title>BWise-Budget Manager</title>
  <meta charset="utf-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/static/scc/bootstrap.min.css" rel="stylesheet">
<link href="/static/scc/style.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  //Function of date selection for the search
  $( function() {
    $( "#date_from" ).datepicker();
    $( "#date_to" ).datepicker();
  } );
  
  </script>
  
  <!-- Convert to PDF and print function -->
  <!--  Adapted from http://stackoverflow.com/questions/43444279/css-not-being-applied-to-print -->
  <script type="text/javascript" >
  function printResultSearch() {
	  var divToPrint = document.getElementById('table_to_print');
      newWin = window.open("");
      newWin.document.write(divToPrint.outerHTML);
      newWin.print();
      newWin.close();
};
  </script>
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


<!-- HOMEPAGE DISPLAY -->
<c:choose>
<c:when test="${mode == 'MODE_HOME' }">
 
  <div >
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a style="color:#077E94;" class="navbar-brand" href="/">BWise</a>
    </div>
    
      <ul class="nav navbar-nav navbar-right">  
       <li><a href="login">Login</a></li>   
      <li><a href="RegisterUser">Register</a></li>     
    </ul>
  </div>
</nav>
  
<div class="container " id="homeDiv">
  <div class="jumbotron">
   <br>
  
    <h1 >BWise</h1> 
    <h2 style="font-family:courier;">Have Your own Spending Tracker</h2> 
    <p style="font-family:courier;">Be Wise with your budget!</p> 
     <br>
     <br>
    
  </div>
    </div>
   <br>
   <br>
  
</div>


<!-- Transaction Table display along with Date Search -->

</c:when>
<c:when test="${mode == 'MODE_TRANSACTIONS' }">
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a style="color:#077E94;" class="navbar-brand" href="/">BWise</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="new-transaction">Add Spending</a></li>
      <li><a href="all-transactions">Spending Manager</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">  
       <li><a href="logout">Logout</a></li>   
         
    </ul>
  </div>
</nav>
<div class="container text-left" id="transDiv">

<!-- Search form -->
<!-- Searching transactions based on date -->
<div id="search_div" style="float: left;">
<form action="search" method="post">
<h2 style="font-family:courier;">Search History</h2> 
<br>
    <p>From: <input type="text" name="date_from" id="date_from"/>
    To: <input type="text" name="date_to" id="date_to" />
    <button style="font-family:courier;" type="submit" class="btn btn-default">Search</button></p>
    
    <br>
     
        <br>    
    </form>
</div>
        <br>    
        <br>    
        <br> 
           
   <!-- Transaction Table -->
     <table class="table table-striped text-left" id="table_to_print">
     
    <thead>
      <tr>        
        <th>Amount</th>
        <th>Spend for:</th>
        <th> Date</th>
          
     <th></th>
      </tr>
    </thead>
    <tbody >
    <c:set var="totalSpending" value="${0}" />
     <c:forEach var="transaction" items="${transactions}">
     
     <tr>     
         
      <td style="width: 100px">${transaction.amount}</td>
       <td style="width: 250px">${transaction.type}</td>
        <td style="width: 200px">${transaction.dateTransfered}</td>
        
       
<c:set var="totalSpending" value="${totalSpending + transaction.amount}" />

<!-- UPDATE & DELETE Buttons -->
      <th style="width: 50px"><a href="update-transaction?id=${transaction.id}"><spam class="glyphicon glyphicon-pencil"></spam></a> </th>
     <th style="width: 200px"><a href="delete-transaction?id=${transaction.id}"><spam class="glyphicon glyphicon-trash"></spam></a> </th>
     
     
     </tr>
     
     </c:forEach>
    
    </tbody>
   
     <tr>
     <td><font style=" font-family:courier;" size="6" color="#11007A">Total:</font></td>
    <td ><font style=" font-family:courier;" size="6.5" color="#11007A" >${totalSpending}</font></td>
         <td></td>
         <td></td>
         <td></td>
    
    </tr>
  </table>
       <br>
       <!-- Convert to PDF Button -->
        <button style="font-family:courier;"  class="btn btn-default btn-block"  onclick="printResultSearch()">PRINT REPORT</button>
  
</div>
   

    <br>
    <br>
    
    <!--  Adding New Transaction  -->
  </c:when>
<c:when test="${mode == 'MODE_NEW' ||  mode == 'MODE_UPDATE'}">
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a style="color:#077E94;" class="navbar-brand" href="/">BWise</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="new-transaction">Add Spending</a></li>
      <li><a href="all-transactions">Spending Manager</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">  
             <li><a href="logout">Logout</a></li>   

    </ul>
  </div>
</nav> 
    <div class="pull-left">
  <div class="container text-left"> 
  
  <form class="form-vertical"  method="POST"  action="save-transaction">
  <input type="hidden" name="id" value= "${transaction.id}">
    <div class="form-group ">
    
      <label style="font-family:courier; class="control-label col-sm-7  ">Amount spent</label>
      <input  type="number" class="form-control" name="amount" value="${transaction.amount}">
          </div>
          
           <div class="form-group">
    
      <label  style="font-family:courier; class="control-label col-sm-7">FOR?</label>
      <input type="text" class="form-control" name="type" value="${transaction.type}">
          </div>
           <br>
          
           <div class="form-group"> 
    <div class="pull-left">
      <button style="font-family:courier;"  type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
          
      </form>
      <br>
       <br>
        <br>
         <br>
           </div>
     
      </div>
      </c:when>
      </c:choose>
     
 
</body>
</html>
