/**
 * Created by aixiaoai on 16/7/11.
 */
import Vue from 'vue'
import auth from '../api/auth'
import { router } from '../../../main'
import * as types from './mutation-types'
import Constant from '../utils/Constant'

//登录action
export const login = ({ dispatch, state }, user, remember) => {
  //调用登录api
  auth.login(user,
    response => {
      if ( response.data.code === 0 ) {
        // 已登录
        auth.authenticated = true

        //保存token
        localStorage.setItem(Constant.tokenItem, response.data.data)

        //保存remember
        localStorage.setItem(Constant.remember, remember)

        Vue.http.headers.common['Authorization'] = response.data.data

        //登录成功跳转到主页面
        router.go({ path: '/main' })
      } else {
        toastr.error(response.data.message)
      }
    },
    response => {
      toastr.error(response.data)
    })
}

//注销
export const logout = ({ dispatch, state  }) => {
  //调用注销api
  auth.logout( response => {
    auth.authenticated = false
    localStorage.removeItem(Constant.tokenItem)
    Vue.http.headers.common['Authorization'] = ''
    router.go({ path: '/login' })
  }, response => {

  })
}

//注册
export const register = ({ dispatch, state }, user) => {

  auth.register(user, response => {
    if (response.data.code === 0) {
      toastr.success('注册成功!')
      //切换界面
      jQuery('.login-form').show();
      jQuery('.register-form').hide();
    }
  },response => {

  })

}

//获取当前用户
export const currentUser = ({ dispatch, state }) => {
  auth.current(response => {
    dispatch(types.USER_CURRENT, response.data.data)
  }, response => {

  })
}
