import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7b extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String favoriteTeam = request.getParameter("team");

        out.println("<html><body>");
        if (favoriteTeam == null) {
            // No team selected - redirect to form page
            response.sendRedirect("ex7b.html");
        } else {
            out.println("<h2>Your favorite cricket team is: " + favoriteTeam + "</h2>");
            // URL rewriting links
            out.println("<a href='ex7b?team=" + favoriteTeam + "'>Refresh</a><br>");
            out.println("<a href='ex7b'>Choose Again</a>");
        }
        out.println("</body></html>");
    }
}
