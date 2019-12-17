package app.servlet;


import app.DAO.DAOLiked;
import app.DAO.DAOUser;
import app.TemplateEngine;
import app.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {

  private final TemplateEngine te;
  private final DAOUser daoUser=new DAOUser();
  public UserServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int count=0;
    Map<String, Object> data = new HashMap<>();
    data.put("firstName", daoUser.getAll().get(count).getFirstName());
    data.put("lastName", daoUser.getAll().get(count).getLastName());
    data.put("image", daoUser.getAll().get(count).getImage());
    te.render("like-page.ftl", data, resp);
    count++;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
