<template>
    <div>
        <p>Server title: {{title2}}</p>
        <button v-on:click="changeTitle">
            Change Title
        </button>
    </div>
</template>

<script>
    export default {
        data:function(){
            return{
                title2:'Hello Vue!'
            }
        },
        methods:{
            changeTitle:function(){
            if(this.title2==='Hello Vue!')
                this.title2='Bye Vue';
            else {this.title2='Hello Vue!';}
            }
        }
    }
</script>

