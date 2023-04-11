package harkkatyo.kotityoseuranta.domain;

import org.springframework.data.repository.CrudRepository;

public interface ApinKayttajaRepo extends CrudRepository<ApinKayttaja, Long> {
	ApinKayttaja findByUsername(String username);
}
