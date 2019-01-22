<template>


<nav class="navbar navbar-default">  
    <div>
        <router-link  to="/" class="navbar-brand">
            Stock Trader
        </router-link>
    </div>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="nav navbar-nav">
      <router-link  to="/portfolio" activeClass="active" tag="li">
            <a>Portfolio</a> 
        </router-link>
        <router-link  to="/stocks" activeClass="active" tag="li">
            <a>Stock</a> 
        </router-link>
    </ul>
    <strong class="navbar-text navbar-right">Funds: {{funds | currency}}</strong>
    <ul class="nav navbar-nav navbar-right">
        <li >
        <a href="#" @click="endDay">End Day</a>
      </li>
      <li class="dropdown" :class="{open: isDropdownOpen}" @click="isDropdownOpen= !isDropdownOpen">
        <a 
            class="dropdown-toggle" 
            href="#" 
            role="button" 
            data-toggle="dropdown" 
            aria-haspopup="true" 
            aria-expanded="false">
          Save & Load
        </a>
        <ul class="dropdown-menu">
            <li><a href="#" @click="saveData">Save Data</a></li>
            <li><a href="#" @click="loadData">Load Data</a></li>
        </ul>
      </li>
      
    </ul>   
  </div>
</nav>

  
  

</template>


<script>

import {mapActions} from 'vuex';

export default {
    data(){
        return {
            isDropdownOpen:false
        }
    },
    computed:{
        funds(){
            return this.$store.getters.funds;
        }
    },
    methods:{
         ...mapActions({
            fetchData:"getData"
        }),

        loadPortfolio(){
            return this.$router.push('/portfolio');
        },
        home(){
            return this.$router.push('/');
        },
        stock(){
            return this.$router.push('/stocks');
        },
        endDay(){
            this.$store.dispatch('randomizeStocks');
        },
        saveData(){
            const data = {
                funds:this.$store.getters.funds,
                stocks:this.$store.getters.stocks,
                stockPortfolio:this.$store.getters.stockPortfolio,           
                }
            this.$http.put('data.json',data);
        },
       
        loadData(){
            this.fetchData();
        }
    }
}
</script>
