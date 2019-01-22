<template>
    <div class="col-sm-6 col-md-4">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title"> {{topic[2]}}              
                </h3>
            </div>
            <div class="panel-body">
            <div class="pull-left">
                
            </div>
            <div class="pull-right">
                <button class="btn btn-success" @click="loadPageWithComments(topic[0])">Show topic</button>
            </div>
        </div>
        </div>
        
    </div>
</template>
<script>
export default {
    props:['topic'],

    methods:{
        

    loadPageWithComments(id){
        console.log("asdasdasda");
        var vm = this;
        debugger;
        axios.get('http://localhost:8087/api/topics/v1/'+id)
        .then(function(response){

        vm.comments = response.data;

        // load topics
        
        var id = id;
        debugger;
        vm.$router.push({path:'topics/show',query:{ topic:vm.topic[2], id:vm.topic[0]}});
        console.log(vm.comments);
        }).catch( error =>{
        
            console.log('Errrrror in loadPage:   '+error)
        })

        
    }
    }
    
}
</script>
