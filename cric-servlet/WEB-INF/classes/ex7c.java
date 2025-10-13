import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex7c extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String format = request.getParameter("format");
        String step = request.getParameter("step");

        out.println("<html><body>");
        if (step == null || step.equals("1")) {
            // Show confirmation page with hidden field
            out.println("<h2>You selected format: " + format + "</h2>");
            out.println("<form method='POST' action='ex7c'>");
            out.println("<input type='hidden' name='format' value='" + format + "'>");
            out.println("<input type='hidden' name='step' value='2'>");
            out.println("<input type='submit' value='Confirm'>");
            out.println("</form>");
        } else if (step.equals("2")) {
            // Final thank you page
            out.println("<h2>Thank you! Your favorite cricket format is: " + format + "</h2>");
            out.println("<a href='ex7c.html'>Start Over</a>");
        } else {
            // Unknown step, go back to index
            response.sendRedirect("ex7c.html");
        }
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Just redirect to index.html on GET
        response.sendRedirect("ex7c.html");
    }
}
