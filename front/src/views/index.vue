<template>
    <div class="basic">
        <FaceIndex/>
        <img class="scrollbar" src="../../src/assets/star/galaxy.png" alt="" @click="goMain"/>
        <MainIndex id="mainIndex" class="mainIndex"/>
    </div>
</template>

<script>
import FaceIndex from "@/views/index/faceIndex.vue";
import MainIndex from "@/views/index/mainIndex.vue";
export default{
    components:{
        MainIndex,
        FaceIndex
    },
    data(){
        return{

        }
    },
    created() {

    },
    mounted() {

    },
    computed:{

    },
    watch:{

    },
    methods:{
        goMain(){
            let main = document.querySelector("#mainIndex");
            main.scrollIntoView({block: "start", inline: "nearest",behavior: "smooth"})
        }
    }

}

</script>

<style>
.basic{
    height: 300vh;
}
.scrollbar{
    z-index: 999;
    position: absolute;
    top: 90%;
    left: 48%;
    width: 100px;
    height: 100px;
}
.mainIndex{
    width: 100%;
    height: 200vh;
    position: absolute;
    top: 100%;
    left: 0;
    z-index: 999;
}
</style>