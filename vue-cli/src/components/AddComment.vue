<template>
    <form  id="app"  @submit="saveComment">        
        Please Write Comment Clearly:<input type="text" v-model="comment">    

        <hr>
        <input class="btn btn-primary" type="submit" value="Submit">
        <button type="button" class="btn btn-primary" @click="loadPageWithComments">
        Back to Comment List
    </button>

    </form>
</template>
<script>
export default {
    data(){
        return{
            comment:'',
            topicId:'',
            comments:[]
        }
    },
   
    methods:{
        saveComment:function(){
            debugger;
        var vm = this;
        debugger;
        var data =  {
            comment: vm.comment,
             topic_id: vm.topicId
        }
        axios.post('http://localhost:8087/api/comment/v1',data)
        .then(res=>console.log("Succeesssss"))
        .catch( error =>{
            
                console.log('Errrrror in loadPage:   '+error)
            });
            // axios({
            // url: 'http://localhost:8087/api/comment/v1',
            // method: 'post',
            // data: {
            //     comment: vm.comment, 
            //     topic_id: vm.topicId               
            // }
            // }).then( function(response){

            // }


            // )      
        },
       loadPageWithComments(){
            var vm = this;
            debugger;
            axios.get('http://localhost:8087/api/topics/v1/'+vm.topicId)
                .then(function(response){

                vm.comments = response.data;

                // load topics
                                
                debugger;
                vm.$router.push({path:'/topics/show',query:{ topic: 'asfdasd', id: vm.topicId}});
                // console.log(vm.comments);
            }).catch( error =>{
            
                console.log('Errrrror in loadPage:   '+error)
            })

        
    }

    },
     beforeMount:function(){
    
        this.topicId = this.$route.query.topicId;
    },

}
</script>
