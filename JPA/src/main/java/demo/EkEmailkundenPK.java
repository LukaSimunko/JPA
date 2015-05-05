package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ek_emailkunden database table.
 * 
 */
@Embeddable
public class EkEmailkundenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ek_k_kunde", insertable=false, updatable=false)
	private int ekKKunde;

	@Column(name="e_email")
	private String eEmail;

	public EkEmailkundenPK() {
	}
	public int getEkKKunde() {
		return this.ekKKunde;
	}
	public void setEkKKunde(int ekKKunde) {
		this.ekKKunde = ekKKunde;
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
		if (!(other instanceof EkEmailkundenPK)) {
			return false;
		}
		EkEmailkundenPK castOther = (EkEmailkundenPK)other;
		return 
			(this.ekKKunde == castOther.ekKKunde)
			&& this.eEmail.equals(castOther.eEmail);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ekKKunde;
		hash = hash * prime + this.eEmail.hashCode();
		
		return hash;
	}
}