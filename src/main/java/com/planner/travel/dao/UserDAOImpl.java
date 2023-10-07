//package com.planner.travel.dao;
//
//import com.planner.travel.constant.DatabaseConnection;
//import com.planner.travel.constant.Queries;
//import com.planner.travel.entity.User;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//
//import java.sql.*;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Qualifier
//public class UserDAOImpl implements UserDAO{
//
//    private final Connection connection;
//
//    public UserDAOImpl() throws SQLException {
//        this.connection = DatabaseConnection.getInstance().getConnection();
//    }
//
//    @Override
//    public User findUserById(Integer id) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.USER_FIND_BY_ID.getQueryName())) {
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        }catch (SQLException e){
//            throw new RuntimeException();
//        }
//        return null;
//    }
//
//
//    @Override
//    public User createUserDAO(User user) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.USER_INSERT.getQueryName(), PreparedStatement.RETURN_GENERATED_KEYS)) {
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getSurname());
//            preparedStatement.setString(3, user.getPhone());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setString(5, user.getCountry());
//            preparedStatement.setString(6, user.getCity());
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Користувача додано до бази даних.");
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    long userId = generatedKeys.getLong(1);
//                    user.setId((int) userId); // Встановлюємо згенерований ID користувача в об'єкт User
//                    System.out.println("Згенерований ID користувача: " + userId);
//                }
//            } else {
//                System.out.println("Не вдалося додати користувача до бази даних.");
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return user;
//    }
//
////    @Override
////    public User createUserDAO(User user) {
////
////
////
////        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.USER_INSERT.getQueryName(), PreparedStatement.RETURN_GENERATED_KEYS)) {
////            preparedStatement.setString(1, user.getName());
////            preparedStatement.setString(2, user.getSurname());
////            preparedStatement.setString(3, user.getPhone());
////            preparedStatement.setString(4, user.getEmail());
////            preparedStatement.setString(5, user.getCountry());
////            preparedStatement.setString(6, user.getCity());
////            int rowsAffected = preparedStatement.executeUpdate();
////            if (rowsAffected > 0) {
////                System.out.println("Користувача додано до бази даних.");
////                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
////                if (generatedKeys.next()) {
////                    long userId = generatedKeys.getInt(1);
////                    System.out.println("Згенерований ID користувача: " + userId);
////                }
////            } else {
////                System.out.println("Не вдалося додати користувача до бази даних.");
////            }
////        } catch (SQLException ex) {
////            throw new RuntimeException(ex);
////        }
////        return user;
////    }
//
//
//
//
//
//
//
//
//    @Override
//    public List<User> findByNameContaining(String nameFragment) {
//        return null;
//    }
//
//    @Override
//    public List<User> findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(int id) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//    }
//
//    @Override
//    public <S extends User> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<User> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> Longs) {
//
//    }
//
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public User getOne(Long Long) {
//        return null;
//    }
//
//    @Override
//    public User getById(Long Long) {
//        return null;
//    }
//
//    @Override
//    public User getReferenceById(Long Long) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> long count(Example<S> example) {
//        return 0;
//    }
//
//
//    @Override
//    public <S extends User> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//
//    @Override
//    public <S extends User> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findById(Long Long) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long Long) {
//        return false;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<User> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long Long) {
//
//    }
//
//    @Override
//    public void delete(User entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends User> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<User> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        return null;
//    }
//}
