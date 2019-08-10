<template>
  <div>
    <Header/>
    <div class="position-relative pt-5 pb-4">
      <div v-if="this.$route.params.idolId == '1'" class="portfolio-image detail-01" style="z-index: -1;"></div>
      <div v-else-if="this.$route.params.idolId == '2'" class="portfolio-image detail-02" style="z-index: -1;"></div>
      <div v-else-if="this.$route.params.idolId == '3'" class="portfolio-image detail-03" style="z-index: -1;"></div>
      <div v-else-if="this.$route.params.idolId == '4'" class="portfolio-image detail-04" style="z-index: -1;"></div>
      <div v-else-if="this.$route.params.idolId == '5'" class="portfolio-image detail-05" style="z-index: -1;"></div>
      <div v-else-if="this.$route.params.idolId == '6'" class="portfolio-image detail-06" style="z-index: -1;"></div>
      <div class="pt-5 px-4 px-md-5">
        <div class="py-md-4 py-xl-5 mx-lg-5">
          <div class="portfolio-caption">
            <div v-if="this.$route.params.idolId == '1'" class="text-tiny t_white font-weight-400">스타벅스의 깔끔한 맛을 자랑하는 커피로,<br>스타벅스 파트너들이<br>가장 좋아하는 커피입니다.</div>
            <div v-else-if="this.$route.params.idolId == '2'" class="text-tiny t_white font-weight-400">남녀노소 모두 좋아하는,<br>애플망고의 달콤함과 깊고 진한 치즈 케이크가 만나,<br>신선하고 상큼한 애플망고의 풍미</div>
            <div v-else-if="this.$route.params.idolId == '3'" class="text-tiny t_white font-weight-400">WHEREVER YOU ARE<br>WHEREVER YOU WANT<br>INTERN NET</div>
            <div v-else-if="this.$route.params.idolId == '4'" class="text-tiny t_white font-weight-400">SUPER DEVELOPER<br>SPECIAL PLANNER<br>GONJOY</div>
            <div v-else-if="this.$route.params.idolId == '5'" class="text-tiny t_white font-weight-400">SO SWEET BOYS<br>SPECIAL SWEET VOICE<br>FRONT ATTACK</div>
            <div v-else-if="this.$route.params.idolId == '6'" class="text-tiny t_white font-weight-400">냉동고를 준비하세요,<br> 당신의 고막이 녹아버릴지도 모르니까.<br> Morning Glory</div>
          </div>
        </div>
      </div>
    </div>
    <div class="container px-3 my-4">
      <h1 class="f30 font-weight-700" v-for="e in content" :key="e.id">
        <span v-if="e.id == $route.params.idolId">{{e.name}}</span>
      </h1>
      <div class="flex">
        <div class="flex-box-70">
          <div class="f15 font-weight-400" v-for="e in content" :key="e.id">
            <p v-if="e.id == $route.params.idolId">{{e.desc}}</p>
          </div>
          <div class="layout-guide-box mt-4">
            <p class="font-weight-700" style="margin-bottom:5px;"> 유의사항<br></p>
            <span>매장 별 재고 상황에 따라 구매가 어려운 경우에는 동일 가격 이상의 타 음료로 교환 가능합니다. 정식 판매처 외의 장소나 경로를 통하여 구매하거나 기타의 방법으로 보유하신 포인트는 정상적인 사용이 금지되거나 제한 될 수 있으니 주의 하시기 바랍니다.</span>
          </div>
        </div>
        <div class="flex-box-40" style="margin-left: 80px;">
          <div v-for="e in content" :key="e.id">
            <strong class="t_dgray f15 font-weight-400" v-if="e.id == $route.params.idolId">{{e.message}}</strong>
          </div>
          <div v-for="e in content" :key="e.id">
            <strong id="money" class="f24 font-weight-700 mb4" v-if="e.id == $route.params.idolId">{{e.price}}<span class="f17 font-weight-700">&nbsp;포인트</span></strong>
          </div>
          <div class="flex" style="margin-top: 15px;" v-for="e in content" :key="e.id">
            <button type="submit" class="button-submit flex-box-80" style="font-weight:400 !important;" v-on:click="fund()" v-if="e.id == $route.params.idolId">포인트로 상품구매</button>
            <button type="submit" class="button-normal flex-box-20" v-bind:value="database" style="margin-left: 10px;" v-on:click="like()" v-if="e.id == $route.params.idolId">
              <i class="fa fa-thumbs-up"></i>&nbsp;{{e.like}}</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from '@/components/header'
import {Config} from '../js/config'

