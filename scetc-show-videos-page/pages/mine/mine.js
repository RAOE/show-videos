const app = getApp()

Page({
  data: {
    faceUrl: "../resource/images/noneface.png",
    fansCounts: "",
    followCounts: "",
    videoList: [],
    receiveLikeCounts: "",
    nickname: "",
    isMe: true,
    isFollowed: false,
    serverUrl: "",
    publisherId: ""
  },
  onGotUserInfo: function (e) {

  },
  onShow: function () {
    var me = this;
    var serverUrl = app.serverUrl;
    var user = app.getGlobalUserInfo();
    var userId = user.id;
    var publisherId = app.globalData.publisherId;
    app.globalData.publisherId = null;
    if (user == null || user == undefined || user == '') {
      wx.redirectTo({
        url: '../userLogin/login',
      })
      return ;
    }
    me.setData(
      {
        isMe: true
      }
    )
    if (publisherId != null && publisherId != '' && publisherId != undefined && publisherId != userId) {
      userId = publisherId;
      me.setData(
        {
          isMe: false,
          publisherId: publisherId,
        }
      )
    }
    var that = this;
    var serverUrl = app.serverUrl;    wx.request({
      url: serverUrl + "/user/query?userId=" + userId,
      method: "post"
      ,
      header:
      {
        'content-type': 'application/json'//默认值
      },
      success: function (res) {
        var serverUrl = app.serverUrl;

        if (res.data.status == 200) {
          var userInfo = res.data.data;
          var faceUrl = "../resource/images/noneface.png";

          if (userInfo.faceImage != null && userInfo.faceImage != '' && userInfo.faceImage != undefined) {
            var faceUrl = serverUrl + userInfo.faceImage;
          }

          that.setData(
            {
              faceUrl: faceUrl,
              fansCounts: userInfo.fansCounts,
              followCounts: userInfo.followCounts,
              receiveLikeCounts: userInfo.receiveLikeCounts,
              nickname: userInfo.nickname,
            })

          //查询追随者
          wx.request({
            url: serverUrl + '/user/queryIsFollowed?userId=' + publisherId + "&fanId=" + user.id,
            method: 'post',
            success(res) {
              that.setData(
                {
                  isFollowed: res.data.data
                })
              //如果此时用户点击的其他人 则应该查询出他人的视频
              var userId = user.id;
              var isMe = me.data.isMe;
              if (isMe == false) {
                userId = publisherId;
              }
              //继续查询 查询自己发布的视频
              wx.request({
                url: serverUrl + '/video/queryVideosByUser?userId=' + userId,
                method: "post",
                success(res) {
                  //根据视频的id去查询
                  var videoList = res.data.data;
                  me.setData(
                    {
                      videoList: videoList,
                      serverUrl: app.serverUrl
                    }
                  )
                  //保存videoList对象
                  //遍历videoList对象并显示到页面上
                }
              })
            }
          })
        }
        else if (res.data.status == 500) {
          wx.showToast({
            title: '登陆失败' + res.data.msg,
            icon: "error"
          })
        }
      }
    })

  },
  //
  onLoad: function (params) {
    var me = this;
    var serverUrl = app.serverUrl;
    var user = app.getGlobalUserInfo();
    var userId = user.id;
    var publisherId = app.globalData.publisherId;
    app.globalData.publisherId = null;
    if (user == null || user == undefined || user == '') {
      wx.redirectTo({
        url: '../userLogin/login',
      })
      return ;
    }
    if (publisherId != null && publisherId != '' && publisherId != undefined && publisherId != userId) {
      userId = publisherId;
      me.setData(
        {
          isMe: false,
          publisherId: publisherId,
        }
      )
    }
    var that = this;
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + "/user/query?userId=" + userId,
      method: "post"
      ,
      header:
      {
        'content-type': 'application/json'//默认值
      },
      success: function (res) {
        var serverUrl = app.serverUrl;

        if (res.data.status == 200) {
          var userInfo = res.data.data;
          var faceUrl = "../resource/images/noneface.png";
          if (userInfo.faceImage != null && userInfo.faceImage != '' && userInfo.faceImage != undefined) {
            var faceUrl = serverUrl + userInfo.faceImage;
          }
          that.setData(
            {
              faceUrl: faceUrl,
              fansCounts: userInfo.fansCounts,
              followCounts: userInfo.followCounts,
              receiveLikeCounts: userInfo.receiveLikeCounts,
              nickname: userInfo.nickname,
            })

          //查询追随者
          wx.request({
            url: serverUrl + '/user/queryIsFollowed?userId=' + publisherId + "&fanId=" + user.id,
            method: 'post',
            success(res) {
              that.setData(
                {
                  isFollowed: res.data.data
                })
              //如果此时用户点击的其他人 则应该查询出他人的视频
              var userId = user.id;
              var isMe = me.data.isMe;
              if (isMe == false) {
                userId = publisherId;
              }
              //继续查询 查询自己发布的视频
              wx.request({
                url: serverUrl + '/video/queryVideosByUser?userId=' + userId,
                method: "post",
                success(res) {
                  //根据视频的id去查询
                  var videoList = res.data.data;
                  me.setData(
                    {
                      videoList: videoList,
                      serverUrl: app.serverUrl
                    }
                  )
                  //保存videoList对象
                  //遍历videoList对象并显示到页面上
                }
              })
            }
          })
        }
        else if (res.data.status == 500) {
          wx.showToast({
            title: '登陆失败' + res.data.msg,
            icon: "error"
          })
        }
      }

    })
  },
  showVideoInfo: function (e) {
    var me = this;
    var videoList = me.data.videoList;
    var arrindex = e.target.dataset.arrindex;
    var videoInfo = JSON.stringify(videoList[arrindex]);//获取视频信息对象
    wx.navigateTo({
      url: '../videoInfo/videoInfo?videoInfo=' + videoInfo,
    })
  },

  followMe: function () {
    var user = app.getGlobalUserInfo();
    var publisherId = this.data.publisherId;
    var serverUrl = app.serverUrl;
    var fansCounts = this.data.fansCounts;
    var me = this;
    wx.request({
      url: serverUrl + 'user/userFollow?userId=' + publisherId + "&fanId=" + user.id,
      method: 'post',
      success: function (resp) {
        //更新
        me.setData(
          {
            isFollowed: true,
          }

        )
        var that = me;
        var serverUrl = app.serverUrl;
        wx.request({
          url: serverUrl + "/user/query?userId=" + publisherId,
          method: "post"
          ,
          header:
          {
            'content-type': 'application/json'//默认值
          },
          success: function (res) {
            if (res.data.status == 200) {
              var userInfo = res.data.data;
              var faceUrl = "../resource/images/noneface.png";
              if (userInfo.faceImage != null && userInfo.faceImage != '' && userInfo.faceImage != undefined) {
                var faceUrl = serverUrl + userInfo.faceImage;
              }

              that.setData(
                {
                  fansCounts: userInfo.fansCounts,
                  followCounts: userInfo.followCounts,
                  receiveLikeCounts: userInfo.receiveLikeCounts,
                })
            }
          }
        })
      }
    })
  },
  UnfollowMe: function () {
    var user = app.getGlobalUserInfo();
    var publisherId = this.data.publisherId;
    var serverUrl = app.serverUrl;
    var fansCounts = this.data.fansCounts;

    var me = this;
    wx.request({
      url: serverUrl + 'user/userUnFollow?userId=' + publisherId + "&fanId=" + user.id,
      method: 'post',
      success: function (resp) {
        //更新
        me.setData(
          {
            isFollowed: false,
          }
        )
        var that = me;
        var serverUrl = app.serverUrl;
        wx.request({
          url: serverUrl + "/user/query?userId=" + publisherId,
          method: "post"
          ,
          header:
          {
            'content-type': 'application/json'//默认值
          },
          success: function (res) {
            if (res.data.status == 200) {
              var userInfo = res.data.data;
              var faceUrl = "../resource/images/noneface.png";
              if (userInfo.faceImage != null && userInfo.faceImage != '' && userInfo.faceImage != undefined) {
                var faceUrl = serverUrl + userInfo.faceImage;
              }

              that.setData(
                {
                  fansCounts: userInfo.fansCounts,
                  followCounts: userInfo.followCounts,
                  receiveLikeCounts: userInfo.receiveLikeCounts,
                })
            }
          }
        })

      }

    })
  },
  changeFace: function () {
    var isMe = this.data.isMe;
    if (!isMe) {
      return;
    }
    var that = this;
    wx.showLoading({
      title: '请等待...',
      icon: 'none'
    }),
      wx.chooseImage({
        count: 1, // 默认9
        sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
        success: function (res) {
          // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
          var tempFilePaths = res.tempFilePaths //獲得一個數組 console 長度為1的數組
          var serverUrl = app.serverUrl;
          var user = app.getGlobalUserInfo();
          wx.uploadFile({
            url: serverUrl + "/user/uploadFace?userId=" + user.id, //真实的接口地址
            filePath: tempFilePaths[0],
            name: 'file',
            header:
            {
              'content-type': 'application/json'//默认值
            },
            success: function (res) {
              var data = JSON.parse(res.data);
              wx.hideLoading();
              if (data.status == 200) {
                wx.showToast({
                  title: '上传成功!~',
                  icon: "success" //图标
                })
                var imageUrl = data.data.faceImage;
                that.setData(
                  {
                    faceUrl: serverUrl + imageUrl
                  }
                );

              }
              else if (data.status == 500) {

                wx.showToast({
                  title: '上传失败' + data.msg,
                  icon: "error"
                })
              }
            }
          })

        }
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
        console.log(duration);
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

  },
  //注销清空缓存
  logout: function (params) {
    var user = app.getGlobalUserInfo;
    var serverUrl = app.serverUrl;

    wx.showLoading({
      title: '请等待...',
    })
    wx.request({
      url: serverUrl + '/logout?userId=' + user.id,
      method: "POST",
      header:
      {
        'content-type': 'application/json'//默认值
      },
      success: function (res) {


        var status = res.data.status;
        if (status == 200) {
          //注销成功
          app.userInfo = null;
          //如果访问量大的情况下页面会转圈
          wx.hideLoading();
          wx.redirectTo({
            url: '../userLogin/login',
            icon: 'success',
            duration: 2000
          })
          wx.removeStorageSync("userInfo");
          wx.redirectTo({
            url: '../userLogin/login',
          })
        }

        else if (status == 500) {
          //登陆失败弹出窗口
          wx.showToast({
            title: res.data.msg,
            icon: 'none',
            duration: 3000
          })
        }
      }
    })
  }



})
