package app;

import app.DAO.DAOLiked;
import app.DAO.DAOMessage;
import app.DAO.DAOUser;
import app.service.LikedService;
import app.service.MessagesService;
import app.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * http://localhost:8001/users/
 * http://localhost:8001/liked/
 * http://localhost:8001/login/
 * http://localhost:8001/messages/
 * http://localhost:8001/register
 */
public class Application {
    public static void main(String[] args) throws Exception {
        TemplateEngine te = TemplateEngine.resources("/templates");
        DAOUser daoUser=new DAOUser();
        DAOLiked daoLiked=new DAOLiked();
        DAOMessage daoMessage=new DAOMessage();
        MessagesService messagesService=new MessagesService(daoMessage);
        LikedService likedService=new LikedService(daoLiked);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet((new ServletHolder(new StaticContentServlet("content"))), "/static/*");
        handler.addServlet((new ServletHolder(new UserServlet(te, daoUser, daoLiked))), "/users/*");
        handler.addServlet((new ServletHolder(new LikedServlet(te, daoUser, likedService))), "/liked/*");
        handler.addServlet((new ServletHolder(new MessageServlet(te, daoUser, messagesService))), "/messages/*");
        handler.addServlet((new ServletHolder(new RegisterServlet(te))), "/register/*");
        handler.addServlet((new ServletHolder(new LoginServlet(te))), "/login/*");
        Server server = new Server(8001);
        server.setHandler(handler);
        server.start();
        server.join();
    }

}
