// pages/chooseBgm/chooseBgm.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    serverUrl: "",
    bgmList: [],
    videoParams: {},
    items: [
      { name: 'define', value: '默认分类', checked: 'true' },
      { name: 'food', value: '美食分类' },
      { name: 'dress', value: '美妆分类' },
    ],
    filter: [
      { name: 'define', value: '普通', checked: 'true' },
      { name: 'light', value: '白皙' },
      { name: 'black', value: '慕斯' },
    ],
    boxValue: "define",
    fileterBoxValue: "define",
    isUpload: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (params) {
    var me = this;
    me.setData(
      {
        videoParam: params,
        isUpload:false
      }
    )
    var serverUrl = app.serverUrl;
    wx.showToast({
      title: '请等待....',
    })
    wx.request({
      url: serverUrl + '/bgm/list',
      method: 'post',
      success: function (res) {
        if (res.data.status == 200) {
          var bgmList = res.data.data;
          me.setData(
            {
              bgmList: bgmList
              , serverUrl: serverUrl
            }
          );
          wx.request({
            url: serverUrl +'/category/queryAll',
            success:function(res)
            {
              
            }
          })

        }
      }
    }

    )

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

  filterBoxChange: function (e) {

    //三个选项卡选中其中一个之后，其他两个会失效
    var me = this;
    var new_items =
      [
        { name: 'define', value: '普通', checked: 'true' },
        { name: 'light', value: '白皙' },
        { name: 'black', value: '慕斯' },
      ]
    //实现思路 拿到数组中最后一个值，并且将该值放到
    var key = e.detail.value;
    var name = key[key.length - 1];
    //做出选择之后遍历数组 并将该值设置为checked ，其他值设置为null
    for (var i = 0; i < new_items.length; i++) {
      if (name == new_items[i].name) {
        new_items[i].checked = true;
        var fileterBoxValue = new_items[i].name;
      }
      else {
        new_items[i].checked = false;
      }
    }
    if (fileterBoxValue != null && fileterBoxValue != '' && fileterBoxValue != undefined) {
      me.setData
        (
        {
          filter: new_items,
          fileterBoxValue: fileterBoxValue
        }
        )
    }
    else {
      me.setData
        (
        {
          fileterBoxValue: ''
        }
        )

    }
  },


  checkboxChange: function (e) {

    //三个选项卡选中其中一个之后，其他两个会失效
    var me = this;
    var new_items =
      [
        { name: 'define', value: '默认分类', checked: 'true' },
        { name: 'food', value: '美食分类' },
        { name: 'dress', value: '美妆分类' },
      ]
    //实现思路 拿到数组中最后一个值，并且将该值放到
    var key = e.detail.value;
    var name = key[key.length - 1];
    //做出选择之后遍历数组 并将该值设置为checked ，其他值设置为null

    for (var i = 0; i < new_items.length; i++) {
      if (name == new_items[i].name) {
        new_items[i].checked = true;
        var boxValue = new_items[i].name;
      }
      else {
        new_items[i].checked = false;
      }
    }
    if (boxValue != null && boxValue != '' && boxValue != undefined) {
      me.setData
        (
        {
          items: new_items,
          boxValue: boxValue
        }
        )
    }
    else {
      me.setData
        (
        {
          boxValue: ''
        }
        )

    }
  },

  upload: function (e) {
    wx.showLoading({
      title: '上传中...',
    })
    var me = this;
    var bgmId = e.detail.value.bgmId;
    var desc = e.detail.value.desc;
    var duration = me.data.videoParam.duration;
    var tmpHeight = me.data.videoParam.tmpHeight;
    var tmpWidth = me.data.videoParam.tmpWidth;
    var tmpVideoUrl = me.data.videoParam.tmpVideoUrl;
    var tmpCoverUrl = me.data.videoParam.tmpCoverUrl;
    var videoCategory = me.data.boxValue;
    var videoFilter = me.data.fileterBoxValue;
   //如果用户没有点击任何的选项卡的时候 则不允许用户进行上传
    if (videoCategory == '') {
      wx.showToast({
        title: '请选择一个视频分类',
        icon: 'none'
      })
      return;
    }
    if (videoFilter == '') {
      wx.showToast({
        title: '请选择一个滤镜模板',
        icon: 'none'
      })
      return;
    }
   //判断上传操作是否已经提交 ，如果在当前页面已经被提交就不能上传了
    if (me.data.isUpload==true)
    {
       wx.showToast({
         title: '正在进行上传,请不要反复提交上传',
       })
       return ;
    }
    else
    {
      me.setData(
        {
          isUpload: true
        }
      )
    }
    me.setData(
      {
        isUpload: true
      }
    )
    var userInfo = app.getGlobalUserInfo();
    var serverUrl = app.serverUrl;
    var userId = userInfo.id;
    // 开始上传
    wx.uploadFile({
      url: serverUrl + "/video/upload",
      formData: {
        userId: userInfo.id,//修改为本地缓存
        bgmId: bgmId,
        desc: desc,
        duration: duration,
        tmpHeight: tmpHeight,
        tmpWidth: tmpWidth,
        tmpVideoUrl: tmpVideoUrl,
        tmpCoverUrl: tmpCoverUrl,
        videoCategory: videoCategory,
        videoFilter: videoFilter
      },
      filePath: tmpVideoUrl,
      name: 'file',
      header:
        {
          'content-type': 'application/json'//默认值
        },
      success: function (res) {
        var data = JSON.parse(res.data);
        if (data.status == 200) {
          
          wx.showToast({
            title: '上传成功',
            icon: "success",
          })
          wx.hideLoading();
          setTimeout(function () {
            wx.switchTab({
              url: '../mine/mine',
            })
          }, 2000) //延迟时间 这里是2秒

          // var videoId = data.data;
          // wx.showLoading({
          //   title: '上传中...',
          // })
          // wx.uploadFile({
          //   url: serverUrl + '/video/uploadCover',
          //   formData:
          //     {
          //       userId: userInfo.id,
          //       videoId: videoId
          //     },
          //   filePath: tmpCoverUrl,
          //   name: 'file',
          //   header:
          //     {
          //       'content-type': 'application/json'//默认值
          //     },
          //   success: function (res) {
          //     var data = JSON.parse(res.data);
          //     if (data.status == 200) {
          //       //上传成功
          //       wx.showToast({
          //         title: '上传成功',
          //         icon: "success"
          //       })
          //       wx.hideLoading();
          //       wx.navigateTo({
          //         url: '../category/category',
          //       })
          //     }
          //     else {
          //       wx.showToast({
          //         title: '上传失败',
          //         icon: "error"
          //       })
          //     }
          //   }
          // })

        } else {
          wx.showToast({
            title: '上传失败!~~',
            icon: "success"
          });
        }

      }

    })


  }
})