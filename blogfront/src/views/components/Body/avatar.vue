<template>
    <div class="demo-type">
        <el-avatar :src="url" :key="url"/>
    </div>
</template>
<script>
const url="@/assets/avatar.jpg"
</script>
<style scoped>
.demo-type {
  display: flex;
}
.demo-type > div {
  flex: 1;
  text-align: center;
}

.demo-type > div:not(:last-child) {
  border-right: 1px solid var(--el-border-color);
}
</style>