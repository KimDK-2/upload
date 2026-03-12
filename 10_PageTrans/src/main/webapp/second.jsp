<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>second page~</h1>
       <% 
           // 1. 값 받기
           int aa = Integer.parseInt(request.getParameter("a"));
           int bb = Integer.parseInt(request.getParameter("b"));
       
           int cc = aa + bb;
           request.setAttribute("ccc", cc);
           
           /*
           (1). parameter
              html에서 만든 값 - input name / url(get 요청 시 만든 문자열)
              자료형 String, String[] _checkbox 할 때
              그런 값이 request 객체에 실려서 전송
              
           (2). attribute
              java에서 만든 값
              자료형 Object 다 됨.
              request 객체에 실려서 전송
           
              자동 이동 시리즈 3개
              1. redirect - 공사중 / 작업 완료, 만료
                 - 값을 잃어버림
              
              2. forward
              first에서 second로 넘어올 때 요청한 정보를 third까지 보내줌.
              
              redirect는 그냥 넘기는거 (문자열로 원하는 값을 명시해서 보내는건 가능)

              forward는 request에 값이 실려서 넘어오는건데
              그 request를 같이 넘기니까 third가 그 값을 쓸 수 있음
              
              3. include (어떤 jsp속에 jsp)
                 관심없음.(?)
                 
           
           */ 
           
           //  response.sendRedirect("third.jsp");
               RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
               rd.forward(request, response); 
           
   
       %>
       <%=cc %>
       
       
       
       
       
       
</body>
</html>