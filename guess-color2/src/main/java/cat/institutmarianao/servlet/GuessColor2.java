package cat.institutmarianao.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuessColor2 extends HttpServlet {

        private static final long serialVersionUID = 1L;
		private Set<String> ip;
		private String initColor;

		@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			ip = new HashSet<>();
			initColor = getServletConfig().getInitParameter("color");

		}

        @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			//String requestIp = request.getRemoteAddr();
			RequestDispatcher rs;
			
			String paramColor = request.getParameter("color");
			
			if (paramColor != null) {
				if (initColor.toLowerCase().equals(paramColor.toLowerCase())) {
					rs = request.getRequestDispatcher("Encertat.html");
				} else {
					rs = request.getRequestDispatcher("NoEncertat.html");
				}
				rs.forward(request, response);
			} else {
				rs = request.getRequestDispatcher("GuessColor.html");
				rs.forward(request, response);
			}


        }

}