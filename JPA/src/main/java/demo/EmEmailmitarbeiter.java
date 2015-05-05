package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the em_emailmitarbeiter database table.
 * 
 */
@Entity
@Table(name="em_emailmitarbeiter")
@NamedQuery(name="EmEmailmitarbeiter.findAll", query="SELECT e FROM EmEmailmitarbeiter e")
public class EmEmailmitarbeiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmEmailmitarbeiterPK id;

	@Column(name="e_bemerkung")
	private String eBemerkung;

	//bi-directional many-to-one association to MMitarbeiter
	@ManyToOne
	@JoinColumn(name="em_m_mitarbeiter",insertable=false, updatable=false)
	private MMitarbeiter MMitarbeiter;

	public EmEmailmitarbeiter() {
	}

	public EmEmailmitarbeiterPK getId() {
		return this.id;
	}

	public void setId(EmEmailmitarbeiterPK id) {
		this.id = id;
	}

	public String getEBemerkung() {
		return this.eBemerkung;
	}

	public void setEBemerkung(String eBemerkung) {
		this.eBemerkung = eBemerkung;
	}

	public MMitarbeiter getMMitarbeiter() {
		return this.MMitarbeiter;
	}

	public void setMMitarbeiter(MMitarbeiter MMitarbeiter) {
		this.MMitarbeiter = MMitarbeiter;
	}

}