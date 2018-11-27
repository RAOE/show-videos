package com.show.admin.scetc.pojo;

import java.util.Date;

/**
 * 定义管理员账户
 * @author Ray
 */
public class AdminUser {

	private Long id;
	private String username;//账号
	private String realName;//真实名称
	private String password;
	private String phoneNumber;
	private String email;
	private String position;
	private String salt;//随机盐
    private String qq;
    private Double latitude;
    private Double Longitude;//经度
    private Date registerDate;
    private Date updateDate;
    private String loginIp;//登陆ip
    private String userAgent;//用户代理
    private Long GeoHash;//用于经纬度
	private Boolean isDeleted;//软删除
	
	
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
		return Longitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
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
				+ ", qq=" + qq + ", latitude=" + latitude + ", Longitude=" + Longitude + ", registerDate="
				+ registerDate + ", updateDate=" + updateDate + ", loginIp=" + loginIp + ", userAgent=" + userAgent
				+ ", GeoHash=" + GeoHash + ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
}
