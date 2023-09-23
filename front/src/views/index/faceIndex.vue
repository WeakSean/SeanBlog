<template>
    <div class="content">
        <div class="back"><Star/></div>
        <div class="name">游离人群之外的羊</div>
        <div class="face"><Typer/></div>
    </div>
</template>

<script>
import Typer from "@/views/index/components/typer.vue";
import Star from "@/views/index/components/star.vue";
export default{
    components:{
        Typer,
        Star
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

    }

}

</script>

<style scoped>
.content{
    position: relative;
    z-index: 0;
}
.back{
    z-index: 1;
}
.name{
    z-index: 999;
    position: absolute;
    font-size: 5em;
    color: white;
    top: 15%;
    left: 38%;
}
.face{
    z-index: 999;
    position: absolute;
    top: 15%;
    left: 45%;
}
</style>