package app.servlet;


import app.DAO.DAOUser;
import app.TemplateEngine;
import app.entity.Message;
import app.service.MessagesService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MessageServlet extends HttpServlet {

  private final TemplateEngine te;
  private final DAOUser daoUser;
  private final MessagesService messagesService;
  public MessageServlet(TemplateEngine te, DAOUser daoUser, MessagesService messagesService) {
    this.te = te;
    this.daoUser = daoUser;
    this.messagesService = messagesService;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=0;
    Cookie[] cookies=req.getCookies();
    if(cookies!=null){
      for(Cookie c:cookies){
        if(c.getName().equals("%like%")) {
          id=Integer.parseInt(c.getValue());
        }
      }
    }
    int toUser = Integer.parseInt(req.getPathInfo().substring(1));

    List<Message> messages = null;
    try {
      messages = messagesService.get(id,toUser);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    HashMap<String, Object> data = new HashMap<>();
    data.put("messages", messages);
    data.put("toName",daoUser.getById(toUser).getFirstName());
    data.put("id",id);
    te.render("chat.ftl", data, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=0;
    Cookie[] cookies=req.getCookies();
    if(cookies!=null){
      for(Cookie c:cookies){
        if(c.getName().equals("%like%")) {
          id=Integer.parseInt(c.getValue());
        }
      }
    }
    int toUser = Integer.parseInt(req.getPathInfo().substring(1));
    String content = req.getParameter("content");
    messagesService.put(new Message(id,toUser,content));
    resp.sendRedirect("/messages/" + toUser);
  }
}
