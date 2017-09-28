/**
 * Created by aixiaoai on 16/7/11.
 */

import Vue from 'vue'
import {
  USER_REGISTER,
  USER_LOGIN,
  USER_LOGOUT,
  USER_CURRENT
} from '../mutation-types'

const state = {
  user: {
    id: "",
    userName: "",
    password: "",
    fullName: "",
    email: "",
    address: "",
    city: "",
    country: ""
  }
}

const mutations = {
  [USER_CURRENT] (state, user) {
    state.user = user
  }
}

export default {
  state,
  mutations
}
