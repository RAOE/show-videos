const app = getApp()
Page({
  data: {
    realUrl: '',
    nickName: '',//用户的名称
    avatarUrl: '' //用户的头像

  },
  doLogin: function (e) {
    var me = this;
    //console.log(e.detail);
    var formObject = e.detail.value;
    var username = formObject.username;
    var password = formObject.password;

    //简单验证
    if (username.length == 0 || password.length == 0) {   //反馈数据
      wx.showToast({
        title: '小主,用户名和密码不能为空哦',
        icon: 'none',//图标
        duration: 3000
      })
    }
    else {
      var serverUrl = app.serverUrl;
      wx.showLoading({
        title: '请等待...',
      })
      wx.request({
        url: serverUrl + '/login',
        method: "POST",
        data: {
          username: username,
          password: password
        },
        header:
        {
          'content-type': 'application/json'//默认值
        },
        //回调函数 
        //返回
        success: function (res) {

          var status = res.data.status;
          if (status == 200) {
            //console.log(res.data.data);
            wx.hideLoading();
            wx.showToast({

              title: '小主,登陆成功啦',
              icon: 'none',
              duration: 3000
            })
            //获得微信的头像以及微信的账号

            //  app.userInfo = res.data.data;
            //fix 修改原有的全局对象为本地缓存
            console.log(res.data.data);

            console.log(me.avatarUrl);

            console.log(me.nickName);

            app.setGlobalUserInfo(res.data.data);
            var realUrl = me.data.realUrl;


            // console.log(app.userInfo.id);
            if (realUrl == '') {
              //跳转
              wx.redirectTo({
                url: '../mine/mine',
              })
            }
            else {
              console.log("realUrl:" + realUrl);
              wx.redirectTo({
                url: realUrl
              })
            }
          }


          else if (status == 500) {
            //失败 弹出框
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
  getUserInfo: function (e) {
    var me = this;
    var rawData = JSON.parse(e.detail.rawData);
    var nickName = rawData.nickName;
    var avatarUrl = rawData.avatarUrl;
  },
  goRegist: function () {
    wx.navigateTo({
      url: '../userRegist/regist',
    })
  },
  onLoad: function (e) {

    var me = this;
    var realUrl = e.realUrl;
    if (realUrl != null && realUrl != '' && realUrl != undefined) {

      realUrl = realUrl.replace('@', '?');
      realUrl = realUrl.replace('#', '=');
      console.log("value=" + realUrl);
      me.setData(
        {
          realUrl: realUrl
        }
      )

    }
    //  if(e!=null&&e!=undefined&&e!='')
    //  {

    //    var realUrl=e.realUrl;
    //    realUlr = realUrl.replace('@', '?');
    //    realUlr = realUrl.replace('#', '=')
    //    console.log("真实的上传路径" + realUrl);

    //    me.setData(
    //      {
    //        realUrl:e.realUrl
    //      }
    //    )
    //  }


  }
})