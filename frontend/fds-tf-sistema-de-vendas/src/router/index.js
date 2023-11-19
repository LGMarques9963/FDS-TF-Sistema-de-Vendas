import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/clientes",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/produtos",
    name: "produtos",
    component: () =>
      import(/* webpackChunkName: "produtos" */ "../views/ProdutoView.vue"),
  },
  {
    path: "/pedidos",
    name: "pedidos",
    component: () =>
      import(/* webpackChunkName: "produtos" */ "../views/PedidosView.vue"),
  },
  {
    path: "/orcamentos",
    name: "orcamentos",
    component: () =>
      import(/* webpackChunkName: "produtos" */ "../views/OrcamentosView.vue"),
  },
  {
    path: "/estisticas",
    name: "estatisticas",
    component: () =>
      import(/* webpackChunkName: "produtos" */ "../views/EstatisticasView.vue"),
  }
];

const router = new VueRouter({
  routes,
});

export default router;
