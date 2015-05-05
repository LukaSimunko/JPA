package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the b_bestellungen database table.
 * 
 */
@Entity
@Table(name="b_bestellungen")
@NamedQuery(name="BBestellungen.findAll", query="SELECT b FROM BBestellungen b")
public class BBestellungen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int b_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="b_aufgegeben")
	private Date bAufgegeben;

	@Temporal(TemporalType.DATE)
	@Column(name="b_bezahlt")
	private Date bBezahlt;

	@Temporal(TemporalType.DATE)
	@Column(name="b_faellig")
	private Date bFaellig;

	@Column(name="b_preis")
	private float bPreis;

	@Column(name="b_rabatt")
	private float bRabatt;

	//bi-directional many-to-one association to KKunden
	@ManyToOne
	@JoinColumn(name="b_k_kunde")
	private KKunden KKunden;

	//bi-directional many-to-one association to MMitarbeiter
	@ManyToOne
	@JoinColumn(name="b_m_bearbeiter")
	private MMitarbeiter MMitarbeiter;

	//bi-directional many-to-one association to LLieferarten
	@ManyToOne
	@JoinColumn(name="b_lieferart")
	private LLieferarten LLieferarten;

	//bi-directional many-to-one association to BpBestellpo
	@OneToMany(mappedBy="BBestellungen")
	private List<BpBestellpo> bpBestellpos;

	//bi-directional many-to-one association to MMahnungen
	@OneToMany(mappedBy="BBestellungen")
	private List<MMahnungen> MMahnungens;

	public BBestellungen() {
	}

	public int getB_ID() {
		return this.b_ID;
	}

	public void setB_ID(int b_ID) {
		this.b_ID = b_ID;
	}

	public Date getBAufgegeben() {
		return this.bAufgegeben;
	}

	public void setBAufgegeben(Date bAufgegeben) {
		this.bAufgegeben = bAufgegeben;
	}

	public Date getBBezahlt() {
		return this.bBezahlt;
	}

	public void setBBezahlt(Date bBezahlt) {
		this.bBezahlt = bBezahlt;
	}

	public Date getBFaellig() {
		return this.bFaellig;
	}

	public void setBFaellig(Date bFaellig) {
		this.bFaellig = bFaellig;
	}

	public float getBPreis() {
		return this.bPreis;
	}

	public void setBPreis(float bPreis) {
		this.bPreis = bPreis;
	}

	public float getBRabatt() {
		return this.bRabatt;
	}

	public void setBRabatt(float bRabatt) {
		this.bRabatt = bRabatt;
	}

	public KKunden getKKunden() {
		return this.KKunden;
	}

	public void setKKunden(KKunden KKunden) {
		this.KKunden = KKunden;
	}

	public MMitarbeiter getMMitarbeiter() {
		return this.MMitarbeiter;
	}

	public void setMMitarbeiter(MMitarbeiter MMitarbeiter) {
		this.MMitarbeiter = MMitarbeiter;
	}

	public LLieferarten getLLieferarten() {
		return this.LLieferarten;
	}

	public void setLLieferarten(LLieferarten LLieferarten) {
		this.LLieferarten = LLieferarten;
	}

	public List<BpBestellpo> getBpBestellpos() {
		return this.bpBestellpos;
	}

	public void setBpBestellpos(List<BpBestellpo> bpBestellpos) {
		this.bpBestellpos = bpBestellpos;
	}

	public BpBestellpo addBpBestellpo(BpBestellpo bpBestellpo) {
		getBpBestellpos().add(bpBestellpo);
		bpBestellpo.setBBestellungen(this);

		return bpBestellpo;
	}

	public BpBestellpo removeBpBestellpo(BpBestellpo bpBestellpo) {
		getBpBestellpos().remove(bpBestellpo);
		bpBestellpo.setBBestellungen(null);

		return bpBestellpo;
	}

	public List<MMahnungen> getMMahnungens() {
		return this.MMahnungens;
	}

	public void setMMahnungens(List<MMahnungen> MMahnungens) {
		this.MMahnungens = MMahnungens;
	}

	public MMahnungen addMMahnungen(MMahnungen MMahnungen) {
		getMMahnungens().add(MMahnungen);
		MMahnungen.setBBestellungen(this);

		return MMahnungen;
	}

	public MMahnungen removeMMahnungen(MMahnungen MMahnungen) {
		getMMahnungens().remove(MMahnungen);
		MMahnungen.setBBestellungen(null);

		return MMahnungen;
	}

}