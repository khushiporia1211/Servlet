package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondSessionServlet")
public class SecondSessionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SecondSessionServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        // Fetch existing session without creating a new one
        HttpSession session = req.getSession(false);
        String n = "";
        
        if (session != null) {
            n = (String) session.getAttribute("uname");
        }

        // Injecting matching UI styling into the response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Dashboard</title>");
        out.println("<style>");
        out.println("  * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }");
        out.println("  body { display: flex; justify-content: center; align-items: center; min-height: 100vh; background-color: #f4f7f6; }");
        out.println("  .card { background-color: #ffffff; padding: 40px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05); text-align: center; max-width: 400px; width: 100%; }");
        out.println("  .avatar { width: 70px; height: 70px; background-color: #e1f5fe; color: #0288d1; border-radius: 50%; display: flex; justify-content: center; align-items: center; margin: 0 auto 20px auto; font-size: 1.8rem; font-weight: bold; }");
        out.println("  h1 { color: #333333; font-size: 1.8rem; margin-bottom: 10px; }");
        out.println("  p { color: #666666; font-size: 1rem; margin-bottom: 25px; }");
        out.println("  .btn-secondary { display: inline-block; width: 100%; padding: 12px; background-color: #f0f0f0; color: #333333; text-decoration: none; border-radius: 4px; font-weight: 600; transition: background-color 0.2s ease; }");
        out.println("  .btn-secondary:hover { background-color: #e0e0e0; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("  <div class='card'>");
        
        // Dynamic avatar using the first letter of the name
        if (n != null && !n.trim().isEmpty()) {
            out.println("    <div class='avatar'>" + n.substring(0, 1).toUpperCase() + "</div>");
            out.println("    <h1>Hello, " + n + "!</h1>");
            out.println("    <p>You have successfully navigated to the second servlet using your session.</p>");
        } else {
            out.println("    <div class='avatar' style='background-color: #ffebee; color: #c62828;'>?</div>");
            out.println("    <h1>Hello, Guest!</h1>");
            out.println("    <p style='color: #d32f2f;'>No active session found or name attribute is missing.</p>");
        }
        
        // Optional navigation back to the starting form
        out.println("    <a class='btn-secondary' href='session.html'>Go to Start</a>");
        out.println("  </div>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
