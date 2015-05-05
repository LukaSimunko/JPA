package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the em_emailmitarbeiter database table.
 * 
 */
@Embeddable
public class EmEmailmitarbeiterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="em_m_mitarbeiter", insertable=false, updatable=false)
	private int emMMitarbeiter;

	@Column(name="e_email")
	private String eEmail;

	public EmEmailmitarbeiterPK() {
	}
	public int getEmMMitarbeiter() {
		return this.emMMitarbeiter;
	}
	public void setEmMMitarbeiter(int emMMitarbeiter) {
		this.emMMitarbeiter = emMMitarbeiter;
	}
	public String getEEmail() {
		return this.eEmail;
	}
	public void setEEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmEmailmitarbeiterPK)) {
			return false;
		}
		EmEmailmitarbeiterPK castOther = (EmEmailmitarbeiterPK)other;
		return 
			(this.emMMitarbeiter == castOther.emMMitarbeiter)
			&& this.eEmail.equals(castOther.eEmail);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.emMMitarbeiter;
		hash = hash * prime + this.eEmail.hashCode();
		
		return hash;
	}
}