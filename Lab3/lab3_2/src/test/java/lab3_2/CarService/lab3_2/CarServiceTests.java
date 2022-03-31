package lab3_2.CarService.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTests {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carService;

    private Car ford;
    @BeforeEach
    public void setUp() {
        ford = new Car("Ford", "2014 Tauros");
        ford.setCarID(111L);
    }

    @Test
    void whenSearchValidId_thenCarShouldBeFound() {
        when(carRepository.findByCarID(ford.getCarID())).thenReturn(ford);
        Optional<Car> car_found = carService.getCarDetails(ford.getCarID());
        assertThat(car_found.get().getCarID()).isEqualTo(111L);
        verify(carRepository, VerificationModeFactory.times(1)).findByCarID(ford.getCarID());
    }

    @Test
    void whenSearchInvalidId_thenCarShouldNotBeFound() {
        when(carRepository.findByCarID(-1)).thenReturn(null);
        Optional<Car> car_found = carService.getCarDetails(-1);
        verify(carRepository, VerificationModeFactory.times(1)).findByCarID(-1);
        assertThat(car_found.isEmpty()).isEqualTo(true);
    }

    @Test
    void given3Cars_whengetAll_thenReturn3Records() {
        Car audi = new Car("Audi", "Audi A8");
        Car bmw = new Car("BMW", "BMW M4");

        List<Car> allCarRep = Arrays.asList(ford, audi, bmw);
        Mockito.when(carRepository.findAll()).thenReturn(allCarRep);

        List<Car> allCars = carService.getAllCars();
        verifyFindAllCarsIsCalledOnce();
        assertThat(allCars).hasSize(3).extracting(Car::getCarID).contains(ford.getCarID(), audi.getCarID(), bmw.getCarID());
    }

    @Test
    void whenSaved_thenCarShouldBeSaved(){
        when(carRepository.save(ford)).thenReturn(ford);

        Car car_saved = carService.save(ford);
        
        verify(carRepository, VerificationModeFactory.times(1)).save(ford);
        assertThat(car_saved.getCarID()).isEqualTo(111L);
    }

    private void verifyFindAllCarsIsCalledOnce() {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }
}
