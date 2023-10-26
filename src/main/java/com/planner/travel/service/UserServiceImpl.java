package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import com.planner.travel.repository.UserRepo;
import com.planner.travel.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{
  //  private final UserDAO userDAO;
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // чекнути, що таке мап стракт MapStruct
        User user = userMapper.toEntity(userDTO);
        user = userRepo.save(user);
        return userMapper.toDTO(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserDTO> getUser(int id) {
        return userRepo.findById(id).map(userMapper::toDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> findAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserDTO> getById(int userId) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public boolean deleteUser(int userId) {
        userRepo.deleteById(userId);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Transactional
    @Override
    public UserDTO updateUser(int userId, UserDTO userDTO) {
        if (userRepo.existsById(userId)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(userId);
            user = userRepo.save(user);
            return userMapper.toDTO(user);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }




  //  @PostConstruct
/*
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
    }
*/

}
