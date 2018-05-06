import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import demo from '@/components/demo'
import login from '@/components/login'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/d',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'demo',
      component: demo
    },
    {
      path: '/login',
      name: 'login',
      component: login
    }
  ]
})
