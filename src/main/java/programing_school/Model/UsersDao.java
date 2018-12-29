package programing_school.Model;

import programing_school.Service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    private static final String SELECT_user_QUERY = "Select * from users where id = ?";
    private static final String SELECT_user_QUERY_by_grupid = "Select * from users where user_group_id = ?";
    private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String CREATE_user_QUERY = "INSERT INTO users(username, email, password, user_group_id) VALUES (?,?,?,?)";
    private static final String DELETE_user_QUERY = "DELETE FROM users where id = ?";
    private static final String UPDATE_user_QUERY = "UPDATE users SET username = ?, email = ?, user_group_id = ? WHERE	id = ?";


    public static Users SelectUserById(Integer id) {
        Users user = new Users();
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(SELECT_user_QUERY)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setUser_group_id(rs.getInt("user_group_id"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("błąd");
        }

        return user;
    }

    public static List<Users> SelectUserByGrupId(Integer id) {
        List<Users> usersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(SELECT_user_QUERY_by_grupid)){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Users users = new Users();
                    users.setId(rs.getInt("id"));
                    users.setUsername(rs.getString("username"));
                    users.setEmail(rs.getString("email"));
                    users.setUser_group_id(rs.getInt("user_group_id"));
                    usersList.add(users);
                }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cos sie nie powiodło");
            }
            return usersList;
        }



        public static List<Users> allUsers() {
            List<Users> usersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setUsername(rs.getString("username"));
                users.setEmail(rs.getString("email"));
                users.setUser_group_id(rs.getInt("user_group_id"));

                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return usersList;

    }

    /**
     * Create User
     *
     * @param user
     * @return
     */
    public static Users create(Users user) {
        try (Connection con = DbUtil.getConnection("programing_school");
             PreparedStatement stmt = con.prepareStatement(CREATE_user_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getUser_group_id());

            int result = stmt.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    user.setId(generatedKeys.getInt(1));
                    return user;
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
             PreparedStatement statement = connection.prepareStatement(DELETE_user_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public static void update(int id, String name, String email, int usergroupid) { // dziala po okresleniu id
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(UPDATE_user_QUERY)) {
            statement.setInt(4, id);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, usergroupid);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}

