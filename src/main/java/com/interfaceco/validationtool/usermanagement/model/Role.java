package com.interfaceco.validationtool.usermanagement.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String roleName;
	
	@ManyToMany(mappedBy="roles")
	Collection<Account> account;
	

	@ManyToMany
    @JoinTable(
            name="roles_privileges", 
            joinColumns = @JoinColumn(name="role_id", referencedColumnName="id"), 
            inverseJoinColumns = @JoinColumn(name="privilege_id", referencedColumnName="id"))
	Collection<Privilege> privileges;
	
	public Role(){}
	
	public Role(String name){
		this.roleName = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int roleId) {
		this.id = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<Account> getUser() {
		return account;
	}

	public void setUser(Collection<Account> account) {
		this.account = account;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", account=" + account + ", privileges=" + privileges
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
		result = prime * result + id;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((account == null) ? 0 : account.hashCode());
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
		Role other = (Role) obj;
		if (privileges == null) {
			if (other.privileges != null)
				return false;
		} else if (!privileges.equals(other.privileges))
			return false;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}
	
	
}
