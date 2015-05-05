package demo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the es_emailstandorte database table.
 * 
 */
@Entity
@Table(name="es_emailstandorte")
@NamedQuery(name="EsEmailstandorte.findAll", query="SELECT e FROM EsEmailstandorte e")
public class EsEmailstandorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EsEmailstandortePK id;

	@Column(name="e_bemerkung")
	private String eBemerkung;

	//bi-directional many-to-one association to SStandorte
	@ManyToOne
	
	@JoinColumn(name="es_s_standort", insertable=false, updatable=false)
	private SStandorte SStandorte;

	public EsEmailstandorte() {
	}

	public EsEmailstandortePK getId() {
		return this.id;
	}

	public void setId(EsEmailstandortePK id) {
		this.id = id;
	}

	public String getEBemerkung() {
		return this.eBemerkung;
	}

	public void setEBemerkung(String eBemerkung) {
		this.eBemerkung = eBemerkung;
	}

	public SStandorte getSStandorte() {
		return this.SStandorte;
	}

	public void setSStandorte(SStandorte SStandorte) {
		this.SStandorte = SStandorte;
	}

}