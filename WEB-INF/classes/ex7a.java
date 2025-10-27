// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ex7a_login extends HttpServlet {
   public ex7a_login() {
   }

   public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      var2.setContentType("text/html");
      PrintWriter var3 = var2.getWriter();
      String var4 = var1.getParameter("username");
      Cookie var5 = new Cookie("playerName", var4);
      var2.addCookie(var5);
      var3.println("<html><body bgcolor='#e6f0ff'>");
      var3.println("<h2>Welcome " + var4 + "!</h2>");
      var3.println("<p>Cookie created successfully.</p>");
      var3.println("<a href='ex7a_welcome'>Go to Welcome Page</a>");
      var3.println("</body></html>");
   }
}
