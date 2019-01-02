<template>

    <div>
         <div class="col-xs-12">    
              <p> Hottest Topics of the day</p>
              <ul>
                <li v-for="(t,i) in topics" @click="loadPageWithComments(i)" class="list-group-item list-group-item-action">  {{i}}) {{ t[2] }} </li>
              </ul>

              <ul>              
              </ul>              
      </div>  

    </div>
</template>

<script>
export default {
    data(){
        return{
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

  getTopics(){

    var vm = this;
    axios.get('http://localhost:8087/api/topics/v1',{crossdomain: true} )
    .then(function(response){
      debugger;
      vm.topics = response.data;
    }).catch( error =>{
      
        console.log('Errrrror in getTopics:   '+error)
    })
  },

  loadPageWithComments(index){
    var vm = this;

    axios.get('http://localhost:8087/api/topics/v1/'+vm.topics[index][0])
    .then(function(response){

      vm.comments = response.data;

      // load topics
      
      var id = vm.topics[index][0];
      debugger;
      vm.$router.push({path:'topics/show',query:{ topic: vm.topics[index][2], id:vm.topics[index][0]}});
      console.log(vm.comments);
    }).catch( error =>{
      
        console.log('Errrrror in loadPage:   '+error)
    })

    
  }
  
  }

}
</script>
