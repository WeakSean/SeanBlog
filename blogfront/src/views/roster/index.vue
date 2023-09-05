<template>
    <div>
        <el-button @click="openForm">
            录入
        </el-button>
        <el-dialog v-model="showForm" width="36%" class="dialog" title="身份信息录入" :draggable="true">
            <template #header="{ titleId, titleClass }">
                <div class="my-header">
                    <h4 :id="titleId" :class="titleClass">这里可以录入信息</h4>
                    <el-divider/>
                </div>
            </template>
            <Form @getValue="getSonValue"></Form>
        </el-dialog>
    </div>
</template>

<script lang="ts" setup>
import Form from "@/views/roster/form.vue"
import {ref} from "vue";

const showForm = ref(false);
const openForm = () =>{
    showForm.value = true;
}

const sonMessage = ref<string>("")
const getSonValue = (show: boolean) => {
    showForm.value = show;
}
</script>
<style scoped>
.dialog{
    align-items: center;
    text-align: center;
    max-width: 70%;
}
</style>