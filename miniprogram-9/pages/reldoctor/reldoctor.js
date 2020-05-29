// pages/reldoctor/reldoctor.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    webtop: "http://localhost:8000/doctorimage/",
navList:[],
currentIndex:-1,
doctors:[],
office:""
  },
  doctInfo: function (e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../doctorInfo/doctorInfo?id=' + id
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
    this.setData({
      doctors : app.globalData.doctors
    })
 wx.request({
   url: 'http://localhost:8000/wx/selectOfficeNameNoRepeat',
   success: res => {

     this.setData({
       navList: res.data
     })
   }
 })
  },
  clicknav:function(e){
   this.setData({
     currentIndex: e.target.dataset.index,
     office: e.target.dataset.office
   
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