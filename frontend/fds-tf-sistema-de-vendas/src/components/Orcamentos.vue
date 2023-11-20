<template>
    <v-container>
        <!-- Listar Orcamentos-->
        <v-expansion-panels accordion focusable inset>
            <v-toolbar dark>

                <v-toolbar-title>Orcamentos</v-toolbar-title>

                <v-spacer></v-spacer>
            </v-toolbar>
            <v-expansion-panel v-for="orcamento in orcamentos" :key="orcamento.id">
                <v-expansion-panel-header dark>
                    <v-row>
                        Cliente {{ orcamento.cliente.nome }} - Orçamento {{ orcamento.id }}
                    </v-row>

                </v-expansion-panel-header>
                <v-expansion-panel-content>
                    <v-card class="mx-auto">

                        <v-row class="fill-height">
                            <v-card-title>
                                <div class="text-h4 pl-12">
                                    {{ orcamento.cliente.nome }}
                                </div>
                            </v-card-title>
                            <v-spacer></v-spacer>
                            <v-card-title>
                                <v-btn light color="success" text class="mr-4" @click="efetivarOrcamento(orcamento.id)">
                                    Efetivar Orçamento
                                    <v-icon>mdi-checkbox-marked-circle</v-icon>
                                </v-btn>
                            </v-card-title>
                        </v-row>
                        <v-card-subtitle>
                            <div class="pl-10">
                                Data do Orçamento {{ orcamento.data }}
                            </div>
                            <div class="pl-10">
                                Valor Total R$ {{ orcamento.valorTotal }}
                            </div>
                            <div class="pl-10">
                                Imposto R$ {{ orcamento.imposto }}
                            </div>
                            <div class="pl-10">
                                Desconto R$ {{ orcamento.desconto }}
                            </div>
                        </v-card-subtitle>
                        <div class="pl-10">
                            <v-chip class="ma-2" color="green" text-color="white" v-if="orcamento.efetivado">
                                Orçamento Efetivado
                            </v-chip>
                            <v-chip class="ma-2" color="red" text-color="white" v-else>
                                Orçamento Não Efetivado
                            </v-chip>
                        </div>
                        <v-list two-line>
                            <v-list-item class="pl-13">
                                <v-list-item-content>
                                    <v-list-item-title> Pedido </v-list-item-title>
                                    <v-list-item-subtitle>Pedido {{ orcamento.pedido.id }} - Data {{ orcamento.pedido.data
                                    }}</v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                            <v-divider inset></v-divider>
                            <v-list-item v-for="item in orcamento.pedido.itens" :key="item.id" class="pl-13">
                                <v-list-content>
                                    <v-list-item-title>Produto {{ item.id }}</v-list-item-title>
                                    <v-list-item-subtitle>Quantidade: {{ item.quantidade }}</v-list-item-subtitle>
                                    <v-list-item-subtitle>Valor Unitário: R$ {{ item.valor }}</v-list-item-subtitle>
                                </v-list-content>
                            </v-list-item>
                        </v-list>
                    </v-card>
                </v-expansion-panel-content>
            </v-expansion-panel>
        </v-expansion-panels>
    </v-container>
</template>

<script>
export default {
    name: "Orcamentos",

    data: () => ({
        orcamentos: [],
    }),

    methods: {
        getOrcamentos() {
            this.$http
                .get("/orcamento")
                .then((res) => {
                    this.orcamentos = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        efetivarOrcamento(id) {
            this.$http
                .put("/orcamento/" + id)
                .then((res) => {
                    alert("Orçamento efetivado com sucesso!");
                    this.getOrcamentos();
                })
                .catch((err) => {
                    console.log(err);
                });
        },

    },

    mounted() {
        this.getOrcamentos();
    },
}
</script>

<style></style>