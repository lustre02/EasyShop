<template>
  <div class="header_wrap">
    <el-row class="content_wrap app-container">
      <el-col :span="5">
        <span class="blue">Esay商城欢迎您的到来</span>
      </el-col>
      <el-col :span="7">
        汕头市
      </el-col>
      <el-col :span="4">
        Hi~请登录! <a href="#" class="blue">[免费注册]</a>
      </el-col>
      <el-col :span="2">
        我的收藏
      </el-col>
      <el-col :span="2">
        申请入驻
      </el-col>
      <el-col :span="2">
        客户服务
      </el-col>
      <el-col :span="2">
        手机客户端
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "index"
  }
</script>

<style scoped>

  .header_wrap {
    height: 50px;
    line-height: 50px;
    border-bottom: 1px solid rgba(0,0,0,.1);
  }

  .blue{
    color:#409eff;
  }
</style>
