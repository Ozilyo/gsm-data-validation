package com.interfaceco.validationtool.gsmparams.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class DomainObject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Long Ref;
	private String Region;
	private String RNC_ID;
	private int NodeB_ID;
	private String UNKNOWN;
	private String NODEBNAME;
	private int LOCELL;
	private String CELLNAME;
	private String Carrier;
	private String CFG;
	private Boolean Activity_State;
	private String Vendor;
	private Double Latitude;
	private Double Longitude;
	private Integer PSC;
	private Integer Azimuth;
	private Double M_Tilt;
	private Double E_Tilt;
	private Double Antenna_height;
	private Integer LAC;
	private Integer SAC;
	private Integer RAC;
	private Integer UL_CE;
	private Integer DL_CE;
	private Integer HS_PDSCH_Code;
	private Integer UlFreq;
	private Integer DlFreq;
	private String TnlBearerType;
	private String IUB_bandwidth;
	private Integer MaxPower;
	private Boolean HSDPA_OpState;
	private Boolean HSUPA_OpState;
	private String HSPA_plus;
	private String Hardware_Type;
	@Type(type="text")
	private String comments;
	private Integer Radius;
	private Integer Beam;
	
	@LastModifiedDate
	private Date lastEdit;

	@CreatedDate
	private Date dateCreated;

	
	
	public DomainObject() {

	}


	@Override
	public String toString() {
		return "DomainObject [id=" + id + ", Ref=" + Ref + ", Region=" + Region + ", RNC_ID=" + RNC_ID + ", NodeB_ID="
				+ NodeB_ID + ", UNKNOWN=" + UNKNOWN + ", NODEBNAME=" + NODEBNAME + ", LOCELL=" + LOCELL + ", CELLNAME="
				+ CELLNAME + ", Carrier=" + Carrier + ", CFG=" + CFG + ", Activity_State=" + Activity_State
				+ ", Vendor=" + Vendor + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", PSC=" + PSC
				+ ", Azimuth=" + Azimuth + ", M_Tilt=" + M_Tilt + ", E_Tilt=" + E_Tilt + ", Antenna_hieght="
				+ Antenna_height + ", LAC=" + LAC + ", SAC=" + SAC + ", RAC=" + RAC + ", UL_CE=" + UL_CE + ", DL_CE="
				+ DL_CE + ", HS_PDSCH_Code=" + HS_PDSCH_Code + ", UlFreq=" + UlFreq + ", DlFreq=" + DlFreq
				+ ", TnlBearerType=" + TnlBearerType + ", IUB_bandwidth=" + IUB_bandwidth + ", MaxPower=" + MaxPower
				+ ", HSDPA_OpState=" + HSDPA_OpState + ", HSUPA_OpState=" + HSUPA_OpState + ", HSPA_plus=" + HSPA_plus
				+ ", Hardware_Type=" + Hardware_Type + ", comments=" + comments + ", Radius=" + Radius + ", Beam="
				+ Beam + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Activity_State == null) ? 0 : Activity_State.hashCode());
		result = prime * result + ((Antenna_height == null) ? 0 : Antenna_height.hashCode());
		result = prime * result + ((Azimuth == null) ? 0 : Azimuth.hashCode());
		result = prime * result + ((Beam == null) ? 0 : Beam.hashCode());
		result = prime * result + ((CELLNAME == null) ? 0 : CELLNAME.hashCode());
		result = prime * result + ((CFG == null) ? 0 : CFG.hashCode());
		result = prime * result + ((Carrier == null) ? 0 : Carrier.hashCode());
		result = prime * result + ((DL_CE == null) ? 0 : DL_CE.hashCode());
		result = prime * result + ((DlFreq == null) ? 0 : DlFreq.hashCode());
		result = prime * result + ((E_Tilt == null) ? 0 : E_Tilt.hashCode());
		result = prime * result + ((HSDPA_OpState == null) ? 0 : HSDPA_OpState.hashCode());
		result = prime * result + ((HSPA_plus == null) ? 0 : HSPA_plus.hashCode());
		result = prime * result + ((HSUPA_OpState == null) ? 0 : HSUPA_OpState.hashCode());
		result = prime * result + ((HS_PDSCH_Code == null) ? 0 : HS_PDSCH_Code.hashCode());
		result = prime * result + ((Hardware_Type == null) ? 0 : Hardware_Type.hashCode());
		result = prime * result + ((IUB_bandwidth == null) ? 0 : IUB_bandwidth.hashCode());
		result = prime * result + ((LAC == null) ? 0 : LAC.hashCode());
		result = prime * result + LOCELL;
		result = prime * result + ((Latitude == null) ? 0 : Latitude.hashCode());
		result = prime * result + ((Longitude == null) ? 0 : Longitude.hashCode());
		result = prime * result + ((M_Tilt == null) ? 0 : M_Tilt.hashCode());
		result = prime * result + ((MaxPower == null) ? 0 : MaxPower.hashCode());
		result = prime * result + ((NODEBNAME == null) ? 0 : NODEBNAME.hashCode());
		result = prime * result + NodeB_ID;
		result = prime * result + ((PSC == null) ? 0 : PSC.hashCode());
		result = prime * result + ((RAC == null) ? 0 : RAC.hashCode());
		result = prime * result + ((RNC_ID == null) ? 0 : RNC_ID.hashCode());
		result = prime * result + ((Radius == null) ? 0 : Radius.hashCode());
		result = prime * result + ((Ref == null) ? 0 : Ref.hashCode());
		result = prime * result + ((Region == null) ? 0 : Region.hashCode());
		result = prime * result + ((SAC == null) ? 0 : SAC.hashCode());
		result = prime * result + ((TnlBearerType == null) ? 0 : TnlBearerType.hashCode());
		result = prime * result + ((UL_CE == null) ? 0 : UL_CE.hashCode());
		result = prime * result + ((UNKNOWN == null) ? 0 : UNKNOWN.hashCode());
		result = prime * result + ((UlFreq == null) ? 0 : UlFreq.hashCode());
		result = prime * result + ((Vendor == null) ? 0 : Vendor.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + id;
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
		DomainObject other = (DomainObject) obj;
		if (Activity_State == null) {
			if (other.Activity_State != null)
				return false;
		} else if (!Activity_State.equals(other.Activity_State))
			return false;
		if (Antenna_height == null) {
			if (other.Antenna_height != null)
				return false;
		} else if (!Antenna_height.equals(other.Antenna_height))
			return false;
		if (Azimuth == null) {
			if (other.Azimuth != null)
				return false;
		} else if (!Azimuth.equals(other.Azimuth))
			return false;
		if (Beam == null) {
			if (other.Beam != null)
				return false;
		} else if (!Beam.equals(other.Beam))
			return false;
		if (CELLNAME == null) {
			if (other.CELLNAME != null)
				return false;
		} else if (!CELLNAME.equals(other.CELLNAME))
			return false;
		if (CFG == null) {
			if (other.CFG != null)
				return false;
		} else if (!CFG.equals(other.CFG))
			return false;
		if (Carrier == null) {
			if (other.Carrier != null)
				return false;
		} else if (!Carrier.equals(other.Carrier))
			return false;
		if (DL_CE == null) {
			if (other.DL_CE != null)
				return false;
		} else if (!DL_CE.equals(other.DL_CE))
			return false;
		if (DlFreq == null) {
			if (other.DlFreq != null)
				return false;
		} else if (!DlFreq.equals(other.DlFreq))
			return false;
		if (E_Tilt == null) {
			if (other.E_Tilt != null)
				return false;
		} else if (!E_Tilt.equals(other.E_Tilt))
			return false;
		if (HSDPA_OpState == null) {
			if (other.HSDPA_OpState != null)
				return false;
		} else if (!HSDPA_OpState.equals(other.HSDPA_OpState))
			return false;
		if (HSPA_plus == null) {
			if (other.HSPA_plus != null)
				return false;
		} else if (!HSPA_plus.equals(other.HSPA_plus))
			return false;
		if (HSUPA_OpState == null) {
			if (other.HSUPA_OpState != null)
				return false;
		} else if (!HSUPA_OpState.equals(other.HSUPA_OpState))
			return false;
		if (HS_PDSCH_Code == null) {
			if (other.HS_PDSCH_Code != null)
				return false;
		} else if (!HS_PDSCH_Code.equals(other.HS_PDSCH_Code))
			return false;
		if (Hardware_Type == null) {
			if (other.Hardware_Type != null)
				return false;
		} else if (!Hardware_Type.equals(other.Hardware_Type))
			return false;
		if (IUB_bandwidth == null) {
			if (other.IUB_bandwidth != null)
				return false;
		} else if (!IUB_bandwidth.equals(other.IUB_bandwidth))
			return false;
		if (LAC == null) {
			if (other.LAC != null)
				return false;
		} else if (!LAC.equals(other.LAC))
			return false;
		if (LOCELL != other.LOCELL)
			return false;
		if (Latitude == null) {
			if (other.Latitude != null)
				return false;
		} else if (!Latitude.equals(other.Latitude))
			return false;
		if (Longitude == null) {
			if (other.Longitude != null)
				return false;
		} else if (!Longitude.equals(other.Longitude))
			return false;
		if (M_Tilt == null) {
			if (other.M_Tilt != null)
				return false;
		} else if (!M_Tilt.equals(other.M_Tilt))
			return false;
		if (MaxPower == null) {
			if (other.MaxPower != null)
				return false;
		} else if (!MaxPower.equals(other.MaxPower))
			return false;
		if (NODEBNAME == null) {
			if (other.NODEBNAME != null)
				return false;
		} else if (!NODEBNAME.equals(other.NODEBNAME))
			return false;
		if (NodeB_ID != other.NodeB_ID)
			return false;
		if (PSC == null) {
			if (other.PSC != null)
				return false;
		} else if (!PSC.equals(other.PSC))
			return false;
		if (RAC == null) {
			if (other.RAC != null)
				return false;
		} else if (!RAC.equals(other.RAC))
			return false;
		if (RNC_ID == null) {
			if (other.RNC_ID != null)
				return false;
		} else if (!RNC_ID.equals(other.RNC_ID))
			return false;
		if (Radius == null) {
			if (other.Radius != null)
				return false;
		} else if (!Radius.equals(other.Radius))
			return false;
		if (Ref == null) {
			if (other.Ref != null)
				return false;
		} else if (!Ref.equals(other.Ref))
			return false;
		if (Region == null) {
			if (other.Region != null)
				return false;
		} else if (!Region.equals(other.Region))
			return false;
		if (SAC == null) {
			if (other.SAC != null)
				return false;
		} else if (!SAC.equals(other.SAC))
			return false;
		if (TnlBearerType == null) {
			if (other.TnlBearerType != null)
				return false;
		} else if (!TnlBearerType.equals(other.TnlBearerType))
			return false;
		if (UL_CE == null) {
			if (other.UL_CE != null)
				return false;
		} else if (!UL_CE.equals(other.UL_CE))
			return false;
		if (UNKNOWN == null) {
			if (other.UNKNOWN != null)
				return false;
		} else if (!UNKNOWN.equals(other.UNKNOWN))
			return false;
		if (UlFreq == null) {
			if (other.UlFreq != null)
				return false;
		} else if (!UlFreq.equals(other.UlFreq))
			return false;
		if (Vendor == null) {
			if (other.Vendor != null)
				return false;
		} else if (!Vendor.equals(other.Vendor))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getRef() {
		return Ref;
	}

	public void setRef(Long ref) {
		Ref = ref;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getRNC_ID() {
		return RNC_ID;
	}

	public void setRNC_ID(String rNC_ID) {
		RNC_ID = rNC_ID;
	}

	public int getNodeB_ID() {
		return NodeB_ID;
	}

	public void setNodeB_ID(int nodeB_ID) {
		NodeB_ID = nodeB_ID;
	}

	public String getUNKNOWN() {
		return UNKNOWN;
	}

	public void setUNKNOWN(String uNKNOWN) {
		UNKNOWN = uNKNOWN;
	}

	public String getNODEBNAME() {
		return NODEBNAME;
	}

	public void setNODEBNAME(String nODEBNAME) {
		NODEBNAME = nODEBNAME;
	}

	public int getLOCELL() {
		return LOCELL;
	}

	public void setLOCELL(int lOCELL) {
		LOCELL = lOCELL;
	}

	public String getCELLNAME() {
		return CELLNAME;
	}

	public void setCELLNAME(String cELLNAME) {
		CELLNAME = cELLNAME;
	}

	public String getCarrier() {
		return Carrier;
	}

	public void setCarrier(String carrier) {
		Carrier = carrier;
	}

	public String getCFG() {
		return CFG;
	}

	public void setCFG(String cFG) {
		CFG = cFG;
	}

	public Boolean getActivity_State() {
		return Activity_State;
	}

	public void setActivity_State(String activity_State) {
		if (activity_State == "ACTIVATED")
			this.Activity_State = true;
		else
			this.Activity_State = false;
	}	

	public String getVendor() {
		return Vendor;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Integer getPSC() {
		return PSC;
	}

	public void setPSC(Integer pSC) {
		PSC = pSC;
	}

	public Integer getAzimuth() {
		return Azimuth;
	}

	public void setAzimuth(Integer azimuth) {
		Azimuth = azimuth;
	}

	public Double getM_Tilt() {
		return M_Tilt;
	}

	public void setM_Tilt(Double m_Tilt) {
		M_Tilt = m_Tilt;
	}

	public Double getE_Tilt() {
		return E_Tilt;
	}

	public void setE_Tilt(Double e_Tilt) {
		E_Tilt = e_Tilt;
	}

	public Double getAntenna_hieght() {
		return Antenna_height;
	}

	public void setAntenna_hieght(Double antenna_hieght) {
		Antenna_height = antenna_hieght;
	}

	public Integer getLAC() {
		return LAC;
	}

	public void setLAC(Integer lAC) {
		LAC = lAC;
	}

	public Integer getSAC() {
		return SAC;
	}

	public void setSAC(Integer sAC) {
		SAC = sAC;
	}

	public Integer getRAC() {
		return RAC;
	}

	public void setRAC(Integer rAC) {
		RAC = rAC;
	}

	public Integer getUL_CE() {
		return UL_CE;
	}

	public void setUL_CE(Integer uL_CE) {
		UL_CE = uL_CE;
	}

	public Integer getDL_CE() {
		return DL_CE;
	}

	public void setDL_CE(Integer dL_CE) {
		DL_CE = dL_CE;
	}

	public Integer getHS_PDSCH_Code() {
		return HS_PDSCH_Code;
	}

	public void setHS_PDSCH_Code(Integer hS_PDSCH_Code) {
		HS_PDSCH_Code = hS_PDSCH_Code;
	}

	public Integer getUlFreq() {
		return UlFreq;
	}

	public void setUlFreq(Integer ulFreq) {
		UlFreq = ulFreq;
	}

	public Integer getDlFreq() {
		return DlFreq;
	}

	public void setDlFreq(Integer dlFreq) {
		DlFreq = dlFreq;
	}

	public String getTnlBearerType() {
		return TnlBearerType;
	}

	public void setTnlBearerType(String tnlBearerType) {
		TnlBearerType = tnlBearerType;
	}

	public String getIUB_bandwidth() {
		return IUB_bandwidth;
	}

	public void setIUB_bandwidth(String iUB_bandwidth) {
		IUB_bandwidth = iUB_bandwidth;
	}

	public Integer getMaxPower() {
		return MaxPower;
	}

	public void setMaxPower(Integer maxPower) {
		MaxPower = maxPower;
	}

	public Boolean getHSDPA_OpState() {
		return HSDPA_OpState;
	}

	public void setHSDPA_OpState(String hSDPA_OpState) {
		if (hSDPA_OpState == "ACTIVATED") 
			HSDPA_OpState = true;
		else
			HSDPA_OpState = false;
	}

	public Boolean getHSUPA_OpState() {
		return HSUPA_OpState;
	}

	public void setHSUPA_OpState(String hSUPA_OpState) {
		if (hSUPA_OpState == "ACTIVATED") 
			HSUPA_OpState = true; 
		else
			HSUPA_OpState = false;
	}

	public String getHSPA_plus() {
		return HSPA_plus;
	}

	public void setHSPA_plus(String hSPA_plus) {
		HSPA_plus = hSPA_plus;
	}

	public String getHardware_Type() {
		return Hardware_Type;
	}

	public void setHardware_Type(String hardware_Type) {
		Hardware_Type = hardware_Type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getRadius() {
		return Radius;
	}

	public void setRadius(Integer radius) {
		Radius = radius;
	}

	public Integer getBeam() {
		return Beam;
	}

	public void setBeam(Integer beam) {
		Beam = beam;
	}


	public Date getLastEdit() {
		return lastEdit;
	}


	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
