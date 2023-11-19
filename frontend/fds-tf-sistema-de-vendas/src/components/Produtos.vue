<template>
    <v-container>


        <!-- Listar Produtos-->
        <v-expansion-panels accordion focusable inset>
            <v-toolbar dark>

                <v-toolbar-title>Produtos</v-toolbar-title>

                <v-spacer></v-spacer>

                <v-btn text @click="openAdicionar">
                    Adicionar Produto
                    <v-icon right>mdi-plus</v-icon>
                </v-btn>
            </v-toolbar>
            <v-expansion-panel v-for="produto in produtos" :key="produto.id">
                <v-expansion-panel-header dark>
                    <v-row>
                        {{ produto.nome }}
                    </v-row>

                </v-expansion-panel-header>
                <v-expansion-panel-content>
                    <v-card class="mx-auto">

                        <v-row class="fill-height">
                            <v-card-title>
                                <div class="text-h4 pl-12">
                                    {{ produto.nome }}
                                </div>
                            </v-card-title>
                            <v-spacer></v-spacer>
                            <v-card-title>
                                <v-btn light icon class="mr-4" @click="openEdit(produto.id)">
                                    <v-icon>mdi-pencil</v-icon>
                                </v-btn>

                                <v-btn light icon @click="openRemove(produto.id)">
                                    <v-icon>mdi-delete</v-icon>
                                </v-btn>
                            </v-card-title>
                        </v-row>
                        <v-card-subtitle>
                            <div class="pl-10">
                                CPF: {{ produto.descricao }}
                            </div>
                        </v-card-subtitle>
                        <v-list two-line>
                            <v-list-item>
                                <v-list-item-icon>
                                    <v-icon color="indigo">
                                        mdi-email
                                    </v-icon>
                                </v-list-item-icon>

                                <v-list-item-content>
                                    <v-list-item-title> {{ produto.email }}</v-list-item-title>
                                    <v-list-item-subtitle>Personal</v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                            <v-divider inset></v-divider>
                        </v-list>
                    </v-card>
                </v-expansion-panel-content>
            </v-expansion-panel>
        </v-expansion-panels>
    </v-container>
</template>

<script>
export default {
    name: "Produtos",

    data: () => ({
        produtos: [],
    }),

    methods: {
        getProdutos() {
            this.$http
                .get("/produtos")
                .then((response) => {
                    this.produtos = response.data;
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        openAdicionar() {
            this.$router.push({ name: "AdicionarProduto" });
        },

        openEdit(id) {
            this.$router.push({ name: "EditarProduto", params: { id } });
        },

        openRemove(id) {
            this.$router.push({ name: "RemoverProduto", params: { id } });
        },

    },

    mounted() {
        this.getProdutos();
    },

}
</script>

<style></style>