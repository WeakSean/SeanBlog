<template>
    <el-form :model="form" label-width="auto" label-position="right">
        <el-tabs :tab-position="tabPosition">
            <el-tab-pane label="基础信息">
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="姓名">
                            <el-input v-model="form.name" />
                        </el-form-item>
                    </el-col>
<!--                    <el-col :span="8">-->
<!--                        <el-form-item label="曾用名">-->
<!--                            <el-input v-model="form.formerName" />-->
<!--                        </el-form-item>-->
<!--                    </el-col>-->
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="身份证">
                            <el-input v-model="form.idCard" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="性别">
                            <el-radio-group v-model="form.sex" class="ml-4">
                                <el-radio label="1">男</el-radio>
                                <el-radio label="2">女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="年龄">
                            <el-input v-model="form.age" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="10">
                        <el-form-item label="阳历生日">
                            <el-date-picker
                                v-model="form.solarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="阴历生日">
                            <el-date-picker
                                v-model="form.lunarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="籍贯">
                            <chooseArea @change="showArea" ></chooseArea>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-tab-pane>
            <el-tab-pane label="学历信息">

            </el-tab-pane>
            <el-tab-pane label="工作信息">
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="籍贯">
                            <el-input v-model="form.formerName" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="性别">
                            <el-input v-model="form.sex" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="阳历生日">
                            <el-date-picker
                                v-model="form.solarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="阴历生日">
                            <el-date-picker
                                v-model="form.lunarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-tab-pane>
            <el-tab-pane label="感情信息">
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="籍贯">
                            <el-input v-model="form.formerName" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="性别">
                            <el-input v-model="form.sex" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="阳历生日">
                            <el-date-picker
                                v-model="form.solarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="阴历生日">
                            <el-date-picker
                                v-model="form.lunarBirth"
                                type="date"
                                style="width: 80%"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-tab-pane>
            <el-tab-pane label="补充信息">

            </el-tab-pane>
        </el-tabs>
        <div class="button">
            <el-form-item>
                <el-button type="primary" @click="onSubmit">Create</el-button>
                <el-button @click="">Cancel</el-button>
            </el-form-item>
        </div>
    </el-form>
</template>

<script lang="ts" setup>
import {inject, reactive, ref} from 'vue'
import  chooseArea  from '../../components/chooseArea/index.vue'
const tabPosition = ref('right')
interface Props {

}
const props =  defineProps<Props>()


// 定义所要传给父组件的值
const show = ref<boolean>(false)

// 使用defineEmits注册一个自定义事件
const emit = defineEmits(["getValue"])

const init:any = inject("reload");

// do not use same name with ref
const form = reactive({
    name: '',
    formerName: '',
    idCard: '',
    age:'',
    nativePlace: '',
    solarBirth: '',
    lunarBirth: '',
    sex:'',
    region: '',
    date1: '',
    date2: '',
    delivery: false,
    type: [],
    resource: '',
    desc: '',
})

const onSubmit = () => {
    console.log('submit!');
    init();
    emit("getValue", show.value);
}

const showArea=(val: any)=>{
    console.log("area",val);
}
</script>
<style scoped>
.el-input{
    width: 80%;
}
.button{
    width: 100%;
    position: relative;
    justify-items: right;
    text-align: right;
}
</style>