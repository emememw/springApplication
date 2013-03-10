package com.markuswi.rolefunction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.markuswi.function.Function;
import com.markuswi.role.Role;

@Entity
@Table
public class RoleFunction {

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@ManyToOne
	private Role role;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Function function;
	
	@Column
	private boolean readable;
	
	@Column
	private boolean writeable;
	
	@Column
	private boolean deleteable;
	
	@Column
	private boolean deactivateable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public boolean isReadable() {
		return readable;
	}

	public void setReadable(boolean readable) {
		this.readable = readable;
	}

	public boolean isWriteable() {
		return writeable;
	}

	public void setWriteable(boolean writeable) {
		this.writeable = writeable;
	}

	public boolean isDeleteable() {
		return deleteable;
	}

	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}

	public boolean isDeactivateable() {
		return deactivateable;
	}

	public void setDeactivateable(boolean deactivateable) {
		this.deactivateable = deactivateable;
	}


}
