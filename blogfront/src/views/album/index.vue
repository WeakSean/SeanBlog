<template>
    <div class="content">
        <div class="choose">
            <el-upload
                ref="uploadRef"
                multiple
                action="/"
                :auto-upload="false"
                :show-file-list="true"
                :on-change="handleChange"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                :on-exceed="handleExceed"
            >
                <el-button type="primary">选择文件</el-button>
            </el-upload>
        </div>
        <div class="confirm">
            <el-button type="success" @click="uploadFile">上传文件</el-button>
        </div>
    </div>

</template>
<script lang="ts" setup>
import { ref } from 'vue'
import {ElMessage, ElMessageBox, UploadInstance, UploadProps, UploadUserFile} from 'element-plus'
import request from "@/utils/request.js"
import * as url from "url";
import axios from "axios";
const fileList = ref()
const uploadRef = ref<UploadInstance>()
const handleChange=(file,uploadFiles) =>{
    fileList.value =uploadFiles;
}

const handleRemove: UploadProps['onRemove'] = (file, uploadFiles) => {
    console.log(file, uploadFiles)
}

const handlePreview: UploadProps['onPreview'] = (uploadFile) => {
    console.log(uploadFile)
}

const handleExceed: UploadProps['onExceed'] = (files, uploadFiles) => {
    ElMessage.warning(
        `The limit is 3, you selected ${files.length} files this time, add up to ${
            files.length + uploadFiles.length
        } totally`
    )
}

const beforeRemove: UploadProps['beforeRemove'] = (uploadFile, uploadFiles) => {
    return ElMessageBox.confirm(
        `Cancel the transfer of ${uploadFile.name} ?`
    ).then(
        () => true,
        () => false
    )
}

const uploadFile=()=>{
    console.log("list",fileList);
    if(fileList.value == undefined){
        ElMessage({
            message: "未选择上传的文件，上传了个空气",
            type: 'error',
        })
        return;
    }
    let fd = new FormData();
    if (fileList.value.length > 0){
        for(let i=0;i<fileList.value.length;i++){
            fd.append("multipartFile",fileList.value[i].raw)
        }
    }
    let method = 'post';
    let url = '/api/annex/upload';
    const headers = {"Content-Type": "multipart/form-data"}
    axios({
        method,
        url,
        data:fd,
        headers:headers,
    }).then(res=>{
        if(res.data.code == 0){
            ElMessage({
                message: res.data.msg,
                type: 'success',
            })
        }else if(res.data.code == 1){
            ElMessage({
                message: res.data.msg,
                type: 'error',
            })
        }
    }).finally(()=>{
        fileList.value.length = 0;
        uploadRef.value!.clearFiles();
    })
}

</script>
<style scoped>
.content{

}
.choose{
    width: 50%;
    float: left;
}
.confirm{
    width: 50%;
    float: right;
}
.el-upload-list{
    width: 100vw;
    display: block;
}
</style>