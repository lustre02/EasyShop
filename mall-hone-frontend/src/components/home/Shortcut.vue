<template>
  <div class="shortcut_wrap">
    <div class="app-container">
      <div class="item_cat">
        全部商品分类
      </div>
      <div class="shortcut">
        <ul>
          <li>商城首页</li>
          <li>本地生活</li>
          <li>团购专区</li>
          <li>积分商城</li>
          <li>分销系统</li>
          <li>办公耗材</li>
          <li>饰品礼品</li>
          <li>休闲娱乐</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Shortcut"
  }
</script>

<style scoped>
  .shortcut_wrap {
    height: 50px;
    border-top: 1px solid rgba(0, 0, 0, .2);
    line-height: 50px;
  }

  .item_cat {
    width: 250px;
    height: 100%;
    text-align: center;
    border-left: 1px solid rgba(0, 0, 0, .2);
    border-right: 1px solid rgba(0, 0, 0, .2);
    font-size: 18px;
    font-weight: bold;
    display: inline-block;
  }

  .shortcut {
    width: 940px;
    display: inline-block;
  }

  .shortcut ul {
    display: flex;
  }

  .shortcut ul li {
    flex: 1;
    text-align: center;
    transition-duration: 0.3s;
  }

  .shortcut ul li:hover {
    cursor: pointer;
    background-color: #409EFF;
    color: white;
  }

</style>
