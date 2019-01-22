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
    <ul class="nav navbar-nav navbar-right">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>   
  </div>
</nav>
    <!-- <div class="row">
        <div class="col-sm-2"> <button class="btn btn-primary" @click="home">Stock Trade</button></div>
        <div class="col-sm-1"><button class="btn btn-primary" @click="loadPortfolio">Portfolio</button></div>
        <div class="col-sm-4"><button class="btn btn-primary" @click="stock">Stock</button></div>
        <div class="col-sm-1"><button class="btn btn-primary">End Day</button></div>     
        <div class="col-sm-2"><button class="btn btn-primary">Save & Load</button></div>               
        <div class="col-sm-1"><p>Funds {{funds}}</p></div>               
        </div>         -->
  
  

</template>


<script>
export default {
    computed:{
        funds(){
            return this.$store.state.funds;
        }
    },
    methods:{
        loadPortfolio(){
            return this.$router.push('/portfolio');
        },
        home(){
            return this.$router.push('/');
        },
        stock(){
            return this.$router.push('/stock');
        }
    }
}
</script>
