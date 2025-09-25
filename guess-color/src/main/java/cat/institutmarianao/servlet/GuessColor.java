package cat.institutmarianao.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuessColor extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws IOException {
                processRequest(request, response);
        }

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                        throws IOException {
                response.setContentType("text/html;charset=UTF-8");

                try (PrintWriter out = response.getWriter()) {

                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Guess the color</title>");
                        out.println("</head>");
                        out.println("<body>");

                        String result = "Sorry, you lost!";

                        // L'usuari ha seleccionat un color i ho ha enviat.
                        String paramColor = request.getParameter("color");

                        // S'ha configurat un paràmetre que conté el color a endevinar:
                        String initColor = getServletConfig().getInitParameter("color");

                        if (initColor.toLowerCase().equals(paramColor.toLowerCase())) {
                                result = "Congratulations! You guess the color";
                        }

                        out.println("<h1>" + result + "</h1>");
                        out.println("<a href='GuessColor.html'>Try again<a/>");
                        out.println("</body>");
                        out.println("</html>");
                }
        }
}