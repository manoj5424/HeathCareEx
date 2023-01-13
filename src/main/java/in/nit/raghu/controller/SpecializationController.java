package in.nit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		String message="Record is ("+id+") created";
		model.addAttribute("message", message);
		return "SpecializationRegister";
	}
	
	@GetMapping("/all")
	public String viewAll(Model model, @RequestParam(value = "message", required = false) String message) {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "SpecializationData";
	}
	
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
		service.removeSpecialization(id);
		attributes.addAttribute("message", "Record is ("+id+") removed");
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model) {
		Specialization spec = service.getOneSpecialization(id);
		model.addAttribute("specialization", spec);
		return "SpecializationEdit";
	}
	
	@PostMapping("/update")
	public String updateDate(
			@ModelAttribute Specialization specialization,RedirectAttributes attributes) {
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Record ("+specialization.getId()+") is updated");
		return "redirect:all";
	}
	
	@GetMapping("/chechcode")
	public @ResponseBody String validaSpecCode(@RequestParam String code) { //@responcebody do not search as view name (not return view name)
		String message="";
		if(service.isSpecCodeExit(code)){
			message = code+", already exist";	//this is respnse
		}
		return message; //not html / view name
	}
}
