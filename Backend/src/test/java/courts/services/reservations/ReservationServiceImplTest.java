package courts.services.reservations;

import courts.authorisation.JwtProvider;
import courts.models.Court;
import courts.models.roles.User;
import courts.repositories.ICortsRepository;
import courts.repositories.ReservationsRepository;
import courts.repositories.roles.UserRepository;
import courts.services.ReservationServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.BDDMockito.*;



@SpringBootTest
@ActiveProfiles("H2")
class ReservationServiceImplTest {
    @Mock
    ReservationsRepository reservationsRepository;

    @Mock
    ICortsRepository cortsRepository;

    @Mock
    UserRepository userRepository;

    @Spy
    ReservationServiceImpl reservationServiceImpl;

    @Mock
    JwtProvider jwtProvider;

    @Before
    public void getDataFromApi(){
        given(userRepository.findById(Long.valueOf(1))).willReturn(java.util.Optional.of(new User()));
        given(userRepository.findById(Long.valueOf(2))).willReturn(java.util.Optional.of(null));
        given(cortsRepository.findById(Long.valueOf(1))).willReturn(java.util.Optional.of(new Court()));
        given(cortsRepository.findById(Long.valueOf(2))).willReturn(java.util.Optional.of(null));
        given(jwtProvider.getUserIdFromToken("")).willReturn(Long.valueOf(1));
    }

    @Test
    void should_add_reservation() {
        
    }


}