<template>
    <el-container>
        <el-header class="top">
            <Header/>
        </el-header>
        <el-container>
            <el-main class="left">
                <Main/>
            </el-main>
            <el-aside class="right">
                <Aside/>
            </el-aside>
        </el-container>
        <el-footer class="bottom">
            <Footer/>
        </el-footer>
    </el-container>
</template>

<script>
import Header from "@/views/index/components/header.vue";
import Main from "@/views/index/components/main.vue";
import Aside from "@/views/index/components/aside.vue";
import Footer from "@/views/index/components/footer.vue";
export default {
    components: {
        Header,
        Main,
        Aside,
        Footer
    },
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

<style scoped>
.left{
    width: 80% !important;
    margin: 3vh 0 0 2vw;
    justify-content: center;
    align-items: center;
    display: flex;
}
.right{
    width: 20% !important;
    margin: 3vh 2vw 0 0;
    justify-content: center;
    align-items: center;
    display: flex;
    padding: 20px;
}
</style>