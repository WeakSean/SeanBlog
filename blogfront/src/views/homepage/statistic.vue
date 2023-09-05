<template>
    <el-row>
        <el-col :span="8"></el-col>
        <el-col :span="8">
            <el-countdown format="DD [天] HH [时] mm [分] ss [秒]" :value="value2">
                <template #title>
                    <div style="display: inline-flex; align-items: center">
                        <el-icon style="margin-right: 4px" :size="12">
                            <Calendar />
                        </el-icon>
                        距离下个月还有
                    </div>
                </template>
            </el-countdown>
<!--            <div class="countdown-footer">{{ value2.format('YYYY-MM-DD') }}</div>-->
        </el-col>
        <el-col :span="8"></el-col>
    </el-row>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import dayjs from 'dayjs'
import { Calendar } from '@element-plus/icons-vue'

const value = ref(Date.now() + 1000 * 60 * 60 * 7)
const value1 = ref(Date.now() + 1000 * 60 * 60 * 24 * 2)
const value2 = ref(dayjs().add(1, 'month').startOf('month'))

function reset() {
    value1.value = Date.now() + 1000 * 60 * 60 * 24 * 2
}
</script>

<style scoped>
.el-col {
    text-align: center;
}

.countdown-footer {
    margin-top: 8px;
}
</style>