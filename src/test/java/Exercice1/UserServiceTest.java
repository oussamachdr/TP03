package Exercice1;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;
public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepositoryMock;

    @Before
    public void setUp() {
        // Créer un mock pour UserRepository
        userRepositoryMock = mock(UserRepository.class);
        // Initialiser UserService avec le mock
        userService = new UserService(userRepositoryMock);
    }

    @Test
    public void testGetUserById_UserExists() {
        // Définir le comportement du mock pour retourner un utilisateur existant
        long userId = 123;
        User user = new User("choudar","oussama",userId);
        when(userRepositoryMock.findUserById(userId)).thenReturn(user);

        User actualUser = userService.getUserById(userId);
        Assertions.assertEquals(user, actualUser);
        verify(userRepositoryMock).findUserById(userId);
    }
}
