package com.markuswi.role;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.markuswi.rolefunction.RoleFunction;

@Entity
@Table
public class Role {

	@Column
	@Id
	private String id;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<RoleFunction> roleFunctions = new LinkedList<RoleFunction>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RoleFunction> getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(List<RoleFunction> roleFunction) {
		this.roleFunctions = roleFunction;
	}
	
	
	
}
