// pages/record/record.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    webtop: "http://localhost:8000/doctorimage/",
records:[]
  },
  reset:function(e){
    var that=this;
    var id = e.currentTarget.dataset.id;
    wx.showModal({
      title: '提示',
      content: '你确定要取消预约',
      success(res) {
        if (res.confirm) {
         that.data.records.forEach(function (item, index) {
           if (item.id === id) {
             that.data.records.splice(index,1)
              that.setData({
                records: that.data.records
              })
            }
          })
          wx.request({
            url: 'http://localhost:8000/wx/deleteRecord',
            data: {
              id: id
            },  success: (res2) => {
              console.log('用户点击确定')
            }
          })
        
       
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  
    console.log(id);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.request({
      url: 'http://localhost:8000/wx/selectRecord',
      data: {
        openid: app.globalData.openid
      },
      success: (res2) => {
        console.log("mm");
        this.setData({
          records: res2.data
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