package com.skillenza.parkinglotjava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {

	@Autowired
	private ParkingLotRepository repo;

	@GetMapping("/parkings")
	public List<ParkingLot> getParkings() {
		return repo.findAll();

	}
	
	@PostMapping("/parking")
	public String calculateAmount(@RequestBody int time){
		//Assuming that time will be in seconds
		ParkingLot lot = new ParkingLot();
		lot.setParking_duration(time);
		if(time<=60){
				lot.setParking_amount(20);
		}else{		
			int extraTime = time - 60;
			int extraTimeAmnt = (int) (extraTime * 0.333);
			lot.setParking_amount(extraTimeAmnt+20);
			
		}
		
		repo.save(lot);
		
		return "success";
		
	}
}
