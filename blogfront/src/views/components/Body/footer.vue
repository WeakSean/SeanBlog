<template>
  <div class="endone">
    Powered by
    <p @click="toVue(vueUrl)" style="display: inline">Vue3 &</p>
    <p @click="toEle(eleUrl)" style="display: inline"> Element Plus</p>
    <br/>
    Copyright 1999-2023,SuperSean
  </div>
  <div class="endtwo">
    苏ICP备222016527号<br/>
    {{ nowTime }}
  </div>
</template>
<script lang="ts" setup>
import { ref,onMounted} from 'vue';
import  {formateDate } from './formatimeone'
const nowTime = ref("")
const vueUrl = "https://cn.vuejs.org/"
const eleUrl = "https://element-plus.gitee.io/zh-CN/"
const toVue = (e) => {window.location.href = e;}
const toEle = (e) => {window.location.href = e;}
onMounted(() => {
  setInterval(() => {
    nowTime.value = formateDate(new Date())
  })
})
</script>
<style>
.endone{
  text-align: left;
  position: absolute;
  color: #313131;
}
.endone a{
  text-decoration: none;
  color: #313131;
}
.endtwo{
  text-align: right;
  position: relative;
  color: #313131;
}
</style>