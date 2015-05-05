package demo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the es_emailstandorte database table.
 * 
 */
@Embeddable
public class EsEmailstandortePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="es_s_standort", insertable=false, updatable=false)
	private int esSStandort;

	@Column(name="e_email")
	private String eEmail;

	public EsEmailstandortePK() {
	}
	public int getEsSStandort() {
		return this.esSStandort;
	}
	public void setEsSStandort(int esSStandort) {
		this.esSStandort = esSStandort;
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
		if (!(other instanceof EsEmailstandortePK)) {
			return false;
		}
		EsEmailstandortePK castOther = (EsEmailstandortePK)other;
		return 
			(this.esSStandort == castOther.esSStandort)
			&& this.eEmail.equals(castOther.eEmail);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.esSStandort;
		hash = hash * prime + this.eEmail.hashCode();
		
		return hash;
	}
}