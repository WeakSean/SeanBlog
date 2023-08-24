<template>
    <div class="common-layout">
        <el-container class="container">
            <el-container>
                <el-aside class="aside">
                    <Aside></Aside>
                </el-aside>
                <el-main class="main">
                    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
                        <el-tab-pane label="首页" name="first">
                            <Homepage></Homepage>
                        </el-tab-pane>
                        <el-tab-pane label="日志" name="second">
                            <Blog></Blog>
                        </el-tab-pane>
                        <el-tab-pane label="相册" name="third">
                            <Album></Album>
                        </el-tab-pane>
                        <el-tab-pane label="设置" name="fourth">
                            Task
                        </el-tab-pane>
                    </el-tabs>
                </el-main>
            </el-container>
            <el-footer class="footer">
                <Footer></Footer>
            </el-footer>
        </el-container>
    </div>
</template>

<script lang="ts" setup>
import Aside from '@/views/aside/index.vue'
import Homepage from '@/views/homepage/index.vue'
import Blog from '@/views/blog/index.vue'
import Album from '@/views/album/index.vue'
import Footer from '@/views/footer/index.vue'
import { ref } from 'vue'
import type { TabsPaneContext } from 'element-plus'

const activeName = ref('first')

const handleClick = (tab: TabsPaneContext, event: Event) => {
    // console.log(tab, event)
}
</script>
<style scoped>
.container{
    height: auto;
    background-color: #EDEDED;
}
.aside{
    width: 10%;
    height: 95vh;
    background-color: #86908A;
}
.main{
    height: 95vh;
}
.footer{
    height: 5vh;
    align-items: center;
    justify-content: center;
}
.demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #86908A;
    font-size: 32px;
    font-weight: 600;
}
</style>