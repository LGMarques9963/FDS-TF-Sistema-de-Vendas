CREATE TABLE Clientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Estoques (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    quantidade INT NOT NULL
);

CREATE TABLE Produtos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idEstoque BIGINT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idEstoque) REFERENCES Estoques(id)
);

CREATE TABLE Pedidos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    idProduto BIGINT NOT NULL,
    idCliente BIGINT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Clientes(id),
    FOREIGN KEY (idProduto) REFERENCES Produtos(id)
);

CREATE TABLE Orcamentos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    valorTotal DECIMAL(10,2) NOT NULL,
    imposto DECIMAL(10,2) NOT NULL,
    desconto DECIMAL(10,2) NOT NULL,
    idPedido BIGINT NOT NULL,
    idCliente BIGINT NOT NULL,
    efetivado BOOLEAN NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Clientes(id),
    FOREIGN KEY (idPedido) REFERENCES Pedidos(id)
);
