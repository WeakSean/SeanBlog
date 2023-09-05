<template>
    <div>
        <el-row>
            <el-col :span="7">
                <el-select  clearable placeholder="请选择省份" v-model="province">
                    <el-option v-for="item in areas" :key="item.code" :value="item.code" :label="item.name">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="7">
                <el-select
                    style="margin: 0 10px;"
                    placeholder="请选择城市"
                    :disabled="!province"
                    v-model="city">
                    <el-option  v-for="item in selectCity" :key="item.code" :value="item.code" :label="item.name">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="7">
                <el-select
                    clearable :disabled="!province || !city"
                    placeholder="请选择区域"
                    v-model="area">
                    <el-option v-for="item in selectArea" :key="item.code" :value="item.code" :label="item.name">
                    </el-option>
                </el-select>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts" setup>
import {ref, watch} from "vue";
import chinaArea from '../chooseArea/chinaArea.json'

export interface AreaItem{
    name: String,
    code: String,
    children?: AreaItem[],
}

export interface Data{
    name: String,
    code: String
}

// 下拉框选择省份的值
let province = ref<string>('')

// 下拉框选择城市的值
let city = ref<string>('')

// 下拉框选择区域的值
let area = ref<string>('')

// 所有的省市区数据
let areas = ref(chinaArea)

// 城市下拉框的所有的值
let selectCity = ref<AreaItem[]>([])

// 区域下拉框的所有的值
let selectArea = ref<AreaItem[]>([])

let emits = defineEmits(['change'])

// 监听选择省份
watch(() => province.value, val => {
    if (val) {
        selectCity.value = areas.value.find(item => item.code === province.value)!.children!
    }
    city.value = ''
    area.value = ''
})

// 监听选择城市
watch(()=> city.value , val =>{
    if(val){
        selectArea.value = selectCity.value.find(item => item.code === city.value)!.children
    }
    area.value = ''
})

// 监听选择区域
watch(() => area.value, val => {
    if (val) {
        let provinceData: Data = {
            code: province.value,
            name: province.value && chinaArea.find(item => item.code === province.value)!.name
        }
        let cityData: Data = {
            code: city.value,
            name: city.value && selectCity.value.find(item => item.code === city.value)!.name
        }
        let areaData: Data = {
            code: val,
            name: val && selectArea.value.find(item => item.code === val)!.name
        }
        emits('change', {
            province: provinceData,
            city: cityData,
            area: areaData
        })
    }
})
</script>

<style scoped>

</style>