function uploadVideos() {
  var that = this
  wx.chooseVideo({
    sourceType: ['album'],
    success: function (res) {

      var duration = res.duration;
      var tmpheight = res.height;
      var tmpwidth = res.width;
      var tmpVideoUrl = res.tempFilePath;
      var tmpCoverUrl = res.thumbTempFilePath;

      if (duration > 300) {
        wx.showToast({
          title: '视频长度不能超过300秒',
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
        //打开选择bgm页面
        //上传视频选择验证通过之后 跳转到选择bgm页面 
        wx.navigateTo({
          url: '../chooseBgm/chooseBgm?duration='
            + duration + '&tmpHeight=' + tmpheight + '&tmpWidth=' + tmpwidth
            + '&tmpVideoUrl=' + tmpVideoUrl + '&tmpCoverUrl=' + tmpCoverUrl


        })

      }
    }
  })

}

module.exports =
  {
    uploadVideos: uploadVideos
  }