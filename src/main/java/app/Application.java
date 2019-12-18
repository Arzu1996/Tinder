package app;

import app.DAO.DAOLiked;
import app.DAO.DAOUser;
import app.service.LikedService;
import app.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * http://localhost:4001/users/
 * http://localhost:4001/liked/
 * http://localhost:4001/login/
 * http://localhost:4001/messages/
 * http://localhost:4001/register
 */
public class Application {
    public static void main(String[] args) throws Exception {
        TemplateEngine te = TemplateEngine.resources("/templates");
        DAOUser daoUser=new DAOUser();
        DAOLiked daoLiked=new DAOLiked();
        LikedService likedService=new LikedService(daoLiked);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet((new ServletHolder(new StaticContentServlet("content"))), "/static/*");
        handler.addServlet((new ServletHolder(new UserServlet(te, daoUser, daoLiked))), "/users/*");
        handler.addServlet((new ServletHolder(new LikedServlet(te, daoUser, likedService))), "/liked/*");
        handler.addServlet((new ServletHolder(new MessageServlet(te))), "/messages/*");
        handler.addServlet((new ServletHolder(new RegisterServlet(te))), "/register/*");
        handler.addServlet((new ServletHolder(new LoginServlet(te))), "/login/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");
        Server server = new Server(4001);
        server.setHandler(handler);
        server.start();
        server.join();
    }

}
