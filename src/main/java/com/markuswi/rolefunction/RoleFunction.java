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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
