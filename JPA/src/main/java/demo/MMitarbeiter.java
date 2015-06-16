package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the m_mitarbeiter database table.
 * 
 */
@Entity
@Table(name="m_mitarbeiter")
@NamedQuery(name="MMitarbeiter.findAll", query="SELECT m FROM MMitarbeiter m")
public class MMitarbeiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int m_ID;

	@Temporal(TemporalType.DATE)
	private Date m_gebDatum;

	@Column(name="m_gehalt")
	private float mGehalt;

	@Column(name="m_hausnummer")
	private String mHausnummer;

	@Column(name="m_nachname")
	private String mNachname;

	@Column(name="m_ort")
	private String mOrt;

	@Column(name="m_plz")
	private String mPlz;

	@Column(name="m_strasse")
	private String mStrasse;

	@Column(name="m_vorname")
	private String mVorname;

	//bi-directional many-to-one association to BBestellungen
	@OneToMany(mappedBy="MMitarbeiter")
	private List<BBestellungen> BBestellungens;

	//bi-directional many-to-one association to EmEmailmitarbeiter
	@OneToMany(mappedBy="MMitarbeiter")
	private List<EmEmailmitarbeiter> emEmailmitarbeiters;

	//bi-directional many-to-many association to StStellen
	@ManyToMany
	@JoinTable(
		name="i_ist"
		, joinColumns={
			@JoinColumn(name="i_m_mitarbeiter")
			}
		, inverseJoinColumns={
			@JoinColumn(name="i_st_stelle")
			}
		)
	private List<StStellen> stStellens;

	//bi-directional many-to-one association to AAbteilungen
	@ManyToOne
	@JoinColumn(name="m_a_abteilung", nullable=true)
	private AAbteilungen AAbteilungen;

	//bi-directional many-to-one association to TmTelmitarbeiter
	@OneToMany(mappedBy="MMitarbeiter")
	private List<TmTelmitarbeiter> tmTelmitarbeiters;

	public MMitarbeiter() {
	}

	public int getM_ID() {
		return this.m_ID;
	}

	public void setM_ID(int m_ID) {
		this.m_ID = m_ID;
	}

	public Date getM_gebDatum() {
		return this.m_gebDatum;
	}

	public void setM_gebDatum(Date m_gebDatum) {
		this.m_gebDatum = m_gebDatum;
	}

	public float getMGehalt() {
		return this.mGehalt;
	}

	public void setMGehalt(float mGehalt) {
		this.mGehalt = mGehalt;
	}

	public String getMHausnummer() {
		return this.mHausnummer;
	}

	public void setMHausnummer(String mHausnummer) {
		this.mHausnummer = mHausnummer;
	}

	public String getMNachname() {
		return this.mNachname;
	}

	public void setMNachname(String mNachname) {
		this.mNachname = mNachname;
	}

	public String getMOrt() {
		return this.mOrt;
	}

	public void setMOrt(String mOrt) {
		this.mOrt = mOrt;
	}

	public String getMPlz() {
		return this.mPlz;
	}

	public void setMPlz(String mPlz) {
		this.mPlz = mPlz;
	}

	public String getMStrasse() {
		return this.mStrasse;
	}

	public void setMStrasse(String mStrasse) {
		this.mStrasse = mStrasse;
	}

	public String getMVorname() {
		return this.mVorname;
	}

	public void setMVorname(String mVorname) {
		this.mVorname = mVorname;
	}

	public List<BBestellungen> getBBestellungens() {
		return this.BBestellungens;
	}

	public void setBBestellungens(List<BBestellungen> BBestellungens) {
		this.BBestellungens = BBestellungens;
	}

	public BBestellungen addBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().add(BBestellungen);
		BBestellungen.setMMitarbeiter(this);

		return BBestellungen;
	}

	public BBestellungen removeBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().remove(BBestellungen);
		BBestellungen.setMMitarbeiter(null);

		return BBestellungen;
	}

	public List<EmEmailmitarbeiter> getEmEmailmitarbeiters() {
		return this.emEmailmitarbeiters;
	}

	public void setEmEmailmitarbeiters(List<EmEmailmitarbeiter> emEmailmitarbeiters) {
		this.emEmailmitarbeiters = emEmailmitarbeiters;
	}

	public EmEmailmitarbeiter addEmEmailmitarbeiter(EmEmailmitarbeiter emEmailmitarbeiter) {
		getEmEmailmitarbeiters().add(emEmailmitarbeiter);
		emEmailmitarbeiter.setMMitarbeiter(this);

		return emEmailmitarbeiter;
	}

	public EmEmailmitarbeiter removeEmEmailmitarbeiter(EmEmailmitarbeiter emEmailmitarbeiter) {
		getEmEmailmitarbeiters().remove(emEmailmitarbeiter);
		emEmailmitarbeiter.setMMitarbeiter(null);

		return emEmailmitarbeiter;
	}

	public List<StStellen> getStStellens() {
		return this.stStellens;
	}

	public void setStStellens(List<StStellen> stStellens) {
		this.stStellens = stStellens;
	}

	public AAbteilungen getAAbteilungen() {
		return this.AAbteilungen;
	}

	public void setAAbteilungen(AAbteilungen AAbteilungen) {
		this.AAbteilungen = AAbteilungen;
	}

	public List<TmTelmitarbeiter> getTmTelmitarbeiters() {
		return this.tmTelmitarbeiters;
	}

	public void setTmTelmitarbeiters(List<TmTelmitarbeiter> tmTelmitarbeiters) {
		this.tmTelmitarbeiters = tmTelmitarbeiters;
	}

	public TmTelmitarbeiter addTmTelmitarbeiter(TmTelmitarbeiter tmTelmitarbeiter) {
		getTmTelmitarbeiters().add(tmTelmitarbeiter);
		tmTelmitarbeiter.setMMitarbeiter(this);

		return tmTelmitarbeiter;
	}

	public TmTelmitarbeiter removeTmTelmitarbeiter(TmTelmitarbeiter tmTelmitarbeiter) {
		getTmTelmitarbeiters().remove(tmTelmitarbeiter);
		tmTelmitarbeiter.setMMitarbeiter(null);

		return tmTelmitarbeiter;
	}

	@Override
	public String toString() {
		return "MMitarbeiter [m_ID=" + m_ID + ", m_gebDatum=" + m_gebDatum
				+ ", mGehalt=" + mGehalt + ", mHausnummer=" + mHausnummer
				+ ", mNachname=" + mNachname + ", mOrt=" + mOrt + ", mPlz="
				+ mPlz + ", mStrasse=" + mStrasse + ", mVorname=" + mVorname
				+ ", BBestellungens=" + BBestellungens
				+ ", emEmailmitarbeiters=" + emEmailmitarbeiters
				+ ", stStellens=" + stStellens + ", AAbteilungen="
				+ AAbteilungen + ", tmTelmitarbeiters=" + tmTelmitarbeiters
				+ "]";
	}

}