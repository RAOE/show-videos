const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    duration : '',
    tmpheight : '',
    tmpwidth : '',
    tmpVideoUrl : '',
    tmpCoverUrl : '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  //用户点击编辑视频
  submitClick: function () {
    var duration=this.data.duration;
    var tmpheight=this.data.tmpheight;
    var tmpwidth = this.data.tmpwidth;
    var tmpVideoUrl = this.data.tmpVideoUrl
    var tmpCoverUrl = this.data.tmpCoverUrl;
    if (duration == '' || duration == undefined || tmpheight == '' || tmpheight==undefined||tmpwidth==''||tmpwidth==undefined
    ||tmpVideoUrl==''||tmpVideoUrl==undefined)
    {
         wx.showToast({
           title: '请选择视频',
         })
         return false;
    }
    var user = app.getGlobalUserInfo();
    if(user==undefined||user==''||user==null)
    {
      wx.redirectTo({
        url: '../userLogin/login'
      })
    }
    wx.navigateTo({
      url: '../chooseBgm/chooseBgm?duration='
        + duration + '&tmpHeight=' + tmpheight + '&tmpWidth=' + tmpwidth
        + '&tmpVideoUrl=' + tmpVideoUrl + '&tmpCoverUrl=' + tmpCoverUrl
    })

  },
  deleteVideo: function () {
    var tmpVideoUrl = '';
    this.setData(
      {
        tmpVideoUrl: tmpVideoUrl
      })

  },
  //上传短视频js
  uploadVideo: function () {
    var that = this
    wx.chooseVideo({
      sourceType: ['album'],
      success: function (res) {
        var duration = res.duration;
        var tmpheight = res.height;
        var tmpwidth = res.width;
        var tmpVideoUrl = res.tempFilePath;
        var tmpCoverUrl = res.thumbTempFilePath;
        if (duration > 30) {
          wx.showToast({
            title: '视频长度不能超过30秒',
            icon: "none",
            duration: 2500
          })
        }
        else if (duration < 2) {
          wx.showToast({
            title: '视频长度太短',
            icon: "icon",
            duration: 2500
          })
        }
        else {
          var videos = res.tempFilePath;
          that.setData(
            {
              duration : duration,
              tmpheight : tmpheight,
              tmpwidth : tmpwidth,
              tmpVideoUrl : tmpVideoUrl,       
              tmpCoverUrl: tmpCoverUrl
            }
          )
        }
      }
    })
  }


})