<template>

  <div id="app">
     
    <div class="container">
        <div class="row marginstyle" >          
          <div class="col-md-3">
            <router-link to='/' class="navbar-brand" :active='true'>
                        Home
                      </router-link>
          </div>
         <div class="col-md-2">
            <button class="btn btn-primary" @click="addTopic">
              Add new Topic
            </button>
         </div>
          
          <!-- <div class="col-md-2">
             <button class="btn btn-primary" @click="loadTopics">
              List Fresh Topics
            </button>
          </div> -->
        
             
      </div> 
                <router-view></router-view>    
      </div>     
       
  </div>
</template>

<script>
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
