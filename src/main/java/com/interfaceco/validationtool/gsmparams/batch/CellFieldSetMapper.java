package com.interfaceco.validationtool.gsmparams.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.interfaceco.validationtool.gsmparams.model.Cell;

@Component
public class CellFieldSetMapper implements FieldSetMapper<Cell> {

	@Override
	public Cell mapFieldSet(FieldSet fs) throws BindException {
		
		Cell cell = new Cell();
		
		cell.setCell_id(fs.readString("SAC").isEmpty()? null : fs.readInt("SAC"));
		cell.setCellName(fs.readString("CELLNAME"));
		cell.setLac(fs.readString("LAC").isEmpty()? null : fs.readInt("LAC"));
		cell.setAzimuth(fs.readString("Azimuth").isEmpty()? null : fs.readInt("Azimuth"));
		cell.setE_tilt(fs.readString("E_Tilt").isEmpty()? null : fs.readFloat("E_Tilt"));
		cell.setM_tilt(fs.readString("M_Tilt").isEmpty()? null : fs.readFloat("M_Tilt"));
		cell.setAntenna_height(fs.readString("Antenna_height").isEmpty()? null : fs.readFloat("Antenna_height"));
//		cell.setFeeder_length(fs.readInt(""));
//		cell.setFeeder_type(fs.readString(""));
//		cell.setAntenna_model(fs.readString(""));
		cell.setSiteId(fs.readString("NodeB_ID").isEmpty()? null : fs.readLong("NodeB_ID"));
		
		return cell;
	}

}
