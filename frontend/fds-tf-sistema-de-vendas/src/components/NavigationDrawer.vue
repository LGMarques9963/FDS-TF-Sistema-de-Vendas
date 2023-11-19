<template>
    <v-card>
        <v-navigation-drawer v-model="drawer" :mini-variant.sync="mini" permanent>
            <v-list-item class="px-2">
                <v-list-item-avatar>
                    <v-img src="https://randomuser.me/api/portraits/men/85.jpg"></v-img>
                </v-list-item-avatar>

                <v-list-item-title>John Leider</v-list-item-title>

                <v-btn icon @click.stop="mini = !mini">
                    <v-icon>mdi-chevron-left</v-icon>
                </v-btn>
            </v-list-item>

            <v-divider></v-divider>

            <v-list dense>
                <router-link v-for="item in items" :key="item.title" :to="item.path" tag="div" class="router-link">
                    <v-list-item>
                        <v-list-item-icon>
                            <v-icon>{{ item.icon }}</v-icon>
                        </v-list-item-icon>

                        <v-list-item-content>
                            <v-list-item-title>{{ item.title }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </router-link>
            </v-list>
        </v-navigation-drawer>
    </v-card>
</template>

<script>
export default {
    name: "NavigationDrawer",

    data: () => ({
        drawer: true,
        mini: false,
        items: [
            { title: "Clientes", icon: "mdi-inbox", path: "/clientes" },
            { title: "Produtos", icon: "mdi-inbox-arrow-up", path: "/produtos" },
            { title: "Pedidos", icon: "mdi-heart", path: "/pedidos" },
            { title: "Orcamentos", icon: "mdi-archive", path: "/orcamentos" },
            { title: "Estatisticas", icon: "mdi-trash-can", path: "/estatisticas" },
        ],
    }),
}
</script>

<style scoped>
.router-link {
  cursor: pointer;
  transition: background-color 0.3s ease; /* Adiciona uma transição suave de 0.3 segundos */
}

.router-link:hover {
  background-color: #cfd8dc; /* Cor de fundo ao passar o mouse */
}
</style>