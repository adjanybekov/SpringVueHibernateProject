<template>
  <div id="app">
    <img src="./assets/logo.png">    
    <h2>Enter Person</h2>    
      First name: <input v-model="firstName" placeholder="firstName"> <br><br>
      Last  name: <input v-model="lastName" placeholder="lastName">   <br><br>
      <!-- Course: <input v-model="course" placeholder="course"> <br><br> -->
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
    </button><br><br>
    <!-- {{ studentData }} -->
    <ul>
      <li v-for="student in studentData" >
        {{  student }}
      </li>      
    </ul>
 <!--
    <h1>  
      Write StudentId to Delete:
    </h1>
    <input v-model="studentId" placeholder="studetId"> <br><br>
        <button v-on:click="deleteStudent">
      deleteStudent
    </button>
    <br><br>
    <h2>Update Student</h2>    
      Id:     <input v-model="studentId" placeholder="firstName"> <br><br>
      First name: <input v-model="firstName" placeholder="firstName"> <br><br>
      Last  name: <input v-model="lastName" placeholder="lastName">   <br><br>
      Course: <input v-model="course" placeholder="course"> <br><br>
      Age: <input v-model="age" placeholder="Age">  <br><br>          
    <button v-on:click="updateStudent">
      UpdateStudent
    </button> -->

    <template>
      <h2>Enter Topic</h2>    
      Id:     <input v-model="topicId" placeholder="topicId"> <br><br>
      Title: <input v-model="title" placeholder="title"> <br><br>      
      PersonId: <input v-model="personId" placeholder="personId"> <br><br>      
      <button v-on:click="updateStudent">
        Save Topic
      </button>
    </template>

    <template>
      <h2>Enter Comment</h2>    
      Id:     <input v-model="commentId" placeholder="commentId"> <br><br>
      Comment: <input v-model="comment" placeholder="comment"> <br><br>      
      PersonId: <input v-model="personId" placeholder="personId"> <br><br>      
      TopicId: <input v-model="topicId" placeholder="topicId"> <br><br>      
      <button v-on:click="updateStudent">
        Save comment
      </button>
    </template>
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
        vm.studentData = response.data;

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
  },
  deleteStudent:function(){
    var vm = this;
    axios.delete('http://localhost:8090/api/v1/students/' + this.studentId)
    .then(function(response){
      console.log(response);
      vm.getStudents();
    })
    .catch(function(error){
      console.log(error);
    })
  },
  updateStudent:function(){
    var vm = this;
    axios.put('http://localhost:8090/api/v1/students/',
    {
          id:vm.studentId,
          firstName: vm.firstName,
          lastName: vm.lastName,
          course: vm.course,
          age: vm.age
    })
    .then(function(response){
      console.log(response);
    })
    .catch(function(error){
      console.log(error);
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
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #458f6e;
}
</style>
