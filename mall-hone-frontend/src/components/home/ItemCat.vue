<template>
  <div @mouseout="hideList" >
    <div class="category_wrap" :style="showList==true?'width:1200px':'width:250px'">
      <div class="category_nav">
        <div class="nav_item"
             v-for="(item,index) in itemCatList"
             @mouseover="showRootIndexList(index)" >{{item.name}} <span style="float: right;color: rgba(255,255,255,.4);line-height: 26px;font-size: 10px;margin-right: 10px; ">></span></div>
      </div>
      <div class="category_list" v-if="itemCatList[rootIndex]" @mouseover="showList=true" :style="showList==true?'width:950px;':'width:0;'">
        <div class="list_row" v-for="item in itemCatList[rootIndex].children">
          <div class="parent_name">
            <a href="">{{item.name}}</a> <span style="margin-left: 2px;font-size: 8px">></span>
          </div>
          <div class="row_item" >
            <ul>
              <li v-for="(item,index) in item.children"><a href="">{{item.name}}</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Axios from 'axios'
  export default {
    name: "index",
    data() {
      return {
        showList:false,
        rootIndex:0,
        itemCatList: [],
      }
    },
    created() {
      this.initItemCategoryList()
    },
    methods:{
      showRootIndexList(index){
        this.rootIndex = index
        this.showList=true
      },
      hideList(){
        this.showList=false
      },

      initItemCategoryList() {
        const that = this
        Axios({
          url: 'http://localhost/api/item/cat/tree'
        }).then(value => {
          if (value.data.code == 20000) {
            that.itemCatList = value.data.data
          }
        })
      },

    }
  }
</script>

<style scoped>
  .category_wrap {
    height: 580px;
    transition-duration: 0.2s;
  }

  .category_nav {
    width: 250px;
    background: rgba(0, 0, 0, .5);
    height: 100%;
    float: left;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }

  .category_nav .nav_item{
    text-align: center;
    font-size: 14px;
    color: #fff;
    height: 30px;
    line-height: 30px;
  }

  .category_nav .nav_item:hover{
    background: rgba(0, 0, 0, .1);
  }


  .category_list{
    display: flex;
    height: 100%;
    /*background: rgb(247, 247, 247);*/
    float: left;
    background-color:  #fff;
    overflow: hidden;
    flex-direction: column;
    transition-duration: 0.2s;
  }

  .category_list .list_row{
    margin: 20px 0 0 40px;
  }

  .list_row .parent_name{
    width: 70px;
    float: left;
    font-size: 13px;
    color: #000;
  }

  .list_row .parent_name a:hover{
    color:  #409EFF;
  }

  .list_row .row_item{
    float: left;
    width: 800px;
  }

  .list_row .row_item li{
    margin: 4px 10px;
    font-size: 12px;
    color: rgb(102,102,102);
    float: left;
  }

  .list_row .row_item li a:hover{
    color:  #409EFF;
  }
</style>
