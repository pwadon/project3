package programing_school.Controller;

import programing_school.Model.Exercise;
import programing_school.Model.ExerciseDao;
import programing_school.Model.UserGroup;
import programing_school.Model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminExercise",urlPatterns = {"/AdminExercise"})
public class AdminExercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("button");
        if (action.equals("add")){
            String file = request.getParameter("file");
            String desc = request.getParameter("description");
            Exercise ex = new Exercise(file,desc);
            ExerciseDao.create(ex);
        }
        if(action.equals("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            String file = request.getParameter("file");
            String desc = request.getParameter("description");
            ExerciseDao.update(id,file,desc);
        }
        if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            ExerciseDao.delete(id);
        }
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exercise> exercises = ExerciseDao.allExercises();
        request.setAttribute("exercises",exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/AdminExercise.jsp").forward(request, response);
    }
}
