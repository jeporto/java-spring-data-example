package br.com.jeporto.car.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeporto.car.api.Car;
import br.com.jeporto.car.dao.CarEntity;
import br.com.jeporto.car.dao.CarRepository;

@Service
public class CarService {

	private CarConverter converter;
	private CarRepository repository;

	@Autowired
	public CarService(CarConverter converter, CarRepository repository) {
		this.converter = converter;
		this.repository = repository;
	}

	public Car save(String name) {
		CarEntity entity = converter.convert(name);
		entity = repository.save(entity);
		return converter.convert(entity);
	}

	public Car update(Car car) {
		CarEntity entity = converter.convert(car);
		entity = repository.save(entity);
		return converter.convert(entity);
	}
	
	public List<Car> list() {
		Stream<CarEntity> entities = StreamSupport.stream(repository.findAll().spliterator(), false);
		return entities
					.map(converter::convert)
					.collect(Collectors.toList());
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
