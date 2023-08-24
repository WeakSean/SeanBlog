import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'


// createApp(App).use(store).use(router).mount('#app')
const app = createApp(App)
 
// 引入 ElementPlus 插件(npm i element-plus)
import ElementPlusPlugin from '@/plugins/element-plus'
 
// 全局注册 ElementPlus 图标组件(npm install @element-plus/icons-vue)
import * as ElementPlusIcons from '@element-plus/icons-vue'
for(const [key, component] of Object.entries(ElementPlusIcons)) {
  app.component(key, component)
}

//全局注册svgIcon
// import SvgIcon from '../src/components/svgIcon/index.vue'
// app.component('svg-icon', SvgIcon)

//在 main.ts 文件引入HTTP请求工具并配置为全局方法
// import UserManage_Api from '@/api/UserManage/index'
// app.config.globalProperties.$http = {
//   ...UserManage_Api,
// }
// app.config.globalProperties.$axios = axios

 
app.use(store)
app.use(router)
app.use(ElementPlusPlugin)
app.mount('#app')
