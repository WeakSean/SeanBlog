<template>
<el-container>
  <el-main>
    <el-row type="flex" justify="center" align="middle">
      <el-col :span="20">
        <el-card class="logincard" :body-style="{ padding: '0px' }">
          <img class="loginimg" src="../assets/login/login-1.jpeg" />
          <div class="loginform">
            <el-form :model="loginData" label-width="120px">
              <el-form-item label="昵称">
                <el-input v-model="loginData.username" />
              </el-form-item>
              <el-form-item label="密码">
                <el-input v-model="loginData.password" type="password" show-password/>
                <div>
                <el-button type="success" text @click="login">登录</el-button>
                <el-button type="success" text @click="centerDialogVisible = true">注册</el-button>
                </div>
              </el-form-item>
<!--              <el-form-item class="btn">-->
<!--                -->
<!--              </el-form-item>-->
            </el-form>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </el-main>
</el-container>
<el-dialog v-model="centerDialogVisible" title="注册" width="30%" scroll-lock=false align-center>
  <el-form :model="data" label-width="120px">
    <el-form-item label="昵称">
      <el-input v-model="data.username" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="data.password" />
    </el-form-item>
    <el-form-item label="性别">
      <el-radio-group v-model="data.gender">
        <el-radio label="男" />
        <el-radio label="女" />
        <el-radio label="阴阳人通道" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="个人简介">
      <el-input v-model="data.profile" type="textarea" placeholder="这个B好勾八懒" />
    </el-form-item>
  </el-form>
  <template #footer>
    <span class="dialog-footer">
      <el-button @click="logon">注册咯</el-button>
      <el-button @click="centerDialogVisible = false">溜了溜了</el-button>
    </span>
  </template>
</el-dialog>
</template>
<script>
import request from "../utils/request.js"
import { ElMessage } from 'element-plus'
import router from "@/router";
export default {
  data(){
    return{
      data:{},
      loginData:{},
      centerDialogVisible:false
    }
  },
  mounted() {
    localStorage.clear();
  },
  methods:{
    logon(){
      request.post("/user/add",this.data).then(res =>{
        ElMessage.success(res.msg);
      });
    },
    login(){
      request.post("/user/login",this.loginData).then(res =>{
        if(res.code === 0){
          ElMessage.success(res.msg);
          localStorage.setItem("token",res.token);
          localStorage.setItem("username",res.username);
          router.push("/");
        }
        if(res.code===500){
            ElMessage.error(res.msg);
        }
      })
    }
  }
}
</script>
<style scoped>
.el-container{
  height: 100vh;
  background-color: rgb(88, 116, 80);
}
.el-main{
  height: 100vh;
}
.el-row{
  height: 100%;
}
.logincard{
  width: 100%;
  position: relative;
  border: 0px;
}
.loginimg{
  width: 50%;
  height: 100%;
  margin: 0px 0px;
  float: left;
}
.loginform{
  width: 50%;
  height: 100%;
  float: left;
  align-items: center;
  position: absolute;
  left: 47%;
  top: 37%;
  /* height: 60%; */
}
.el-form{
  height: 100%;
}
.el-input{
  width: 91%;
}
/*.btn{*/
/*    */
/*}*/
/* .el-popup-parent--hidden {
    width: calc(100%-20px) !important;
} */
</style>