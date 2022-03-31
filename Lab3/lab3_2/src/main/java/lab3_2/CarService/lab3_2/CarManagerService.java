package lab3_2.CarService.lab3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car newCar){
        return carRepository.save(newCar);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarDetails(long carID){
        Car car = carRepository.findByCarID(carID);
        Optional<Car> c;
        if(car!=null){
            c = Optional.of(car);
        }
        else{
            c = Optional.empty();
        }
        return c;
    }
}
