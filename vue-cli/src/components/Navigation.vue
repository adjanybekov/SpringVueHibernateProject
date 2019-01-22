<template>


<nav class="navbar navbar-default">  
    <div>
        <router-link  to="/" class="navbar-brand">
           Main Page
        </router-link>
    </div>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="nav navbar-nav">
      <router-link  to="/create" activeClass="active" tag="li">
            <a>Add New Topic</a> 
        </router-link>
        <router-link  to="/topics" activeClass="active" tag="li">
            <a>List Topics</a>  
        </router-link>
    </ul>
    <strong class="navbar-text navbar-right">Funds:</strong>
    <ul class="nav navbar-nav navbar-right">
        <li >
        <a href="#" >End Day</a>
      </li>
      <li class="dropdown"  >
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
            <li><a href="#" >Save Data</a></li>
            <li><a href="#" >Load Data</a></li>
        </ul>
      </li>
      
    </ul>   
  </div>
</nav>

  
  

</template>


<script>

// import {mapActions} from 'vuex';

// export default {
//     data(){
//         return {
//             isDropdownOpen:false
//         }
//     },
//     computed:{
//         funds(){
//             return this.$store.getters.funds;
//         }
//     },
//     methods:{
//          ...mapActions({
//             fetchData:"getData"
//         }),

//         loadPortfolio(){
//             return this.$router.push('/portfolio');
//         },
//         home(){
//             return this.$router.push('/');
//         },
//         stock(){
//             return this.$router.push('/stocks');
//         },
//         endDay(){
//             this.$store.dispatch('randomizeStocks');
//         },
//         saveData(){
//             const data = {
//                 funds:this.$store.getters.funds,
//                 stocks:this.$store.getters.stocks,
//                 stockPortfolio:this.$store.getters.stockPortfolio,           
//                 }
//             this.$http.put('data.json',data);
//         },
       
//         loadData(){
//             this.fetchData();
//         }
//     }
// }
</script>
