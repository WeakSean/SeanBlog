<template>
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
</template>

<script>

</script>

<style scoped>

</style>