const app = getApp()
Page({
  data: {
    focus: false,
    inputValue: '',
    content: "",
    title: "",
    errorMessage: "",
    isContentError: false,
    videoId: "",
    pubulisherId: ""
  },


  doReport:function(e) 
  {
    var formObject = e.detail.value;
    var reportTitle = formObject.reportTitle;
    var reportContent = formObject.reportContent;
    var serverUrl = app.serverUrl; //获取服务器地址
    var user = app.getGlobalUserInfo();
    var userId=user.id;
    var dealVideoId = this.data.videoId;//获取当前视频的id
    var dealUserId=this.data.pubulisherId;
    var title = reportTitle;
    var content = reportContent;

    let setErrorMessage = msg => {
      this.setData({
        errorMessage: msg
      })

      return true
    }

    (content === "" && setErrorMessage("没有内容输入")) || (title === "" && setErrorMessage("没有类型输入")) ? this.setData({
      isContentError: true
    }) :
      wx.showToast({
        title: '提交成功',
        icon: 'success',
      })
    wx.request({
      url: serverUrl + '/video/report?userId='+userId+"&dealUserId="+dealUserId+
        "&dealVideoId=" + dealVideoId + "&title=" + title+"&content="+content,
        method:"post",
        success(res){
           console.log(res);
        }
    
    })
    setTimeout(function () {
      wx.navigateBack({

      })
    }, 500)
  },
  cancel() {
    wx.navigateBack({

    })
  },

  bindReplaceInput: function (e) {
    var value = e.detail.value
    var pos = e.detail.cursor
    if (pos != -1) {
      //光标在中间
      var left = e.detail.value.slice(0, pos)
      //计算光标的位置
      pos = left.replace(/11/g, '2').length
    }

    //直接返回对象，可以对输入进行过滤处理，同时可以控制光标的位置
    return {
      value: value.replace(/11/g, '2'),
      cursor: pos
    }

    //或者直接返回字符串,光标在最后边
    //return value.replace(/11/g,'2'),
  },
  /*页面初始化
  */
  onLoad(param) {
    var videoId = param.videoId;
    var pubulisherId = param.pubulisherId;
    console.log(videoId);
    console.log(pubulisherId);
    this.setData(
      {
        videoId: videoId,
        pubulisherId: pubulisherId
      })
  }


})