<template>
  <div id="app">
    <img src="./assets/logo.png">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>    
      First name: <input v-model="firstName" placeholder="firstName"> <br><br>
      Last  name: <input v-model="lastName" placeholder="lastName">   <br><br>
      Course: <input v-model="course" placeholder="course"> <br><br>
      Age: <input v-model="age" placeholder="Age">  <br><br>          
    <button v-on:click="saveStudent">
      SaveStudent
    </button>
    <button v-on:click="loadQuote">
      changeQuote
      </button>

    <p>
      {{ status }}
    </p>

    <button v-on:click="getStudents">
      getStudents
    </button>

    <h1>  
      Delete Student
    </h1>
    <input v-model="studentId" placeholder="studetId"> <br><br>
        <button v-on:click="deleteStudent">
      deleteStudent
    </button>

    <p>
      {{ studentData }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      status:'',
      studentData:'',
      firstName:'',
      lastName:'',
      course:'',
      age:''
    }
  },
  created: function(){
    this.loadQuote(); 
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
        debugger
        vm.studentData = response.data[0];

      })
      .catch(function(error){
        debugger
        vm.studentData='Error.. = ' + error;
      })
  },
  saveStudent:function(){
      var vm = this;
      debugger

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
      //   debugger
      //   console.log(response);
      // })
      // .catch(function (error) {
      //   debugger
      //   console.log(error);
      // });
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
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
