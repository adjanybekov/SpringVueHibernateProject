<template>
    <div class="container">
          <br>
        <nav-bar></nav-bar>
        <hr>        
        <router-view></router-view>        
        
    </div>
</template>

<script>
    import NavBar from "./components/NavBar.vue";    

    export default {
        components:{
            NavBar
        }
    }
</script>

<style>

</style>
