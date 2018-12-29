package programing_school.Controller;

import programing_school.Model.UserGroup;
import programing_school.Model.UserGroupDao;
import programing_school.Model.Users;
import programing_school.Model.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUser",urlPatterns = {"/AdminUser"})
public class AdminUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("button");
        if (action.equals("add")){
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            int usergroupid = Integer.parseInt(request.getParameter("usergroupid"));
            Users users = new Users(name,email,pass,usergroupid);
            UsersDao.create(users);
        }
        if(action.equals("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int usergroupid = Integer.parseInt(request.getParameter("usergroupid"));
            UsersDao.update(id,name,email,usergroupid);
        }
        if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            UsersDao.delete(id);
        }
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Users> users = UsersDao.allUsers();

        request.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/AdminUser.jsp").forward(request,response);
    }
}
