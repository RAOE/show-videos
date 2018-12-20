import { RESOURCE_PATH_RELATIVE_PAGE } from "../../common/path-config";
import * as Path from "../../utils/path";

const delayTime = 1 * 1000;
const NEXT_PAGE = Path.join("..", "userLogin", "login");
const VIDEO_URI = "http://119.23.73.70:8088/bootstrap.mp4";

let currentTime = 9;
let skipControl;

Page({
  /**
   * 页面的初始数据
   */
  data: {
    imagePath: Path.join(RESOURCE_PATH_RELATIVE_PAGE, "logo.png"),
    viewNum: currentTime,
    videoUri: VIDEO_URI,
    isViewShape: true,
    videoPlayDuration: currentTime
  },
  videoCtx: {},
  loadDone() {
    this.setData({
      isViewShape: false
    });
  },
  jump(e){
    clearInterval(skipControl);
    wx.redirectTo({
       url: '../userLogin/login',
     })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var me=this;
    var videoCtx = wx.createAudioContext('myAudio')
    skipControl = setInterval(
      () =>
        currentTime === 0
          ? clearInterval(skipControl) || wx.navigateTo({ url: NEXT_PAGE })
          : this.setData({
              viewNum: currentTime--
            }),
      delayTime
    );
  },
  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    var me=this;
    me.videoCtx.pause;
  }





});
