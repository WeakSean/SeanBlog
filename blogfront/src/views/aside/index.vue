<template>
    <div class="info">
        <div class="first">
            <el-avatar :size="60" class="avatar" @error="errorHandler">
                <img src="../../assets/avatar.jpg">
            </el-avatar>
            <div class="profile">
                <h1>SuperSean</h1>
                <p>为什么不笑呢？</p>
            </div>
        </div>

<!--        <div class="second">-->
<!--            <div class="cube">1</div>-->
<!--            <div class="cube">2</div>-->
<!--            <div class="cube">3</div>-->
<!--        </div>-->
    </div>
</template>

<script lang="ts" setup>
const errorHandler = () => true
</script>

<style scoped>
.info{
    display: flex;
    align-items: center;
    justify-content: center;
    color: #FFFFFF;
}
.first{
    position: relative;
    width: 90%;
    height: 100%;
    top: 5vh;
    border-radius: 20px;
    background-color: rgba(255,255,255,0.2);
    backdrop-filter: blur(4px);
    animation: am3 ease-out 1s 0.2s backwards;

}
@keyframes am3 {
    0% {transform: translateY(8px);opacity: 0}
    100% {transform: translateY(0);opacity: 1}
}
.avatar{
    position: relative;
    top: 8%;
}
img{
    width: 100%;
    height: 100%;
}
.profile{
    position: relative;
    top: 9%;
}
.cube{
    width: 33%;
}
.second{

}
</style>