<template>
    <form  id="app"  @submit="saveComment">        
        Please Write Comment Clearly:<input type="text" v-model="comment">    

        <hr>
        <input class="btn btn-primary" type="submit" value="Submit">
        <button class="btn btn-primary" @click="topicList">
        Back to Topic List
    </button>

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
                topic_id: this.$route.query.topicId               
            }
            })      
        },
        topicList(){
            this.$router.push( {path:'/topics'});
        }

    },
     beforeMount:function(){
        debugger;
        // this.topicId = this.$route.query.topicId;
    },

}
</script>
