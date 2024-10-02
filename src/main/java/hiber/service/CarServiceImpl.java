package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Override
    @Transactional
    public void addCar(Car car) {
        log.info("Successfully add car with id {}", car.getId());
        carDao.addCar(car);
    }

    @Override
    @Transactional
    public List<Car> getCars(int limit) {
        List<Car> result = carDao.getCars(limit);
        log.info("Cars list size - {}", result.size());
        return result;
    }
}
