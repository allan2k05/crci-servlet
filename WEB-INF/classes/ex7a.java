import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7a extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String favoritePlayer = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("favoritePlayer".equals(cookie.getName())) {
                    favoritePlayer = cookie.getValue();
                }
            }
        }

        out.println("<html><body>");
        if (favoritePlayer == null) {
            // If no cookie, redirect to form page (index.html)
            response.sendRedirect("ex7a.html");
        } else {
            out.println("<h2>Your favorite cricket player is: " + favoritePlayer + "</h2>");
            out.println("<a href='ex7a?clear=true'>Change Selection</a>");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String player = request.getParameter("player");
        if (player != null) {
            Cookie cookie = new Cookie("favoritePlayer", player);
            cookie.setMaxAge(60 * 60); // expires in 1 hour
            response.addCookie(cookie);
        }
        response.sendRedirect("ex7a");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("true".equals(request.getParameter("clear"))) {
            Cookie cookie = new Cookie("favoritePlayer", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("ex7a.html");
        } else {
            super.service(request, response);
        }
    }
}
