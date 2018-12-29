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

@WebServlet(name = "editGroups",urlPatterns = {"/editGroups"})
public class AdminGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("button");
        if (action.equals("add")){
            UserGroup userGroup = new UserGroup(request.getParameter("name"));
            UserGroupDao.create(userGroup);
        }
        if(action.equals("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            UserGroupDao.update(id,name);
        }
        if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            UserGroupDao.delete(id);
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserGroup> userGroup = UserGroupDao.findAll();

        request.setAttribute("userGroup",userGroup);
        getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/editGroups.jsp").forward(request,response);
    }
}
