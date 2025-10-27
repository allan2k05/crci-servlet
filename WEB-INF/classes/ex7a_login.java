import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7a_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        // Create a cookie
        Cookie ck = new Cookie("playerName", name);
        res.addCookie(ck);

        out.println("<html><body bgcolor='#e6f0ff'>");
        out.println("<h2>Welcome " + name + "!</h2>");
        out.println("<p>Cookie created successfully.</p>");
        out.println("<a href='ex7a_welcome'>Go to Welcome Page</a>");
        out.println("</body></html>");
    }
}
