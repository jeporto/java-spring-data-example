package br.com.jeporto.car.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeporto.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarRest {

	private CarService service;

	@Autowired
	public CarRest(CarService service) {
		this.service = service;
	}

	@PostMapping(value = "/{name}")
	public ResponseEntity<Car> save(@PathVariable String name) {
		return ResponseEntity
							.status(HttpStatus.OK)
							.body(service.save(name));
	}
	@PutMapping(value = "/")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		return ResponseEntity
							.status(HttpStatus.OK)
							.body(service.update(car));
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Car>> list() {
		return ResponseEntity
							.status(HttpStatus.OK)
							.body(service.list());
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity
							.status(HttpStatus.OK)
							.body("Ok");
	}
}