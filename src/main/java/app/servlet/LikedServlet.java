package app.servlet;


import app.DAO.DAOUser;
import app.TemplateEngine;
import app.entity.Liked;
import app.entity.User;
import app.service.LikedService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class LikedServlet extends HttpServlet {

  private final TemplateEngine te;
  private final DAOUser daoUser;
  private final LikedService likedService;

  public LikedServlet(TemplateEngine te, DAOUser daoUser, LikedService likedService) {
    this.te = te;
    this.daoUser = daoUser;
    this.likedService = likedService;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=0;
    Cookie[] cookies=req.getCookies();
    System.out.println(Arrays.toString(cookies));
    if(cookies!=null){
      for(Cookie c:cookies){
        if(c.getName().equals("%like%")) {
          id=Integer.parseInt(c.getValue());
        }
      }
    }
    List<User> users=new ArrayList<>();
      List<Liked> likedList = null;
      try {
          likedList = likedService.getById(id);
      } catch (SQLException e) {
          e.printStackTrace();
      }

      assert likedList != null;
      for (Liked liked : likedList) {
          User user = daoUser.getById(liked.getToWhom());
          users.add(user);
      }
    Map<String, Object> data = new HashMap<>();
      data.put("users",users);
    te.render("people-list.ftl", data, resp);
  }
}
