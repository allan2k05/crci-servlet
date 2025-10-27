import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7c_welcome extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("user");

        out.println("<html><body bgcolor='#e6ffe6'>");
        if (name != null && !name.isEmpty()) {
            out.println("<h2>🏏 Welcome back, " + name + "!</h2>");
            out.println("<p>Your session is managed using Hidden Form Fields.</p>");
        } else {
            out.println("<h3>Session expired! <a href='ex7c.html'>Login again</a></h3>");
        }
        out.println("</body></html>");
    }
}
