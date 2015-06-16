package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the a_abteilungen database table.
 * 
 */
@Entity
@Table(name="a_abteilungen")
@NamedQuery(name="AAbteilungen.findAll", query="SELECT a FROM AAbteilungen a")
public class AAbteilungen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int a_ID;

	@Column(name="a_bezeichnung")
	private String aBezeichnung;

	//bi-directional many-to-many association to SStandorte
	@ManyToMany(mappedBy="AAbteilungens")
	private List<SStandorte> SStandortes;

	//bi-directional many-to-one association to MMitarbeiter
	@OneToMany(mappedBy="AAbteilungen")
	private List<MMitarbeiter> MMitarbeiters;

	public AAbteilungen() {
	}

	public int getA_ID() {
		return this.a_ID;
	}

	public void setA_ID(int a_ID) {
		this.a_ID = a_ID;
	}

	public String getABezeichnung() {
		return this.aBezeichnung;
	}

	public void setABezeichnung(String aBezeichnung) {
		this.aBezeichnung = aBezeichnung;
	}

	public List<SStandorte> getSStandortes() {
		return this.SStandortes;
	}

	public void setSStandortes(List<SStandorte> SStandortes) {
		this.SStandortes = SStandortes;
	}

	public List<MMitarbeiter> getMMitarbeiters() {
		return this.MMitarbeiters;
	}

	public void setMMitarbeiters(List<MMitarbeiter> MMitarbeiters) {
		this.MMitarbeiters = MMitarbeiters;
	}

	public MMitarbeiter addMMitarbeiter(MMitarbeiter MMitarbeiter) {
		getMMitarbeiters().add(MMitarbeiter);
		MMitarbeiter.setAAbteilungen(this);

		return MMitarbeiter;
	}

	public MMitarbeiter removeMMitarbeiter(MMitarbeiter MMitarbeiter) {
		getMMitarbeiters().remove(MMitarbeiter);
		MMitarbeiter.setAAbteilungen(null);

		return MMitarbeiter;
	}

	@Override
	public String toString() {
		return "AAbteilungen [a_ID=" + a_ID + ", aBezeichnung=" + aBezeichnung
				+"]";
	}

}