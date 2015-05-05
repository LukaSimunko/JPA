package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ts_telstandorte database table.
 * 
 */
@Embeddable
public class TsTelstandortePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ts_s_standort", insertable=false, updatable=false)
	private int tsSStandort;

	private String t_telefonNr;

	public TsTelstandortePK() {
	}
	public int getTsSStandort() {
		return this.tsSStandort;
	}
	public void setTsSStandort(int tsSStandort) {
		this.tsSStandort = tsSStandort;
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
		if (!(other instanceof TsTelstandortePK)) {
			return false;
		}
		TsTelstandortePK castOther = (TsTelstandortePK)other;
		return 
			(this.tsSStandort == castOther.tsSStandort)
			&& this.t_telefonNr.equals(castOther.t_telefonNr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tsSStandort;
		hash = hash * prime + this.t_telefonNr.hashCode();
		
		return hash;
	}
}