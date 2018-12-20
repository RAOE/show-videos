//app.js
App({
  //可能不在同一个网段 
  //https://www.lotcloudy.com/scetc-show-videos-mini-api-0.0.1-SNAPSHOT
  // https://www.lotcloudy.com/scetc-show-videos-mini-api-0.0.1-SNAPSHOT
  //http://localhost:8080/scetc-show-videos-mini-api/
  serverUrl: "http://localhost:8080/scetc-show-videos-mini-api/",
  userInfo: null,
  //内网ip的方式访问
  setGlobalUserInfo: function (user) {
    wx.setStorageSync("userInfo", user);
  },
  getGlobalUserInfo: function () {
    return wx.getStorageSync("userInfo");
  },
  saveUserInfo: function (saveUser) {
    wx.setStorageSync("saveUser", saveUser);
  },
  getSaveUserInfo: function () {
    return wx.getStorageSync("saveUser");
  }

},


)