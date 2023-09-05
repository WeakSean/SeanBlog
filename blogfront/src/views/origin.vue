<template>
<!--    <el-scrollbar height="300vh">-->
    <div class="mmj">
        <div class="daming">{{ wodemingzi }}</div>
        <div class="saobihua"><typer/></div>
        <img class="aowu" src="../assets/aowu.png" @click="gogogo()"/>
    </div>
    <div class="kkj" ref="mmj">
        <mainIndex></mainIndex>
    </div>
<!--    </el-scrollbar>-->
</template>
<script>
import typer from './components/origin/typer.vue'
import mainIndex from '../views/index/mainIndex.vue'
export default {
    components: {
        typer,
        mainIndex
    },
    data(){
        return{
            wodemingzi:"游离人群之外的羊"
        }
    },
    mounted(){

    },
    methods:{
        gogogo(){
            this.$refs.mmj.scrollIntoView({behavior: 'smooth'});
        }
    }
}
</script>
<style scoped>
.mmj{
    position: relative;
    height: 100vh;
    background-image: url('../assets/origin-background.jpg');
    background-size: cover;
}
.mmj .daming{
    position: absolute;
    font-size: 5em;
    color: #ffffff;
    left: 39%;
    top: 49%;
}
.mmj .saobihua{
    position: absolute;
    left: 50%;
    top: 49%;
}
.aowu{
    width: 90px;
    height: 90px;
    position: absolute;
    left: 48%;
    top: 90%;
}
.kkj{
    height: 200vh;
}

</style>