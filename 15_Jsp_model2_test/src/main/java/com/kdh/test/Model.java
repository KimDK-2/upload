package com.kdh.test;

import javax.servlet.http.HttpServletRequest;

public class Model {

    public static void member(HttpServletRequest request) {
         String name = request.getParameter("name");
         String age = request.getParameter("age");
         String gender = request.getParameter("gender");
         String[] habit = request.getParameterValues("habit");


        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);

        String habit2 ="";
        for (String h : habit){
            System.out.println(h);
            habit2 += h + "/";
        }

               // 한번에 뭉쳐서 보내자. (객체)

        Information info = new Information(name,age,gender,habit2);

        request.setAttribute("information",info);

         }
    }

