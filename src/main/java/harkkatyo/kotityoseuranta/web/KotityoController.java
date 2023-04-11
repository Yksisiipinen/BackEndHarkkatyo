package harkkatyo.kotityoseuranta.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import harkkatyo.kotityoseuranta.domain.KotityoRepository;
import harkkatyo.kotityoseuranta.domain.KategoriaRepository;
import harkkatyo.kotityoseuranta.domain.Kotityo;

@Controller
public class KotityoController {
	@Autowired
	private KotityoRepository kotityoRepo;
	
	@Autowired
	KategoriaRepository kategoriaRepo;

	@GetMapping(value= {"/", "index"})
	public String naytaEtusivu() {
		return "index";
	}
	
	@GetMapping("kotityolista")
	public String naytaTyot (Model model) {
		model.addAttribute("kotityot", kotityoRepo.findAll());
		return "kotityolista";
	}
	
	@GetMapping("lisaatyo")
	public String lisaaKotityo(Model model) {
		model.addAttribute("uusiKotityo", new Kotityo());
		model.addAttribute("kategoriat", kategoriaRepo.findAll());
		return "lisaatyo";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("muokkaa/{id}")
	public String muokkaa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaTyo", kotityoRepo.findById(id));
		model.addAttribute("kategoriat", kategoriaRepo.findAll());
		return "muokkaaTyo";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("delete/{id}")
	public String poistaTyo(@PathVariable("id") Long id, Model model) {
		kotityoRepo.deleteById(id);
		return "redirect:/kotityolista";
	}
	
	@PostMapping("/tallenna")
	public String tallenna(Kotityo kotityo, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			System.out.println("some error happened");
			model.addAttribute("uusiKotiTyo", kotityo);
			model.addAttribute("kategoriat", kategoriaRepo.findAll());
			return "lisaatyo";
		}
		kotityoRepo.save(kotityo);
		return "redirect:kotityolista";
	}
}
