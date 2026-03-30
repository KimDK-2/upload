package com.kdh.board.main;

import com.kdh.board.account.AccountDAO;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    public void destroy() {
    }
}