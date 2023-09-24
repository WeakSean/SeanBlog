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
    background-color: rgba(33, 33, 33,0.2);
    margin: 0 0 0 0;
    display: flex;
    border-radius: 20px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.5);
}
</style>