package app.servlet;



import app.DAO.DAOLiked;
import app.DAO.DAOUser;
import app.TemplateEngine;
import app.entity.Liked;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {

  private final TemplateEngine te;
  private final DAOUser daoUser;
  private int count;
  private final DAOLiked daoLiked;
  public UserServlet(TemplateEngine te, DAOUser daoUser, DAOLiked daoLiked) {
    this.te = te;
      this.daoUser = daoUser;
      this.daoLiked = daoLiked;
  }
  private int id=-1;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Cookie [] cookies=req.getCookies();
      if(cookies!=null){
          for(Cookie c:cookies){
              if(c.getName().equals("%like%")) {
                  id=Integer.parseInt(c.getValue());
              }
          }
      }
    Map<String, Object> data = new HashMap<>();
    data.put("firstName", daoUser.getAll().get(count).getFirstName());
    data.put("lastName", daoUser.getAll().get(count).getLastName());
    data.put("image", daoUser.getAll().get(count).getImage());
    te.render("like-page.ftl", data, resp);
    count++;
      if(count == daoUser.getAll().size()){
          resp.sendRedirect("/liked");
          count = 0;
      }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String choice = req.getParameter("choice");
      if (choice.equals("like")){
          Liked like = new Liked(id,daoUser.getAll().get(count).getUserId());
          daoLiked.put(like);
          }else if (choice.equals("dislike")){count++;resp.sendRedirect("/users");}
      Map<String, Object> data = new HashMap<>();
      data.put("userId", daoUser.getAll().get(count).getUserId());
      data.put("firstName", daoUser.getAll().get(count).getFirstName());
      data.put("lastName", daoUser.getAll().get(count).getLastName());
      data.put("image", daoUser.getAll().get(count).getImage());
      te.render("like-page.ftl", data, resp);
      count++;
      if(count == daoUser.getAll().size()){
          resp.sendRedirect("/liked");
          count = 0;
      }
  }
}
