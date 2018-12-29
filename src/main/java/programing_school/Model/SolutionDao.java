package programing_school.Model;

import programing_school.Service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
    private static final String SELECT_SOLUTION_QUERY = "Select * from solution where id = ?";
    private static final String SELECT_ALL_SOLUTIONS_QUERY = "SELECT * FROM solution";
    private static final String CREATE_SOLUTION_QUERY = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?)";
    private static final String DELETE_SOLUTION_QUERY = "DELETE FROM solution where id = ?";
    private static final String GET_User_Solution_byUserAndExercise_id = "SELECT * FROM solution where users_id =? and exercise_id =?";
    private static final String UPDATE_SOLUTION_QUERY = "UPDATE solution SET created =?, updated =?, description = ? WHERE	exercise_id = ?";
    private static final String GET_USER_Solutions = "SELECT * FROM solution where users_id = ?";
    private static final String SELECT_5_Last_Solutions = "SELECT * from solution ORDER BY solution.created DESC LIMIT ?";


    public static List<Solution> loadALLByUserId(Integer id) {
        List<Solution> solutionList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(GET_USER_Solutions)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Solution solution = new Solution();
                solution.setId(rs.getInt(1));
                solution.setCreated(rs.getString(2));
                solution.setUpdated(rs.getString(3));
                solution.setDescription(rs.getString(4));
                solution.setExercise_id(rs.getInt(5));
                solution.setUsers_id(rs.getInt(6));

                solutionList.add(solution);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("błąd");
        }
        return solutionList;
    }

    public static Solution SelectSolutionByUserAndExerciseId (int users_id, int exercise_id){
        Solution solution = new Solution();
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(GET_User_Solution_byUserAndExercise_id))
        {
            stmt.setInt(1,users_id);
            stmt.setInt(2,exercise_id);
            try ( ResultSet rs = stmt.executeQuery()){

                while (rs.next()){
                    solution.setId(rs.getInt(1));
                    solution.setCreated(rs.getString(2));
                    solution.setUpdated(rs.getString(3));
                    solution.setDescription(rs.getString(4));
                    solution.setExercise_id(rs.getInt(5));
                    solution.setUsers_id(rs.getInt(6));
                }
            }
        }catch ( Exception e){
            e.printStackTrace();
            System.out.println("błąd");
        }
        return solution;

    }

    public static Solution SelectSolutionById (Integer id){
        Solution solution = new Solution();
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(SELECT_SOLUTION_QUERY))
        {
            stmt.setInt(1,id);
            try ( ResultSet rs = stmt.executeQuery()){

                while (rs.next()){
                    solution.setId(rs.getInt(1));
                    solution.setCreated(rs.getString(2));
                    solution.setUpdated(rs.getString(3));
                    solution.setDescription(rs.getString(4));
                    solution.setExercise_id(rs.getInt(5));
                    solution.setUsers_id(rs.getInt(6));
                }
            }
        }catch ( Exception e){
            e.printStackTrace();
            System.out.println("błąd");
        }
        return solution;
    }

    public static List<Solution> allSolutions() {
        List<Solution> solutionList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SOLUTIONS_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getString("created"));
                solution.setUpdated(rs.getString("updated"));
                solution.setDescription(rs.getString("description"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));

                solutionList.add(solution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return solutionList;
    }
    public static List<Solution> allSolutions(int number) {
        List<Solution> solutionList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(SELECT_5_Last_Solutions))
        {
             statement.setInt(1,number);
             try(ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getString("created"));
                solution.setUpdated(rs.getString("updated"));
                solution.setDescription(rs.getString("description"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));

                solutionList.add(solution);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return solutionList;
    }

    /**
     * Create solution
     *
     * @param solution
     * @return
     */
    public static Solution create(Solution solution) {
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(CREATE_SOLUTION_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, solution.getCreated());
            stmt.setString(2, solution.getUpdated());
            stmt.setString(3, solution.getDescription());
            stmt.setInt(4, solution.getExercise_id());
            stmt.setInt(5, solution.getUsers_id());

            int result = stmt.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    solution.setId(generatedKeys.getInt(1));
                    return solution;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return null;
    }

    public static void delete(Integer id) {
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(DELETE_SOLUTION_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public static void update(Solution solution) {
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(UPDATE_SOLUTION_QUERY)) {
            statement.setInt(4, solution.getExercise_id());
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}

