package com.planner.travel.unit;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import com.planner.travel.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
            public void setUp() {
        userMapper = new UserMapper();
    }

    @Test
       public void testToDTO() {
        //Підготовка
        User user = new User();
        user.setId(1L);
        user.setName("Serhij");
        user.setEmail("abcd@gmail.com");
        user.setSurname("Abcding");
        user.setCity("Kyiv");
//        user.setDob(Date.valueOf("01.01.1995"));
        user.setCountry("Ukraine");
        user.setPhone("050505050505");


        //Дія
        UserDTO dto = userMapper.toDTO(user);

        //Перевірка
        assertEquals(1L, dto.getId());
        assertEquals("Serhij", dto.getName());
        assertEquals("Abcding", dto.getSurname());
        assertEquals("abcd@gmail.com", dto.getEmail());
        assertEquals("Kyiv", dto.getCity());
        assertEquals("Ukraine", dto.getCountry());
        assertEquals("050505050505", dto.getPhone());
//      assertEquals(Date.valueOf("01.011995"), dto.getDob());

    }

    @Test
    public void testToEntity() {
        // Підготовка
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setName("Alex");
        dto.setEmail("abcd@gmail.com");
        dto.setSurname("Example.com");
        dto.setCity("Tokyo");
        dto.setPhone("050505050505");
        dto.setCountry("Japan");

   //     dto.setDob(Date.valueOf("01/01/1995"));


        // Дія
        User user = userMapper.toEntity(dto);

        // Перевірка
        assertEquals(1L, user.getId());
        assertEquals("abcd@gmail.com", user.getEmail());
        assertEquals("Alex", user.getName());
        assertEquals("Example.com", user.getSurname());
        assertEquals("050505050505", user.getPhone());
        assertEquals("Japan", user.getCountry());
        assertEquals("Kyiv", user.getCity());

     //   assertEquals(Date.valueOf("01/01/1995"), user.getDob());
    }




}
