CREATE TABLE Clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    idPedido BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    FOREIGN KEY (idPedido) REFERENCES Pedidos (id),
);

CREATE TABLE Pedidos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,
    valorTotal DECIMAL(10,2) NOT NULL,
    idProduto BIGINT NOT NULL,
    idOrcamento BIGINT NOT NULL,
    idCliente BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES Clientes (id)
    FOREIGN KEY (idProduto) REFERENCES Produtos (id),
    FOREIGN KEY (idOrcamento) REFERENCES Orcamentos (id),
);

CREATE TABLE Produtos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    idPedido BIGINT NOT NULL,
    idEstoque BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idPedido) REFERENCES Pedidos (id),
    FOREIGN KEY (idEstoque) REFERENCES Estoques (id),
);

CREATE TABLE Orcamentos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,
    valorTotal DECIMAL(10,2) NOT NULL,
    idPedido BIGINT NOT NULL,
    idCliente BIGINT NOT NULL,
    idCliente BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES Clientes (id)
    FOREIGN KEY (idPedido) REFERENCES Pedidos (id),
);

CREATE TABLE Estoques (
    id BIGINT NOT NULL AUTO_INCREMENT,
    quantidade INT NOT NULL,
    idProduto BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idProduto) REFERENCES Produtos (id)
);
