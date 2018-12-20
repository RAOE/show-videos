
var app = getApp()

Page({
  data: {
    categoryInfo: {},
    serverUrl: ''
  },
  //生命周期函数--监听页面加载
  onLoad: function () {
    var that = this;
    var me = this;
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + "/category/queryAll",
      success(res) {
        var data = res.data.data;
        me.setData(
          {
            serverUrl: serverUrl,
            categoryInfo: res.data.data
          }
        )

      }
    })
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
    //category 加载的时候将图片加载到其中

  },
  // 每条List点击事件
  jump: function (e) {
    let id = e.currentTarget.dataset.id;
    if (id == 'define') {
      wx.navigateTo({
        url: '../index/index?id=' + id,
      })
    }
    else if (id == 'food') {
      wx.navigateTo({
        url: '../index/index?id=' + id,
      })

    }
    else if (id == 'dress') {
      wx.showToast({
        title: '敬请期待....',
        icon: 'none'
      })
    }
    else if (id == 'more') {
      wx.showToast({
        title: '敬请期待....',
        icon: 'none'
      })
    }
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

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

  }
})