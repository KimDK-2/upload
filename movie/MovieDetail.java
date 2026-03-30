package com.kdh.board.movie;

import com.kdh.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail-movie")
public class MovieDetail extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         // 클릭 조회
       // MovieDAO.getMovie(request);
       MovieDAO.MDAO.getMovie(request);

        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie_detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}