<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<div class="container">
		<form:form action="addtripprocess" modelAttribute="tripBooking" method="post">
    
      <div class="form-group">
        <label for="fromLocation">From Location</label>
        <form:input path="fromLocation"  class="form-control"/>
      </div>

      <div class="form-group">
        <label for="toLocation">To Location</label>
        <form:input path="toLocation"  class="form-control"/>
      </div>

      <div class="form-group">
        <label for="fromDateTime">From Date Time</label>
        <form:input path="fromDateTime"  class="form-control"/>
      </div>

      <div class="form-group">
        <label for="toDateTime">To Date Time</label>
        <form:input path="toDateTime"  class="form-control"/>
      </div>
      <div class="form-group">
        <label for="status">Status</label>
        <form:input path="status"  class="form-control"/>
      </div>

      <div class="form-group">
        <label for="distanceInKm">Distance (in km)</label>
        <form:input path="distanceInKm"  class="form-control"/>
      </div>

      <div class="form-group">
        <label for="bill">Bill (in Rs)</label>
        <form:input path="bill"  class="form-control"/>
      </div>
      <div class="form-group">
        <label for="customerId">customerId</label>
        <form:input path="customerId"  class="form-control"/>
      </div>
      <div class="form-group">
        <label for="driverId">driverId</label>
        <form:input path="driverId"  class="form-control"/>
      </div>
			
      <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
	
</body>
</html>