import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class ex8b extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1; // First visit
        } else {
            count++;
        }

        session.setAttribute("count", count);

        out.println("<html><body bgcolor='#fff8dc' style='text-align:center;'>");
        out.println("<h1 style='color:#1e90ff;'>Welcome Cricket Fan!</h1>");
        out.println("<h2>Your Individual Visit Count: " + count + "</h2>");
        out.println("<br><a href='ex8.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
