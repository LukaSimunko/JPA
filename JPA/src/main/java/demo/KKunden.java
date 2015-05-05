package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the k_kunden database table.
 * 
 */
@Entity
@Table(name="k_kunden")
@NamedQuery(name="KKunden.findAll", query="SELECT k FROM KKunden k")
public class KKunden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int k_ID;

	@Temporal(TemporalType.DATE)
	private Date k_gebDatum;

	@Column(name="k_hausnummer")
	private String kHausnummer;

	private byte k_istKunde;

	private byte k_istLieferant;

	@Column(name="k_nachname")
	private String kNachname;

	@Column(name="k_ort")
	private String kOrt;

	@Column(name="k_plz")
	private String kPlz;

	@Column(name="k_strasse")
	private String kStrasse;

	@Column(name="k_vorname")
	private String kVorname;

	//bi-directional many-to-one association to BBestellungen
	@OneToMany(mappedBy="KKunden")
	private List<BBestellungen> BBestellungens;

	//bi-directional many-to-one association to EkEmailkunden
	@OneToMany(mappedBy="KKunden")
	private List<EkEmailkunden> ekEmailkundens;

	//bi-directional many-to-one association to KoKonditionen
	@OneToMany(mappedBy="KKunden")
	private List<KoKonditionen> koKonditionens;

	//bi-directional many-to-one association to TkTelkunden
	@OneToMany(mappedBy="KKunden")
	private List<TkTelkunden> tkTelkundens;

	public KKunden() {
	}

	public int getK_ID() {
		return this.k_ID;
	}

	public void setK_ID(int k_ID) {
		this.k_ID = k_ID;
	}

	public Date getK_gebDatum() {
		return this.k_gebDatum;
	}

	public void setK_gebDatum(Date k_gebDatum) {
		this.k_gebDatum = k_gebDatum;
	}

	public String getKHausnummer() {
		return this.kHausnummer;
	}

	public void setKHausnummer(String kHausnummer) {
		this.kHausnummer = kHausnummer;
	}

	public byte getK_istKunde() {
		return this.k_istKunde;
	}

	public void setK_istKunde(byte k_istKunde) {
		this.k_istKunde = k_istKunde;
	}

	public byte getK_istLieferant() {
		return this.k_istLieferant;
	}

	public void setK_istLieferant(byte k_istLieferant) {
		this.k_istLieferant = k_istLieferant;
	}

	public String getKNachname() {
		return this.kNachname;
	}

	public void setKNachname(String kNachname) {
		this.kNachname = kNachname;
	}

	public String getKOrt() {
		return this.kOrt;
	}

	public void setKOrt(String kOrt) {
		this.kOrt = kOrt;
	}

	public String getKPlz() {
		return this.kPlz;
	}

	public void setKPlz(String kPlz) {
		this.kPlz = kPlz;
	}

	public String getKStrasse() {
		return this.kStrasse;
	}

	public void setKStrasse(String kStrasse) {
		this.kStrasse = kStrasse;
	}

	public String getKVorname() {
		return this.kVorname;
	}

	public void setKVorname(String kVorname) {
		this.kVorname = kVorname;
	}

	public List<BBestellungen> getBBestellungens() {
		return this.BBestellungens;
	}

	public void setBBestellungens(List<BBestellungen> BBestellungens) {
		this.BBestellungens = BBestellungens;
	}

	public BBestellungen addBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().add(BBestellungen);
		BBestellungen.setKKunden(this);

		return BBestellungen;
	}

	public BBestellungen removeBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().remove(BBestellungen);
		BBestellungen.setKKunden(null);

		return BBestellungen;
	}

	public List<EkEmailkunden> getEkEmailkundens() {
		return this.ekEmailkundens;
	}

	public void setEkEmailkundens(List<EkEmailkunden> ekEmailkundens) {
		this.ekEmailkundens = ekEmailkundens;
	}

	public EkEmailkunden addEkEmailkunden(EkEmailkunden ekEmailkunden) {
		getEkEmailkundens().add(ekEmailkunden);
		ekEmailkunden.setKKunden(this);

		return ekEmailkunden;
	}

	public EkEmailkunden removeEkEmailkunden(EkEmailkunden ekEmailkunden) {
		getEkEmailkundens().remove(ekEmailkunden);
		ekEmailkunden.setKKunden(null);

		return ekEmailkunden;
	}

	public List<KoKonditionen> getKoKonditionens() {
		return this.koKonditionens;
	}

	public void setKoKonditionens(List<KoKonditionen> koKonditionens) {
		this.koKonditionens = koKonditionens;
	}

	public KoKonditionen addKoKonditionen(KoKonditionen koKonditionen) {
		getKoKonditionens().add(koKonditionen);
		koKonditionen.setKKunden(this);

		return koKonditionen;
	}

	public KoKonditionen removeKoKonditionen(KoKonditionen koKonditionen) {
		getKoKonditionens().remove(koKonditionen);
		koKonditionen.setKKunden(null);

		return koKonditionen;
	}

	public List<TkTelkunden> getTkTelkundens() {
		return this.tkTelkundens;
	}

	public void setTkTelkundens(List<TkTelkunden> tkTelkundens) {
		this.tkTelkundens = tkTelkundens;
	}

	public TkTelkunden addTkTelkunden(TkTelkunden tkTelkunden) {
		getTkTelkundens().add(tkTelkunden);
		tkTelkunden.setKKunden(this);

		return tkTelkunden;
	}

	public TkTelkunden removeTkTelkunden(TkTelkunden tkTelkunden) {
		getTkTelkundens().remove(tkTelkunden);
		tkTelkunden.setKKunden(null);

		return tkTelkunden;
	}

}