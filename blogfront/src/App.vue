<template>
   <div>
    <router-view />
  </div>
</template>
<script lang="ts">
  
</script>
<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

.el-tabs__item:hover {
    color: #6B8770 !important;
}
.el-tabs__item.is-active{
    color: #6B8770 !important;
}
.el-tabs__active-bar{
    background-color: #6B8770 !important;
}
.el-pagination button{
    background-color: transparent !important;
}
.el-pager li{
    background-color: transparent !important;
}

</style>
