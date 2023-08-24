<template>
    <el-row>
        <el-col :span="6">

        </el-col>
        <el-col :span="10">
            <el-input></el-input>
        </el-col>
        <el-col :span="2">
            <el-button class="search" type="success">查询</el-button>
        </el-col>
        <el-col :span="2">
            <el-button class="search" type="info" @click="openEditor">撰文</el-button>
        </el-col>
        <el-col :span="4">

        </el-col>
    </el-row>
    <el-row class="main">
        <List v-if="isRouterAlive"/>
        <el-dialog v-model="showEditor">
            <Add @getValue="getSonValue"/>
        </el-dialog>

    </el-row>
</template>

<script lang="ts" setup>
import List from '@/views/blog/list.vue'
import Add from '@/views/blog/add.vue'
import {inject, nextTick, provide, ref} from 'vue'
// 局部组件刷新
const isRouterAlive = ref(true);
const reload = () => {
    isRouterAlive.value = false;
    nextTick(() => {
        isRouterAlive.value = true;
    });
};
provide("reload", reload);

const showEditor = ref(false)
const openEditor=()=>{
    showEditor.value = true;
}

const getSonValue = (show: boolean) => {
    showEditor.value = show
}

</script>

<style scoped>
.search{
    width: 90%;
}
.main{
    margin-top: 2vh;
    height: 100%;
    display: flex;
    /*background-color: #b1c5b4;*/
}

</style>