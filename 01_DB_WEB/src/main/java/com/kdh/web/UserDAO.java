package com.kdh.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
    public static void showAllPeople(HttpServletRequest request) {
        // 1. 값 or DB   껍데기 3종  con, pstmt, rs

        Connection  con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from NAME_AGE_TEST";
        try{
           con = DBManager.connect();
            System.out.println("connect success");
           ps = con.prepareStatement(sql);

           rs = ps.executeQuery();

           ArrayList<Human> humans = new ArrayList<>();
           Human human = null;
           while(rs.next()){
             human = new Human(rs.getString("n_name"), rs.getInt("n_age"));
             humans.add(human);
           }
            System.out.println(humans);
            request.setAttribute("humans", humans);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs, ps, con);
        }





    }

    public static void addPeople(HttpServletRequest request) {
      // 1. 값 or db

        Connection con = null;
        PreparedStatement ps = null;


        try{
        String name = request.getParameter("n_name");
        String age = request.getParameter("n_age");

        con = DBManager.connect();
        System.out.println("connect success");
        ps = con.prepareStatement("insert into NAME_AGE_TEST values(?,?)");
        ps.setString(1, name);
        ps.setInt(2, Integer.parseInt(age));

         if (ps.executeUpdate() == 0){
             System.out.println("insert success");
         }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(null, ps, con);
        }


    }
}
