// pages/doctorInfo/doctorInfo.js
var util=require("../../utils/util.js");
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    webtop: "http://localhost:8000/doctorimage/",
doctor:{},
    date:"",
    time:"09:00"
  },
  bindDateChange:function(e){
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange:function(e){
    this.setData({
      time: e.detail.value
    })
  },
  click:function(e){
    var doctor = encodeURIComponent(JSON.stringify(this.data.doctor));
    var date = this.data.date;

    var time = this.data.time;
    wx.navigateTo({
      url: '../txInfo/txInfo?doctor=' + doctor+'&date='+date+'&time='+time,
    })

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var TIME = util.formatDate(new Date());
    this.setData({
      date: TIME,
    });
 
    var that=this;
    app.globalData.doctors.forEach(function (item, index){
  
      if ((item.id +'')=== options.id){
        that.setData({
          doctor : item
        })
      } 
    })
 
   
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

  }
})