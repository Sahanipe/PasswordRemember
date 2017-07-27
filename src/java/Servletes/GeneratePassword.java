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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Savinda Keshan
 */
@WebServlet(name = "GeneratePassword", urlPatterns = {"/GeneratePassword"})
public class GeneratePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession sessionUser = request.getSession(false);
            String email = (String) sessionUser.getAttribute("email");

            User user = new User();
            user.getUser(email);
            String id = user.getName();
            String userEmail = request.getParameter("user_email");

            GenPassword password = new GenPassword();
            ArrayList<Question> questionList = new ArrayList<Question>();

            questionList = password.genPassword(user.getId());
            String passwordText = "";

            ArrayList<String> index = new ArrayList<String>();
            index.add("First");
            index.add("Second");
            index.add("Third");
            index.add("Forth");
            index.add("Fifth");
            index.add("Sixth");
            index.add("Seventh");
            index.add("Eighth");

            String content = "";
            String json = "{";
            int x = 1;
            for (int i = 0; i < questionList.size(); i++) {
                int j = i + 1;
                Question temp = questionList.get(i);
                String json1 = "\"hint"+j+"\":[\"" + temp.getType() + "\",\"" + j + "\",\"" + temp.getqId() + "\",\"" + temp.getRandSize() + "\",\"" + temp.getFrom() + "\",\"" + temp.getOrder() + "\",\"" + temp.getRandAnswer() + "\"]";
                json += json1;
                if (i != questionList.size() - 1) {
                    json += ",";
                } else {
                    json += "}";
                }

                if (temp.getType() != "CHAR") {
                    passwordText += temp.getRandAnswer();
                    if (i == 0) {
                        content += "<div class=\"panel-group\" style=\"margin-top: 20px;\">";
                    } else {
                        content += "<div class=\"panel-group\" style=\"margin-top: -15px;\">";
                    }
                    content += "                                                <div class=\"panel panel-default\">\n"
                            + "                                                    <div class=\"panel-heading\" >\n"
                            + "                                                        <h4 class=\"panel-title\">\n"
                            + "                                                            <a data-toggle=\"collapse\" href=\"#hint" + x + "\"><b>Hint for character \"" + temp.getRandAnswer() + "\"</b></a>\n"
                            + "                                                        </h4>\n"
                            + "                                                    </div>\n"
                            + "                                                    <div id=\"hint" + x + "\" class=\"panel-collapse collapse\">\n"
                            + "                                                        <div class=\"panel-body\">\n"
                            + "                                                            <small><b>" + index.get(x - 1) + " " + temp.getRandSize() + " characters of the generated password<br>\n"
                            + "                                                                    " + temp.getOrder() + " order of the " + temp.getFrom() + " " + temp.getRandSize() + " characters in answer to question<br>\n"
                            + "                                                                    " + temp.getQuestion() + "</b>\n"
                            + "                                                            </small>\n"
                            + "                                                        </div>\n"
                            + "                                                    </div>\n"
                            + "                                                </div>\n"
                            + "                                            </div>";
                    x++;
                }
                else{
                    passwordText += "<span style=\"color:blue\">"+temp.getRandAnswer()+"</span>";
                }
            }

            String content1 = "<h3 style=\"color: #489FDF;\">Generate new password</h3>\n"
                    + "                                            <h4 style=\"margin-top: 20px\"><b>Generated Password : " + passwordText + "</b></h4>\n"
                    + "                                            <h4 style=\"margin-top: 15px\"><b>Password Hints :</b></h4>" + content + "<div class=\"row\">\n"
                    + "                                                <div class=\"col-md-6\">\n"
                    + "                                                    <button type=\"button\" class=\"btn btn-lg btn-block\" onclick=\"generatePwd()\" style=\"background-color: #69b6ee; color: white;\">\n"
                    + "                                                        <span class=\"glyphicon glyphicon-search\"></span> Generate another password\n"
                    + "                                                    </button>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-md-6\">\n"
                    + "                                                     <input type='hidden' id='jsonArray' value='" + json + "' />"
                    + "                                                    <button type=\"button\" class=\"btn btn-lg btn-block\" onclick=\"addHints()\" style=\"background-color: #32CD32; color: white;\">\n"
                    + "                                                        <span class=\"glyphicon glyphicon-search\"></span> Accept password\n"
                    + "                                                    </button>\n"
                    + "                                                </div>\n"
                    + "                                            </div>";

            out.print(content1);

//            out.println("<ol>");
//            for (int i = 0; i < questionList.size(); i++) {
//                Question temp = questionList.get(i);
//                passwordText += temp.getRandAnswer();
//                out.println("<li> <b>question :</b> " + temp.getQuestion() + " <b>answer :</b> " + temp.getAnswer() + " <b>from :</b> " + temp.getFrom() + " <b>order :</b> " + temp.getOrder() + " <b>num of characters :</b> " + temp.getRandSize() + "</li>");
//            }
//            out.println("</ol>");
//            out.println("  password : " + passwordText);
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
