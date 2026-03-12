<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
         <%
          
          String[] sports = request.getParameterValues("sports");
         String result = "";
         for(String ss : sports){
             result += ss + " / ";
         }
         
         String korResult = "";
         for(String ss : sports) {
             switch (ss) {
             case "soccer":
                 korResult += "축구 ";
                 break;
             case "basketball":
                 korResult += "농구 ";
                 break;
             case "badminton":
                 korResult += "배드민턴 ";
                 break;
             }
         }
         for(String sport : sports){ %>
             <h1> <%= sport%> </h1>
         <% }
         %>
         <hr>
     <h1>    <%=result %></h1>
     <h1>    <%=korResult %></h1> 
         
         
         
         <hr>
         version2.
        
               
     
         
        
         
         
         
         
</body>
</html>