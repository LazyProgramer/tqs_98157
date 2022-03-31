package lab3_2.CarService.lab3_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    
    Car findByCarID(long carID);
    List<Car> findAll();
}
