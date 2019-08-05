<template>
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container-fluid px-3">
      <router-link class="navbar-brand text-big font-weight-700 line-height-1 py-3" :to="{ name: 'home' }">MyWorkChain 마켓</router-link>

      <div class="navbar-collapse" id="landing-navbar-collapse">
        <div class="navbar-nav align-items-lg-center ml-lg-4">
          <router-link class="nav-link font-weight-700" :class="{selected: $route.path.indexOf('product') !== -1}" :to="{ name: 'product' }">Product</router-link>
        </div>
        <div class="navbar-nav align-items-lg-center ml-auto">
          <div class="nav-item">
            <router-link class="btn btn-outline-white btn-round" :to="{ name: 'my' }">
              <i v-if="compUserName" class="fa fa-user" />{{username}}
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
  import {Config} from '../js/config'
  export default{
    data () {
      return {
        username : Config.userName ? Config.userName + ' 님' : 'My Page'
      }
    },
    computed:{
      compUserName() {
        return Config ? Config.userName : false
      }
    }
  }
</script>