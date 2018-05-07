// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
import store from "./vuex/store";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
Vue.config.productionTip = false;
Vue.use(ElementUI);
/* eslint-disable no-new */

// const router = () => import('./router')

router.beforeEach((to, from, next) => {
  if( to.name=='demo' && store.state.loginName == 'fq'){
      // router.push({name: 'login'});
      // this.$router.push('/')
      // window.location='login'
      next('/login')
      console.log(from.name)
      console.log()
      
      // next('/login');
      console.log(1)
  }
  next();
});

new Vue({
  el: "#app",
  router,
  store,
  components: {
    App
  },
  template: "<App/>"
});
