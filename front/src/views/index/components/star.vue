<template>
    <el-row>
        <el-col :span="24">
            <div class="main">
                <div class="small-star"></div>
                <div class="normal-star"></div>
                <div class="medium-star"></div>
                <div class="large-star"></div>
            </div>
        </el-col>
    </el-row>

</template>

<script>
export default {
    components: {},
    data() {
        return {}
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
.main{
    height: 300vh;
    background: radial-gradient(ellipse at bottom,#1B2735 0%,#090A0F 100%);
    overflow: hidden;
}

//定义星空的大小
$sky-size: 5555;

//通过函数生成指定数量的星星
@function generate-star($num){
    $value: '#{random($sky-size)}px #{random($sky-size)}px #fff';
    //通过循环，生成星星
    @for $i from 2 through $num{
        $value: '#{$value}, #{random($sky-size)}px #{random($sky-size)}px #fff';
    }
    //去除返回值的引号
    @return unquote($string:$value);
}

.small-star{
    width: 1px;
    height: 1px;
    background-color: transparent;
    box-shadow: generate-star(888);
    animation: animate 90s linear infinite,twinkle 9s infinite;

}

.normal-star{
    width: 1.5px;
    height: 1.5px;
    background-color: transparent;
    box-shadow: generate-star(444);
    animation: animate 120s linear infinite,twinkle 12s infinite;
}

.medium-star{
    width: 2px;
    height: 2px;
    background-color: transparent;
    box-shadow: generate-star(222);
    animation: animate 150s linear infinite,twinkle 15s infinite;
}

.large-star{
    width: 3px;
    height: 3px;
    background-color: transparent;
    box-shadow: generate-star(111);
    animation: animate 180s linear infinite,twinkle 36s infinite;
}

//上面生成了三种不同数量的星星，下面添加动画让它们动起来
@keyframes animate {
    from {
       transform: translateY(0);
    }
    to {
        transform: translateY(unquote('-#{$sky-size}px'));
    }
}

@keyframes twinkle {
    0% {
        opacity: 0;
    }
    25% {
        opacity: 0.5;
    }
    50% {
        opacity: 1;
    }
    75% {
        opacity: 0.5;
    }
    100% {
        opacity: 0;
    }
}
</style>