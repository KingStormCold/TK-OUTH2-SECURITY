package net.kuleasycode.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_entity")
public class UserEntity {

	@Id
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "enabled", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled = true;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userOauth")
	private List<RoleEntity> roleEntities;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}

	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}

	public UserEntity() {
	}

	public UserEntity(String userName, String password, String fullName, String email, String phone, Date createdDate,
			Date updatedDate, String createdBy, String updatedBy, boolean enabled) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.enabled = enabled;
	}

	public UserEntity(String userName, String password, String fullName, String email, String phone, Date createdDate,
			Date updatedDate, String createdBy, String updatedBy, boolean enabled, List<RoleEntity> roleEntities) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.enabled = enabled;
		this.roleEntities = roleEntities;
	}
	
}
