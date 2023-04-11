package harkkatyo.kotityoseuranta.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import harkkatyo.kotityoseuranta.domain.ApinKayttaja;
import harkkatyo.kotityoseuranta.domain.ApinKayttajaRepo;
import harkkatyo.kotityoseuranta.domain.KayttajaRekkaus;

@Controller
public class ApinKayttajaController {

	@Autowired
	ApinKayttajaRepo userRepository;
	
	@GetMapping("/admin/rekisterointi")
	public String lisaaUusiKayttaja(Model model) {
		model.addAttribute("uusiKayttaja", new KayttajaRekkaus());
		return "rekisterointi";
	}
	
	@PostMapping("/admin/saveuser")
	public String tallennaKayttaja(@Valid @ModelAttribute("uusiKayttaja") KayttajaRekkaus uusiKayttaja, BindingResult bindingResult) {

		if (!bindingResult.hasErrors()) {
			if (uusiKayttaja.getPassword().equals(uusiKayttaja.getPasswordCheck())) {
				String pwd = uusiKayttaja.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				ApinKayttaja uusiApinKayttaja = new ApinKayttaja();
				uusiApinKayttaja.setPasswordHash(hashPwd);
				uusiApinKayttaja.setUsername(uusiKayttaja.getUsername());
				uusiApinKayttaja.setRole("USER");
				if (userRepository.findByUsername(uusiKayttaja.getUsername()) == null) {
					userRepository.save(uusiApinKayttaja);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "rekisterointi";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
				return "rekisterointi";
			}
		} else {
			return "rekisterointi";
		}
		return "redirect:/login";
	}
}
