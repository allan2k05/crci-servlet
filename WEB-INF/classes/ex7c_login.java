import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7c_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        out.println("<html><body bgcolor='#e6ffe6'>");
        out.println("<h2>Welcome " + name + "!</h2>");
        out.println("<p>Session will be continued using hidden form fields.</p>");

        out.println("<form action='ex7c_welcome' method='post'>");
        out.println("<input type='hidden' name='user' value='" + name + "'>");
        out.println("<input type='submit' value='Go to Welcome Page'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
