var videoUtils = require('../../utils/videoUtils.js')
var util = require("../../utils/formateTime.js");

const app = getApp()


Page({
  /**
   * 页面的初始数据
   */
  data: {
    actionSheetHidden: true,
    cover: "cover",
    videoId: "",
    src: "",
    imagesrc: "",
    videoInfo: {},
    userLikeVideo: false,
    placeholder: "说点什么吧",
    CommentList: [],
    contentValue: "",
    itemList: [{
      name: "下载视频"
    }, {
      name: '举报用户'
    }],
  },
  videoCtx: {},

  /**
   * 生命周期函数--监听页面加载
   */
  // listenerButton: function () {
  //   this.setData({
  //     actionSheetHidden: !this.data.actionSheetHidden
  //   });
  // },
  // listenerActionSheet: function () {

  //   this.setData({
  //     actionSheetHidden: !this.data.actionSheetHidden,
  //   })
  // },
  // operate: function (params) {

  //   var me = this;
  //   //先判断用户是否 登陆如果没有登陆 则提醒用户进行登陆
  //   var user = app.getGlobalUserInfo();
  //   var videoInfo = me.data.videoInfo;
  //   var videoId = videoInfo.id;
  //   var videoInfo = JSON.stringify(me.data.videoInfo);
  //   var realUrl = '../videoInfo/videoInfo#videoInfo@' + videoInfo;
  //   var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
  //   if (user == null || user == '' || user == undefined) {
  //     wx.redirectTo({
  //       url: '../userLogin/login?realUrl=' + realUrl,
  //     })
  //   } else {
  //     var value = params;
  //     var videoInfo = this.data.videoInfo;
  //     var id = params.currentTarget.id;
  //      console.log("下载视频");
  //     if (id == 0) //下载视频
  //     {  
  //       // consol.log(videoInfo);
  //       // console.log('下载视频');
  //       // console.log(app.serverUrl + me.data.videoInfo.videoPath);
  //       // wx.showLoading({
  //       //   title: '下载中...',
  //       // })
  //       // wx.downloadFile({

  //       //   url: app.serverUrl + me.data.videoInfo.videoPath,
  //       //   success: function (res) {
  //       //     // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
  //       //     if (res.statusCode === 200) {

  //       //       wx.saveVideoToPhotosAlbum({
  //       //         filePath: res.tempFilePath,
  //       //         success: function (res) {
  //       //           wx.hideLoading();
  //       //         }
  //       //       })
  //       //     }
  //       //   }
  //       // })
  //     } else if (id == 1) //举报用户
  //     {
  //       wx.redirectTo({
  //         url: '../report/report?videoId=' + videoInfo.id + "&pubulisherId=" + videoInfo.userId,
  //       })

  //     }
  //   }
  // },
  onLoad: function (params) {
    var me = this;
    me.videoCtx = wx.createVideoContext('myVideo', me);
    var realUrlParam = app.globalData.realUrlParam;
    if (realUrlParam != '' && realUrlParam != null && realUrlParam != undefined) {
      videoInfo = JSON.parse(realUrlParam);
      app.globalData.realUrl = null;
      app.globalData.realUrlParam = null;
    } else {
      var videoInfo = JSON.parse(params.videoInfo);
    }
    //解决高和宽的问题
    //横屏和竖屏的问题。
    var height = videoInfo.videoHeight;
    var width = videoInfo.videoWidth;
    var cover = 'cover';
    if (width > height) {
      cover = '';
    }
    me.setData({
      videoId: videoInfo.id,
      src: app.serverUrl + videoInfo.videoPath,
      imagesrc: videoInfo.face_image,
      videoInfo: videoInfo,
      cover: cover,
    })
    var serverUrl = app.serverUrl;
    var loginUserId = '';
    var user = app.getGlobalUserInfo();
    if (user != null && user != undefined && user != '') {
      loginUserId = user.id;
    }
    wx.request({
      url: serverUrl + '/user/queryPublisher?loginUserId=' + user.id + '&videoId=' + videoInfo.id +
        '&publisherUserId=' + videoInfo.userId,
      method: 'post',
      success: function (res) {
        me.setData({
          userLikeVideo: res.data.data.userLikeVideo,
        })
      }
    })
    //查询视频id的 所有评论
    wx.request({
      url: serverUrl + '/video/queryCommentsByVideoId?videoId=' + videoInfo.id,
      method: 'post',
      success: function (resp) {
        var CommentList = resp.data.data;
        for (var i = 0; i < CommentList.length; i++) {
          CommentList[i]["createTime"] = util.formatDate(CommentList[i]["createTime"]);
        }
        //将获得的评论
        me.setData({
          CommentList: resp.data.data
        })

      }

    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  sendComment: function (e) {

    var me = this;
    var comment = e.detail.value;
    var serverUrl = app.serverUrl;
    var user = app.getGlobalUserInfo();
    var videoInfo = me.data.videoInfo;
    var videoId = videoInfo.id;
    var videoInfo = JSON.stringify(me.data.videoInfo);
    var realUrl = '../videoInfo/videoInfo#videoInfo@' + videoInfo;
    var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
    if (user == null || user == '' || user == undefined) {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      var videoInfo = this.data.videoInfo;
      var videoId = videoInfo.id;
      wx.request({
        url: serverUrl + 'video/saveComments?comment=' + comment + "&videoId=" + videoId + "&userId=" + user.id,
        method: 'post',
        success: function (resp) {
          wx.showToast({
            title: '发送成功',
            icon: 'success'
          })
          wx.request({
            url: serverUrl + '/video/queryCommentsByVideoId?videoId=' + videoInfo.id,
            method: 'post',
            success: function (resp) {
              //进行时间戳的转换
              var CommentList = resp.data.data;
              for (var i = 0; i < CommentList.length; i++) {
                CommentList[i]["createTime"] = util.formatDate(CommentList[i]["createTime"]);

              }
              var contentValue = ''
              //将获得的评论
              me.setData({
                contentValue: contentValue, //清空输入框
                CommentList: CommentList
              })

            }

          })
          //发送成功之后 需要更新评论区域

        }
      })

    }

  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var me = this;
    me.videoCtx.play();

  },
  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    var me = this;
    me.videoCtx.pause();
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

  showSearch: function () {
    wx.switchTab({
      url: '../searchVideos/searchVideos',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })

  },
  //点击上传自己的短视频
  upload: function () {
    var me = this;
    var videoInfo = JSON.stringify(me.data.videoInfo);
    var realUrl = '../videoInfo/videoInfo@videoInfo#' + videoInfo; //视频的信息
    app.globalData.realUrl = '../videoInfo/videoInfo';
    app.globalData.realUrlParam = videoInfo;
    var user = app.getGlobalUserInfo();
    if (user == null || user == '' || user == undefined) {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      videoUtils.uploadVideos();
    }
  },
  showIndex: function () {
    wx.switchTab({
      url: '../category/category',
    })
  },
  showPublisher: function () {
    var user = app.getGlobalUserInfo();
    var videoInfo = this.data.videoInfo;
    var realUrl = '../videoInfo/publisherId@publisherId#' + videoInfo.userId; //视频的信息
    app.globalData.publisherId = videoInfo.userId;
    if (user == null || user == undefined || user == '') {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      wx.switchTab({
        // url: '../mine/mine?publisherId=' + videoInfo.userId,\
        url: '../mine/mine'
      })
    }
    //对页面级别进行拦截

  },
  //点击评论
  comments: function () {

    var me = this;
    //先判断用户是否 登陆如果没有登陆 则提醒用户进行登陆
    var user = app.getGlobalUserInfo();
    var videoInfo = me.data.videoInfo;
    var videoId = videoInfo.id;
    var videoInfo = JSON.stringify(me.data.videoInfo);
    var realUrl = '../videoInfo/videoInfo#videoInfo@' + videoInfo;
    app.globalData.realUrl = '../videoInfo/videoInfo';
    app.globalData.realUrlParam = videoInfo;
    var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
    if (user == null || user == '' || user == undefined) {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      //滚动页面自动到最底部 评论
      wx.showToast({
        title: '请在下方评论',
      })
      wx.createSelectorQuery().select('#myVideo').boundingClientRect(function (rect) {
        // 使页面滚动到底部
        wx.pageScrollTo({
          scrollTop: rect.bottom
        })
      }).exec()
    }
  },
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function (res) {

    var me = this;
    var videoInfo = me.data.videoInfo;
    return {
      title: '快来看看秀视频吧',
      path: '/pages/videoInfo/videoInfo?videoInfo=' +
        JSON.stringify(videoInfo),
    }
  },
  shareMe: function () {

    var me = this;
    //先判断用户是否 登陆如果没有登陆 则提醒用户进行登陆
    var user = app.getGlobalUserInfo();
    var videoInfo = me.data.videoInfo;
    var videoId = videoInfo.id;
    var videoInfo = JSON.stringify(me.data.videoInfo);
    var realUrl = '../videoInfo/videoInfo#videoInfo@' + videoInfo;
    app.globalData.realUrl = '../videoInfo/videoInfo';
    app.globalData.realUrlParam = videoInfo;
    var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
    if (user == null || user == '' || user == undefined) {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      var videoInfo = this.data.videoInfo;
      var me = this;
      var user = app.getGlobalUserInfo();
      wx.getSystemInfo({
        success: function (result) {
          //选项集合
          let itemList;
          if (result.platform == 'android') {
            itemList = ['下载到本地', '举报用户', '分享到微信群', '取消']
          } else {
            itemList = ['下载到本地', '举报用户', '分享到微信群',]
          }
          wx.showActionSheet({
            itemList: itemList,
            success: function (res) {
              if (res.tapIndex == 0) {
                const downloadTask = wx.downloadFile({
                  url: app.serverUrl + me.data.videoInfo.videoPath,
                  header: ' Content-Type ',
                  success: function (res) {
                    // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
                    console.log(res);
                    if (res.statusCode === 200) {
                      wx.saveVideoToPhotosAlbum({
                        filePath: res.tempFilePath,
                        success: function (res) {
                          wx.hideLoading();
                        }
                      })
                    }
                  }
                })
                downloadTask.onProgressUpdate((res) => {
                  console.log('下载进度', res.progress)
                  wx.showLoading({
                    title: '下载进度:' + res.progress,
                  })
                  console.log('已经下载的数据长度', res.totalBytesWritten)
                  console.log('预期需要下载的数据总长度', res.totalBytesExpectedToWrite)
                })

              } else if (res.tapIndex == 1) {
                // 举报
                if (user.id)
                  wx.redirectTo({
                    url: '../report/report?videoId=' + videoInfo.id + "&pubulisherId=" + videoInfo.userId,
                  })
              } else if (res.tapIndex == 2) {
                wx.showToast({
                  title: '使用右上角转发',
                  duration: 5000
                })
              }

            },
          })
        },
      })
    }
  },

  likeVideoOrNot: function () {
    var me = this;
    //先判断用户是否 登陆如果没有登陆 则提醒用户进行登陆
    var user = app.getGlobalUserInfo();
    var videoInfo = me.data.videoInfo;
    var videoId = videoInfo.id;
 
    if (user == null || user == '' || user == undefined) {
      var videoInfo = JSON.stringify(me.data.videoInfo);
      var realUrl = '../videoInfo/videoInfo#videoInfo@' + videoInfo;
      app.globalData.realUrl = '../videoInfo/videoInfo';
      app.globalData.realUrlParam = videoInfo;
      var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      var userLikeVideo = me.data.userLikeVideo;
      var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
      if (userLikeVideo) {
        url = '/video/userUnLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
      }
      var serverUrl = app.serverUrl;
      wx.showLoading({
        title: '...',
      })
      wx.request({
        url: serverUrl + url,
        method: 'post',
        header: {
          'content-type': 'application/json' //默认值
        },
        success: function (res) {

          wx.hideLoading();
          userLikeVideo = !userLikeVideo;
          me.setData({
            userLikeVideo: userLikeVideo,
          })
        }
      })
    }
  }
})