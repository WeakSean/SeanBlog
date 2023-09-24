<template>
    <div class="statistic-main">
        <span class="statistic-title">统计</span>
        <el-divider></el-divider>
        <el-row :gutter="20">
            <el-col :span="6">
                <div>
                    <el-statistic
                        group-separator=","
                        :precision="2"
                        :value="value2"
                        :title="title"
                    ></el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic title="男女比">
                        <template slot="formatter">
                            38/20
                        </template>
                    </el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic
                        group-separator=","
                        :precision="2"
                        decimal-separator="."
                        :value="value1"
                        :title="title"
                    >
                        <template slot="prefix">
                            <i class="el-icon-s-flag" style="color: red"></i>
                        </template>
                        <template slot="suffix">
                            <i class="el-icon-s-flag" style="color: blue"></i>
                        </template>
                    </el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic :value="like ? 521 : 520" title="Feedback">
                        <template slot="suffix">
              <span @click="like = !like" class="like">
                <i
                    class="el-icon-star-on"
                    style="color:red"
                    v-show="!!like"
                ></i>
                <i class="el-icon-star-off" v-show="!like"></i>
              </span>
                        </template>
                    </el-statistic>
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
            like: true,
            value1: 4154.564,
            value2: 1314,
            title: "增长人数",
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

<style lang="scss">
.statistic-main{
    padding-top: 1vh;
    padding-bottom: 2vw;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
    background-color: rgba(24, 24, 24, 0.4);
}
.statistic-title{
    display: flex;
    margin: 2vh 0 0 2vw;
    color: white;
    font-size: 1.5rem;
}
.el-statistic .head{
    color: white !important;
    font-size: 1.2rem !important;
}
.el-statistic .con{
    color: white !important;
}
.like {
    cursor: pointer;
    font-size: 25px;
    display: inline-block;
}
</style>