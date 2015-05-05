package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ko_konditionen database table.
 * 
 */
@Entity
@Table(name="ko_konditionen")
@NamedQuery(name="KoKonditionen.findAll", query="SELECT k FROM KoKonditionen k")
public class KoKonditionen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KoKonditionenPK id;

	@Column(name="ko_bemerkung")
	private String koBemerkung;

	@Column(name="ko_kondition")
	private String koKondition;

	//bi-directional many-to-one association to KKunden
	@ManyToOne
	@JoinColumn(name="ko_k_ID",insertable=false, updatable=false)
	private KKunden KKunden;

	public KoKonditionen() {
	}

	public KoKonditionenPK getId() {
		return this.id;
	}

	public void setId(KoKonditionenPK id) {
		this.id = id;
	}

	public String getKoBemerkung() {
		return this.koBemerkung;
	}

	public void setKoBemerkung(String koBemerkung) {
		this.koBemerkung = koBemerkung;
	}

	public String getKoKondition() {
		return this.koKondition;
	}

	public void setKoKondition(String koKondition) {
		this.koKondition = koKondition;
	}

	public KKunden getKKunden() {
		return this.KKunden;
	}

	public void setKKunden(KKunden KKunden) {
		this.KKunden = KKunden;
	}

}