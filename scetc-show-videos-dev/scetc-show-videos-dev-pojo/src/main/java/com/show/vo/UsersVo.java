package com.show.vo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="用户对象",description="这是用户对象")
public class UsersVo {
  
    @ApiModelProperty(hidden=true)
    private String id;
    @ApiModelProperty(value="用户名",name="username",example="imoocUser",required=true)
    private String username;
    @ApiModelProperty(value="密码",name="password",example="123456",required=true)
    @JsonIgnore
    private String password;
    @ApiModelProperty(hidden=true)
    private String faceImage;
    private String userToken;
    private String nickname;
    private Integer fansCounts;
    private Integer followCounts;
    private Integer receiveLikeCounts;
    
    
    
    public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	/**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return face_image
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * @param faceImage
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return fans_counts
     */
    public Integer getFansCounts() {
        return fansCounts;
    }

    /**
     * @param fansCounts
     */
    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * @return follow_counts
     */
    public Integer getFollowCounts() {
        return followCounts;
    }

    /**
     * @param followCounts
     */
    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    /**
     * @return receive_like_counts
     */
    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * @param receiveLikeCounts
     */
    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }
    public UsersVo() {
  		super();
  	}
      
      public UsersVo(String id, String username, String password, String faceImage, String nickname, Integer fansCounts,
  			Integer followCounts, Integer receiveLikeCounts) {
  		super();
  		this.id = id;
  		this.username = username;
  		this.password = password;
  		this.faceImage = faceImage;
  		this.nickname = nickname;
  		this.fansCounts = fansCounts;
  		this.followCounts = followCounts;
  		this.receiveLikeCounts = receiveLikeCounts;
  	}

	@Override
	public String toString() {
		return "UsersVo [id=" + id + ", username=" + username + ", password=" + password + ", faceImage=" + faceImage
				+ ", userToken=" + userToken + ", nickname=" + nickname + ", fansCounts=" + fansCounts
				+ ", followCounts=" + followCounts + ", receiveLikeCounts=" + receiveLikeCounts + "]";
	}
    
    
}