/**
 * Created by aixiaoai on 16/6/24.
 */

import Vue from 'vue'
import Constant from '../utils/Constant'


export default {
  authenticated: false,
  //检查是否已登录
  isLoggedIn() {
    //token
    var token = localStorage.getItem(Constant.tokenItem)
    //remember
    var remember = localStorage.getItem(Constant.remember)

    //记住登录且已登录且token不为空的情况下,判定已登录
    if (remember === "true" && token != null) {
      return true
    }

    if (this.authenticated && token != null) {
      return true
    }

    //其他情况都是未登录,跳转 登录页
    return false
  },
  //登录
  login(user, success, error) {
    Vue.http.post("login", user).then(response => {
      success(response)
    },response => {
      error(response)
    })
  },
  //注册
  register(user, success, error) {
    Vue.http.post("register", user).then(response => {
      success(response)
    },response => {
      error(response)
    })
  },
  //注销
  logout(success, error) {
    Vue.http.get("logout").then(response => {
      success(response)
    },response => {
      error(response)
    })
  },
  //获取当前用户
  current(success, error) {
    Vue.http.get("user").then(response => {
      success(response)
    }, response => {
      error(response)
    })
  }
}
