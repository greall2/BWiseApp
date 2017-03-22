<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/static/scc/bootstrap.min.css" rel="stylesheet">
<link href="/static/scc/style.css" rel="stylesheet">
</head>

<style>

.jumbotron { 
 font-family: "Comic Sans MS", cursive, sans-serif;
    background-color:		#CD6889; 
    color:#F2F2F2;
}
.table {
 background-color:		#FFF0F5; 
  color:	#8B1C62;
  text-align: center;
      padding: 50px 40px;
	 
  }
  
   .navbar{
      background-color: #FFF0F5; 
    color:	#8B1C62
	
  }

</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">BWise</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="new-transaction">New Transactions</a></li>
      <li><a href="all-transactions">All Transactions</a></li>     
    </ul>
  </div>



<c:choose>
<c:when test="${mode == 'MODE_HOME' }">
<div class="container" id="homeDiv">
  <div class="jumbotron">
    <h1>BWise</h1> 
    <p>Transaction manager</p> 
  </div>
  
</div>
</c:when>
<c:when test="${mode == 'MODE_TRANSACTIONS' }">
<div class="container text-center" id="transDiv">
  
    <h3>My transactions</h3> 
    
    
     <table class="table table-striped text-left">
    <thead>
      <tr>
        <th>   Transaction Id</th>
        <th>        Amount</th>
        <th>            Purpose</th>
        <th>                 Date</th>
          
     <th></th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="transaction" items="${transactions}">
     <tr>
     <td>${transaction.id}</td>
      <td>${transaction.amount}</td>
       <td>${transaction.type}</td>
        <td>${transaction.dateTransfered}</td>
       



      <th><a href="update-transaction?id=${transaction.id}"><spam class="glyphicon glyphicon-pencil"></spam></a> </th>
     <th><a href="delete-transaction?id=${transaction.id}"><spam class="glyphicon glyphicon-trash"></spam></a> </th>
     
     
     </tr>
     
     
     
     </c:forEach>
    </tbody>
  </table>
</div>
   
  </c:when>
<c:when test="${mode == 'MODE_NEW' ||  mode == 'MODE_UPDATE'}">


  


  
  <div class="container text-center">
  <h2>Manage Transaction</h2>
  <form class="form-horizontal"  method="POST"  action="save-transaction">
  <input type="hidden" name="id" value= "${transaction.id}">
    <div class="form-group">
    
      <label class="control-label col-sm-5">Amount:</label>
      <input type="number" class="form-control" name="amount" value="${transaction.amount}">
          </div>
          
           <div class="form-group">
    
      <label class="control-label col-sm-4">Type of transaction:</label>
      <input type="text" class="form-control" name="type" value="${transaction.type}">
          </div>
          
          <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Save</button>
      </div>
    </div>
          
      </form>
      </div>
      </c:when>
      </c:choose>
     
    
   
</nav>



  




</body>
</html>
