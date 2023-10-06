package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dao.UserDAOImpl;
import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import com.planner.travel.dao.UserDAO;
import com.planner.travel.utils.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final UserMapper userMapper;


    @Override
    public UserDTO findById(Integer id) {
        return userMapper.toDTO(userDAO.findById(id));
    }

    public UserServiceImpl(UserDAOImpl userDAOImpl, UserMapper userMapper) {
        this.userDAO = userDAOImpl;
        this.userMapper = userMapper;
    }

//    private final Map<Integer, User> users = new HashMap<>();

    private final Map<Integer, User> users = new HashMap<>();




    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        System.out.println("UserServiceImplementation - createUser method - 3");
        User user = userMapper.toEntity(userDTO);
        System.out.println("UserServiceImplementation - toEntity works - 4");
        user = userDAO.save(user);
        System.out.println("UserServiceImplementation - toDAO works - 5");
        return userMapper.toDTO(user);
    }

    @Override
    public Optional<UserDTO> getUser(int id) {
        return userDAO.findById(Long.valueOf(id)).map(userMapper::toDTO);
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        if (userDAO.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user = userDAO.save(user);
            return userMapper.toDTO(user);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);

    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userDAO.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    // DAO layer 48.44
    @Override
    public Optional<UserDTO> getById(int userId) {
        return Optional.ofNullable(userMapper.toDTO(userDAO.findById(userId)));
    }


    // метод додавання користувача
//    @Override
//    public User add(User user) {
//        users.put(Math.toIntExact(user.getId()), user);
//        return user;
//    }
/*
    @PostConstruct
    public void init() {
        User sergij = User.builder()
                .id(1)
                .name("Serhij")
                .city("Kyiv")
                .country("Ukraine")
                .phone("0505050505")
                .email("serhij@gmail.com")
          //      .dob(Date.valueOf("01.01.1995"))
                .build();
        User vlad = User.builder()
                .id(2)
                .name("Vlad")
                .city("Tokyo")
                .country("japan")
                .phone("0505050505")
                .email("vladj@gmail.com")
           //     .dob(Date.valueOf("01.01.1987"))
                .build();
        users.put(1, sergij);
        users.put(2, vlad);
    }*/

}
