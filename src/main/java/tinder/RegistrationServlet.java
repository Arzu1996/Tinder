package tinder;


import tinder.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

  private final TemplateEngine te;
  private final UserDao userDao;

  public RegistrationServlet(TemplateEngine te, UserDao userDao) {

    this.te = te;

    this.userDao = userDao;
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    te.render("login.ftl", resp);
  }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email=req.getParameter("email");
       String password=req.getParameter("password");
      if (userDao.existByEmailAndPass(email,password)){
        resp.sendRedirect("/users/*");}
     else {
          PrintWriter writer = resp.getWriter();
          writer.println("not ok");
        }
    }
}
