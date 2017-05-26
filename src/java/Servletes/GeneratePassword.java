/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletes;

import Beans.User;
import Algorithm.GenPassword;
import Beans.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Savinda Keshan
 */
@WebServlet(name = "GeneratePassword", urlPatterns = {"/GeneratePassword"})
public class GeneratePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            User user = new User();
            user.getUser(request.getParameter("user_email"));
            String id = user.getName();
            String email = user.getEmail();
            String userEmail = request.getParameter("user_email");

            GenPassword password = new GenPassword();
            ArrayList<Question> questionList = new ArrayList<Question>();

            questionList = password.genPassword(user.getId());
            String passwordText = "";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetUserPass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<ol>");
            for (int i = 0; i < questionList.size(); i++) {
                Question temp = questionList.get(i);
                passwordText += temp.getRandAnswer();
                out.println("<li> <b>question :</b> " + temp.getQuestion() + " <b>answer :</b> " + temp.getAnswer() + " <b>from :</b> " + temp.getFrom() + " <b>order :</b> " + temp.getOrder() + " <b>num of characters :</b> " + temp.getRandSize()+"</li>");
            }
            out.println("</ol>");
            out.println("  password : " + passwordText);
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            System.out.println(e);
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
