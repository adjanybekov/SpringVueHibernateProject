import Vue from 'vue'
import App from './App.vue'
// import Home from './Home.vue';
import VueRouter from '../vue-router';
import {routes} from './routes';

// Vue.component('my-component',Home)
Vue.use(VueRouter);
const router = new VueRouter({
  routes, // short for `routes: routes`,
  mode:'history'
})



new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
