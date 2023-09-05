<template>
<!--  <div class="endone">-->
<!--    Powered by-->
<!--    <p @click="toVue(vueUrl)" style="display: inline">Vue3 &</p>-->
<!--    <p @click="toEle(eleUrl)" style="display: inline"> Element Plus</p>-->
<!--    <br/>-->
<!--    Copyright 1999-2023,SuperSean-->
<!--  </div>-->
<!--  <div class="endtwo">-->
<!--    苏ICP备222016527号<br/>-->
<!--    {{ nowTime }}-->
<!--  </div>-->
    <div class="foot">

    </div>
</template>
<script lang="ts" setup>
import { ref,onMounted} from 'vue';
import  {formateDate } from '@/views/components/Body/formatimeone'
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
.foot{
    width: 100%;
    height: 100%;
    background-color: #86908A;
}
</style>