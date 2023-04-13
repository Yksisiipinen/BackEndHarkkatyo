package harkkatyo.kotityoseuranta.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Kotityo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //IDENTITY
	private Long kotityoid;
	private String tekija, tyonNimi;
	private int kesto;
	
	@ManyToOne
	@JoinColumn(name="kategoriaid")
	private Kategoria kategoria;
	
	public Kotityo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kotityo(String tekija, String tyonNimi, int kesto) {
		super();
		this.tekija = tekija;
		this.tyonNimi = tyonNimi;
		this.kesto = kesto;
	}

	public Kotityo(String tekija, String tyonNimi, int kesto, Kategoria kategoria) {
		super();
		this.tekija = tekija;
		this.tyonNimi = tyonNimi;
		this.kesto = kesto;
		this.kategoria = kategoria;
	}

	public Long getKotityoid() {
		return kotityoid;
	}

	public void setKotityoid(Long kotityoid) {
		this.kotityoid = kotityoid;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public String getTyonNimi() {
		return tyonNimi;
	}

	public void setTyonNimi(String tyonNimi) {
		this.tyonNimi = tyonNimi;
	}

	public int getKesto() {
		return kesto;
	}

	public void setKesto(int kesto) {
		this.kesto = kesto;
	}

	@Override
	public String toString() {
		return "Kotityo [kotityoid=" + kotityoid + ", tekija=" + tekija + ", tyonNimi=" + tyonNimi + ", kesto=" + kesto + "]";
	}
}
