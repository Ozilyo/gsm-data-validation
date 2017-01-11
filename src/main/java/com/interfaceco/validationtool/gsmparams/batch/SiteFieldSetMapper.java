package com.interfaceco.validationtool.gsmparams.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.interfaceco.validationtool.gsmparams.model.Site;

@Component
public class SiteFieldSetMapper implements FieldSetMapper<Site>{

	@Override
	public Site mapFieldSet(FieldSet fs) throws BindException {
		
		
		Site site = new Site();
		
//		Ref, Region, RNC_ID, NodeB_ID, unknown,NODEBNAME, LOCELL, CELLNAME, Carrier, CFG, Activity_State, Vendor, Latitude, Longitude, PSC, 
//		Azimuth, M_Tilt, E_Tilt, Antenna_height, LAC, SAC, RAC, UL_CE, DL_CE, HS-PDSCH_Code,UlFreq, DlFreq, TnlBearerType, IUB_bandwidth, MaxPower, 
//		HSDPA_OpState, HSUPA_OpState, HSPA_plus, Hardware_Type, comments, Radius, Beam
		site.setSiteId(fs.readString("NodeB_ID").isEmpty()? null : fs.readInt("NodeB_ID"));
		site.setAddress(fs.readString("Region"));
		site.setLongitude(fs.readString("Longitude").isEmpty()? null : fs.readFloat("Longitude"));
		site.setLatitude(fs.readString("Latitude").isEmpty()? null : fs.readFloat("Latitude"));
		site.setSiteName(fs.readString("NODEBNAME"));
		
		return site;
	}

}
