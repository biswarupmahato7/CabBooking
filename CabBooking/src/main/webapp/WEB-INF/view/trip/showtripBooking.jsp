<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>List of Cabs</title> 
 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

 <!-- jQuery library -->
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
 
 <!-- Popper JS -->
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 
 <!-- Latest compiled JavaScript -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>  
</head>  
<body> 
  <div class="container text-center" style= "background-color:white; margin: auto; padding-top: 90px;">
    <h1 class="fa fa-align-center" aria-hidden="true">Details of Trip</h1> 
        <table class="table table-dark" align="center">
            <thead class="thead">
                <tr>
                    
                    <th>fromLocation</th>
                    <th>toLocation</th>
                    <th>fromDateTime</th>
                    <th>toDateTime</th>
                    <th>distanceInKm</th>
                    <th>bill</th>
                    
                </tr>
            </thead>
            <c:forEach items="${triplist}" var="trip">
                <tr>
                   
                    <td>${trip.fromLocation}</td>
                    <td>${trip.toLocation}</td>
                    <td>${trip.fromDateTime}</td>
                    <td>${trip.toDateTime}</td>
                    <td>${trip.distanceInKm}</td>
                    <td>${trip.bill}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>  
</html>  