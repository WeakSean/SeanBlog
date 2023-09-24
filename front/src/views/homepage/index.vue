<template>
    <div class="homepage-index">
        <Statistic class="Statistic"/>
        <Calendar class="Calendar"/>
    </div>
</template>

<script>
import Statistic from "@/views/homepage/components/statistic.vue";
import Calendar from "@/views/homepage/components/calendar.vue";
export default {
    components: {
        Statistic,
        Calendar
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
.Statistic{
    margin: 2vw 2vw 2vw 2vw;
}
.Calendar{
    margin: 2vw 2vw 2vw 2vw;
}
</style>