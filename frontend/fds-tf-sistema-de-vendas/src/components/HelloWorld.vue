<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-card-title>Clientes</v-card-title>
          <v-card-text>
            <v-list>
              <v-list-item v-for="cliente in clientes" :key="cliente.id">
                <v-list-item-content>
                  <v-list-item-title>{{ cliente.nome }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "HelloWorld",

  data: () => ({
    clientes: [],
    
  }),
  methods: {
    getClientes() {
      this.$http
        .get("/clientes")
        .then((response) => {
          this.clientes = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },

  mounted() {
    this.getClientes();
  },
};
</script>
