<template>
  <div>
    <esay-header></esay-header>
    <esay-search></esay-search>
    <esay-shortcut></esay-shortcut>
    <!--轮播图和商品类目的容器-->
    <div class="content_wrap">
      <esay-swiper></esay-swiper>
      <div class="w">
        <esay-item-category class="item_category"></esay-item-category>
      </div>
    </div>
    <esay-push-item></esay-push-item>
    <esay-footer></esay-footer>
  </div>
</template>

<script>
  import Header from '@/components/header/index'
  import Swiper from '@/components/home/Swiper'
  import Search from "@/components/home/Search";
  import ItemCategory from '@/components/home/ItemCat'
  import Shortcut from "@/components/home/Shortcut";
  import Footer from '@/components/footer/index'
  import PushItem from "../../components/home/PushItem";


  export default {
    components: {
      "esay-header": Header,
      'esay-swiper': Swiper,
      'esay-item-category': ItemCategory,
      'esay-search':Search,
      'esay-shortcut':Shortcut,
      'esay-footer':Footer,
      'esay-push-item':PushItem
    },
    data() {
      return {

      }
    },
  }
</script>

<style scoped>
  .w {
    width: 1200px;
    margin: 0 auto;
  }

  .content_wrap {
    position: relative;
    height: 580px;
  }

  .item_category {
    position: absolute;
    top: 0;
    z-index: 999;
  }


</style>
