package com.interfaceco.validationtool.actiontracker.revision;

import java.text.DateFormat;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevisionEntity extends DefaultRevisionEntity implements Comparable<UserRevisionEntity> {
	
	private String username;
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	
	@Override
	public String toString() {
		return "UserRevisionEntity [id = " + this.getId()
				+ ", revisionDate = " + DateFormat.getDateTimeInstance().format( getRevisionDate() ) + ", username = " + username + "]";
	}
	@Override
	public int compareTo(UserRevisionEntity compareEntity) {
		int compareEntId = compareEntity.getId();
		return compareEntId - this.getId();
	}
}
