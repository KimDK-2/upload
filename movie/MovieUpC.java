package com.kdh.board.movie;

import com.kdh.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class MovieUpC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 그 영화 하나 정보
       // MovieDAO.getMovie(request);
      MovieDAO.MDAO.getMovie(request);
        // 어디로?
        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie_up.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 수정
      // MovieDAO.upMovie(req);
      MovieDAO.MDAO.upMovie(req);


        //
//        MovieDAO.getMovie(req);
//
//        req.setAttribute("content", "jsp/movie/movie_detail.jsp");
//        req.getRequestDispatcher("index.jsp").forward(req, resp);
        resp.sendRedirect("detail-movie?no=" + req.getParameter("no"));
    }

    public void destroy() {
    }
}