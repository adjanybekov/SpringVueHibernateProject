<template>
    <div>       
        <button class="btn btn-primary" @click="getTopics">
            Show topics
        </button>
    </div>        
</template>

<script>
export default {
    methods:{
        getTopics(){
            this.$router.push('/topics');
        }
    }
}
</script>

