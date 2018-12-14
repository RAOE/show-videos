var videoUtils = require('../../utils/videoUtils.js')
var util = require("../../utils/formateTime.js");

const app = getApp()


Page({
  /**
   * 页面的初始数据
   */
  data: {
    cover: "cover",
    videoId: "",
    src: "",
    imagesrc: "",
    videoInfo: {},
    userLikeVideo: false,
    placeholder: "说点什么吧",
    CommentList: [],
    contentValue: ""

  },
  videoCtx: {},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (params) {
    var me = this;

    me.videoCtx = wx.createVideoContext('myVideo', me);
    var videoInfo = JSON.parse(params.videoInfo);
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
      imagesrc: app.serverUrl + videoInfo.face_image,
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
    var videoInfo = this.data.videoInfo;
    var videoId = videoInfo.id;


    wx.request({
      url: serverUrl + 'video/saveComments?comment=' + comment + "&videoId=" + videoId + "&userId=" + user.id,
      method: 'post',
      success: function (resp) {
        console.log(resp);
        wx.showToast({
          title: '发送成功',
          icon: 'success'
        })
        wx.request({
          url: serverUrl + '/video/queryCommentsByVideoId?videoId=' + videoInfo.id,
          method: 'post',
          success: function (resp) {
           
            //console.log(resp.data.data);
            //进行时间戳的转换
            var CommentList = resp.data.data;
            for (var i = 0; i < CommentList.length; i++) {
              CommentList[i]["createTime"] = util.formatDate(CommentList[i]["createTime"]);
              console.log('转换完毕');
            }
            console.log(CommentList);
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  showSearch: function () {
    wx.navigateTo({
      url: '../searchVideos/searchVideos',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })

  },
  upload: function () {
    var me = this;
    var videoInfo = JSON.stringify(me.data.videoInfo);

    var realUrl = '../videoInfo/videoInfo@videoInfo#' + videoInfo; //视频的信息

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
    wx.redirectTo({
      url: '../category/category',
    })
  },
  showPublisher: function () {
    var user = app.getGlobalUserInfo();
    var videoInfo = this.data.videoInfo;
    var realUrl = '../videoInfo/publisherId@publisherId#' + videoInfo.userId; //视频的信息
    if (user == null || user == undefined || user == '') {
      wx.redirectTo({
        url: '../userLogin/login' + realUrl,
      })
    } else {
      wx.redirectTo({
        url: '../mine/mine?publisherId=' + videoInfo.userId,
      })
    }
    //对页面级别进行拦截

  },
  comments: function () {
    //滚动页面自动到最底部 评论
    wx.createSelectorQuery().select('#myVideo').boundingClientRect(function (rect) {
      // 使页面滚动到底部
      wx.pageScrollTo({
        scrollTop: rect.bottom
      })
    }).exec()
  },
  shareMe: function () {
    
    var videoInfo = this.data.videoInfo;
    var me = this;
    var user = app.getGlobalUserInfo();
    console.log(videoInfo);

    wx.showActionSheet({
      itemList: ['下载到本地', '举报用户', '分享到朋友圈'],
      success: function (res) {
        console.log(res.tapIndex);
        if (res.tapIndex == 0) {
          // 下载
          wx.showLoading({
            title: '下载中...',
          })
          wx.downloadFile({
            url: app.serverUrl + me.data.videoInfo.videoPath,
            success: function (res) {
              // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
              if (res.statusCode === 200) {
                console.log(res.tempFilePath);

                wx.saveVideoToPhotosAlbum({
                  filePath: res.tempFilePath,
                  success: function (res) {
                    console.log(res.errMsg)
                    wx.hideLoading();
                  }
                })
              }
            }
          })
        } else if (res.tapIndex == 1) {
          // 举报
          wx.redirectTo({
            url: '../report/report?videoId=' + videoInfo.id +"&pubulisherId="+videoInfo.userId,
          })
        } else {
          wx.showToast({
            title: '官方暂未开放...',
          })
          f
        }
      }
    })



  },


  onShareAppMessage: function (res) {

    var me = this;
    var videoInfo = me.data.videoInfo;


    return {
      title: '快来看看秀视频吧',
      path: '/page/videoInfo/videoInfo?videoInfo=' +
        JSON.stringify(videoInfo),
    }

  },
  likeVideoOrNot: function () {
    var me = this;
    var videoInfo = me.data.videoInfo;
    var videoId = videoInfo.id;

    var user = app.getGlobalUserInfo();
    var realUrl = '../videoinfo/videoinfo#videoInfo@' + videoInfo;
    var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoId + '&videoCreaterId=' + videoInfo.userId;
    if (user == null || user == '' || user == undefined) {
      wx.redirectTo({
        url: '../userLogin/login?realUrl=' + realUrl,
      })
    } else {
      var userLikeVideo = me.data.userLikeVideo;
      var url = '/video/userLike?userId=' + user.id + '&videoId=' + videoInfo.id + '&videoCreaterId=' + videoInfo.userId;
      if (userLikeVideo) {
        url = '/video/userUnLike?userId=' + user.id + '&videoId=' + videoInfo.id + '&videoCreaterId=' + videoInfo.userId;
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