package com.example.spring_course;

import com.example.spring_course.repository.UserRepository;
import com.example.spring_course.repository.model.UserEntity;
import com.example.spring_course.service.UserService;
import com.example.spring_course.service.dto.UserRequestDTO;
import com.example.spring_course.service.dto.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserApplicationTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void calcoloTotale() {
        double prezzo = 10.0;
        int quantita = 3;
        double totale = prezzo * quantita;
        assertEquals(30.0, totale);
    }

    @Test
    public void createUserTest() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setFirstName("John");
        userRequestDTO.setLastName("Doe");
        userRequestDTO.setEmail("john.doe@example.com");
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(userEntity));
        UserResponseDTO userResponse = userService.createUser(userRequestDTO);
        assertNotNull(userResponse);
        assertEquals("john.doe@example.com", userResponse.getEmail());
    }
}
