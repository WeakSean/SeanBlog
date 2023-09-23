<template>
<!--    <el-input placeholder="请输入内容" type="text" v-model="search" class="input-with-select">-->
<!--        <el-button slot="append" icon="el-icon-search"></el-button>-->
<!--    </el-input>-->
    <div class="head">
        <el-row>
            <el-col :span="24">
                <div class="navbar">
                    &nbsp;
                    <div class="logo"><a href="#">SuperSean's Blog</a></div>
                    <ul class="links">
                        <li><a href="#">主页</a></li>
                        <li><a href="#">博客</a></li>
                        <li><a href="#">相册</a></li>
                        <li><a href="#">待定</a></li>
                    </ul>
                    <div class="logo"><a href="#">Web Dev</a></div>
                    &nbsp;
                </div>
            </el-col>
        </el-row>
    </div>

</template>

<script>
export default {
    components: {},
    data() {
        return {
            search:""
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

<style>
.head{
    margin-top: 2vh;
    margin-bottom: 2vh;
    height: 7vh;
    align-items: center;
    justify-content: center;
}
li {
    list-style: none;
}
a {
    text-decoration: none;
    color: white;
    font-size: 1rem;
}
a:hover{
    color: aqua;
}
.navbar{
    width: 80%;
    height: 5vh;
    background-color: rgba(255,255,255,0.05);
    margin: 0 auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
}
.navbar .logo a{
    font-size: 1.5rem;
    font-weight: bold;
}
.navbar .links{
    display: flex;
    gap: 2rem;
}
</style>