package programing_school.Controller;

import programing_school.Model.UserGroup;
import programing_school.Model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "User_GroupServlet",urlPatterns = {"/User_Group"})
public class User_GroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserGroup> userGroup = UserGroupDao.findAll();

        request.setAttribute("userGroup",userGroup);
        getServletContext().getRequestDispatcher("/WEB-INF/views/User_Group/user_group.jsp").forward(request,response);

    }
}
