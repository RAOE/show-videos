package com.show.admin.scetc.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 定义管理员账户
 * 
 * @author Ray
 */
@Table(name = "adminusers")
public class AdminUser {

	@Id
	@Column(name = "Id")
	private Long id;
	@Column(name = "UserName")
	private String username;// 账号
	@Column(name = "RealName")
	private String realName;// 真实名称
	@Column(name = "Password")
	private String password;
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "Position")
	private String position;
	@Column(name = "Salt")
	private String salt;// 随机盐
	@Column(name = "Qq")
	private String qq;
	@Column(name = "Latitude")
	private Double latitude;
	@Column(name = "Longitude")
	private Double longitude;// 经度
	@Column(name = "registerDate")
	private Date registerDate;
	@Column(name = "updateDate")
	private Date updateDate;
	@Column(name = "loginIp")
	private String loginIp;// 登陆ip
	@Column(name = "userAgent")
	private String userAgent;// 用户代理
	@Column(name = "GeoHash")
	private Long GeoHash;// 用于经纬度
	@Column(name = "isDeleted")
	private Boolean isDeleted;// 软删除

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Long getGeoHash() {
		return GeoHash;
	}

	public void setGeoHash(Long geoHash) {
		GeoHash = geoHash;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", realName=" + realName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", position=" + position + ", salt=" + salt
				+ ", qq=" + qq + ", latitude=" + latitude + ", Longitude=" + longitude + ", registerDate="
				+ registerDate + ", updateDate=" + updateDate + ", loginIp=" + loginIp + ", userAgent=" + userAgent
				+ ", GeoHash=" + GeoHash + ", isDeleted=" + isDeleted + "]";
	}

}
