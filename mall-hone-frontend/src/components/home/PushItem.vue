<template>
  <div class="app-container">
    <div class="push_wrap">
      <div class="push_nav">
        <div class="push_icon">
          <i class="el-icon-orange"></i>
        </div>
        <div class="push_title">
          推荐好货 <span>PUSH</span>
        </div>
      </div>
      <div class="push_item_wrap">
        <div class="push_item_wrap_left">
          <img src="http://lustre123-myshop.oss-cn-beijing.aliyuncs.com/d8b7b712-cc35-4107-a984-5e355e3b27f2.jpg"
               alt=""
               height="500"
               width="500">
        </div>
        <div class="push_item_wrap_right">
          <div class="push_item" v-for="item in 6">
            <div class="push_item_top">
              <div class="push_item_image"
                   style="background-image: url(http://lustre123-myshop.oss-cn-beijing.aliyuncs.com/5f689ed8-d34d-40ff-a379-84a32e13c362.jpg)"></div>
            </div>
            <div class="push_item_bottom">
              <div class="push_item_desc">
                林氏木业简约现代真皮转角客厅头层牛皮沙发家具2036林氏木业简约现代真皮转角客厅头层牛皮沙发家具2036
              </div>
              <div class="push_item_sum">
                ￥999
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PushItem"
  }
</script>

<style scoped>
  .push_wrap {
    height: 570px;
  }

  .push_nav {
    height: 70px;
    /*background-color: pink;*/
    line-height: 70px;
    /*border-bottom: 1px solid rgba(0, 0, 0, .1);*/
    display: flex;
  }

  .push_icon {
    font-size: 30px;
    flex: 1;
  }

  .push_icon i {
    color: #409EFF;
  }

  .push_title {
    color: #303133;
    font-size: 20px;
    flex: 22;
  }

  .push_title span {
    color: rgb(170, 170, 170);
    font-style: italic;
    font-size: 18px;
  }

  .push_item_wrap {
    height: 500px;
    display: flex;
    /*border: 1px solid rgba(0, 0, 0, .1);*/
  }

  .push_item_wrap_left {
    flex: 5;
    /*background-color: #409EFF;*/
  }

  .push_item_wrap_left img {
    border-radius: 20px;
  }

  .push_item_wrap_right {
    /*background-color: #42b983;*/
    flex: 7;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-content: space-between;
  }

  .push_item {
    width: 210px;
    height: 240px;
    background-color: rgba(0, 0, 0, .05);
    overflow: hidden;
    border-radius: 15px;
    display: flex;
    position: relative;
    flex-direction: column;
  }



  .push_item_top {
    flex: 2;
    /*background-color: #42b983;*/
  }

  .push_item_image {
    height: 160px;
    /*border-radius: 20px;*/
    width: 210px;
    background-size: 210px auto;
    background-position: center;
    transition-duration: 0.5s;
    position: absolute;
  }


  .push_item_image:hover{
    margin-top: -10px;
  }

  .push_item_bottom {
    flex: 1;
    /*background-color: #409EFF;*/
    padding: 5px 10px;
  }

  .push_item_desc {
    flex: 2;
    font-size: 14px;
    overflow: hidden;
    height: 40px;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
  }

  .push_item_desc:hover{
    color: #409EFF;
  }

  .push_item_sum {
    color: red;
  }
</style>
