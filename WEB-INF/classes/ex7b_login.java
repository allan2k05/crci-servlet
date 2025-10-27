import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7b_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        out.println("<html><body bgcolor='#fff3e6'>");
        out.println("<h2>Welcome " + name + "!</h2>");
        out.println("<p>Session information will be passed via URL rewriting.</p>");
        out.println("<a href='ex7b_welcome?user=" + name + "'>Go to Welcome Page</a>");
        out.println("</body></html>");
    }
}
