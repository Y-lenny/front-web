/**
 * Created by aixiaoai on 16/6/19.
 */
import auth from 'assets/js/api/auth'

export function routerConfig(router) {

  router.map({
    //登录页
    '/login': {
      component: function (resolve) {
        require(['./components/login/Login.vue'], resolve)
      }
    },
    //主页面
    '/main': {
      component: function (resolve) {
        require(['./components/main/MainContent.vue'], resolve)
      }
    },
    '*path': {
      component: function (resolve) {
        require(['./components/other/404.vue'], resolve)
      }
    }
  })

  router.redirect({ '*': '/login' })

  router.beforeEach(function ({ to, next, redirect }) {

    //如果不是登录页,则验证是否已登录
    if ( to.path !== "/login" ) {
      //是否已登录
      if (!auth.isLoggedIn()) {
        redirect({ path: '/login' })
      }
    } else {
      
      //如果是登录页,则验证是否已登录,已登录的话直接进入/main
      if (auth.isLoggedIn()) {
        redirect({ path: '/main' })
      }
    }

    next()
  })
}
