package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tm_telmitarbeiter database table.
 * 
 */
@Entity
@Table(name="tm_telmitarbeiter")
@NamedQuery(name="TmTelmitarbeiter.findAll", query="SELECT t FROM TmTelmitarbeiter t")
public class TmTelmitarbeiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TmTelmitarbeiterPK id;

	@Column(name="t_bemerkung")
	private String tBemerkung;

	//bi-directional many-to-one association to MMitarbeiter
	@ManyToOne
	@JoinColumn(name="tm_m_mitarbeiter",insertable=false, updatable=false)
	private MMitarbeiter MMitarbeiter;

	public TmTelmitarbeiter() {
	}

	public TmTelmitarbeiterPK getId() {
		return this.id;
	}

	public void setId(TmTelmitarbeiterPK id) {
		this.id = id;
	}

	public String getTBemerkung() {
		return this.tBemerkung;
	}

	public void setTBemerkung(String tBemerkung) {
		this.tBemerkung = tBemerkung;
	}

	public MMitarbeiter getMMitarbeiter() {
		return this.MMitarbeiter;
	}

	public void setMMitarbeiter(MMitarbeiter MMitarbeiter) {
		this.MMitarbeiter = MMitarbeiter;
	}

}