<template>
  <div class="total">
    <div class="title">
      <el-button type="info" text @click="login">登录</el-button>
      <el-button type="info" text @click="logout">退出</el-button>
    </div>
    <div class="common-layout">
      <el-container>
        <el-header>
          <el-menu
              :default-active="activeIndex"
              active-text-color="#ffd04b"
              background-color="#545c64"
              text-color="#fff"
              class="el-menu-vertical-demo"
              mode="horizontal"
              @select="handleSelect"
          >
            <el-menu-item index="1" @click="showIndex">首页</el-menu-item>
            <el-menu-item index="2" @click="showBlog">日志</el-menu-item>
            <el-menu-item index="3" @click="showPhoto">相册</el-menu-item>
          </el-menu>
        </el-header>
        <el-container id="main">
          <el-aside>
<!--            <calendar/>-->
          </el-aside>
          <el-main>
            <div v-if="type==='A'"><Profile/></div>
            <div v-else-if="type==='B'">
              <el-input v-model="search" placeholder="Please input" />
              <el-button type="info" text @click="openEditor">写文章</el-button>
              <el-dialog v-model="dialogVisible" title="文章" width="80%">
                <Editor :userUid="userInfo.uid"/>
              </el-dialog>
              <el-divider />
              <Bloglist  />
            </div>
            <div v-else-if="type==='C'"><h1>相册</h1></div>
          </el-main>
          <el-aside>
            <img class="avatar" src="../assets/avatar.jpg"/>
            <div class="userinfo">
              {{userInfo.username}}
              <br/><br/><br/>
              {{userInfo.profile}}
            </div>
          </el-aside>
        </el-container>
        <el-footer>
          <Footer/>
        </el-footer>
      </el-container>
    </div>
  </div>
</template>
<script lang="ts" setup>
import {ref, onMounted, reactive, watch} from 'vue'
import router from "@/router"
import request from "@/utils/request.js"
import Profile from "@/views/components/Body/profile.vue"
import Editor from "@/views/components/Body/editor.vue"
import Footer from "./components/Body/footer.vue"
import Bloglist from "@/views/components/Blog/list.vue";

const activeIndex = ref('1')
const search = ref('')
const type = ref('A')
const dialogVisible = ref(false)
const username = localStorage.getItem("username")
const userInfoWrapper = {"username":username}
const userInfo = reactive({"id":0,"uid":"","username":"游客sama","profile":"快说你是谁！！！"})
const handleSelect = (key: string, keyPath: string[],type) => {
  // console.log(key, keyPath)
}
const showIndex = () =>{type.value='A'}
const showBlog = () =>{type.value='B'}
const showPhoto = () =>{type.value='C'}

const login = () => {router.push("/login")}
const logout = () =>{localStorage.clear();location.reload()}
const openEditor =()=>{dialogVisible.value = true};
const getInfoByUserName = () =>{
  request.post("/user/getInfoByUserName",userInfoWrapper).then(res=>{
    userInfo.id = res.data.id;
    userInfo.uid = res.data.uid;
    userInfo.username = res.data.username;
    userInfo.profile = res.data.profile;
    return userInfo;
  })
}
onMounted(() => {
  if(userInfoWrapper.username!=""&&userInfoWrapper.username!=null){
    getInfoByUserName()
  }

});
</script>
<style scoped lang="less">
//@maincolor:#fbfae9;
//@maincolor: #545c64;
@maincolor: #FFFFFF;
.total{
  background-color: #6e6e6e;
  height: 100vh;
}
.title{
  height: 5vh;
  line-height: 5vh;
  font-size: 25px;
  text-align: right;
  text-decoration: none;
}
.el-container{
  height: 95vh;
}
.el-header{
  //display: flex;
  margin: 7px 7px;
  //justify-content:center;
  border-radius:16px;
  background-color: #545c64;
}
//.el-menu {
//  background-color: #ffffff;
//}
.el-menu--horizontal{
  border-bottom:solid 0px;
}
.el-menu-demo{
  width: 100%;
}
.el-aside{
  position: relative;
  width: 18%;
  height: 77%;
  margin: 7px 7px;
  border-radius:16px;
  background-color:@maincolor;
  color: var(--el-text-color-primary);
}
.el-aside .avatar{
  width: 50%;
  height: auto;
  border-radius:50%;
  overflow:hidden;
  position: absolute;
  top: 10%;
  left: 25%;
  transition: transform 1.5s ease-out;
  box-shadow: 0.3em 0.3em 1em rgba(132,133,137,0.4);  
}
.el-aside .avatar:hover{
  transform: rotateZ(360deg);
}
.el-aside .userinfo{
  margin-top: 85%;
}
.el-main{
  height: auto;
  margin: 7px 7px;
  border-radius: 16px;
  background-color: @maincolor;
}
//.el-dialog{
//  width:80%
//}
.el-footer{
  position: relative;
}
.el-footer .endone{
  text-align: left;
  // color: aliceblue;
  position: absolute;
}
.el-footer .endone a{
  text-decoration: none;
  color: #000;
}
.el-footer .endtwo{
  text-align: right;
  position: relative;
}
.html{
  height: 100%;
}
.body{
  height: 100%;
}
</style>