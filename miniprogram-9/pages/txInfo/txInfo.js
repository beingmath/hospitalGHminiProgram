// pages/txInfo/txInfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    doctor:'',
    time:'',
    date:'',
    birth:'',
    name:'',
    phone:'',
    doctorjson:''
  },
  nameInput:function(e){
    this.setData({
      name: e.detail.value
    })
  },
  phoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },
  bindBirthChange:function(e){
    this.setData({
      birth: e.detail.value
    })
  },
  torecord:function(){
    if (this.data.name==='' || this.data.phone==='' || this.data.birth===''){
return
    }
      var record={
        doctor:'',
        patientName:'',
        phone:'',
        birth:'',
      time:'',
      };
    record.doctor = this.data.doctor;
    record.patientName = this.data.name,
      record.phone = this.data.phone,
      record.birth = this.data.birth,
      record.time = this.data.date+" "+this.data.time
    var recordJSON=JSON.stringify(record)
    var record = encodeURIComponent(JSON.stringify(record));
    
    wx.request({
      url: 'http://localhost:8000/wx/saveRecord',
      data: { openid: app.globalData.openid,
        record: recordJSON
       },
      success: (res2) => {
       console.log("success");
        wx.navigateTo({
          url: '../record/record?record=' + record,
        })
      }
    })
   
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var doctor = JSON.parse(decodeURIComponent(options.doctor))
    var time=options.time
    var date=options.date
    this.setData({
      doctor: doctor,
      time: time,
      date: date,
      doctorjson: options.doctor
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