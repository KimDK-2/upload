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
            double change = Double.parseDouble(request.getParameter("value"));
            String u = request.getParameter("unit");
            double result = 0;
            
            if(u.equals("cm")){
            	result = change * 0.3937;
            } else if(u.equals("㎡")){
                result = change * 0.3025;
            } else if(u.equals("℃")){
            	result = (change * 9/5.0) + 32;
            } else if(u.equals("km/h")){
            	result = change * 0.621371;
            }
            
         %>
         
        <div>
            <div>변환결과</div>
            <div><%=change %> cm</div>
            <div>↓</div>
            <div><%=result %><span class ></span></div>
            <div><button onclick="location.href='input.html'">돌아가기</button></div>
        </div>
         
            
         
         
         
         
</body>
</html>