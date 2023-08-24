<template>
    <el-container class="container">
        <el-header class="header">
            <Statistic></Statistic>
        </el-header>
        <el-main class="main">

        </el-main>
    </el-container>
</template>

<script setup lang="ts">
import Statistic from "@/views/homepage/statistic.vue";

</script>

<style scoped>
.container{

    align-items: center;
    justify-content: center;
}
.header{
    position: relative;
    top: 5vh;
    width: 60%;
    height: auto;
}
</style>