package com.planner.travel.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class questions {




        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String insertQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

                String newUsername = "new_user";
                String newEmail = "user@example.com";
                String newPassword = "password123";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, newUsername);
                    preparedStatement.setString(2, newEmail);
                    preparedStatement.setString(3, newPassword);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Користувача додано до бази даних.");
                    } else {
                        System.out.println("Не вдалося додати користувача до бази даних.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public class Main2 {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String insertQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

                String newUsername = "new_user";
                String newEmail = "user@example.com";
                String newPassword = "password123";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, newUsername);
                    preparedStatement.setString(2, newEmail);
                    preparedStatement.setString(3, newPassword);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Користувача додано до бази даних.");
                        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            long userId = generatedKeys.getLong(1);
                            System.out.println("Згенерований ID користувача: " + userId);
                        }
                    } else {
                        System.out.println("Не вдалося додати користувача до бази даних.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
/*

Порядок класів та виконання коду:

public class UserController - отримує запит

 @PostMapping("/requestBody")
    public ResponseEntity<User> createUser(@RequestBody User user) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.createUser(user));

Отримуємо модель користувача user клас entity.

{
    "name": "Thor4",
    "surname": "Odin",
    "phone": "777",
    "email": "6577rrf@gmailcom",
    "country": "Ukraine",
    "city": "Kyiv"
}

Наступним кроком йдемо в інтерфейс користувача та його знаходимо цей метод -createUser.
public interface UserService

    User createUser(User user);

Далі знаходимо імплементацію в класі UserServiceImpl, де описаний механізм виконання методу.
UserService

@Service
public class UserServiceImpl implements UserService {
Клас має дві змінні
    private final UserDAO userDAO; - Модель DAO
    private final UserMapper userMapper; - Маппер, що формує Entity та DTO

Та конструктор, для них
    public UserServiceImpl(UserDAOImpl userDAOImpl, UserMapper userMapper) {
        this.userDAO = userDAOImpl;
        this.userMapper = userMapper;
    }
метод createUser

    @Transactional
    @Override
    public User createUser(User user) {
        user = userDAO.createUserDAO(user);
        return user;
    }

В інтрефейсі userDAO
метод createUser має визначання
User createUserDAO(User user);

А в класі userDAOImpl
@Qualifier
public class UserDAOImpl implements UserDAO

методі має визначення
    @Override
    public User createUserDAO(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.USER_INSERT.getQueryName(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getCountry());
            preparedStatement.setString(6, user.getCity());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Користувача додано до бази даних.");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long userId = generatedKeys.getInt(1);
                    System.out.println("Згенерований ID користувача: " + userId);
                }
            } else {
                System.out.println("Не вдалося додати користувача до бази даних.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }


Як в запиті повернути коректний id нового користувача?






*/



