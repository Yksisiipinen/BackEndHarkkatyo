package harkkatyo.kotityoseuranta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harkkatyo.kotityoseuranta.domain.ApinKayttaja;
import harkkatyo.kotityoseuranta.domain.ApinKayttajaRepo;
import harkkatyo.kotityoseuranta.domain.Kategoria;
import harkkatyo.kotityoseuranta.domain.KategoriaRepository;
import harkkatyo.kotityoseuranta.domain.Kotityo;
import harkkatyo.kotityoseuranta.domain.KotityoRepository;

@SpringBootApplication
public class KotityoseurantaApplication implements CommandLineRunner {
	@Autowired
	KotityoRepository kotityoRepo;
	
	@Autowired
	KategoriaRepository kategoriaRepo;


	public static void main(String[] args) {
		SpringApplication.run(KotityoseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner kotityoDemo (KotityoRepository kotityoRepo, KategoriaRepository kategoriaRepo, ApinKayttajaRepo userRepository) {
		return(args) -> {
			kategoriaRepo.save(new Kategoria("Siivous"));
			kategoriaRepo.save(new Kategoria("Keittiö"));
			kategoriaRepo.save(new Kategoria ("Ulkoilu"));
			
			kotityoRepo.save(new Kotityo("Selina", "Huoneen siivous", 30, kategoriaRepo.findBykatNimi("Siivous").get(0)));
			
			ApinKayttaja kayt1 = new ApinKayttaja("user", "$2a$10$IBt5MGTYmk6jUZcs4lshlOKNMXcGCohAdVkQiuBadEq2KR6XBM1OC", "USER");
			ApinKayttaja kayt2 = new ApinKayttaja("admin", "$2a$10$P.5NWleCZCUsolOWdB834.ISIICazrZlRVAQi4vRZf1LZGZogRlju", "ADMIN");
			userRepository.save(kayt1);
			userRepository.save(kayt2);
		};
		}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
