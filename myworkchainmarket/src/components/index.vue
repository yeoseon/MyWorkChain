<template>
<div>
  <Header/>
  <div class="position-relative pt-7">
    <div class="wrapper"><h2>Reward Point Market</h2></div>
  </div>
  <section class="site-home-scene">
    <div class="inner-container">
        <div class="row">
          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 1} }">
            <img src="@/assets/img/starbucks_iceamericano.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">4,100 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f17 " style="margin-top: -20px; float: left;">아이스 카페아메리카노 Tall</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;스타벅스</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              스타벅스의 깔끔한 맛을 자랑하는 커피로, 스타벅스 파트너들이 가장 좋아하는 커피입니다. 
            </div>
          </router-link>
          
          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 2} }">
            <img src="@/assets/img/applemangocheese.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">11,900 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-bold mb-2 f17" style="margin-top: -20px; float: left;">애플망고 치즈 설빙</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;설빙</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              남녀노소 모두 좋아하는 망고의 최상급 품질인 애플망고의 달콤함과 깊고 진한 치즈 케이크가 만나 신선하고 상큼한 애플망고의 풍미를 더 해 주죠.
            </div>
          </router-link>

          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 3} }">
            <img src="@/assets/img/shinsegae50000.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">100,000 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-bold mb-2 f17" style="margin-top: -20px; float: left;">신세계상품권 모바일교환권</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;이마트, 신세계상품권</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              전국 이마트 매장내 설치된 상품권 교환 KIOSK에서 신세계 상품권으로 교환후 사용하실수 있습니다.
            </div>
          </router-link>

          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 4} }">
            <img src="@/assets/img/shinsegae50000.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">100,000 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-bold mb-2 f17" style="margin-top: -20px; float: left;">신세계상품권 모바일교환권</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;이마트, 신세계상품권</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              전국 이마트 매장내 설치된 상품권 교환 KIOSK에서 신세계 상품권으로 교환후 사용하실수 있습니다.
            </div>
          </router-link>

          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 5} }">
            <img src="@/assets/img/shinsegae50000.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">100,000 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-bold mb-2 f17" style="margin-top: -20px; float: left;">신세계상품권 모바일교환권</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;이마트, 신세계상품권</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              전국 이마트 매장내 설치된 상품권 교환 KIOSK에서 신세계 상품권으로 교환후 사용하실수 있습니다.
            </div>
          </router-link>

          <router-link class="col-sm-6 col-lg-4 p-4" :to="{ name: 'detail', params: {idolId: 6} }">
            <img src="@/assets/img/shinsegae50000.jpg" class="photo5" alt>
            <div style="height: 30px;"> &nbsp;</div>
            <div style="display: flow-root;">
              <span class="font-weight-700 mb-2 f20 t_purple" style="margin-top: -20px; float: right;">100,000 포인트</span>
            </div>
            <br>
            <div style="display: flow-root;">
              <span class="font-weight-bold mb-2 f17" style="margin-top: -20px; float: left;">신세계상품권 모바일교환권</span>
              <span class="t_gry2 small mb-3" style="margin-top: -15px; float: left;"> &nbsp;ㅣ&nbsp;이마트, 신세계상품권</span>
            </div>
            <div class="t_gry3 small" style=" text-align: left;">
              전국 이마트 매장내 설치된 상품권 교환 KIOSK에서 신세계 상품권으로 교환후 사용하실수 있습니다.
            </div>
          </router-link>

          <div style="height: 80px;"> &nbsp;</div>
        </div>
    </div>
  </section>
</div>
</template>

<script>
import Header from '@/components/header'
export default {
  components: {
    Header,
  },
}
</script>

<style scoped>
  .position-relative{
    background-color: #e8e6f2 !important;
    height: 230px;
  }
  .position-relative-sub{
    background-color: #f15a29 !important;
    height: 120px;
  }
  .inner-container{
    padding-top: 60px !important;
  }

</style>
