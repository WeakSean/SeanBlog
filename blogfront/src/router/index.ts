import {createRouter, createWebHashHistory, RouteRecordRaw, RouterOptions} from 'vue-router'
import index from '../views/index.vue'
import origin from '../views/origin.vue'
// route level code-splitting
// this generates a separate chunk (about.[hash].js) for this route
// which is lazy-loaded when the route is visited.
const routes: Array<RouteRecordRaw> = [
  //登录界面
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login/login.vue')
  },
  //主页
  {
    path: '/',
    name: 'home',
    component: origin
  },
  //初始页面
  {
    path: '/origin',
    name: 'origin',
    component: () => import('../views/origin.vue')
  },
  //日历测试
  {
    path: '/calendar',
    name: 'calendar',
    component: () => import('../views/components/Body/calendar.vue')
  },
  //页脚测试
  {
    path: '/footer',
    name: 'footer',
    component: () => import('../views/components/Body/footer.vue')
  },
  //编辑器测试
  {
    path: '/editor',
    name: 'editor',
    component: () => import('../views/components/Body/editor.vue')
  },
  //菜单测试
  {
    path: '/menu',
    name: 'menu',
    component: () => import('../views/components/Menu/menu.vue')
  },
  //博客列表
  {
    path:'/list',
    name:'list',
    component:() => import('../views/blog/list.vue')
  },
  //博客详情
  {
    path:'/detail',
    name:'detail',
    component:() => import('../views/blog/detail.vue')
  },
  //新主页
  {
    path:'/main',
    name:'main',
    component:() => import('../views/index/mainIndex.vue')
  },
  //新主页
  {
    path:'/roster',
    name:'roster',
    component:() => import('../views/roster/index.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top:0 }
    }
  }
}as RouterOptions)

// 全局
// router.beforeEach((to, from, next) => {
//   console.log("to",to)
//   console.log("from",from)
//   console.log("next",next)
//   document.body.scrollTop = 100;
//   document.documentElement.scrollTop = 100;
//   next();
// });

export default router
