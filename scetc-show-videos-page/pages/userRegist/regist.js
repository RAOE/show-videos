const app = getApp()

Page({
  data: {

  },
  doRegist: function(e) {
    var formObject = e.detail.value;
    var username = formObject.username;
    var password = formObject.password;
    //简单验证
    if (username.length == 0 || password.length == 0) { //反馈数据
      wx.showToast({
        title: '用户名或者密码不能为空',
        icon: 'none', //图标
        duration: 3000
      })
    } else {
      var serverUrl = app.serverUrl;
      wx.showLoading({
        title: '请等待...',
      })
      wx.request({
        url: serverUrl + '/regist',
        method: "POST",
        data: {
          username: username,
          password: password
        },
        header: {
          'content-type': 'application/json' //默认值
        },
        //回调函数 
        success: function(res) {
          var status = res.data.status;
          wx.hideLoading();

          if (status == 200) {
            wx.showToast({
              title: '注册成功啦~~',
              icon: 'none',
              duration: 3000
            })
            app.setGlobalUserInfo(res.data.data);
            //页面跳转
            wx.navigateTo({
              url: '../userLogin/login',
            })


          } else if (status = 500) {
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 3000
            })
          }
        }
      })
    }
  },
  goLoginPage: function() {
    wx.navigateTo({
      url: '../userLogin/login',
    })
  }
})