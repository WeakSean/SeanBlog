<template>
  <el-calendar v-model="value" >
    <template #date-cell="{ data }">
      <p :class="data.isSelected ? 'is-selected' : ''">
        {{ data.day.split('-').slice(2).join('-') }}
        {{ data.isSelected ? '✔️' : '' }}
      </p>
    </template>
  </el-calendar>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const value = ref(new Date())
</script>
<style>
.is-selected {
  color: #d30b40;
}
.el-calendar{
  background-color: #d30b40;
}
</style>