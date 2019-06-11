<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Spring</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>

    
        <!-- <img src="https://m.media-amazon.com/images/M/MV5BZmUzOWFiNDAtNGRmZi00NTIxLWJiMTUtYzhkZGRlNzg1ZjFmXkEyXkFqcGdeQXVyNDE5MTU2MDE@._V1_SY1000_SX677_AL_.jpg"  type="image/jpg"> -->
   
<h2 > Registered </h2>

<c:if test="${empty obj}">

    We couldn't find what you are looking for right now ! <br>
    Please try other options.

</c:if>

<c:if test="${not empty obj}">

<c:forEach items="${obj}" var="item">
      <tr>
        <td>Type: <c:out value="${item.type}" /></td> <br>
        <td>No of BedRooms : <c:out value="${item.no_of_bedrooms}" /></td> <br>
        <td> Price :  <c:out value="${item.price}" /></td> <br>
        <td>Pincode :<c:out value="${item.pincode}" /></td> <br>
        <td>Key Features :<c:out value="${item.keyf}" /></td> <br>
        <td>Location :<c:out value="${item.location}" /></td> <br>
        <td>Description :<c:out value="${item.desc}" /></td> <br>
      </tr><br><br>
    </c:forEach>

</c:if>
    
 


</Form>
</body>
</html>
