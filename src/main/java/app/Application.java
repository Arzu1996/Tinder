package app;

import app.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * http://localhost:2001/users/
 * http://localhost:2001/liked/
 * http://localhost:2001/login/
 * http://localhost:2001/messages/
 * http://localhost:2001/register
 */
public class Application {
    public static void main(String[] args) throws Exception {
        TemplateEngine te = TemplateEngine.resources("/templates");
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet((new ServletHolder(new StaticContentServlet("content"))), "/static/*");
        handler.addServlet((new ServletHolder(new UserServlet(te))), "/users/*");
        handler.addServlet((new ServletHolder(new LikedServlet(te))), "/liked/*");
        handler.addServlet((new ServletHolder(new MessageServlet(te))), "/messages/*");
        handler.addServlet((new ServletHolder(new RegisterServlet(te))), "/register/*");
        handler.addServlet((new ServletHolder(new LoginServlet(te))), "/login/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");
        Server server = new Server(2001);
        server.setHandler(handler);
        server.start();
        server.join();
    }

}
