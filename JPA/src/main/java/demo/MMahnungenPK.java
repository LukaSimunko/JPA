package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the m_mahnungen database table.
 * 
 */
@Embeddable
public class MMahnungenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int m_ID;

	@Column(insertable=false, updatable=false)
	private int m_b_ID;

	public MMahnungenPK() {
	}
	public int getM_ID() {
		return this.m_ID;
	}
	public void setM_ID(int m_ID) {
		this.m_ID = m_ID;
	}
	public int getM_b_ID() {
		return this.m_b_ID;
	}
	public void setM_b_ID(int m_b_ID) {
		this.m_b_ID = m_b_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MMahnungenPK)) {
			return false;
		}
		MMahnungenPK castOther = (MMahnungenPK)other;
		return 
			(this.m_ID == castOther.m_ID)
			&& (this.m_b_ID == castOther.m_b_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.m_ID;
		hash = hash * prime + this.m_b_ID;
		
		return hash;
	}
}