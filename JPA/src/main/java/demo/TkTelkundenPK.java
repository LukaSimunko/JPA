package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tk_telkunden database table.
 * 
 */
@Embeddable
public class TkTelkundenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tk_k_kunde", insertable=false, updatable=false)
	private int tkKKunde;

	private String t_telefonNr;

	public TkTelkundenPK() {
	}
	public int getTkKKunde() {
		return this.tkKKunde;
	}
	public void setTkKKunde(int tkKKunde) {
		this.tkKKunde = tkKKunde;
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
		if (!(other instanceof TkTelkundenPK)) {
			return false;
		}
		TkTelkundenPK castOther = (TkTelkundenPK)other;
		return 
			(this.tkKKunde == castOther.tkKKunde)
			&& this.t_telefonNr.equals(castOther.t_telefonNr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tkKKunde;
		hash = hash * prime + this.t_telefonNr.hashCode();
		
		return hash;
	}
}