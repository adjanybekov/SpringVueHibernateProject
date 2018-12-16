<template>
  <div id="app">
     
    <div class="container">
        <div class="row">
          <button>
            Add new Topic
          </button>
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">    
              <p> Hottest Topics of the day</p>
              <ul>
                <li v-for="(t,i) in topics" @click="loadPageWithComments(i)" class="list-group-item list-group-item-action">  {{i}}) {{ t[1] }} </li>
              </ul>

              <ul>
              
              </ul>
      </div>     
      </div>     
      </div>     
       
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      topics:[],
      comments:[],
      msg: 'Welcome to Your Vue.js App',
      status:'',
      studentData:'',
      firstName:'',
      lastName:'',
      course:'',
      age:'',
      studentId:'',
      topicId:'',
      commentId:'',
      title:'',
      comment:'',
      personId:''
    }
  },
  created: function(){
    // this.loadQuote(); 
    this.getTopics();
    
  },
  methods:{
    loadQuote:function(){
      this.status="Loading...";
      var vm = this;      
      axios.get('http://ron-swanson-quotes.herokuapp.com/v2/quotes')
      .then(function(response){
        vm.status = response.data[0];        
      })
      .catch(function(error){
        vm.status='Error.. = ' + error;
      })
    },
    getStudents:function(){       
      var vm = this;       
      axios.get('http://localhost:8090/api/v1/students')
      .then(function(response){
        
        vm.studentData = response.data[0];

      })
      .catch(function(error){
        
        vm.studentData='Error.. = ' + error;
      })
  },
  saveStudent:function(){
      var vm = this;
      

      axios({
        url: 'http://localhost:8090/api/v1/students',
        method: 'post',
        data: {
          firstName: vm.firstName,
          lastName: vm.lastName,
          course: vm.course,
          age: vm.age
        }
      })
      // axios.post('http://localhost:8090/api/v1/students', {
      //   firstName: vm.firstName,
      //   lastName: vm.lastName,
      //   course: vm.course,
      //   age: vm.age
      // })
      // .then(function (response) {
      //   
      //   console.log(response);
      // })
      // .catch(function (error) {
      //   
      //   console.log(error);
      // });
  },
  getTopics(){

    var vm = this;
    axios.get('http://localhost:8087/api/topics/v1',{crossdomain: true} )
    .then(function(response){

      vm.topics = response.data;
    }).catch( error =>{
      
        console.log('Errrrror:   '+error)
    })
  },

  loadPageWithComments(index){
    var vm = this;

    axios.get('http://localhost:8087/api/topics/v1/'+vm.topics[index][0])
    .then(function(response){

      vm.comments = response.data;

      alert(vm.comments);
      console.log(vm.comments);
    }).catch( error =>{
      
        console.log('Errrrror:   '+error)
    })

    
  }


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
</style>
