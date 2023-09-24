<template>
    <div>

        <span class="calendar-title">日历</span>
        <el-divider></el-divider>
        <div class="calendar-content">
            <el-calendar v-model="value" class="calendar"></el-calendar>
        </div>
        <div class="calendar-collapse">
            <el-button round class="calendar-button">添加日程</el-button>
            <el-collapse v-model="activeName" accordion>
                <el-collapse-item title="一致性 Consistency" name="1">
                    <div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>
                    <div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
                </el-collapse-item>
                <el-collapse-item title="反馈 Feedback" name="2">
                    <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
                    <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
                </el-collapse-item>
                <el-collapse-item title="效率 Efficiency" name="3">
                    <div>简化流程：设计简洁直观的操作流程；</div>
                    <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
                    <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
                </el-collapse-item>
                <el-collapse-item title="可控 Controllability" name="4">
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
                </el-collapse-item>
            </el-collapse>
        </div>
    </div>
</template>

<script>
export default {
    components: {},
    data() {
        return {
            activeName: 1,
            value: new Date()
        }
    },
    created() {

    },
    mounted() {

    },
    computed: {},
    watch: {},
    methods: {}

}

</script>

<style scoped>
.calendar-title{
    display: flex;
    margin: 2vh 0 0 2vw;
    color: white;
    font-size: 1.5rem;
}
.calendar-content{
    position: relative;
    float: left;
    margin: 2vh 0 0 2vw;
    width: 70%;
}
.calendar-collapse{
    position: relative;
    float: right;
    margin: 2vh 2vw 0 0;
    width: 22%;
    height: auto;
}
.calendar-button{
    width: 80%;
    margin: 1vh;
    background-color: #2c3e50;
    color: white;
}
.calendar-button:hover{
    width: 80%;
    margin: 1vh;
    background-color: #2c3e50;
    color: aqua;
}
.calendar{
    border-radius: 20px;
    border: 1px solid white;
    background-color: rgba(45, 65, 84,0.8);
}
</style>