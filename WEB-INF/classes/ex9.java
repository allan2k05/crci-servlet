import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ex9 extends HttpServlet {

    // Oracle DB connection details
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String DB_USER = "system";     // your Oracle username
    private static final String DB_PASS = "newpassword";     // your Oracle password

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String team = req.getParameter("team");
        String runsStr = req.getParameter("runs");
        String operation = req.getParameter("operation");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            Statement st = con.createStatement();

            if (operation.equals("insert")) {
                int runs = Integer.parseInt(runsStr);
                String sql = "INSERT INTO players (name, team, runs) VALUES ('" + name + "', '" + team + "', " + runs + ")";
                st.executeUpdate(sql);
                out.println("<h3>Player inserted successfully!</h3>");
            } 
            else if (operation.equals("update")) {
                int runs = Integer.parseInt(runsStr);
                String sql = "UPDATE players SET team='" + team + "', runs=" + runs + " WHERE name='" + name + "'";
                int count = st.executeUpdate(sql);
                if (count > 0)
                    out.println("<h3>Player updated successfully!</h3>");
                else
                    out.println("<h3>Player not found!</h3>");
            } 
            else if (operation.equals("select")) {
                String sql = "SELECT * FROM players";
                ResultSet rs = st.executeQuery(sql);
                out.println("<h2>Player Records</h2>");
                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Team</th><th>Runs</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                                rs.getString("name") + "</td><td>" +
                                rs.getString("team") + "</td><td>" +
                                rs.getInt("runs") + "</td></tr>");
                }
                out.println("</table>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
        out.close();
    }
}
