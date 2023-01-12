package in.nit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.raghu.entity.Specialization;
import in.nit.raghu.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	

	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
	}
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Specialization spec, Model model) {
		Long id=service.saveSpecialization(spec);
		String message="Specialization ("+id+") created";
		model.addAttribute("message", message);
		return "SpecializationRegister";
	}
	
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list", list);
		return "SpecializationData";
	}
	
}
