//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    webtop: "http://localhost:8000/doctorimage/",
    webtop2: "http://localhost:8000/circleimage/",
    doctors:[],
    pageannoun:[],
    currentid:1,
    currentPro:{}
  },
  searchFun:function(e){
    console.log(e.detail.value);
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../index2/index2'
    })
  },
  announ:function(e){
    var index = e.currentTarget.dataset.index;
    var announ= encodeURIComponent(JSON.stringify(this.data.pageannoun[index]))
    wx.navigateTo({
      url: '../announ/announ?announ='+announ
    })
  },
  doctInfo:function(e){
   var id=e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../doctorInfo/doctorInfo?id='+id
    })
  }, 
  onLoad: function () {
 wx.request(
   {
     url: 'http://localhost:8000/wx/selectdoctor',
     success:res=> {
       app.globalData.doctors = res.data

       this.setData({
         doctors:res.data
       })
     }
 }
 ),
 wx.request({
   url: 'http://localhost:8000/wx/selectPageannoun',
   success: res => {
     app.globalData.pageannoun = res.data
     this.setData({
       pageannoun: res.data
     })
   }
 })
  },
  getUserInfo: function(e) {
  
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
    
  }
})
