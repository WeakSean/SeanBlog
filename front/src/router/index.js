import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Index
  },
  {
    path: '/star',
    name: '/star',
    component: ()=> import('@/views/index/components/typer.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
