import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7b_welcome extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("user");

        out.println("<html><body bgcolor='#fff3e6'>");
        if (name != null && !name.isEmpty()) {
            out.println("<h2>Welcome back, " + name + "!</h2>");
            out.println("<p>Your session is managed using URL Rewriting.</p>");
        } else {
            out.println("<h3>Session expired! <a href='ex7b.html'>Login again</a></h3>");
        }
        out.println("</body></html>");
    }
}
