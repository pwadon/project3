package programing_school.Controller;

import programing_school.Model.Solution;
import programing_school.Model.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Solution",urlPatterns = {"/Solution"})
public class SolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("number"));

        Solution solution = SolutionDao.SelectSolutionById(number);
        request.setAttribute("solution",solution);

        getServletContext().getRequestDispatcher("/WEB-INF/views/Solution/solution.jsp").forward(request,response);

    }
}
