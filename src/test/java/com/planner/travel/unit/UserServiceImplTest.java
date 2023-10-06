package com.planner.travel.unit;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import com.planner.travel.dao.UserDAO;
import com.planner.travel.service.UserServiceImpl;
import com.planner.travel.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    /*
     Анотація @Mock: Ви можете створити мок (mock) для конкретного класу або інтерфейсу за допомогою анотації @Mock.
      Наприклад, якщо ви маєте @Mock private SomeClass someClass;, то MockitoAnnotations.openMocks(this); ініціалізує цей мок для вас.
      */
    @Mock
    private UserDAO userRepository;

    /*
    Ця анотація дозволяє створювати "шпигунів" на реальних об'єктах. Коли ви створюєте шпигуна на реальному об'єкті,
    всі його методи викликаються насправді, доки ви явно не вказуєте інше за допомогою мокування (when/thenReturn).
     */
    @Spy
    private UserMapper userMapper;

    /*
    Анотація @InjectMocks: Використовується для автоматичного вставляння моків в основний об'єкт, який ви хочете протестувати.
    Тобто, якщо ви хочете протестувати сервіс, який має залежності, @InjectMocks автоматично вставить моки цих залежностей в ваш сервіс.
     */
    @InjectMocks
    private UserServiceImpl userService;


    @BeforeEach
    public void setUp() {
        /*
        використовується для ініціалізації моків (mock objects), які визначені в тестовому класі,
        так що вам не потрібно ініціалізувати кожен мок окремо.
         */
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("Test");
        user.setName("Serhii");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setEmail("Test");
        userDTO.setName("Serhii");

        //if UserMapper will be Mock
        //when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);
        //when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);

    //    User resultDTO = userService.createUser(user);

        /*
        зазвичай verify використовується для перевірки, чи був викликаний певний метод на мокованому об'єкті, і скільки разів.
        тут :
        чи метод save був викликаний один раз під час створення користувача:
        */
        verify(userRepository, times(1)).save(any(User.class));
   //     assertEquals(1L, resultDTO.getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(userMapper, times(1)).toEntity(userDTO);
        verify(userMapper, times(1)).toDTO(user);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("Test");
        user.setName("Serhii");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setEmail("Test");
        userDTO.setName("Serhii");

        //if UserMapper will be Mock
        //when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);
        //when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        given(userRepository.findById(Long.valueOf(1))).willReturn(Optional.of(user));

        Optional<UserDTO> resultDTO = userService.getUser(1);

        assertTrue(resultDTO.isPresent());
        assertEquals(1, resultDTO.get().getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(userMapper, times(1)).toDTO(user);
    }
}
