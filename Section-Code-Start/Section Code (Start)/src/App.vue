<template>
    <div class="container">
          <br>
        <nav-bar></nav-bar>
        <hr>        
        <transition name="slide" mode="out-in">
            <router-view></router-view> 
        </transition>
               
        
    </div>
</template>

<script>
    import NavBar from "./components/NavBar.vue";    

    export default {
        components:{
            NavBar
        },
        created(){
            this.$store.dispatch('initStocks');
        }
    }
</script>

<style>
    
</style>
