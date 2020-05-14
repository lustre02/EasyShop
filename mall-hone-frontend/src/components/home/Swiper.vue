<template>
  <div>
    <swiper ref="mySwiper"
            :options="swiperOptions"
            class="my_swiper">
      <swiper-slide v-for="(item,index) in imageList" :key="index">
       	<a :href="item.redirect"> <div class="swiper-image" :style="'background-image:url('+item.imageUrl+')' " :data-src="item.imageUrl"></div></a>
      </swiper-slide>
      <div class="swiper-pagination" slot="pagination"></div>
    </swiper>
  </div>
</template>

<script>
  import Axios from 'axios'
  export default {
    data() {
      return {
        swiperOptions: {
          pagination: {
            el: '.swiper-pagination'
          },
        },
        imageList: []
      }
    },
    methods: {
      initBigAd() {
        const that = this

        Axios({
          url: 'http://localhost/api/content/page/89'
        }).then(value => {
          if (value.data.code == 20000) {
            that.imageList = value.data.data
          }
        })
      },
    },
    computed: {
      swiper() {
        return this.$refs.mySwiper.$swiper
      },
      loadImage(e) {
        console.log(e)
        return 'imgUrl'
      }
    },
    created() {
      this.initBigAd()
    },
    mounted() {
      this.swiper.slideTo(3, 1000, false)
    }
  }
</script>
<style>
  .swiper-image {
    background-repeat: no-repeat;
    background-size: auto 580px;
    height: 580px;
    background-color: rgba(0, 0, 0, .2);
    background-position: center;
  }
</style>
