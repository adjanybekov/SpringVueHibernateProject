import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store  = new Vuex.Store({
    state:{
        funds:100,
        bmwStock:0
    },
    getters:{
        getFunds:()=>{
            return state.funds;
        }
    },
    mutations:{
        buyStock: (state,payload) =>{
            state.funds -=payload;
        },
        sellStock: (state,payload) =>{
            state.funds +=payload;
        }   ,
        updateValue(state,payload){
            state.bmwStock = payload;
        }     
    },
});