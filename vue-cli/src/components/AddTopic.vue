<template>
    <div>
    <form  id="app"  @submit="saveTopic">

        title:<input type="text" v-model="title">
        description:<input type="text" v-model="description">    
        <hr>
        <input class="btn btn-primary"   type="submit"      value="Submit" > 
        <button type="button" class="btn btn-primary" @click="topicList">
            Back to Topic List
        </button>
    
    </form>
        
    </div>
    

    

    
</template>
<script>
export default {
    data(){
        return {
            title:'',
            description:''
        }
    },
    methods:{
         topicList(){
             debugger;
            this.$router.push( {path:'/topics'});
        },
        
    saveTopic(){
        debugger;
      var vm = this;
        axios({
          url: 'http://localhost:8087/api/topics/v1',
          method: 'post',
          data: {
            title: vm.title,
            description: vm.description        
          }
        })      
      },
     
    }
}
</script>
