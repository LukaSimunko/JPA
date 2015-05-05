package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the l_lieferarten database table.
 * 
 */
@Entity
@Table(name="l_lieferarten")
@NamedQuery(name="LLieferarten.findAll", query="SELECT l FROM LLieferarten l")
public class LLieferarten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int l_ID;

	@Column(name="l_bezeichnung")
	private String lBezeichnung;

	//bi-directional many-to-one association to BBestellungen
	@OneToMany(mappedBy="LLieferarten")
	private List<BBestellungen> BBestellungens;

	public LLieferarten() {
	}

	public int getL_ID() {
		return this.l_ID;
	}

	public void setL_ID(int l_ID) {
		this.l_ID = l_ID;
	}

	public String getLBezeichnung() {
		return this.lBezeichnung;
	}

	public void setLBezeichnung(String lBezeichnung) {
		this.lBezeichnung = lBezeichnung;
	}

	public List<BBestellungen> getBBestellungens() {
		return this.BBestellungens;
	}

	public void setBBestellungens(List<BBestellungen> BBestellungens) {
		this.BBestellungens = BBestellungens;
	}

	public BBestellungen addBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().add(BBestellungen);
		BBestellungen.setLLieferarten(this);

		return BBestellungen;
	}

	public BBestellungen removeBBestellungen(BBestellungen BBestellungen) {
		getBBestellungens().remove(BBestellungen);
		BBestellungen.setLLieferarten(null);

		return BBestellungen;
	}

}