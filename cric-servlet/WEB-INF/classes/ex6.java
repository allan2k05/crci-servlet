import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ex6 extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Welcome to the Cricket Arena! Get the latest cricket updates here.";
   }

   public void doGet(HttpServletRequest request,
         HttpServletResponse response)
         throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
      out.println("<p>Next Match: India vs Australia on 15th November 2025.</p>");
      out.println("<p><a href='http://localhost:8080/cric-servlet/ex6.html'>Go Back</a></p>");
   }

   public void destroy() {
      // do nothing.
   }
}
