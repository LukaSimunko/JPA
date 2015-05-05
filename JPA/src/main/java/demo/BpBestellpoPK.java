package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bp_bestellpos database table.
 * 
 */
@Embeddable
public class BpBestellpoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int bp_b_ID;

	@Column(insertable=false, updatable=false)
	private int bp_p_ID;

	public BpBestellpoPK() {
	}
	public int getBp_b_ID() {
		return this.bp_b_ID;
	}
	public void setBp_b_ID(int bp_b_ID) {
		this.bp_b_ID = bp_b_ID;
	}
	public int getBp_p_ID() {
		return this.bp_p_ID;
	}
	public void setBp_p_ID(int bp_p_ID) {
		this.bp_p_ID = bp_p_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BpBestellpoPK)) {
			return false;
		}
		BpBestellpoPK castOther = (BpBestellpoPK)other;
		return 
			(this.bp_b_ID == castOther.bp_b_ID)
			&& (this.bp_p_ID == castOther.bp_p_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bp_b_ID;
		hash = hash * prime + this.bp_p_ID;
		
		return hash;
	}
}