package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import com.planner.travel.repository.UserJpaRepository;
import com.planner.travel.utils.UserMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserJpaRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserJpaRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

//    private final Map<Integer, User> users = new HashMap<>();

    private final Map<Integer, User> users = new HashMap<>();

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public Optional<UserDTO> getUser(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user = userRepository.save(user);
            return userMapper.toDTO(user);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);

    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    // DAO layer 48.44
    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public User add(User user) {
        users.put(Math.toIntExact(user.getId()), user);
        return user;
    }

    @PostConstruct
    public void init() {
        User sergij = User.builder()
                .id(1L)
                .name("Serhij")
                .city("Kyiv")
                .country("Ukraine")
                .phone("0505050505")
                .email("serhij@gmail.com")
          //      .dob(Date.valueOf("01.01.1995"))
                .build();
        User vlad = User.builder()
                .id(2L)
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

}
