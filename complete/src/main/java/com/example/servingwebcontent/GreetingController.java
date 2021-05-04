package com.example.servingwebcontent;

import com.archer.exercise.uam.service.TripCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

//	@Autowired
	private TripCountService tripCountService = new TripCountService();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/geo")
	public String geo(@RequestParam(name="name", required=false, defaultValue="sort") String name, @RequestParam(name="date", required=false) String date, Model model) {
		model.addAttribute("test", name.equals("sort") ? tripCountService.sortTrip(null, date) : tripCountService.jsonHeatMap(null, null, date));
		return "geo";
	}

}
