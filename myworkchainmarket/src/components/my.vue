<template>
  <div>
    <Header />
    <div class="pt-5">
      <!-- <div class="mypage-img"></div>
      <div class="py-5">
        <div class="wrapper py-xl-5">
          <div class="portfolio-caption">
            <div class="portfolio-caption t_white font-weight-500">
              <div class="h1 mb4">{{username}}</div>
            </div>
            <div class="portfolio-caption t_orange font-weight-500">
              {{balance}}
              <span class="h1 mb4 t_white">포인트</span>
            </div>
          </div>
        </div>
      </div> -->
    </div>
    <div class="container px-3">
      <div class="row justify-content-between">
        <div class="mb-3" style="margin-top: 6rem;">
          <h3>구매내역</h3>
        </div>
        <table class="tbl">
          <colgroup>
            <col style="width:20%" />
            <col style="width:40%" />
            <col style="width:10%" />
          </colgroup>
          <thead>
            <tr>
              <th scope="col">일시</th>
              <th scope="col">항목</th>
              <th scope="col">실행결과</th>
            </tr>
          </thead>
          <tbody>
            <tr v-bind:key="`${i}`" v-for="(history, i) in History">
              <td scope="row">{{history.time}}</td>
              <td>
                <time datetime>{{history.name.toUpperCase()}}</time>
              </td>
              <td>
                <time datetime v-bind:style="{color: history.color}">{{history.status}}</time>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/header";
import { Config } from "../js/config";
import BigNumber from "bignumber.js";

export default {
  components: {
    Header
  },
  data() {
    return {
      balance: 0,
      isLoading: false,
      username: Config.userName + "님, 안녕하세요.",
      History: []
    };
  },
  computed: {
    walletAddress() {
      return Config.walletAddress;
    },
    mtSymbol() {
      return Config.mt.symbol;
    },
    stSymbol() {
      return Config.st.symbol;
    },
    apiKey() {
      return Config.apiKey;
    },
    txActionName() {
      return Config.txActionName;
    }
  },
  mounted() {
    this.load();
  },
  methods: {
    load() {
      this.axios
        .get(
          `https://api.luniverse.io/tx/v1.0/wallets/${this.walletAddress.user}/${this.mtSymbol}/${this.stSymbol}/${this.txActionName.balance}`,
          {
            headers: {
              Authorization: `Bearer ${this.apiKey}`
            }
          }
        )
        .then(response => {
          this.balance = BigNumber(response.data.data.balance).div(
            BigNumber("10").pow(18)
          );
        })
        .catch(() => {
          this.balance = 0;
        });

      this.axios
        .get(`https://api.luniverse.io/tx/v1.0/histories?next=0`, {
          headers: {
            Authorization: `Bearer ${this.apiKey}`,
            "Content-Type": `application/json`
          }
        })
        .then(response => {
          var temp = response.data.data.histories.items.filter(
            valid =>
              (valid.txStatus === "SUCCEED" || valid.txStatus === "FAILED") &&
              ["funding", "like", "purchase"].indexOf(valid.actionName) !== -1
          );
          temp.map(tx =>
            this.History.push({
              time: tx.createdAt.substring(0, 10),
              name: tx.actionName,
              status: tx.txStatus
            })
          );
          this.History.map(history => {
            if (history.status === "SUCCEED") {
              history.color = "#00B580";
            } else if (history.status === "FAILED") {
              history.color = "#F14E4E";
            }
          });
        })
        .catch(() => {});
    }
  }
};
</script>