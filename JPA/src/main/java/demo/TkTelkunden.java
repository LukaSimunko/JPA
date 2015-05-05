package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tk_telkunden database table.
 * 
 */
@Entity
@Table(name="tk_telkunden")
@NamedQuery(name="TkTelkunden.findAll", query="SELECT t FROM TkTelkunden t")
public class TkTelkunden implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TkTelkundenPK id;

	@Column(name="t_bemerkung")
	private String tBemerkung;

	//bi-directional many-to-one association to KKunden
	@ManyToOne
	@JoinColumn(name="tk_k_kunde",insertable=false, updatable=false)
	private KKunden KKunden;

	public TkTelkunden() {
	}

	public TkTelkundenPK getId() {
		return this.id;
	}

	public void setId(TkTelkundenPK id) {
		this.id = id;
	}

	public String getTBemerkung() {
		return this.tBemerkung;
	}

	public void setTBemerkung(String tBemerkung) {
		this.tBemerkung = tBemerkung;
	}

	public KKunden getKKunden() {
		return this.KKunden;
	}

	public void setKKunden(KKunden KKunden) {
		this.KKunden = KKunden;
	}

}