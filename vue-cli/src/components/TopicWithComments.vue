<template>
    <div>
        <p class=""> Topic: {{topic}}</p>

        Comments:
        <ul>
            <li v-for="(comment,i) in comments">{{i}} ) {{ comment[1] }}</li>
        </ul>
        <button class="btn btn-primary" @click="addComment"> Add comment </button>

        <router-view></router-view>
    </div>

</template>
<script>
export default {  
    
    data(){
        return {
            comments:[],
            topic:'Dummy Topic',
            topicId:''
        }
    },
    
    methods:{
        loadTopic(topicId){
            var vm = this;
            this.topicId = topicId;
            debugger;
            axios.get('http://localhost:8087/api/topics/v1/' + topicId)
            .then(function(response){                        
                vm.comments = response.data;
                console.log(vm.comments);
            }).catch( error =>{            
                console.log('Errrrror in loadPage:' + error)
            })
        },        
        addComment(){
            this.$router.push( {path:'show/addcomment', query:{topicId:this.topicId}})
            
        }
    },
    beforeMount: function(){
        debugger;
        this.topic = this.$route.query.topic;

        if (this.$route.query.id){
            
              this.loadTopic(this.$route.query.id);

        }                
    },

}
</script>