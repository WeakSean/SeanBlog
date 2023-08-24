<template>
    <el-container class="container">
        <el-main>
            <div class="main" v-for="(item,index) in blogList" :key="item.id">
                <div class="info" @click="getDetail(item)">
                    <div class="content">
                        <h2 class="title">{{item.title}}</h2>
<!--                        <p class="time">{{formatTime(item.createTime)}}</p>-->
                    </div>
                    <div class="classify">
                        <p>{{item.classify}}</p>
                    </div>
                </div>
            </div>
        </el-main>
        <el-footer class="footer">
            <el-pagination class="pagination" layout="prev, pager, next" :total="total" @current-change="pageChange"/>
        </el-footer>
    </el-container>

</template>

<script lang="ts" setup>
import {onMounted, reactive, ref} from 'vue'
import request from "@/utils/request.js"
import {formatTime} from "@/views/components/Body/formatimetwo";
import Detail from "@/views/blog/detail.vue"
import { useRouter } from "vue-router"
const router = useRouter()

const babyId = ref(1)
const blogList = ref([])
const showDetail = ref(false)
const total = ref(0)
const page = reactive({
    pageNum: 1,
    pageSize: 10,
});
const blogWrapper = reactive({
    title:"",
    classify:""
})
const pageChange = (val) => {
    page.pageNum = val;
    getBlogByPage()
}
const getBlogByPage = () =>{
    request.post(
        "/blog/page",
        {
            pageNum:page.pageNum.toString(),
            pageSize:page.pageSize.toString(),
            title:blogWrapper.title,
            classify:blogWrapper.classify
        }
    ).then(res=>{
        // console.log(res.data);
        blogList.value = res.data.records;
        total.value = res.data.total;
        // return blogList.value;
    })
}
const getDetail=(item)=>{
    router.push({
        path: '/detail',
        query: {
            id: item.id
        }
    })
}
onMounted(() => {
    getBlogByPage()
});

</script>
<style scoped>
.container{
    height: 100%;
    position: relative;
}
/*.main{*/
/*    background-color: #d9edf7;*/
/*}*/
.header{
    background-color: transparent;
}
.main{
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;

    //overflow: hidden;
}
.el-main{
    padding-top: 60px;
    height: 100%;
}
.info{
    overflow: hidden;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
    transition: all 0.2s;
    //margin: auto;
    margin-top: -60px;
    border-radius: 10px;
    width: 70%;
    height: 10vh;
    /*background-color: #b1c5b4;*/
    background-color: #6B8770;
    color: #FFFFFF;
}
.info:hover{
    background-color: #657a69;
    margin-top: 30px;
    transform: translateY(-40px) scale(1.01,1.01);
    box-shadow: 0 10px 20px rgba(0,0,0,0.3);
}
.info:first-child{
    padding-top: 1vh;
}
.title{
    font-size: 1.8rem;
}
.content{
    float: left;
    text-align: left;
    margin-left: 1vw;
}
.classify{
    float: right;
    writing-mode: vertical-lr;
    //height: 100%;
    color: #FFFFFF;
    border-radius: 20px;
    background-color: #719847;
}
.footer{
    //width: 100%;
    //position: absolute;
    //bottom: 0;
    //overflow: hidden;
}
.pagination{
    display: flex;
    align-items: center;
    justify-content: center;
}



</style>