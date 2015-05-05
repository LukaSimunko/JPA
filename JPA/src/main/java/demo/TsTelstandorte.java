package demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ts_telstandorte database table.
 * 
 */
@Entity
@Table(name="ts_telstandorte")
@NamedQuery(name="TsTelstandorte.findAll", query="SELECT t FROM TsTelstandorte t")
public class TsTelstandorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TsTelstandortePK id;

	@Column(name="t_bemerkung")
	private String tBemerkung;

	//bi-directional many-to-one association to SStandorte
	@ManyToOne
	@JoinColumn(name="ts_s_standort",insertable=false, updatable=false)
	private SStandorte SStandorte;

	public TsTelstandorte() {
	}

	public TsTelstandortePK getId() {
		return this.id;
	}

	public void setId(TsTelstandortePK id) {
		this.id = id;
	}

	public String getTBemerkung() {
		return this.tBemerkung;
	}

	public void setTBemerkung(String tBemerkung) {
		this.tBemerkung = tBemerkung;
	}

	public SStandorte getSStandorte() {
		return this.SStandorte;
	}

	public void setSStandorte(SStandorte SStandorte) {
		this.SStandorte = SStandorte;
	}

}