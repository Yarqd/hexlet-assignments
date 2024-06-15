package exercise.controller;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarDTO;
import exercise.dto.CarUpdateDTO;
import exercise.mapper.CarMapper;
import exercise.model.Car;
import exercise.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @GetMapping("/{id}")
    public CarDTO getCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return carMapper.mapToDTO(car);
    }

    @GetMapping
    public List<CarDTO> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return cars.stream()
                .map(carMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CarDTO createCar(@RequestBody CarCreateDTO carData) {
        Car car = carMapper.mapToEntity(carData);
        carService.saveCar(car);
        return carMapper.mapToDTO(car);
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarUpdateDTO carUpdateDTO) {
        Car car = carService.getCarById(id);
        carMapper.updateCarFromDTO(carUpdateDTO, car);
        carService.saveCar(car);
        return carMapper.mapToDTO(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}
