<template>
  <v-app>
    <app-bar />
    <v-main class="d-flex">
      <v-row>
        <v-col class="flex-shrink-0 flex-grow-0">
          <navigation-drawer />
        </v-col>
        <v-col>
          <router-view />
        </v-col>
      </v-row>
    </v-main>
  </v-app>
</template>

<script>
import NavigationDrawer from './components/NavigationDrawer.vue';
import AppBar from './components/AppBar.vue';

export default {
  
  name: "App",

  components: {
    NavigationDrawer,
    AppBar,
  },

  data: () => ({
    //
  }),
};
</script>
