<template>
    <div class="typer">
        <div class="typer-content">
            <p class="typer-static">&nbsp;</p>
            <p class="typer-dynamic">
                <span class="cut">
                    <span class="word" v-for="(letter,index) in words" :key="index">{{letter}}</span>
                </span>
                <!--  模拟光标  -->
                <span class="typer-cursor"></span>
            </p>
        </div>
    </div>
</template>

<script>
export default {
    components: {},
    data() {
        return {
            words:[],               //字母数组push，pop的载体
            str:"慢慢来，谁不是翻山越岭来相爱",          //str初始化
            letters:[],             //str分解后的字母数组
            order:1,                //表示当前是第几句话
        }
    },
    created() {

    },
    mounted() {

    },
    computed: {},
    watch: {
        order(newVal,oldVal){
            if(this.order % 4 === 1){
                this.str = "慢慢来，谁不是翻山越岭来相爱。"
            } else if(this.order % 4 === 2){
                this.str = "我们是孤独的总和，所以相遇了。"
            } else if(this.order % 4 === 3){
                this.str = "我不太喜欢猫，我喜欢狗。"
            } else {
                this.str = "但我更欢喜你！"
            }
        }
    },
    methods: {
        //开始输入的效果动画
        begin(){
            this.letters = this.str.split("");
            for(let i = 0 ; i < this.letters.length ; i++ ){
                setTimeout();
            }
        },
        //开始删除的效果动画
        back(){
            for(let i = 0 ; i < this.letters.length ; i++){
                setTimeout(this.wipe(i),i*50);
            }
        },
        //输入字母
        write(i){
            return ()=>{
                this.words.push(this.letters[i]);
                let that=this;
                /*如果输入完毕，在3s后开始删除*/
                if(i === this.letters.length - 1){
                    setTimeout(function(){
                        that.back();
                    },3000);
                }
            }
        },
        //擦掉(删除)字母
        wipe(i){
            return ()=>{
                this.words.pop(this.letters[i]);
                /*如果删除完毕，在300ms后开始输入*/
                if(this.words.length === 0){
                    this.order++;
                    let that=this;
                    setTimeout(function(){
                        that.begin();
                    },300);
                }
            }
        },
    }
}

</script>

<style scoped>
.typer{
    margin-top: 2%;
    box-sizing: border-box;
}
.typer .typer-content{
    font-weight: normal;
    font-size: 50px;
    flex-direction: row;
    letter-spacing: 2px
}
.typer-dynamic{
    position: relative;
}
.cut{
    color: #ffffff;
}
.typer-cursor{
    position: absolute;
    height: 100%;
    width: 3px;
    top: 0;
    right: -10px;
    background-color: #ffffff;
    animation: flash 1.5s linear infinite;
}
</style>