export default {
  components: {
    Header,
  },
  data () {
    return {
      database: {
        money: '100000',
        people: '14'
      },
      content: [
        {
          id: '1',
          name: '아이스 카페아메리카노 Tall',
          message: '리워드 포인트를 사용하여 원하는 상품을 구매하세요.',
          price: '4,100',
          desc: `강렬한 에스프레소 샷에 시원한 물의 조화. 풍부하고 진한 농도의 에스프레소에 시원한 정수물을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 부드럽지만 시원하게 즐기실 수 있는 커피입니다.`,
          like: '1'
        },
        {
          id: '2',
          name: '애플망고 치즈 설빙',
          message: '리워드 포인트를 사용하여 원하는 상품을 구매하세요.',
          price: '11,900',
          desc: `남녀노소 모두 좋아하는 망고의 최상급 품질인 애플망고의 달콤함과 깊고 진한 치즈 케이크가 만나 신선하고 상큼한 애플망고의 풍미를 온전히 느낄 수 있는 제품`,
          like: '2'
        },
        {
          id: '3',
          name: 'Intern net',
          message: 'Intern net 데뷔 앨범 제작 프로젝트에 참여해보세요!',
          price: '11,900',
          desc: `‘인턴넷'은 샴푸, 앤, 젬, 린다로 구성된 혼성 그룹이다. 현 시대에 빼놓고는 설명할 수 없는 internet을 모티브로 했으며, 언제 어디서나 생각나는 그룹이 되겠다는 의미를 담고있다. 대중들이 좋아할만한 솔직한 쉬운 멜로디와 사랑에 대한 현실적이면서 솔직한 노랫말 그리고 아크로바틱을 기반으로 한 동작이 큰 안무로 활동을 이어갈 계획이라고 밝혔으며 다양한 광고활동 또한 능히 감당할 수 있는 그룹이라고 자신있게 소개한다. 신인답지않은 여유로움을 가장 큰 매력으로 어필하고 있다.`,
          like: '3'
        },
        {
          id: '4',
          name: 'Gonjoy',
          message: 'Gonjoy 월드투어 포토북 프로젝트에 참여해보세요!',
          price: '11,900',
          desc: '',
          like: '4'
        },
        {
          id: '5',
          name: 'Front attack',
          message: 'Front Attack 데뷔 응원 프로젝트에 참여해보세요!',
          price: '11,900',
          desc: '',
          like: '5'
        },
        {
          id: '6',
          name: 'Morning Glory',
          message: 'Morning Glory 스페셜 화보집 프로젝트에 참여해보세요!',
          price: '11,900',
          desc: `아침 햇살같이 상큼한 멜로디로 ‘제 2의 아이유'를 꿈꾸고 있는 떠오르는 보컬. 청아한 목소리와 알 수 없는 강인함이 돋보이는 신인이다. 비공식 앨범 활동은 두 차례 진행한 것으로 알려졌으며, 소규모의 공연도 여러번 진행한 실력파로 알려져있다. 앞으로 많은 대중들에게 사랑받을 아티스트로 성장할 것이라는 평가가 계속해서 이어지고 있다.`,
          like: '6'
        },
      ]
    }
  },
  computed: {
    walletAddress() {
      return Config.walletAddress
    },
    apiKey() {
      return Config.dapp.apiKey
    },
    txActionName() {
      return Config.txActionName
    },
    userName() {
      return Config.userName
    }
  },
  mounted() {
    this.load()
  },
  methods: {
    load() {
      this.axios.get(`https://api.luniverse.io/tx/v1.0/histories?next=0`,{
        headers: {
          'Authorization': `Bearer ${this.apiKey}`,
          'Content-Type': `application/json`
        },
      })
        .then((response) => {
          var l = parseInt(this.database.like.replace(/,/g,""));
          var p = parseInt(this.database.people.replace(/,/g,""));
          var m = parseInt(this.database.money.replace(/,/g,""));
          var temp=response.data.data.histories.items.filter(valid => valid.txStatus==="SUCCEED" && ['funding', 'like'].indexOf(valid.actionName) !== -1);
          temp.map(tx => {
            if(tx.actionName === 'like'){
              l = l + 1;
            }
            else if(tx.actionName === 'funding'){
              p = p + 1;
              m = m + 10000;
            }
          })
          l = l.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.like = l;
          p = p.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.people = p;
          m = m.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.money = m;
        })
        .catch(() => {
        })
    },
    like(){
      let n = parseInt(this.database.like.replace(/,/g,""));
      this.axios.post(`https://api.luniverse.io/tx/v1.0/transactions/${this.txActionName.like}`,{ 
          'from': this.walletAddress.pd,
          'inputs' : {
            'receiverAddress': this.walletAddress.user,
            'valueAmount': '100000000000000000000'
          }
      },
      {
        headers: {
          'api-key': this.apiKey,
        }
      }
      )
        .then(() => {
          alert('좋아요를 눌러주셔서 감사합니다!\n100RWT를 드려요!');
          n = n + 1;
          n = n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.like=n;
        })
        .catch(() => {
          alert('좋아요에 실패했습니다!')
        });
    },
    fund(){
      let m = parseInt(this.database.money.replace(/,/g,""));
      let p = parseInt(this.database.people.replace(/,/g,""));
      this.axios.post(`https://api.luniverse.io/tx/v1.0/transactions/${this.txActionName.funding}`,{
            'from': this.walletAddress.pd,
            'inputs' : {
              'receiverAddress': this.walletAddress.user,
              'valueAmount': '1000000000000000000000'
            }
        }, 
        {
          headers: {
            'api-key': this.apiKey,
          },
        })
        .then(() => {
          alert(`10,000원이 펀딩되었습니다.\n1,000RWT를 드려요!`)
          m = m + 10000;
          m = m.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.money=m;
          p = p + 1;
          p= p.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          this.database.people=p;
        })
        .catch(() => {
          alert('Fund에 실패했습니다!')
        });
      
    }
  }
}
</script>

