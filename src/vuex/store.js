import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);
const state = {
  loginName: ""
};
const mutations = {
  updateLoginName(state, name) {
    state.loginName = name;
  }
};
export default new Vuex.Store({
  state,
  mutations
});
