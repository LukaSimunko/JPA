package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ek_emailkunden database table.
 * 
 */
@Entity
@Table(name="ek_emailkunden")
@NamedQuery(name="EkEmailkunden.findAll", query="SELECT e FROM EkEmailkunden e")
public class EkEmailkunden implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EkEmailkundenPK id;

	@Column(name="e_bemerkung")
	private String eBemerkung;

	//bi-directional many-to-one association to KKunden
	@ManyToOne
	@JoinColumn(name="ek_k_kunde",insertable=false, updatable=false)
	private KKunden KKunden;

	public EkEmailkunden() {
	}

	public EkEmailkundenPK getId() {
		return this.id;
	}

	public void setId(EkEmailkundenPK id) {
		this.id = id;
	}

	public String getEBemerkung() {
		return this.eBemerkung;
	}

	public void setEBemerkung(String eBemerkung) {
		this.eBemerkung = eBemerkung;
	}

	public KKunden getKKunden() {
		return this.KKunden;
	}

	public void setKKunden(KKunden KKunden) {
		this.KKunden = KKunden;
	}

}