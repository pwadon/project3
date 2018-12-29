package programing_school.Controller;

import programing_school.Model.Users;
import programing_school.Model.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet",urlPatterns = {"/Users"})
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("GroupId"));
        if (id != 0) {
            List<Users> users = UsersDao.SelectUserByGrupId(id);
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/WEB-INF/views/Users/users.jsp").forward(request, response);
        }
        else {
            List<Users> users = UsersDao.allUsers();
            request.setAttribute("users",users);
            getServletContext().getRequestDispatcher("/WEB-INF/views/Users/users.jsp").forward(request, response);
        }
    }
}
