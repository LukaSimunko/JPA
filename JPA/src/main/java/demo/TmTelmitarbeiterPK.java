package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tm_telmitarbeiter database table.
 * 
 */
@Embeddable
public class TmTelmitarbeiterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tm_m_mitarbeiter", insertable=false, updatable=false)
	private int tmMMitarbeiter;

	private String t_telefonNr;

	public TmTelmitarbeiterPK() {
	}
	public int getTmMMitarbeiter() {
		return this.tmMMitarbeiter;
	}
	public void setTmMMitarbeiter(int tmMMitarbeiter) {
		this.tmMMitarbeiter = tmMMitarbeiter;
	}
	public String getT_telefonNr() {
		return this.t_telefonNr;
	}
	public void setT_telefonNr(String t_telefonNr) {
		this.t_telefonNr = t_telefonNr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TmTelmitarbeiterPK)) {
			return false;
		}
		TmTelmitarbeiterPK castOther = (TmTelmitarbeiterPK)other;
		return 
			(this.tmMMitarbeiter == castOther.tmMMitarbeiter)
			&& this.t_telefonNr.equals(castOther.t_telefonNr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tmMMitarbeiter;
		hash = hash * prime + this.t_telefonNr.hashCode();
		
		return hash;
	}
}