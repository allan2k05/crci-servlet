import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7d_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        // Create or get the current session
        HttpSession session = req.getSession();
        session.setAttribute("playerName", name);

        out.println("<html><body bgcolor='#e6f7ff'>");
        out.println("<h2>Welcome " + name + "!</h2>");
        out.println("<p>Session created successfully using HttpSession.</p>");
        out.println("<a href='ex7d_welcome'>Go to Welcome Page</a>");
        out.println("</body></html>");
    }
}
