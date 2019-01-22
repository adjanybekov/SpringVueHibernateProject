<template>

    <div>
         
              <p> Hottest Topics of the day</p>

                <topic v-for="t in topics" :topic="t"></topic>
          


    </div>
</template>

<script>
import Topic from './topic/Topic.vue';
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
  components:{
    Topic
  },
  methods:{

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
