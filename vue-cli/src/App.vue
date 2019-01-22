<template>

  <div id="app">
    
    <div class="container">       
       <navigation></navigation>        
        <router-view></router-view>    
    </div>     
       
  </div>
</template>

<script>
import Navigation from './components/Navigation.vue';

export default {
  name: 'app',
  data () {
    return {

    }
  },
  methods:{
    loadTopics(){
      this.$router.push('/topics');
    },  
    addTopic(){
      this.$router.push('/topics/create');
    },  
  },
  components:{
    Navigation
  }
  
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  /* display: inline-block; */
  margin: 0 10px;
}

a {
  color: #458f6e;
}

body {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  font-size: 12px
}

.list-group-item {
  display: block;
  text-decoration: none;
  margin: 1em 0.2em;
  color: #4a4a4a;
}

.list-group-item:hover {
  color: red;
}

.highlight {
  color: blue;
}

.marginstyle{
   border: 1px solid black;
  margin-top: 100px;
  margin-bottom: 100px;
  margin-right: 150px;
  margin-left: 80px;
  /* background-color: lightblue; */

}
</style>
