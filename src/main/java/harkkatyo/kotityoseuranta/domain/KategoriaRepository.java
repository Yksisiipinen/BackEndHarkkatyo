package harkkatyo.kotityoseuranta.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KategoriaRepository extends CrudRepository<Kategoria, Long> {
	List<Kategoria> findBykatNimi(String katNimi);
}
