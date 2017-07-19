/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletes;

import Beans.GeneralQuestionAnswer;
import Beans.User;
import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Savinda Keshan
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            User user = new User();
            user = user.signUp(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
            if (user.getId() != null) {

                ArrayList<String> answers = new ArrayList<String>();
                answers.add(request.getParameter("answer1"));
                answers.add(request.getParameter("answer2"));
                answers.add(request.getParameter("answer3"));
                answers.add(request.getParameter("answer4"));
                answers.add(request.getParameter("answer5"));
                answers.add(request.getParameter("answer6"));

                GeneralQuestionAnswer gn = new GeneralQuestionAnswer();

                if (gn.addAnswer(user.getId(), answers)) {
                    out.print("success");
                    HttpSession sessionUser = request.getSession();
                    sessionUser.setAttribute("email", request.getParameter("email"));
                } else {
                    out.print("fail");
                }
            } else {
                out.print("fail");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
