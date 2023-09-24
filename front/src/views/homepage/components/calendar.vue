<template>
    <div class="calendar-main">
        <span class="calendar-title">日历</span>
        <el-divider></el-divider>
        <div class="calendar-content">
            <el-calendar v-model="value" class="calendar"></el-calendar>
            <div class="calendar-schedule">
                <el-button round class="calendar-button">添加日程</el-button>
                <el-card class="card" v-for="i in 4" :key="i">
                    come on！
                </el-card>
            </div>
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

<style lang="scss" scoped>
.calendar-main{
    padding-top: 1vh;
    padding-bottom: 2vw;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
    background-color: rgba(24, 24, 24, 0.4);
}
.calendar-title{
    display: flex;
    margin: 2vh 0 0 2vw;
    color: white;
    font-size: 1.5rem;
}
.calendar-content{
    position: relative;
    display: flex;
    margin: 2vh 0 0 2vw;
    width: 100%;
}
.calendar-schedule{
    position: relative;
    width: 22%;
    height: auto;
}
.calendar-button{
    width: 90%;
    height: 5vh;
    margin-left: 5vh;
    color: white;
    border-radius: 20px;
    border: 0 solid #000000;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
    background-color: rgba(24, 24, 24, 0.6);
}
.calendar-button:hover{
    width: 90%;
    margin-left: 5vh;
    background-color: #2c3e50;
    color: white;
}
.calendar{
    width: 70%;
    border-radius: 20px;
    border: 0 solid #090A0F;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
    background-color: rgba(24, 24, 24, 0.6);
}

.el-calendar__header{
    color: white !important;
}
.card{
    display: flex;
    width: 100%;
    height: 20%;
}
</style>