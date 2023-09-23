<template>
    <div class="main-index">
        <Homepage v-if="true"/>
    </div>
</template>

<script>
import Homepage from "@/views/homepage/index.vue";
export default {
    components: {
        Homepage
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

<style>
.main-index{
    width: 100%;
    height: 100%;
    background-color: rgba(255,255,255,0.05);
    margin: 0 0 0 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
}
</style>