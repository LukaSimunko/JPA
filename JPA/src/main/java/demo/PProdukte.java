package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the p_produkte database table.
 * 
 */
@Entity
@Table(name="p_produkte")
@NamedQuery(name="PProdukte.findAll", query="SELECT p FROM PProdukte p")
public class PProdukte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int p_ID;

	@Column(name="p_beschreibung")
	private String pBeschreibung;

	@Column(name="p_bez")
	private String pBez;

	@Column(name="p_preis")
	private float pPreis;

	@Column(name="p_stueckzahl")
	private int pStueckzahl;

	//bi-directional many-to-one association to BpBestellpo
	@OneToMany(mappedBy="PProdukte")
	private List<BpBestellpo> bpBestellpos;

	//bi-directional many-to-one association to PaProduktarten
	@ManyToOne
	@JoinColumn(name="p_pa_ID")
	private PaProduktarten paProduktarten;

	public PProdukte() {
	}

	public int getP_ID() {
		return this.p_ID;
	}

	public void setP_ID(int p_ID) {
		this.p_ID = p_ID;
	}

	public String getPBeschreibung() {
		return this.pBeschreibung;
	}

	public void setPBeschreibung(String pBeschreibung) {
		this.pBeschreibung = pBeschreibung;
	}

	public String getPBez() {
		return this.pBez;
	}

	public void setPBez(String pBez) {
		this.pBez = pBez;
	}

	public float getPPreis() {
		return this.pPreis;
	}

	public void setPPreis(float pPreis) {
		this.pPreis = pPreis;
	}

	public int getPStueckzahl() {
		return this.pStueckzahl;
	}

	public void setPStueckzahl(int pStueckzahl) {
		this.pStueckzahl = pStueckzahl;
	}

	public List<BpBestellpo> getBpBestellpos() {
		return this.bpBestellpos;
	}

	public void setBpBestellpos(List<BpBestellpo> bpBestellpos) {
		this.bpBestellpos = bpBestellpos;
	}

	public BpBestellpo addBpBestellpo(BpBestellpo bpBestellpo) {
		getBpBestellpos().add(bpBestellpo);
		bpBestellpo.setPProdukte(this);

		return bpBestellpo;
	}

	public BpBestellpo removeBpBestellpo(BpBestellpo bpBestellpo) {
		getBpBestellpos().remove(bpBestellpo);
		bpBestellpo.setPProdukte(null);

		return bpBestellpo;
	}

	public PaProduktarten getPaProduktarten() {
		return this.paProduktarten;
	}

	public void setPaProduktarten(PaProduktarten paProduktarten) {
		this.paProduktarten = paProduktarten;
	}

}