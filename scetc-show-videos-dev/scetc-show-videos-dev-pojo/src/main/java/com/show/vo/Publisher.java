package com.show.vo;

public class Publisher {
  
   public UsersVo pulisher;
   public boolean userLikeVideo;
public UsersVo getPulisher() {
	return pulisher;
}
public void setPulisher(UsersVo pulisher) {
	this.pulisher = pulisher;
}
public boolean isUserLikeVideo() {
	return userLikeVideo;
}
public void setUserLikeVideo(boolean userLikeVideo) {
	this.userLikeVideo = userLikeVideo;
}
@Override
public String toString() {
	return "Publisher [pulisher=" + pulisher + ", userLikeVideo=" + userLikeVideo + "]";
}
    
    
}