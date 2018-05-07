import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);
const state = {
  loginName: "fq"
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
