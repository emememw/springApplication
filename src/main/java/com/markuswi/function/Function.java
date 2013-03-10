package com.markuswi.function;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.markuswi.rolefunction.RoleFunction;

@Entity
@Table
public class Function {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;
	
	@Column
	private boolean readableByDefault;
	
	@Column
	private boolean readableEditable = true;
	
	@Column
	private boolean writeableByDefault;
	
	@Column
	private boolean writeableEditable = true;
	
	@Column
	private boolean deleteableByDefault;
	
	@Column
	private boolean deleteableEditable = true;
	
	@Column
	private boolean deactivateableByDefault;
	
	@Column
	private boolean deactivateableEditable = true;

	@OneToMany(mappedBy = "function", orphanRemoval = true)
	private List<RoleFunction> roleFunctions = new LinkedList<RoleFunction>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isReadableByDefault() {
		return readableByDefault;
	}

	public void setReadableByDefault(boolean readableByDefault) {
		this.readableByDefault = readableByDefault;
	}

	public boolean isReadableEditable() {
		return readableEditable;
	}

	public void setReadableEditable(boolean readableEditable) {
		this.readableEditable = readableEditable;
	}

	public boolean isWriteableByDefault() {
		return writeableByDefault;
	}

	public void setWriteableByDefault(boolean writeableByDefault) {
		this.writeableByDefault = writeableByDefault;
	}

	public boolean isWriteableEditable() {
		return writeableEditable;
	}

	public void setWriteableEditable(boolean writeableEditable) {
		this.writeableEditable = writeableEditable;
	}

	public boolean isDeleteableByDefault() {
		return deleteableByDefault;
	}

	public void setDeleteableByDefault(boolean deleteableByDefault) {
		this.deleteableByDefault = deleteableByDefault;
	}

	public boolean isDeleteableEditable() {
		return deleteableEditable;
	}

	public void setDeleteableEditable(boolean deleteableEditable) {
		this.deleteableEditable = deleteableEditable;
	}

	public boolean isDeactivateableByDefault() {
		return deactivateableByDefault;
	}

	public void setDeactivateableByDefault(boolean deactivateableByDefault) {
		this.deactivateableByDefault = deactivateableByDefault;
	}

	public boolean isDeactivateableEditable() {
		return deactivateableEditable;
	}

	public void setDeactivateableEditable(boolean deactivateableEditable) {
		this.deactivateableEditable = deactivateableEditable;
	}

	public List<RoleFunction> getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(List<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	
	
	
}
