<template>
    <div class="head">
        <el-row>
            <el-col :span="8"></el-col>
            <el-col :span="8"></el-col>
            <el-col :span="8">
                <div class="user">
                    <el-avatar class="avatar" :size="35" v-if="userInfoWrapper.username"/>
                    <el-text class="userInfo" v-if="userInfoWrapper.username">{{userInfoWrapper.username}}</el-text>
                    <el-text class="userInfo" v-if="userInfoWrapper.username">个人中心</el-text>
                    <el-text class="userInfo" v-if="userInfoWrapper.username" @click="logout">退出</el-text>
                    <el-text class="userInfo" v-if="!userInfoWrapper.username" @click="login">登录</el-text>
<!--                    <el-text class="userInfo" v-if="true">注册</el-text>-->
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts" setup>
import router from "@/router";
import {ref} from "vue";

const userInfoWrapper = {"username":localStorage.getItem("username")}
const login = () =>{
    router.push("/login");
}

const logout = () =>{
    localStorage.clear();
    location.reload();
}

</script>

<style scoped>
.head{
    width: 100%;
    height: 100%;
    background-color: #5d635e;
}
.user{
    height: 5vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
.avatar{

}
.userInfo{
    margin-left: 1vw;
    color: #EDEDED;
}
</style>