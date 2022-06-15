package com.example.wcdt2009achutunglam.servlet;

import com.example.wcdt2009achutunglam.dao.PhoneDAO;
import com.example.wcdt2009achutunglam.model.Phone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class PhoneServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private PhoneDAO phoneDAO;

    public void init() {
        phoneDAO = new PhoneDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertPhone(request, response);
                    break;
                default:
                    listPhones(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addphone.jsp");
        dispatcher.forward(request, response);
    }

    private void listPhones(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Phone> listPhone = phoneDAO.selectAllPhones();
        request.setAttribute("listPhone", listPhone);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listphones.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPhone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        Phone newPhone = new Phone(name, brand, price, description);
        phoneDAO.insertPhone(newPhone);
        response.sendRedirect("list");
    }
}
