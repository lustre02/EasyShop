<template>
  <div class="search_wrap app-container">
    <div class="logo">
      <img height="75"
           src="http://lustre123-myshop.oss-cn-beijing.aliyuncs.com/ed4595a8-690c-4413-bb85-f349b57df7cd.png" alt="">
    </div>
    <div class="search_box">
      <el-input style="width: 400px" prefix-icon="el-icon-search"></el-input>
      <el-button type="primary"><span style="color: #fff">搜索</span></el-button>
    </div>
    <div class="car_wrap">
      <div class="car">
        <i class="el-icon-shopping-cart-2"></i>
        <span>我的购物车</span>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Search"
    }
</script>

<style scoped>
  .search_wrap {
    height: 150px;
    display: flex;
  }

  .logo {
    padding: 37.5px 0;
    flex: 1;
  }

  .search_box {
    width: 480px;
    height: 42px;
    flex: 3;
    padding: 45px 30px;
  }

  .car_wrap {
    font-size: 20px;
    flex: 1;
  }

  .car {
    padding: 10px;
    transform: translateY(70%);
  }

  .car:hover {
    border: 1px solid #409EFF;
  }

  .car i {
    font-size: 30px;
    color: #409EFF;
    margin-right: 10px;
  }

  .car span {
    color: #303133;
  }

</style>
