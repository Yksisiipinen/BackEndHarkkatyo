package harkkatyo.kotityoseuranta.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Kategoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String katNimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
	@JsonIgnore
	private List<Kotityo> kotityot;
	
	public Kategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kategoria(String katNimi) {
		this.katNimi = katNimi;
	}
	
	public Kategoria(Long id, String katNimi) {
		super();
		this.id = id;
		this.katNimi = katNimi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKatNimi() {
		return katNimi;
	}

	public void setKatNimi(String katNimi) {
		this.katNimi = katNimi;
	}

	@Override
	public String toString() {
		return "kategoria [id=" + id + ", katNimi=" + katNimi + "]";
	}
	
	
}
