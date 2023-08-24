<template>
    <el-container class="container">
        <el-header class="header">
            <div class="title">
                <h1>{{data.title}}</h1>
                <p>
                    <el-icon><EditPen /></el-icon>&nbsp;发表于{{format(data.createTime)}}
                    &nbsp;&nbsp;|&nbsp;&nbsp;
                    <el-icon><Edit /></el-icon>&nbsp;修改于{{format(data.updateTime)}}
                </p>
            </div>
        </el-header>
        <el-main class="main">
            <el-row>

            </el-row>
            <div class="content" v-html="data.content"></div>
        </el-main>
        <el-footer>

        </el-footer>
    </el-container>
</template>

<script lang="ts" setup>
import {computed, onMounted, ref, toRefs, watch} from 'vue'
import request from "@/utils/request.js"
import { useRoute } from 'vue-router'
import {format} from "@/views/components/Body/formatimetwo";


const route = useRoute()
const data = ref({
    "id":Number,
    "title":String,
    "classify":String,
    "content":String,
    "createTime":String,
    "updateTime":String,
})
const getData =()=>{
    request.post(
        "/blog/getDetailById",
        {
            id:route.query.id
        }
    ).then(res=>{
        data.value = res.data
        return data.value;
    })
}
onMounted(() => {
    getData()
});


</script>
<style scoped>
.header{
    height: 30vh;
    background-image: url("../../assets/blog/water.jpg");
    background-size: 100%;
    width: 100%;
    display:flex;
    justify-content: center;
    align-items:center;
}
.title{
    width: 80%;
    line-height: 3vh;
    /*color: #eee;*/
    background: rgba(255,255,255,0);
    border-radius: 20px;
}
.title h1{
    font-size: 3rem;
}
.title p{
    font-size: 14px;
}
.main{
    background-color: #EDEDED;
    height: 100vh;
    display:flex;
    justify-content: center;
    /*align-items:center;*/
}
.content{
    width: 50%;
    height: auto;
    font-size: 1.6rem;
    border-radius: 20px;
    border: 1px solid #c0c0c0;
}

</style>