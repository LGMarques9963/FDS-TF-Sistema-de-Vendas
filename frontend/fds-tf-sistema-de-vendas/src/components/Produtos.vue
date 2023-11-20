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
                    Você tem certeza que deseja remover este produto?
                    <v-col class="shrink">
                        <v-btn color="error" @click="deletarProdutos">Remover</v-btn>
                        <v-btn text @click="remove = false">Cancelar</v-btn>
                    </v-col>
                </v-alert>
            </v-dialog>
        </div>

        <!-- Adicionar Produto -->
        <div class="tex-center">
            <v-dialog v-model="addDialog" persistent max-width="600px">
                <v-card>
                    <v-card-title>
                        <span class="text-h5">Adicionar Produto</span>
                    </v-card-title>
                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.nome" label="Nome*" required></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.descricao" label="Descricao*" required></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.valor" label="Valor*" required
                                        prefix="R$"></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field v-model="formData.itemEstoque[0].quantidadeAtual"
                                        label="Quantidade em Estoque*" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field v-model="formData.itemEstoque[0].quantidadeMax"
                                        label="Quantidade Máxima em Estoque"></v-text-field>
                                </v-col>
                            </v-row>
                        </v-container>
                        <small>*Indica um campo obrigatório</small>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" text @click="addDialog = false">
                            Close
                        </v-btn>
                        <v-btn color="blue darken-1" text @click="addProdutos">
                            Save
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </div>

        <!-- Editar Produto -->
        <div class="tex-center">
            <v-dialog v-model="editDialog" persistent max-width="600px">
                <v-card>
                    <v-card-title>
                        <span class="text-h5">Editar Produto</span>
                    </v-card-title>
                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.nome" label="Nome*" required></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.descricao" label="Descricao*" required></v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field v-model="formData.valor" label="Valor*" required
                                        prefix="R$"></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field v-model="formData.itemEstoque[0].quantidadeAtual"
                                        label="Quantidade em Estoque*" required></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6">
                                    <v-text-field v-model="formData.itemEstoque[0].quantidadeMax"
                                        label="Quantidade Máxima em Estoque"></v-text-field>
                                </v-col>
                            </v-row>
                        </v-container>
                        <small>*Indica um campo obrigatório</small>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" text @click="editDialog = false">
                            Close
                        </v-btn>
                        <v-btn color="blue darken-1" text @click="editProduto">
                            Save
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </div>

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
                                {{ produto.descricao }}
                            </div>
                            <div class="pl-10">
                                R$ {{ produto.valor }}
                            </div>
                        </v-card-subtitle>
                        <v-list two-line>
                            <v-list-item v-for="itemEstoque in produto.itemEstoque" :key="itemEstoque.id" class="pl-13">
                                <v-list-item-content>
                                    <v-list-item-title> Quantidade em Estoque: {{ itemEstoque.quantidadeAtual
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
    </v-container>
</template>

<script>
export default {
    name: "Produtos",

    data: () => ({
        produtos: [],
        remove: false,
        loading: false,
        idRemove: null,
        editDialog: false,
        addDialog: false,
        idEdit: null,
        formData: {
            nome: "",
            descricao: "",
            valor: "",
            itemEstoque: [{
                quantidadeAtual: "",
                quantidadeMax: "",
            }],
        },
    }),

    methods: {
        getProdutos() {
            this.$http
                .get("/produtos")
                .then((response) => {
                    this.produtos = response.data;
                })
                .catch((error) => {
                    alert("Erro ao listar produtos")
                    console.log(error);
                });
        },

        getProduto(id) {
            this.$http
                .get(`/produtos/${id}`)
                .then((response) => {
                    const produto = response.data;
                    this.formData.nome = produto.nome;
                    this.formData.descricao = produto.descricao;
                    this.formData.valor = produto.valor;
                    this.formData.itemEstoque[0].quantidadeAtual = produto.itemEstoque[0].quantidadeAtual;
                    this.formData.itemEstoque[0].quantidadeMax = produto.itemEstoque[0].quantidadeMax;
                })
                .catch((error) => {
                    alert("Erro ao buscar produto")
                    console.log(error);
                });
        },

        addProdutos() {
            this.$http
                .post("/produtos", this.formData)
                .then((response) => {
                    this.getProdutos();
                    this.addDialog = false;
                    alert("Produto adicionado com sucesso!")
                })
                .catch((error) => {
                    alert("Erro ao adicionar produto")
                    console.log(error);
                });
        },

        editProduto() {
            const id = this.idEdit;
            this.$http
                .put(`/produtos/${id}`, this.formData)
                .then((response) => {
                    this.getProdutos();
                    this.editDialog = false;
                    alert("Produto editado com sucesso!")
                })
                .catch((error) => {
                    alert("Erro ao editar produto")
                    console.log(error);
                });
        },

        deletarProdutos() {
            const id = this.idRemove;
            this.$http
                .delete(`/produtos/${id}`)
                .then((response) => {
                    this.getProdutos();
                    this.remove = false;
                    alert("Produto removido com sucesso!")
                })
                .catch((error) => {
                    alert("Erro ao remover produto")
                    console.log(error);
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
        this.getProdutos();
    },

}
</script>

<style></style>