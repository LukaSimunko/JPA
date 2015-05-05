package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ma_mahnungsarten database table.
 * 
 */
@Entity
@Table(name="ma_mahnungsarten")
@NamedQuery(name="MaMahnungsarten.findAll", query="SELECT m FROM MaMahnungsarten m")
public class MaMahnungsarten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ma_ID;

	@Column(name="ma_bez")
	private String maBez;

	//bi-directional many-to-one association to MMahnungen
	@OneToMany(mappedBy="maMahnungsarten")
	private List<MMahnungen> MMahnungens;

	public MaMahnungsarten() {
	}

	public int getMa_ID() {
		return this.ma_ID;
	}

	public void setMa_ID(int ma_ID) {
		this.ma_ID = ma_ID;
	}

	public String getMaBez() {
		return this.maBez;
	}

	public void setMaBez(String maBez) {
		this.maBez = maBez;
	}

	public List<MMahnungen> getMMahnungens() {
		return this.MMahnungens;
	}

	public void setMMahnungens(List<MMahnungen> MMahnungens) {
		this.MMahnungens = MMahnungens;
	}

	public MMahnungen addMMahnungen(MMahnungen MMahnungen) {
		getMMahnungens().add(MMahnungen);
		MMahnungen.setMaMahnungsarten(this);

		return MMahnungen;
	}

	public MMahnungen removeMMahnungen(MMahnungen MMahnungen) {
		getMMahnungens().remove(MMahnungen);
		MMahnungen.setMaMahnungsarten(null);

		return MMahnungen;
	}

}