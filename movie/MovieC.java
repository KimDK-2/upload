package com.kdh.board.movie;

import com.kdh.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MovieC", value = "/movie")
public class MovieC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String p = request.getParameter("p");
        int page = 1;
       // MovieDAO.selectAllMovie(request);

         MovieDAO.MDAO.selectAllMovie(request);
         MovieDAO.MDAO.paging(page, request);
        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

        if (p != null) {
            page = Integer.parseInt(p);
        }

      //  MovieDAO.paging(page,request);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 등록하는 일
    //    MovieDAO.addMovie(req);
        MovieDAO.MDAO.addMovie(req);
        // 어디로?
        resp.sendRedirect("movie");
    }

    public void destroy() {
    }
}