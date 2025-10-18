import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7d extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String favoriteGround = null;
        if (session != null) {
            favoriteGround = (String) session.getAttribute("favoriteGround");
        }

        out.println("<html><body>");
        if (favoriteGround == null) {
            // Redirect to form page
            response.sendRedirect("ex7d.html");
        } else {
            out.println("<h2>Your favorite cricket ground is: " + favoriteGround + "</h2>");
            out.println("<a href='ex7d?clear=true'>Change Selection</a>");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ground = request.getParameter("ground");
        if (ground != null) {
            HttpSession session = request.getSession();
            session.setAttribute("favoriteGround", ground);
        }
        response.sendRedirect("ex7d");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("true".equals(request.getParameter("clear"))) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("ex7d.html");
        } else {
            super.service(request, response);
        }
    }
}
