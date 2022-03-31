package lab3_2.CarService.lab3_2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private CarRepository CarRepository;
    
    @Test
    void whenFindFordByCarId_thenReturnFord() {
        Car ford = new Car("Ford", "2014 Tauros");
        entityManager.persistAndFlush(ford);

        Car found = CarRepository.findByCarID(ford.getCarID());
        assertThat( found ).isEqualTo(ford);
    }

    @Test
    void whenInvalidId_thenReturnNull() {
        Car fromDb = CarRepository.findByCarID(-1);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenSetOfCars_whenFindAll_thenReturnAllCars() {
        Car ford = new Car("Ford", "2014 Tauros");
        Car audi = new Car("Audi", "Audi A8");
        Car bmw = new Car("BMW", "BMW M4");

        entityManager.persist(ford);
        entityManager.persist(bmw);
        entityManager.persist(audi);
        entityManager.flush();

        List<Car> allCars = CarRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getCarID).containsOnly(ford.getCarID(), audi.getCarID(), bmw.getCarID());
    }
}
