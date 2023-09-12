<template>
    <el-carousel :interval="4000" type="card" height="200px" indicator-position="none">
        <el-carousel-item v-for="item in 6" :key="item">
            <h3 text="2xl" justify="center">{{ item }}</h3>
        </el-carousel-item>
    </el-carousel>
</template>

<script lang="ts" setup>
import {onMounted} from "vue";
import request from "@/utils/request";

function initHead():any{
    request.post(
        "/annex/getPhotoByRecent",
        {}
    ).then(res=>{
        console.log("res",res);
    })

}

onMounted(() => {
    initHead();
})
</script>


<style scoped>
.el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
    text-align: center;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
}
</style>