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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
public class Account {

	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private boolean enabled = true;
	
	Collection<Role> roles;

	
	public Account() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() { return id; }
	public void setId(long account) {
		this.id = account;
	}

	
	@NotNull
	@Column(unique=true)
	public String getUsername() { return username; }
	public void setUsername(String userName) {
		this.username = userName;
	}

	@NotNull
	@Size(min = 6, max = 70, message="{password.size}")
	public String getPassword() { return password; }
	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull
	@Length(min = 1, max = 40, message="{firstName.size}")
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Length(min = 1, max = 40, message="{lastName.size}")
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Transient
	public String getFullName() { return firstName + " " + lastName; }

	@NotNull(message="email field should not be empty}")
	@Email
	public String getEmail() { return email; }
	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@ManyToMany
	@JoinTable( 
			name = "accounts_roles", 
			joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	public Collection<Role> getRoles() { return roles; }
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", enabled=" + enabled + ", roles=" + roles + "]";
	}
	
	
	//TODO: to be implemented
//	public Object getMatchingPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
}
