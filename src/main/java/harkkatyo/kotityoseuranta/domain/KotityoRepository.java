package harkkatyo.kotityoseuranta.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KotityoRepository  extends CrudRepository<Kotityo, Long> {
	List<Kotityo> findBytyonNimi(String tyonNimi);
}
