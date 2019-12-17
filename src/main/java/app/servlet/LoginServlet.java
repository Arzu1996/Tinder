package app.servlet;


import app.DAO.DAOUser;
import app.TemplateEngine;
import app.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private LoginService ls = new LoginService();
    private final TemplateEngine te;
    private final DAOUser daoUser=new DAOUser();
    public LoginServlet(TemplateEngine te) {
        this.te = te;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        te.render("login.ftl", resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        // =========================
        boolean res = ls.checkLogin(email, pass);
        // =========================
        PrintWriter w = resp.getWriter();
        if (res) {
            Cookie cookie = new Cookie("%B",
                    daoUser.get(email).getUserId());
            resp.addCookie(cookie);
            resp.sendRedirect("/users");
        } else {
            w.println("ERR");
        }
    }
}
