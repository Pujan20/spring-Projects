package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SdController {
	
	@Autowired
	private SdService sdService;
	
	@PostMapping("/create")
	public int CreateSd(@RequestBody Sdetails S) {
		return sdService.Create(S);
	}
	
	@PutMapping("/update/{id}")
	public int UpdateSd(@RequestBody Sdetails S,@PathVariable int id) {
		return sdService.Update(S, id);
	}
	
	
	@GetMapping("/byId/{id}")
	public Optional<List<Sdetails>> getById(@PathVariable int id) {
		return sdService.FindById(id);
		
	}
	@GetMapping("/getAll")
	public List<Sdetails> getAll(){
		return sdService.ShowAll();
		
	}
	
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}

}
