import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7a_welcome extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie ck[] = req.getCookies();
        String name = null;

        if (ck != null) {
            for (Cookie c : ck) {
                if (c.getName().equals("playerName")) {
                    name = c.getValue();
                }
            }
        }

        out.println("<html><body bgcolor='#e6f0ff'>");
        if (name != null)
            out.println("<h2>🏏 Welcome back, " + name + "!</h2><p>Session managed using cookies.</p>");
        else
            out.println("<h3>No cookie found! <a href='ex7a.html'>Login again</a></h3>");
        out.println("</body></html>");
    }
}
