package com.kdh.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountDelectC", value = "/user-delete")
public class AccountDelectC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("hello-servlet");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            if (AccountDAO.ADAO.deleteUser(request)) {
            // 성공
            response.sendRedirect("hello-servlet");
        } else {
            // 실패
            response.sendRedirect("user-info");

        }

    }

}
