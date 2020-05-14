<template>
  <!--底部-->
  <div class="dib_beij">
    <div class="dib_jvz_beij">
      <div class="shangp_baoz">
        <p>本地购物&nbsp;&nbsp;看得见的商品</p>
        <p class="beng1">正品行货&nbsp;&nbsp;购物无忧</p>
        <p class="beng2">低价实惠&nbsp;&nbsp;帮你省钱</p>
        <p class="beng3">本地直发&nbsp;&nbsp;专业配送</p>
      </div>
      <div class="zhongj_youx">
        <div class="lieb_daoh">
          <h4>物流配送</h4>
          <ul>
            <li><a href="#">配送查询</a></li>
            <li><a href="#">配送服务</a></li>
            <li><a href="#">配送费用</a></li>
            <li><a href="#">配送时效</a></li>
            <li><a href="#">签收与验货</a></li>
          </ul>
        </div>
        <div class="lieb_daoh">
          <h4>支付与账户</h4>
          <ul>
            <li><a href="#">货到付款</a></li>
            <li><a href="#">在线支付</a></li>
            <li><a href="#">门店支付</a></li>
            <li><a href="#">账户安全</a></li>
          </ul>
        </div>
        <div class="lieb_daoh">
          <h4>购物帮助</h4>
          <ul>
            <li><a href="#">购物保障</a></li>
            <li><a href="#">购物流程</a></li>
            <li><a href="#">焦点问题</a></li>
            <li><a href="#">联系我们</a></li>
          </ul>
        </div>
        <div class="lieb_daoh">
          <h4>售后服务</h4>
          <ul>
            <li><a href="#">退换货服务</a></li>
            <li><a href="#">退款说明</a></li>
            <li><a href="#">专业维修</a></li>
            <li><a href="#">延保服务</a></li>
            <li><a href="#">家电回收</a></li>
          </ul>
        </div>
        <div class="lieb_daoh">
          <div class="kef_dianh">
            <p>客服电话</p><span>1353-119-6495</span>
          </div>
          <div class="kef_dianh kef_dianh_youx">
            <p>意见收集邮箱</p><p>36898897@qq.com</p>
          </div>
        </div>
        <div class="lieb_daoh lieb_daoh_you">
          <div class="erw_ma_beij">
            <div class="erw_m">
              <h1><img src="/static/mb_wangid.png"></h1>
              <span>扫码下载MyShop客户端</span>
            </div>
            <div class="erw_m">
              <h1><img src="/static/mb_wangid.png"></h1>
              <span>扫码下载MyShop客户端</span>
            </div>
          </div>
        </div>
      </div>
      <div class="beia_hao">
        <p>京ICP备：123456789号  </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
        <div class="renz_">
          <span></span>
          <span class="span1"></span>
          <span class="span2"></span>
          <span class="span3"></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "index"
    }
</script>

<style scoped>

  .dib_beij{
    background: #fff;
  }
  .dib_jvz_beij{
    width: 1200px;
    margin:0 auto;
  }

  .shangp_baoz{
    border-bottom: solid 1px #cbcbcb;
    padding: 25px 0;
    text-align: center;
    overflow: hidden;
  }

  .shangp_baoz p{
    background: url(/static/beng.png) no-repeat;
    background-position: 0 0;
    padding-left: 45px;
    line-height: 40px;
    font-size: 18px;
    color: #3c4042;
    display: inline-block;
    font-family:"微软雅黑";
    margin: 0 40px;
  }
  .shangp_baoz  .beng1{
    background-position: 0 -47px;
  }
  .shangp_baoz  .beng2{
    background-position: 0 -93px;
  }
  .shangp_baoz  .beng3{
    background-position: 0 -140px;
  }
  .zhongj_youx{
    border-bottom: solid 1px #cbcbcb;
    padding: 25px 0;
    overflow: hidden;
  }

  .lieb_daoh{
    padding: 20px 50px 20px 20px;
    float: left;
  }

  .lieb_daoh_you{
    float: right;
    padding: 20px 10px 20px 20px;
  }

  .lieb_daoh h4{
    color: #2c2e2f;
    font-size: 16px;
    font-family: "微软雅黑";
    margin-bottom: 15px;
  }
  .lieb_daoh a{
    color: #676767;
    line-height: 23px;
    font-size: 13px;
  }
  .lieb_daoh a:hover{
    color: #409EFF;
  }

  .kef_dianh{
    padding-left: 55px;
    background: url(/static/Shape_140.png) no-repeat;
    background-position: 0 0;
    height: 50px;
    line-height: 20px;
    margin-bottom: 20px;
  }
  .kef_dianh p{
    font-size: 16px;
    color: #6a6a6a;
    font-family: "微软雅黑";
  }
  .kef_dianh span{
    color: #409EFF;
    font-size: 18px;
  }
  .kef_dianh_youx{
    background-position: 0 -62px;
  }
  .erw_ma_beij{
    text-align: center;

  }
  .erw_m{
    float: left;
    margin-right: 25px;
  }
  .erw_m h1{
    width: 121px;
    height: 121px;
    overflow: hidden;
    background: #FFF;
    padding: 2px;
    border: solid 1px #c2c2c2;
  }
  .erw_m span{
    line-height: 25px;
    display: block;
    font-size: 12px;
  }

  .beia_hao{
    padding:25px 0;
    position: relative;
  }


  .beia_hao p{
    background: url(/static/jing_b.png) no-repeat;
    padding-left: 25px;
    line-height: 20px;
    font-size: 16px;
    margin-bottom: 15px;
  }

  .beia_hao .gonga_bei{
    background-position: 0 -30px;
  }

  .renz_{
    position: absolute;
    right: 0px;
    top: 25px;
  }

  .renz_ span{
    width: 120px;
    height: 52px;
    display: block;
    background: url( /static/renz.png) no-repeat;
    float: left;
    margin: 0 5px;
  }

  .renz_ .span1{
    background-position: 0 -52px;
  }
  .renz_ .span2{
    background-position: 0 -104px;
  }
  .renz_ .span3{
    background-position: 0 -156px;
  }
</style>
