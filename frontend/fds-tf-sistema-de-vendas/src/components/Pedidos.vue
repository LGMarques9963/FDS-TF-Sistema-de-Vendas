<template>
    <v-container>
        <!-- Loading-->
        <div class="text-center">
            <v-dialog v-model="loading" hide-overlay persistent width="300">
                <v-card color="primary" dark>
                    <v-card-text>
                        Aguarde
                        <v-progress-linear indeterminate color="white" class="mb-0"></v-progress-linear>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </div>

        <!-- Remove-->
        <div class="text-center">
            <v-dialog v-model="remove" hide-overlay persistent width="300">
                <v-alert prominent type="error">
                    Você tem certeza que deseja remover este pedido?
                    <v-col class="shrink">
                        <v-btn color="error" @click="deleteClientes">Remover</v-btn>
                        <v-btn text @click="remove = false">Cancelar</v-btn>
                    </v-col>
                </v-alert>
            </v-dialog>
        </div>

        <!-- Listar Pedidos-->
        <v-expansion-panels accordion focusable inset>
            <v-toolbar dark>
                <v-app-bar-nav-icon></v-app-bar-nav-icon>

                <v-toolbar-title>Pedidos</v-toolbar-title>

                <v-spacer></v-spacer>

            </v-toolbar>
            <v-expansion-panel v-for="pedido in pedidos" :key="pedido.id">
                <v-expansion-panel-header dark>
                    <v-row>
                        Pedido {{ pedido.id }}
                    </v-row>

                </v-expansion-panel-header>
                <v-expansion-panel-content>
                    <v-card class="mx-auto">

                        <v-row class="fill-height">
                            <v-card-title>
                                <div class="text-h4 pl-12">
                                    Pedido {{ pedido.id }}
                                </div>
                            </v-card-title>
                            <v-spacer></v-spacer>
                            <v-card-title>
                                <v-btn light icon class="mr-4" @click="openEdit(pedido.id)">
                                    <v-icon>mdi-pencil</v-icon>
                                </v-btn>

                                <v-btn light icon @click="openRemove(pedido.id)">
                                    <v-icon>mdi-delete</v-icon>
                                </v-btn>
                            </v-card-title>
                        </v-row>
                        <v-list two-line>
                            <v-list-item v-for="item in pedido.itens" :key="item.id" class="pl-13">
                                <v-list-item-content>
                                    <v-list-item-title> R$ {{ item.valor }}</v-list-item-title>
                                    <v-list-item-subtitle>Quantidade: {{ item.quantidade }}</v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                            <v-divider inset></v-divider>
                        </v-list>
                        <v-card-action>
                            <v-btn text @click="gerarOrcamento(pedido.id)">Gerar Orçamento</v-btn>
                        </v-card-action>
                    </v-card>
                </v-expansion-panel-content>
            </v-expansion-panel>
        </v-expansion-panels>
    </v-container>
</template>

<script>
export default {
    name: "Pedidos",

    data: () => ({
        pedidos: [],
        remove: false,
        loading: false,
        idRemove: null,
        editDialog: false,
        addDialog: false,
        idEdit: null,
        formData: {
            itens: [],
        },

    }),

    methods: {
        getPedidos() {
            this.$http
                .get("/pedidos")
                .then((res) => {
                    this.pedidos = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        getPedido(id) {
            this.$http
                .get("/pedidos/" + id)
                .then((res) => {
                    const data = res.data;
                    this.formData.itens = res.data.itens;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        deletePedido() {
            this.$http
                .delete("/pedidos/" + this.idRemove)
                .then((res) => {
                    this.getPedidos();
                    this.remove = false;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        addPedidos() {
            this.$http
                .post("/pedidos", this.formData)
                .then((res) => {
                    this.getPedidos();
                    this.addDialog = false;
                })
                .catch((err) => {
                    console.log(err);
                });

        },

        updatePedidos() {
            this.$http
                .put("/pedidos/" + this.idEdit, this.formData)
                .then((res) => {
                    this.getPedidos();
                    this.editDialog = false;
                })
                .catch((err) => {
                    console.log(err);
                });
        },
        
        gerarOrcamento(id) {
            this.$http
                .post("/orcamento/gerar/" + id)
                .then((res) => {
                    alert("Orçamento gerado com sucesso!")
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        openAdicionar() {
            this.addDialog = true;
        },

        openEdit(id) {
            this.idEdit = id;
            this.getProduto(id);
            this.editDialog = true;
        },

        openRemove(id) {
            this.remove = true;
            this.idRemove = id;
        },

    },

    mounted() {
        this.getPedidos();
    },

    computed: {
        dataFormatada() {
            // Faz o parsing da string de data
            const dataObj = new Date(this.pedidos.data);

            // Obtém os componentes da data
            const dia = String(dataObj.getDate()).padStart(2, '0');
            const mes = String(dataObj.getMonth() + 1).padStart(2, '0');
            const ano = dataObj.getFullYear();
            const hora = String(dataObj.getHours()).padStart(2, '0');
            const minuto = String(dataObj.getMinutes()).padStart(2, '0');
            const segundo = String(dataObj.getSeconds()).padStart(2, '0');

            // Monta a string formatada
            const dataFormatada = `${dia}/${mes}/${ano} ${hora}:${minuto}:${segundo}`;

            return dataFormatada;
        },
    },
}
</script>

<style></style>