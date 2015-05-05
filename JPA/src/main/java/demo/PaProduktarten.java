package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pa_produktarten database table.
 * 
 */
@Entity
@Table(name="pa_produktarten")
@NamedQuery(name="PaProduktarten.findAll", query="SELECT p FROM PaProduktarten p")
public class PaProduktarten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pa_ID;

	@Column(name="pa_bez")
	private String paBez;

	//bi-directional many-to-one association to PProdukte
	@OneToMany(mappedBy="paProduktarten")
	private List<PProdukte> PProduktes;

	//bi-directional many-to-one association to PaProduktarten
	@ManyToOne
	@JoinColumn(name="pa_pa_kategorie")
	private PaProduktarten paProduktarten;

	//bi-directional many-to-one association to PaProduktarten
	@OneToMany(mappedBy="paProduktarten")
	private List<PaProduktarten> paProduktartens;

	public PaProduktarten() {
	}

	public int getPa_ID() {
		return this.pa_ID;
	}

	public void setPa_ID(int pa_ID) {
		this.pa_ID = pa_ID;
	}

	public String getPaBez() {
		return this.paBez;
	}

	public void setPaBez(String paBez) {
		this.paBez = paBez;
	}

	public List<PProdukte> getPProduktes() {
		return this.PProduktes;
	}

	public void setPProduktes(List<PProdukte> PProduktes) {
		this.PProduktes = PProduktes;
	}

	public PProdukte addPProdukte(PProdukte PProdukte) {
		getPProduktes().add(PProdukte);
		PProdukte.setPaProduktarten(this);

		return PProdukte;
	}

	public PProdukte removePProdukte(PProdukte PProdukte) {
		getPProduktes().remove(PProdukte);
		PProdukte.setPaProduktarten(null);

		return PProdukte;
	}

	public PaProduktarten getPaProduktarten() {
		return this.paProduktarten;
	}

	public void setPaProduktarten(PaProduktarten paProduktarten) {
		this.paProduktarten = paProduktarten;
	}

	public List<PaProduktarten> getPaProduktartens() {
		return this.paProduktartens;
	}

	public void setPaProduktartens(List<PaProduktarten> paProduktartens) {
		this.paProduktartens = paProduktartens;
	}

	public PaProduktarten addPaProduktarten(PaProduktarten paProduktarten) {
		getPaProduktartens().add(paProduktarten);
		paProduktarten.setPaProduktarten(this);

		return paProduktarten;
	}

	public PaProduktarten removePaProduktarten(PaProduktarten paProduktarten) {
		getPaProduktartens().remove(paProduktarten);
		paProduktarten.setPaProduktarten(null);

		return paProduktarten;
	}

}