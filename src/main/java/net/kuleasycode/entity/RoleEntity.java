package net.kuleasycode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_entity")
public class RoleEntity {

	@Id
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "desciption")
	private String desciption;
	
	@Column(name = "user_name")
	private String userName;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name", insertable = false, nullable = false, updatable = false)
	private UserEntity userOauth;

	public String getDesciption() {
		return desciption;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserEntity getUserOauth() {
		return userOauth;
	}

	public void setUserOauth(UserEntity userOauth) {
		this.userOauth = userOauth;
	}

	public RoleEntity() {
	}

	public RoleEntity(String roleId, String desciption, String userName) {
		this.roleId = roleId;
		this.desciption = desciption;
		this.userName = userName;
	}

	public RoleEntity(String roleId, String desciption, String userName, UserEntity userOauth) {
		this.roleId = roleId;
		this.desciption = desciption;
		this.userName = userName;
		this.userOauth = userOauth;
	}

}
