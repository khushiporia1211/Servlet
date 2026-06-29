package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String appName; 
  private int requestCount = 0;
    
    public LifeCycleServlet() {
        super();
        
    }

    // ─── PHASE 1: INITIALIZATION ───────────────────────────────
  public void init(ServletConfig config) throws ServletException {
    
    super.init(config);
    // Called ONCE when servlet is first loaded
    appName =  config.getInitParameter("appName");
    System.out.println("✅ Servlet INITIALIZED - App: " + appName);
  }

  
  
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    requestCount++;
    System.out.println("🔄 Request #" + requestCount + " received");
    // Delegates to doGet() or doPost() automatically
    super.service(request, response);
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h1>Request Count: " + requestCount + "</h1>");

  }
  
  public void destroy() {
    
    // Called ONCE when servlet is being unloaded
    System.out.println("🔴 Servlet DESTROYED after "
        + requestCount + " requests");
  }  

  
  

}
