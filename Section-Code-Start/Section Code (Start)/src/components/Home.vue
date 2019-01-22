<template>
    <div>
        funds: {{funds | currency}}
    </div>
</template>
<script>
export default {
    computed:{
        funds(){
           return this.$store.getters.funds;
        }
    }
}
</script>
