import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ex8a extends HttpServlet {
    private int totalHits;

    public void init() throws ServletException {
        totalHits = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        totalHits++; // Increment total count

        out.println("<html><body bgcolor='#e8ffe8' style='text-align:center;'>");
        out.println("<h1 style='color:green;'>Cricket Page Total Visits</h1>");
        out.println("<h2>Total Visits by All Users: " + totalHits + "</h2>");
        out.println("<br><a href='ex8.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
