package com.kdh.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountEditC", value = "/user-edit")
public class AccountEditC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
             // 수정하는 곳으로 보내기(어디로?)
          if(AccountDAO.ADAO.loginCheck(request)){
           request.setAttribute("content", "jsp/account/edit.jsp");

          } else {
            request.setAttribute("content", "home.jsp");
          }
           request.getRequestDispatcher("index.jsp").forward(request, response);




    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (AccountDAO.ADAO.loginCheck(request)) {
               AccountDAO.ADAO.editUser(request);

        }

        response.sendRedirect("user-info");



    }


}


