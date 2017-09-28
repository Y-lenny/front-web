import Vue from 'vue'
import Router from 'vue-router'
import Resource from 'vue-resource'
import store from './assets/js/vuex/store'
import { routerConfig } from './routerConfig'
import { initDirective } from './assets/js/directives/mainDirective'


//加载css
require("assets/js/metronic.config.css")
//加载js
require("assets/js/metronic.config.plugins")

const App = Vue.extend({
  store,
  replace: false,
  template: '<router-view :is="view" transition="fade" transition-mode="out-in" keep-alive></router-view>'
})

//使用路由
Vue.use(Router)

//设置路由选项
export const router = new Router({
  transitionOnLoad: true,
  history: true,
  saveScrollPosition: true
})

//配置路由
routerConfig(router)

//使用Resource
Vue.use(Resource)
Vue.http.options.root = 'http://localhost/api'

var token = localStorage.getItem("user_token")
if (token != null) {
  Vue.http.headers.common['Authorization'] = token
}


initDirective(Vue)


//开启路由
router.start(App, "body");
