<template>
    <div>
        <p>BMW Stock price: {{BmvQuantity}}</p>
        <input type="text" v-model="BmvQuantity">
        <button class="btn-primary" @click="buyStock(BmvQuantity)">Buy</button>

    </div>
</template>

<script>
import {mapMutations} from 'vuex';

export default {
    computed:{
        BmvQuantity:{
            get(){
                return this.$store.state.bmwStock;
            },
            set(value){
                this.$store.commit('updateValue',value);
            }
            
        }
    },
    data(){
        return{            
            BmwStockPrice:50
        }
    },

    methods:{       
        // ...mapMutations([
        //     'buyStock','sellStock'
        // ]),
        buyStock(at){                 
            // this.$store.dispatch('buyStock', event.target.value)  
            this.$store.commit('buyStock', at);
        },
        buyBmwStock(){
            alert('Please confirm bying '+this.BmvQuantity+' stocks ?');

        },   
        updateValue(event) {
            this.$store.commit('updateValue',event.target.value);
            
        }
    },
    
    beforeRouteLeave(to,from,next){
        if(this.confirmed){
            next();
        }
        else{
            if(confirm('Are you sure ?')){
                next();
            }
            else{
                next( false);
            }
        }
        // next();
    }
}
</script>

