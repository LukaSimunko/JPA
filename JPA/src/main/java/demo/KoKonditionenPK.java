package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ko_konditionen database table.
 * 
 */
@Embeddable
public class KoKonditionenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ko_ID;

	@Column(insertable=false, updatable=false)
	private int ko_k_ID;

	public KoKonditionenPK() {
	}
	public int getKo_ID() {
		return this.ko_ID;
	}
	public void setKo_ID(int ko_ID) {
		this.ko_ID = ko_ID;
	}
	public int getKo_k_ID() {
		return this.ko_k_ID;
	}
	public void setKo_k_ID(int ko_k_ID) {
		this.ko_k_ID = ko_k_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KoKonditionenPK)) {
			return false;
		}
		KoKonditionenPK castOther = (KoKonditionenPK)other;
		return 
			(this.ko_ID == castOther.ko_ID)
			&& (this.ko_k_ID == castOther.ko_k_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ko_ID;
		hash = hash * prime + this.ko_k_ID;
		
		return hash;
	}
}