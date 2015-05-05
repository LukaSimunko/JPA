package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bp_bestellpos database table.
 * 
 */
@Entity
@Table(name="bp_bestellpos")
@NamedQuery(name="BpBestellpo.findAll", query="SELECT b FROM BpBestellpo b")
public class BpBestellpo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BpBestellpoPK id;

	@Column(name="bp_bemerkung")
	private String bpBemerkung;

	private float bp_posPreis;

	@Column(name="bp_rabatt")
	private float bpRabatt;

	private float bp_stueckPreis;

	private int bp_stueckZahl;

	//bi-directional many-to-one association to BBestellungen
	@ManyToOne
	@JoinColumn(name="bp_b_ID",insertable=false, updatable=false)
	private BBestellungen BBestellungen;

	//bi-directional many-to-one association to PProdukte
	@ManyToOne
	@JoinColumn(name="bp_p_ID",insertable=false, updatable=false)
	private PProdukte PProdukte;

	public BpBestellpo() {
	}

	public BpBestellpoPK getId() {
		return this.id;
	}

	public void setId(BpBestellpoPK id) {
		this.id = id;
	}

	public String getBpBemerkung() {
		return this.bpBemerkung;
	}

	public void setBpBemerkung(String bpBemerkung) {
		this.bpBemerkung = bpBemerkung;
	}

	public float getBp_posPreis() {
		return this.bp_posPreis;
	}

	public void setBp_posPreis(float bp_posPreis) {
		this.bp_posPreis = bp_posPreis;
	}

	public float getBpRabatt() {
		return this.bpRabatt;
	}

	public void setBpRabatt(float bpRabatt) {
		this.bpRabatt = bpRabatt;
	}

	public float getBp_stueckPreis() {
		return this.bp_stueckPreis;
	}

	public void setBp_stueckPreis(float bp_stueckPreis) {
		this.bp_stueckPreis = bp_stueckPreis;
	}

	public int getBp_stueckZahl() {
		return this.bp_stueckZahl;
	}

	public void setBp_stueckZahl(int bp_stueckZahl) {
		this.bp_stueckZahl = bp_stueckZahl;
	}

	public BBestellungen getBBestellungen() {
		return this.BBestellungen;
	}

	public void setBBestellungen(BBestellungen BBestellungen) {
		this.BBestellungen = BBestellungen;
	}

	public PProdukte getPProdukte() {
		return this.PProdukte;
	}

	public void setPProdukte(PProdukte PProdukte) {
		this.PProdukte = PProdukte;
	}

}