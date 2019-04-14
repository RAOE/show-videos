const app = getApp()

Page({
  data: {
    totalPage: 1,
    page: 1,
    videoList: [],
    serverUrl: "",
    screenWidth: 350,
    searchContent: "",
    category: ""
  },
  onLoad: function (params) {
    var me = this;
    var screenWidth = wx.getSystemInfoSync().screenWidth;
    var category = params.id;
    if (category != null && category != '' && category != undefined) {
      me.setData({
        category: category,
      })
    }
    me.setData({
      screenWidth: screenWidth,
    })
    var searchContent = params.search;
    var isSaveRecord = params.isSaveRecord;
    if (isSaveRecord == null || isSaveRecord == '') {
      isSaveRecord = 0;
    }
    if (searchContent != undefined) {
      me.setData(
        {
          searchContent: searchContent
        }
      );
    }
    var page = me.data.page;
    me.getAllVideoList(page, isSaveRecord);
  },
  getAllVideoList: function (page, isSaveRecord) {
    var me = this;
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '请等待...加载中',
    })
    var searchContent = me.data.searchContent;
    var category = me.data.category;
    var url = serverUrl + 'video/showAll?page=' + page + "&isSaveRecord="
      + isSaveRecord + '&category=' + category;
    if (category == null || category == undefined) {
      url = serverUrl + 'video/showAll?page=' + page + "&isSaveRecord="
        + isSaveRecord + '&category=' + null;
    }
    wx.request({
      url: url,
      method: "post",
      data:
      {
        videoDesc: searchContent
      },
      success: function (res) {
        wx.hideLoading();
        wx.hideNavigationBarLoading();
        wx.stopPullDownRefresh();
        // 判断当前也page是否是第一页 如果是第一页，
        // 那么就吧videoList 清空一下
        if (page == 1) {
          me.setData(
            {
              videoList: []
            }
          );
        }
        var videoList = res.data.data.rows;
        //遍历视频信息 将face_image为null的视频头像改为默认头像
        for (var i = 0; i < videoList.length; i++) {
          if (videoList[i].face_image == null || videoList[i].face_image == undefined || videoList[i].face_image == '') {
            videoList[i].face_image = "../resource/images/noneface.png";
          }
          else {
            var serverUrl = app.serverUrl;
            videoList[i].face_image = serverUrl + videoList[i].face_image;
          }
        }
        var newVideoList = me.data.videoList;
        me.setData(
          {
            videoList: newVideoList.concat(videoList),
            page: page,
            totalPage: res.data.data.total,
            serverUrl: app.serverUrl
          }
        );
      }
    })
  },
  onReachBottom: function () {
    var me = this;
    var currentPage = me.data.page;
    var totalPage = me.data.totalPage;
    if (currentPage == totalPage) {
      wx.showToast({
        title: '已经没有视频啦',
        icon: "none"

      })
      return;
    }
    var page = currentPage + 1;
    me.getAllVideoList(page, 0);

  },
  onPullDownRefresh: function () {
    wx.showNavigationBarLoading();
    this.getAllVideoList(1, 0);
  },
  showVideoInfo: function (e) {
    var me = this;
    var videoList = me.data.videoList;
    var arrindex = e.target.dataset.arrindex;
    var videoInfo = JSON.stringify(videoList[arrindex]);//获取视频信息对象
    wx.navigateTo({
      url: '../videoInfo/videoInfo?videoInfo=' + videoInfo,
    })
  }

})