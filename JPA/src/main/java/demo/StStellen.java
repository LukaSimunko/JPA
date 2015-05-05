package demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the st_stellen database table.
 * 
 */
@Entity
@Table(name="st_stellen")
@NamedQuery(name="StStellen.findAll", query="SELECT s FROM StStellen s")
public class StStellen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int st_ID;

	@Column(name="st_bezeichnung")
	private String stBezeichnung;

	//bi-directional many-to-many association to MMitarbeiter
	@ManyToMany(mappedBy="stStellens")
	private List<MMitarbeiter> MMitarbeiters;

	public StStellen() {
	}

	public int getSt_ID() {
		return this.st_ID;
	}

	public void setSt_ID(int st_ID) {
		this.st_ID = st_ID;
	}

	public String getStBezeichnung() {
		return this.stBezeichnung;
	}

	public void setStBezeichnung(String stBezeichnung) {
		this.stBezeichnung = stBezeichnung;
	}

	public List<MMitarbeiter> getMMitarbeiters() {
		return this.MMitarbeiters;
	}

	public void setMMitarbeiters(List<MMitarbeiter> MMitarbeiters) {
		this.MMitarbeiters = MMitarbeiters;
	}

}