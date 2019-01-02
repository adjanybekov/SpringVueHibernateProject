<template>
    <form  id="app"  @submit="saveComment">        
        Please Write Comment Clearly:<input type="text" v-model="comment">    

        <p>
        <input type="submit" value="Submit">
        </p>

    </form>
</template>
<script>
export default {
    data(){
        return{
            comment:'',
            topicId:''
        }
    },
   
    methods:{
        saveComment:function(){
        var vm = this;
            axios({
            url: 'http://localhost:8087/api/comment/v1',
            method: 'post',
            data: {
                comment: vm.comment, 
                topic_id: vm.topicId                  
            }
            })      
        },

    },
     beforeMount:function(){
        debugger;
        this.topicId = this.$route.query.topicId;
    },

}
</script>
