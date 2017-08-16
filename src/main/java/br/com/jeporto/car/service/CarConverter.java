package br.com.jeporto.car.service;

import org.springframework.stereotype.Component;

import br.com.jeporto.car.api.Car;
import br.com.jeporto.car.dao.CarEntity;

@Component
public class CarConverter {

	public Car convert(CarEntity entity) {
		Car car = new Car();
		car.setId(entity.getId());
		car.setName(entity.getName());
		
		return car;
		
	}

	public CarEntity convert(Car car) {
		CarEntity entity = new CarEntity();
		entity.setId(car.getId());
		entity.setName(car.getName());
		
		return entity;
	}

	public CarEntity convert(String name) {
		CarEntity entity = new CarEntity();
		entity.setName(name);
		
		return entity;
	}
}
