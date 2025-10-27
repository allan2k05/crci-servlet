import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7d_welcome extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Retrieve session
        HttpSession session = req.getSession(false); // false = don't create new session
        String name = null;

        if (session != null) {
            name = (String) session.getAttribute("playerName");
        }

        out.println("<html><body bgcolor='#e6f7ff'>");
        if (name != null) {
            out.println("<h2>🏏 Welcome back, " + name + "!</h2>");
            out.println("<p>Your session is managed using HttpSession.</p>");
        } else {
            out.println("<h3>Session expired! <a href='ex7d.html'>Login again</a></h3>");
        }
        out.println("</body></html>");
    }
}
