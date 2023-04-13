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
	private Long kategoriaid;
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
	
	public Kategoria(String katNimi, List<Kotityo> kotityot) {
		super();
		this.katNimi = katNimi;
		this.kotityot = kotityot;
	}
	
	public Long getKategoriaid() {
		return kategoriaid;
	}

	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}

	public String getKatNimi() {
		return katNimi;
	}

	public void setKatNimi(String katNimi) {
		this.katNimi = katNimi;
	}
	
	public List<Kotityo> getKotityot() {
		return kotityot;
	}

	public void setKotityot(List<Kotityo> kotityot) {
		this.kotityot = kotityot;
	}

	@Override
	public String toString() {
		return "kategoria [kategoriaid=" + kategoriaid + ", katNimi=" + katNimi + "]";
	}
	
	
}
