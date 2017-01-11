package com.interfaceco.validationtool.gsmparams.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cell {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cellName;
	private Integer lac;
	@Id
	@Column(unique = true)
	private Integer cell_id;
	private Boolean activated;
	private Integer azimuth;
	private Boolean fixed_e_tilt;
	private Float e_tilt;
	private Float m_tilt;
	private Float antenna_height;
	private Integer feeder_length;
	private String feeder_type;
	private String antenna_model;
	
	private Long siteId;
	
	@ManyToOne
	@JoinColumn(name="node_id")
	private Site site;
	
	@Type(type="text")
	private String comments;
	
	@CreatedDate
	private Date date_created;
	
	@LastModifiedDate
	private Date last_modified;

	
	public Cell() {

	}

	
	

	@Override
	public String toString() {
		return "Cell [id=" + id + ", cellName=" + cellName + ", lac=" + lac + ", cell_id=" + cell_id + ", activated="
				+ activated + ", azimuth=" + azimuth + ", fixed_e_tilt=" + fixed_e_tilt + ", e_tilt=" + e_tilt
				+ ", m_tilt=" + m_tilt + ", antenna_height=" + antenna_height + ", feeder_length=" + feeder_length
				+ ", feeder_type=" + feeder_type + ", antenna_model=" + antenna_model + ", siteId=" + siteId + ", site="
				+ site + ", comments=" + comments + ", date_created=" + date_created + ", last_modified="
				+ last_modified + "]";
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activated == null) ? 0 : activated.hashCode());
		result = prime * result + ((antenna_height == null) ? 0 : antenna_height.hashCode());
		result = prime * result + ((antenna_model == null) ? 0 : antenna_model.hashCode());
		result = prime * result + ((azimuth == null) ? 0 : azimuth.hashCode());
		result = prime * result + ((cellName == null) ? 0 : cellName.hashCode());
		result = prime * result + ((cell_id == null) ? 0 : cell_id.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date_created == null) ? 0 : date_created.hashCode());
		result = prime * result + ((e_tilt == null) ? 0 : e_tilt.hashCode());
		result = prime * result + ((feeder_length == null) ? 0 : feeder_length.hashCode());
		result = prime * result + ((feeder_type == null) ? 0 : feeder_type.hashCode());
		result = prime * result + ((fixed_e_tilt == null) ? 0 : fixed_e_tilt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lac == null) ? 0 : lac.hashCode());
		result = prime * result + ((last_modified == null) ? 0 : last_modified.hashCode());
		result = prime * result + ((m_tilt == null) ? 0 : m_tilt.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
		return result;
	}
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (activated == null) {
			if (other.activated != null)
				return false;
		} else if (!activated.equals(other.activated))
			return false;
		if (antenna_height == null) {
			if (other.antenna_height != null)
				return false;
		} else if (!antenna_height.equals(other.antenna_height))
			return false;
		if (antenna_model == null) {
			if (other.antenna_model != null)
				return false;
		} else if (!antenna_model.equals(other.antenna_model))
			return false;
		if (azimuth == null) {
			if (other.azimuth != null)
				return false;
		} else if (!azimuth.equals(other.azimuth))
			return false;
		if (cellName == null) {
			if (other.cellName != null)
				return false;
		} else if (!cellName.equals(other.cellName))
			return false;
		if (cell_id == null) {
			if (other.cell_id != null)
				return false;
		} else if (!cell_id.equals(other.cell_id))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (date_created == null) {
			if (other.date_created != null)
				return false;
		} else if (!date_created.equals(other.date_created))
			return false;
		if (e_tilt == null) {
			if (other.e_tilt != null)
				return false;
		} else if (!e_tilt.equals(other.e_tilt))
			return false;
		if (feeder_length == null) {
			if (other.feeder_length != null)
				return false;
		} else if (!feeder_length.equals(other.feeder_length))
			return false;
		if (feeder_type == null) {
			if (other.feeder_type != null)
				return false;
		} else if (!feeder_type.equals(other.feeder_type))
			return false;
		if (fixed_e_tilt == null) {
			if (other.fixed_e_tilt != null)
				return false;
		} else if (!fixed_e_tilt.equals(other.fixed_e_tilt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lac == null) {
			if (other.lac != null)
				return false;
		} else if (!lac.equals(other.lac))
			return false;
		if (last_modified == null) {
			if (other.last_modified != null)
				return false;
		} else if (!last_modified.equals(other.last_modified))
			return false;
		if (m_tilt == null) {
			if (other.m_tilt != null)
				return false;
		} else if (!m_tilt.equals(other.m_tilt))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId))
			return false;
		return true;
	}

	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getLac() {
		return lac;
	}


	public void setLac(Integer lac) {
		this.lac = lac;
	}


	public Integer getCell_id() {
		return cell_id;
	}


	public void setCell_id(Integer cell_id) {
		this.cell_id = cell_id;
	}


	public Boolean getActivated() {
		return activated;
	}


	public void setActivated(Boolean activated) {
		this.activated = activated;
	}


	public Integer getAzimuth() {
		return azimuth;
	}


	public void setAzimuth(Integer azimuth) {
		this.azimuth = azimuth;
	}


	public Boolean getFixed_e_tilt() {
		return fixed_e_tilt;
	}


	public void setFixed_e_tilt(Boolean fixed_e_tilt) {
		this.fixed_e_tilt = fixed_e_tilt;
	}


	public Float getE_tilt() {
		return e_tilt;
	}


	public void setE_tilt(Float e_tilt) {
		this.e_tilt = e_tilt;
	}


	public Float getM_tilt() {
		return m_tilt;
	}


	public void setM_tilt(Float m_tilt) {
		this.m_tilt = m_tilt;
	}


	public Float getAntenna_height() {
		return antenna_height;
	}


	public void setAntenna_height(Float antenna_height) {
		this.antenna_height = antenna_height;
	}


	public Integer getFeeder_length() {
		return feeder_length;
	}


	public void setFeeder_length(Integer feeder_length) {
		this.feeder_length = feeder_length;
	}


	public String getFeeder_type() {
		return feeder_type;
	}


	public void setFeeder_type(String feeder_type) {
		this.feeder_type = feeder_type;
	}


	public String getAntenna_model() {
		return antenna_model;
	}


	public void setAntenna_model(String antenna_model) {
		this.antenna_model = antenna_model;
	}


	public Site getSite() {
		return site;
	}
	
	public void setSite(Site site) {
		this.site = site;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}


	public Date getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}




	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}




	public Long getSiteId() {
		return siteId;
	}




	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}



	
	
}
