package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionDemo")
public class SessionDemo extends HttpServlet {
    
    private static final long serialVersionUID = 453060368245630937L;
    
    public SessionDemo() {
        super();
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        
        // Storing the attribute exactly as before
        HttpSession session = req.getSession();
        session.setAttribute("uname", name);
        
        // Injecting modern UI styling into the response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Session Demo</title>");
        out.println("<style>");
        out.println("  * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }");
        out.println("  body { display: flex; justify-content: center; align-items: center; min-height: 100vh; background-color: #f4f7f6; }");
        out.println("  .card { background-color: #ffffff; padding: 40px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05); text-align: center; max-width: 400px; width: 100%; }");
        out.println("  h1 { color: #333333; font-size: 1.8rem; margin-bottom: 10px; }");
        out.println("  p { color: #666666; font-size: 1rem; margin-bottom: 25px; }");
        out.println("  .btn { display: inline-block; width: 100%; padding: 12px; background-color: #4a90e2; color: #ffffff; text-decoration: none; border-radius: 4px; font-weight: 600; transition: background-color 0.2s ease; }");
        out.println("  .btn:hover { background-color: #357abd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        // Displaying content inside a styled card wrapper
        out.println("  <div class='card'>");
        out.println("    <h1>Welcome, " + name + "</h1>");
        out.println("    <p>Your session has been successfully initialized.</p>");
        out.println("    <a class='btn' href='SecondSessionServlet'>Visit Next Page</a>");
        out.println("  </div>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
