package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_standorte database table.
 * 
 */
@Entity
@Table(name="s_standorte")
@NamedQuery(name="SStandorte.findAll", query="SELECT s FROM SStandorte s")
public class SStandorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int s_ID;

	@Column(name="s_fax")
	private String sFax;

	@Column(name="s_hausnummer")
	private String sHausnummer;

	@Column(name="s_ort")
	private String sOrt;

	@Column(name="s_plz")
	private String sPlz;

	@Column(name="s_strasse")
	private String sStrasse;

	//bi-directional many-to-one association to EsEmailstandorte
	@OneToMany(mappedBy="SStandorte")
	private List<EsEmailstandorte> esEmailstandortes;

	//bi-directional many-to-many association to AAbteilungen
	@ManyToMany
	@JoinTable(
		name="h_hat"
		, joinColumns={
			@JoinColumn(name="h_s_standort")
			}
		, inverseJoinColumns={
			@JoinColumn(name="h_a_abteilung")
			}
		)
	private List<AAbteilungen> AAbteilungens;

	//bi-directional many-to-one association to TsTelstandorte
	@OneToMany(mappedBy="SStandorte")
	private List<TsTelstandorte> tsTelstandortes;

	public SStandorte() {
	}

	public int getS_ID() {
		return this.s_ID;
	}

	public void setS_ID(int s_ID) {
		this.s_ID = s_ID;
	}

	public String getSFax() {
		return this.sFax;
	}

	public void setSFax(String sFax) {
		this.sFax = sFax;
	}

	public String getSHausnummer() {
		return this.sHausnummer;
	}

	public void setSHausnummer(String sHausnummer) {
		this.sHausnummer = sHausnummer;
	}

	public String getSOrt() {
		return this.sOrt;
	}

	public void setSOrt(String sOrt) {
		this.sOrt = sOrt;
	}

	public String getSPlz() {
		return this.sPlz;
	}

	public void setSPlz(String sPlz) {
		this.sPlz = sPlz;
	}

	public String getSStrasse() {
		return this.sStrasse;
	}

	public void setSStrasse(String sStrasse) {
		this.sStrasse = sStrasse;
	}

	public List<EsEmailstandorte> getEsEmailstandortes() {
		return this.esEmailstandortes;
	}

	public void setEsEmailstandortes(List<EsEmailstandorte> esEmailstandortes) {
		this.esEmailstandortes = esEmailstandortes;
	}

	public EsEmailstandorte addEsEmailstandorte(EsEmailstandorte esEmailstandorte) {
		getEsEmailstandortes().add(esEmailstandorte);
		esEmailstandorte.setSStandorte(this);

		return esEmailstandorte;
	}

	public EsEmailstandorte removeEsEmailstandorte(EsEmailstandorte esEmailstandorte) {
		getEsEmailstandortes().remove(esEmailstandorte);
		esEmailstandorte.setSStandorte(null);

		return esEmailstandorte;
	}

	public List<AAbteilungen> getAAbteilungens() {
		return this.AAbteilungens;
	}

	public void setAAbteilungens(List<AAbteilungen> AAbteilungens) {
		this.AAbteilungens = AAbteilungens;
	}

	public List<TsTelstandorte> getTsTelstandortes() {
		return this.tsTelstandortes;
	}

	public void setTsTelstandortes(List<TsTelstandorte> tsTelstandortes) {
		this.tsTelstandortes = tsTelstandortes;
	}

	public TsTelstandorte addTsTelstandorte(TsTelstandorte tsTelstandorte) {
		getTsTelstandortes().add(tsTelstandorte);
		tsTelstandorte.setSStandorte(this);

		return tsTelstandorte;
	}

	public TsTelstandorte removeTsTelstandorte(TsTelstandorte tsTelstandorte) {
		getTsTelstandortes().remove(tsTelstandorte);
		tsTelstandorte.setSStandorte(null);

		return tsTelstandorte;
	}

}