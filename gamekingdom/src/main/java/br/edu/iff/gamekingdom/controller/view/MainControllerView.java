package br.edu.iff.gamekingdom.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "")
public class MainControllerView {
	@GetMapping("/layout-base")
	public String cruds(){
		return "layout-base";
	}
	
}