<template>
    <el-form>
        <el-form-item>
            <h1>请！</h1>
        </el-form-item>
        <el-form-item label="文章标题">
            <el-input v-model="title" placeholder="不会有人忘记写标题吧"></el-input>
        </el-form-item>
        <el-form-item label="文章类别">
            <el-select class="groupSelect" v-model="classify" clearable placeholder="求求你选个类别吧">
                <el-option-group v-for="group in options" :key="group.label" :label="group.label">
                    <el-option v-for="item in group.options" :key="item.value" :label="item.label" :value="item.value"/>
                </el-option-group>
            </el-select>
        </el-form-item>
        <el-form-item>
            <Tinymce v-model="content" width="100%" />
        </el-form-item>
        <el-form-item class="btn">
            <el-button @click="submit">提交</el-button>
            <!--      <el-button @click="back">返回</el-button>-->
        </el-form-item>
    </el-form>


</template>
<script lang="ts" setup>
import {reactive, ref, onMounted, inject} from "vue";
import { ElMessage } from 'element-plus'
import Tinymce from "@/components/Tinymce/Tinymce.vue";
import request from "@/utils/request.js"
const uid = ref("7ad8996f6ba143f18a3d643806b688eb")
const title = ref('')
const classify = ref('')
const content = ref('')
const options = [
    {
        label: '前端',
        options: [
            {
                value: 'Vue',
                label: 'Vue',
            },
            {
                value: 'React',
                label: 'React',
            },
        ],
    },
    {
        label: '后端',
        options: [
            {
                value: 'Java',
                label: 'Java',
            },
            {
                value: 'Python',
                label: 'Python',
            },
        ],
    },
    {
        label: '随笔',
        options: [
            {
                value: '正事',
                label: '正事',
            },
            {
                value: '吐槽',
                label: '吐槽',
            },
            {
                value: '骚话',
                label: '骚话',
            },
            {
                value: '摘录',
                label: '摘录',
            },
        ],
    },
]
// 定义所要传给父组件的值
const show = ref<boolean>(false)

// 使用defineEmits注册一个自定义事件
const emit = defineEmits(["getValue"])

// 点击事件触发emit，去调用我们注册的自定义事件getValue,并传递value参数至父组件
const transValue = () => {

}
const init:any = inject("reload");
const submit = () => {
    let data = {"uid":uid.value,"title":title.value,"classify":classify.value,"content":content.value}
    request.post("/blog/add",data).then(res=>{
        ElMessage.success(res.msg)
        if(res.code==0){
            title.value='';
            classify.value='';
            content.value='';
            emit("getValue", show.value);
            init();
        }
    })
}
const back = () => {console.log("溜咯")}

onMounted(()=>{
    // userUid
})
</script>
<style>
.groupSelect{
    width: 100%;
}
.btn{
    color: #d30b40;
    position: absolute;
    right: 1.5%;
    top:94.5%
}
</style>