<template>
<div>
    <form  id="app"  @submit="saveTopic">

    title:<input type="text" v-model="title">
    description:<input type="text" v-model="description">    

     <p>
    <input
      type="submit"
      value="Submit"
    >
  </p>

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
        
    saveTopic:function(){
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
