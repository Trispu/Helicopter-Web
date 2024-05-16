/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "Error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_PAGE = "LoginController";
    private static final String REGISTER = "Register";
    private static final String REGISTER_PAGE = "RegisterController";
    private static final String SEARCH_USER = "SearchUser";
    private static final String SEARCH_USER_CONTROLLER = "SearchUserController";
    private static final String DELETE_USER = "DeleteUser";
    private static final String DELETE_USER_PAGE = "DeleteUserController";
    private static final String UPDATE_USER = "UpdateUser";
    private static final String UPDATE_USER_PAGE = "UpdateUserController";
    private static final String SEARCH_HELI = "SearchHelicopter";
    private static final String SEARCH_HELI_CONTROLLER = "SearchHelicopterController";
    private static final String DELETE_HELI = "DeleteHelicopter";
    private static final String DELETE_HELI_PAGE = "DeleteHelicopterController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals(LOGIN)) {
                url = LOGIN_PAGE;
            }
            if (action.equals(REGISTER)) {
                url = REGISTER_PAGE;
            }
            if (action.equals(SEARCH_USER)) {
                url = SEARCH_USER_CONTROLLER;
            }
            if (action.equals(DELETE_USER)) {
                url = DELETE_USER_PAGE;
            }
            if (action.equals(UPDATE_USER)) {
                url = UPDATE_USER_PAGE;
            }
            if (action.equals(SEARCH_HELI)) {
                url = SEARCH_HELI_CONTROLLER;
            }
            if (action.equals(DELETE_HELI)) {
                url = DELETE_HELI_PAGE;
            }
            if (action.equals(LOGOUT)) {
                url = LOGOUT_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
