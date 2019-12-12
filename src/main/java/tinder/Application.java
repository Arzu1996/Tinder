package tinder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.model.UserDao;

/**
 * http://localhost:2001/users/
 * http://localhost:2001/liked/
 * http://localhost:2001/login/
 * http://localhost:2001/messages/
 */
public class Application {
  public static void main(String[] args) throws Exception {
    TemplateEngine te = TemplateEngine.resources("/templates");
    UserDao userDao=new UserDao();
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet((new ServletHolder(new StaticContentServlet("content"))), "/static/*");
    handler.addServlet((new ServletHolder(new UsersServlet(te))), "/users/*");
    handler.addServlet((new ServletHolder(new LikedServlet(te))), "/liked/*");
    handler.addServlet((new ServletHolder(new MessagesServlet(te))), "/messages/*");
    handler.addServlet((new ServletHolder(new LoginServlet(te, userDao))), "/login/*");
    Server server = new Server(2001);
    server.setHandler(handler);
    server.start();
    server.join();
  }

}
