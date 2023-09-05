<template>
    <el-container class="container">
        <el-header class="header">
            <div class="box">
                <Statistic></Statistic>
            </div>
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
    width: 80%;
    height: 30vh;
}
.box{
    padding: 50px;
    border: 1px solid var(--el-border-color);
    border-radius: 4px
}
</style>