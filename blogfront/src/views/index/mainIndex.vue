<template>
    <div class="common-layout">
        <el-container class="container">
            <el-header class="header">
                <Header/>
            </el-header>
            <el-container class="childContainer">
                <el-aside class="aside">
<!--                    <Aside></Aside>-->
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
                        <el-tab-pane label="花名册" name="fourth">
                            <Roster></Roster>
                        </el-tab-pane>
                    </el-tabs>
                </el-main>
                <el-aside class="aside">
                    <!--                    <Aside></Aside>-->
                </el-aside>
            </el-container>
<!--            <el-footer class="footer">-->
<!--                <Footer></Footer>-->
<!--            </el-footer>-->
        </el-container>
    </div>
</template>

<script lang="ts" setup>
import Header from '@/views/header/index.vue'
import Aside from '@/views/aside/index.vue'
import Homepage from '@/views/homepage/index.vue'
import Blog from '@/views/blog/index.vue'
import Album from '@/views/album/index.vue'
import Footer from '@/views/footer/index.vue'
import Roster from '@/views/roster/index.vue'
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
.childContainer{
    //margin-top: 5vh;
}
.affix{
    width: 100vw;
    height: 5vh;
}
.header{
    //position: absolute;
    //bottom: -5vh;
    position: sticky;
    top: 0;
    z-index: 9;
    width: 100%;
    height: 5vh;
    padding: 0 0;
    align-items: center;
    justify-content: center;
}
.aside{
    width: 15%;
    height: 200vh;
    background-color: #86908A;
}
.main{
    width: 100vw;
    height: 200vh;
}
.footer{
    position: absolute;
    bottom: -100vh;
    width: 100%;
    height: 7vh;
    padding: 0 0;
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