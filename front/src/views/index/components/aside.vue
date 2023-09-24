<template>
    <div class="aside-index">
        <Aside/>
    </div>
</template>

<script>
import Aside from "@/views/aside/index.vue";
export default {
    components: {
        Aside
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
.aside-index{
    width: 100%;
    height: 100%;
    background-color: rgba(255,255,255,0.05);
    margin: 0 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
}
</style>