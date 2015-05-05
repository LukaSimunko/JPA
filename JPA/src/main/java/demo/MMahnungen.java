package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the m_mahnungen database table.
 * 
 */
@Entity
@Table(name="m_mahnungen")
@NamedQuery(name="MMahnungen.findAll", query="SELECT m FROM MMahnungen m")
public class MMahnungen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MMahnungenPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="m_datum")
	private Date mDatum;

	//bi-directional many-to-one association to BBestellungen
	@ManyToOne
	@JoinColumn(name="m_b_ID",insertable=false, updatable=false)
	private BBestellungen BBestellungen;

	//bi-directional many-to-one association to MaMahnungsarten
	@ManyToOne
	@JoinColumn(name="m_ma_ID")
	private MaMahnungsarten maMahnungsarten;

	public MMahnungen() {
	}

	public MMahnungenPK getId() {
		return this.id;
	}

	public void setId(MMahnungenPK id) {
		this.id = id;
	}

	public Date getMDatum() {
		return this.mDatum;
	}

	public void setMDatum(Date mDatum) {
		this.mDatum = mDatum;
	}

	public BBestellungen getBBestellungen() {
		return this.BBestellungen;
	}

	public void setBBestellungen(BBestellungen BBestellungen) {
		this.BBestellungen = BBestellungen;
	}

	public MaMahnungsarten getMaMahnungsarten() {
		return this.maMahnungsarten;
	}

	public void setMaMahnungsarten(MaMahnungsarten maMahnungsarten) {
		this.maMahnungsarten = maMahnungsarten;
	}

}