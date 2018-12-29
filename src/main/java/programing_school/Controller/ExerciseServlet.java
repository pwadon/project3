package programing_school.Controller;

import programing_school.Model.Exercise;
import programing_school.Model.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExerciseServlet",urlPatterns = {"/Exercise"})
public class ExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exercise> exercises = ExerciseDao.allExercises();
        request.setAttribute("exercises",exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/views/Exercise/exercise.jsp").forward(request, response);
    }
}
