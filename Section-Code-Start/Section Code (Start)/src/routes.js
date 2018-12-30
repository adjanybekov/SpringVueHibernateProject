import MainPageText from './components/MainPageText.vue';
import Portfolio from './components/Portfolio.vue';
import Stock from './components/Stock.vue';

export const routes = [
    { path:'',component:MainPageText},
    { path:'/portfolio', component:Portfolio},
    { path:'/stock', component:Stock}
];