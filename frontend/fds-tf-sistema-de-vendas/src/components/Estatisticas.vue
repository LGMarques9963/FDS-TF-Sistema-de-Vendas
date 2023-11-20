<template>
    <v-container>
        <v-row>

            <v-card class="mx-auto">

                <v-card-title>
                    Produtos Mais Comprados
                </v-card-title>

                <v-card-actions>
                    <v-btn color="orange lighten-2" text @click="showMaisComprados = !showMaisComprados">
                        Visualizar


                        <v-spacer></v-spacer>


                        <v-icon>{{ showMaisComprados ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                </v-card-actions>

                <v-expand-transition>
                    <div v-show="showMaisComprados">
                        <v-expansion-panels accordion focusable inset>
                            <v-expansion-panel v-for="produto in produtosMaisComprados" :key="produto.id">
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
                                        </v-row>
                                        <v-card-subtitle>
                                            <div class="pl-10">
                                                {{ produto.descricao }}
                                            </div>
                                            <div class="pl-10">
                                                R$ {{ produto.valor }}
                                            </div>
                                        </v-card-subtitle>
                                        <v-list two-line>
                                            <v-list-item v-for="itemEstoque in produto.itemEstoque" :key="itemEstoque.id"
                                                class="pl-13">
                                                <v-list-item-content>
                                                    <v-list-item-title> Quantidade em Estoque: {{
                                                        itemEstoque.quantidadeAtual
                                                    }}</v-list-item-title>
                                                    <v-list-item-subtitle>Quantidade Máxima {{ itemEstoque.quantidadeMax
                                                    }}</v-list-item-subtitle>
                                                </v-list-item-content>
                                            </v-list-item>
                                            <v-divider inset></v-divider>
                                        </v-list>
                                    </v-card>
                                </v-expansion-panel-content>
                            </v-expansion-panel>
                        </v-expansion-panels>
                    </div>
                </v-expand-transition>
            </v-card>

            <v-card class="mx-auto">

                <v-card-title>
                    Meses com mais Vendas
                </v-card-title>

                <v-card-actions>
                    <v-btn color="orange lighten-2" text @click="showMaisVendas = !showMaisVendas">
                        Visualizar


                        <v-spacer></v-spacer>


                        <v-icon>{{ showMaisVendas ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                </v-card-actions>

                <v-expand-transition>
                    <div v-show="showMaisVendas">
                        <v-list>
                            <v-list-item-group v-for="(qtdeVendas, mes) in mesesComMaisVendas" :key="mes">
                                <v-list-item>
                                    <v-list-item-content>
                                        <v-list-item-title>Mês: {{ mes }}</v-list-item-title>
                                        <v-list-item-subtitle>Quantidade de Vendas: {{ qtdeVendas }}</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-list-item>
                            </v-list-item-group>
                        </v-list>
                    </div>
                </v-expand-transition>
            </v-card>
            <v-card class="mx-auto">

                <v-card-title>
                    Clientes Inadiplentes
                </v-card-title>

                <v-card-actions>
                    <v-btn color="orange lighten-2" text @click="showInadiplentes = !showInadiplentes">
                        Visualizar


                        <v-spacer></v-spacer>


                        <v-icon>{{ showInadiplentes ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                </v-card-actions>

                <v-expand-transition>
                    <div v-show="showInadiplentes">
                        <v-list>
                            <v-list-item-group v-for="cliente in clientesInadiplentes" :key="cliente.id">
                                <v-list-item>
                                    <v-list-item-content>
                                        <v-list-item-title>Cliente: {{ cliente.nome }}</v-list-item-title>
                                        <v-list-item-subtitle>Email: {{ cliente.email }}</v-list-item-subtitle>
                                        <v-list-item-subtitle>Quantidade de Pedidos: {{ calcularQuantidadePedidos(cliente) }}</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-list-item>
                            </v-list-item-group>
                        </v-list>
                    </div>
                </v-expand-transition>
            </v-card>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: "Estatisticas",

    data: () => ({
        showMaisComprados: false,
        showMaisVendas: false,
        showInadiplentes: false,
        produtosMaisComprados: [],
        mesesComMaisVendas: {},
        clientesInadiplentes: [],
    }),

    methods: {
        getProdutosMaisComprados() {
            this.$http
                .get("/estatisticas/produtosMaisComprados")
                .then((response) => {
                    this.produtosMaisComprados = response.data;
                })
                .catch((error) => {
                    alert("Erro ao buscar produtos mais comprados")
                    console.log(error);
                });
        },

        getMesesComMaisVendas() {
            this.$http
                .get("/estatisticas/mesesMaisVendas")
                .then((response) => {
                    const apiResponse = response.data;

                    // Converte o objeto em um array de pares chave-valor
                    const entries = Object.entries(apiResponse);

                    // Ordena o array com base nos valores (números)
                    const sortedEntries = entries.sort((a, b) => b[1] - a[1]);

                    // Reconstrói o objeto a partir do array ordenado
                    const sortedObject = Object.fromEntries(sortedEntries);
                    this.mesesComMaisVendas = sortedObject;
                })
                .catch((error) => {
                    alert("Erro ao buscar meses com mais vendas")
                    console.log(error);
                });
        },

        getClientesInadiplentes() {
            this.$http
                .get("/estatisticas/clientesInadiplentes")
                .then((response) => {
                    this.clientesInadiplentes = response.data;
                })
                .catch((error) => {
                    alert("Erro ao buscar clientes inadiplentes")
                    console.log(error);
                });
        },

        calcularQuantidadePedidos(cliente) {
            return cliente.pedidos.length;
        },

    },

    mounted() {
        this.getProdutosMaisComprados();
        this.getMesesComMaisVendas();
        this.getClientesInadiplentes();
    },

}
</script>

<style></style>