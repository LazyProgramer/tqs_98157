package lab3_2.CarService.lab3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carService;

    @PostMapping("/cars" )
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save( car );
        return new ResponseEntity<>(saved, status);
    }


    @GetMapping(path="/cars" )
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(path="/cars&carId={carId}" )
    public ResponseEntity<Car> getCarById(@PathVariable(value = "carId")Long carId) {
        //return carService.getCarDetails(carId);
        return ResponseEntity.ok().body(carService.getCarDetails(carId).get());
    }
}
