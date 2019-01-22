import Vue from 'vue';
import Vuex from 'vuex';
import stocks from './modules/Stocks'
import portfolio from './modules/Portfolio'
import * as actions from './actions'

Vue.use(Vuex);

export default new Vuex.Store({
    actions,
    modules:{
        stocks,
        portfolio
    }
    
});


// state:{
    //     funds:100,
    //     bmwStock:0
    // },
    // getters:{
    //     getFunds:()=>{
    //         return state.funds;
    //     }
    // },
    // mutations:{
    //     buyStock: (state,payload) =>{
    //         state.funds -=payload;
    //     },
    //     sellStock: (state,payload) =>{
    //         state.funds +=payload;
    //     }   ,
    //     updateValue(state,payload){
    //         state.bmwStock = payload;
    //     }     
    // },