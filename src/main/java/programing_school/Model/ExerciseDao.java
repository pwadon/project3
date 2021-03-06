package programing_school.Model;

import programing_school.Service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {


    private static final String SELECT_exercise_QUERY = "Select * from exercise where id = ?";
    private static final String SELECT_ALL_EXERCISES_QUERY = "SELECT * FROM exercise";
    private static final String CREATE_exercise_QUERY = "INSERT INTO exercise(file,description) VALUES (?,?)";
    private static final String DELETE_exercise_QUERY = "DELETE FROM exercise where id = ?";
    private static final String UPDATE_exercise_QUERY = "UPDATE exercise SET file = ?, description = ? WHERE	id = ?";

    public static Exercise SelectExerciseById (Integer id){ // brakuje opcji ze w przypadku braku uzytkownika wyswietla taka informacje
       Exercise exercise = new Exercise();
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(SELECT_exercise_QUERY))
        {
            stmt.setInt(1,id);
            try ( ResultSet rs = stmt.executeQuery()){

                while (rs.next()){
                    exercise.setId(rs.getInt(1));
                    exercise.setFile(rs.getString(2));
                    exercise.setDescription(rs.getString(3));
                }
            }
        }catch ( Exception e){
            e.printStackTrace();
            System.out.println("błąd");
        }

        return exercise;
    }

    public static List<Exercise> allExercises() {
        List<Exercise> exercisesList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EXERCISES_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Exercise exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setFile(rs.getString("file"));
                exercise.setDescription(rs.getString("description"));

                exercisesList.add(exercise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return exercisesList;

    }

    /**
     * Create exercise
     *
     * @param exercise
     * @return
     */
    public static Exercise create(Exercise exercise) {
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(CREATE_exercise_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, exercise.getFile());
            stmt.setString(2, exercise.getDescription());

            int result = stmt.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    exercise.setId(generatedKeys.getInt(1));
                    return exercise;
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

    public static void delete(Integer id) { // dziala
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(DELETE_exercise_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public static void update(int id, String file, String description) { // dziala po okresleniu id
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(UPDATE_exercise_QUERY)) {
            statement.setInt(3, id);
            statement.setString(1, file);
            statement.setString(2, description);


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}
