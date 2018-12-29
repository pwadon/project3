package programing_school.Controller;

import programing_school.Model.Solution;
import programing_school.Model.SolutionDao;
import programing_school.Model.Users;
import programing_school.Model.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"/User"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userid"));
        Users users = UsersDao.SelectUserById(id);
        request.setAttribute("users",users);
        List <Solution> solutions = SolutionDao.loadALLByUserId(id);
        request.setAttribute("solutions",solutions);
        getServletContext().getRequestDispatcher("/WEB-INF/views/User/user.jsp").forward(request,response);
    }
}
