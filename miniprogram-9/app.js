//app.js
App({
  onLaunch: function () {
   var openid= wx.getStorageSync('openid');
    this.globalData.openid=openid;
    if (this.globalData.openid===''){
      wx.login({
        success: res => {
          // 发送 res.code 到后台换取 openId, sessionKey, unionId
          console.log(res.code+"-----------------------------");
          wx.request({
            url: 'http://localhost:8000/wx/login',
            data: { code: res.code },
            success: (res2) => {
              this.globalData.openid = res2.data;
              wx.setStorageSync("openid", this.globalData.openid);
            }
          })
        }
      })
  }else{
    console.log(this.globalData.openid);
  }
         
  },
  globalData: {
    userInfo: null,
    openid:''
  }
})