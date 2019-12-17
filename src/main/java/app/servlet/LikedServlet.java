package app.servlet;


import app.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LikedServlet extends HttpServlet {

  private final TemplateEngine te;

  public LikedServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    te.render("people-list.ftl", resp);
  }
}
