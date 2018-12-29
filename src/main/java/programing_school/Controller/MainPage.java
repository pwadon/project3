package programing_school.Controller;

import programing_school.Model.Solution;
import programing_school.Model.SolutionDao;
import programing_school.Service.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "MainPage",urlPatterns = {"/"})
public class MainPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Solution> solutions = SolutionDao.allSolutions(5);
            request.setAttribute("solutions", solutions);

        getServletContext().getRequestDispatcher("/WEB-INF/views/mainpage/mainpage.jsp").forward(request, response);
    }
}
