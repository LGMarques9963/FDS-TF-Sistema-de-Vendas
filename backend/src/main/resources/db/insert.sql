INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Ana Pereira', '12345678910', 'anapereira@gmail.com', '123456');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Carlos Oliveira', '98765432101', 'carlosoliveira@gmail.com', 'abcdef');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Mariana Santos', '65432198710', 'marianasantos@gmail.com', '789012');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Rafael Souza', '78901234567', 'rafaelsouza@gmail.com', 'qwerty');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Juliana Lima', '23456789012', 'julianalima@gmail.com', 'abc123');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Lucas Martins', '34567890123', 'lucasmartins@gmail.com', '456789');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Isabela Pereira', '45678901234', 'isabelapereira@gmail.com', 'xyz789');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Fernando Oliveira', '56789012345', 'fernandooliveira@gmail.com', '567890');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Camila Santos', '67890123456', 'camilasantos@gmail.com', 'p@ssw0rd');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Rodrigo Souza', '78901234567', 'rodrigosouza@gmail.com', 'password');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Aline Lima', '89012345678', 'alinelima@gmail.com', 'aline123');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Gustavo Martins', '90123456789', 'gustavomartins@gmail.com', 'martins456');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Carolina Pereira', '12345678910', 'carolinapereira@gmail.com', '7890123');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Diego Oliveira', '23456789012', 'diegooliveira@gmail.com', 'doliveira');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Renata Santos', '34567890123', 'renatasantos@gmail.com', 'rsantos123');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Vinícius Souza', '45678901234', 'viniciussouza@gmail.com', 'vsouza456');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Patrícia Lima', '56789012345', 'patricialima@gmail.com', 'plima789');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Luciano Martins', '67890123456', 'lucianomartins@gmail.com', 'lmartins567');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Beatriz Pereira', '78901234567', 'beatrizpereira@gmail.com', 'beatriz123');
INSERT INTO Clientes (nome, cpf, email, senha) VALUES ('Carlos Aquino', '71235439871', 'carlosaquino@gmail.com', 'carlos123');

INSERT INTO Estoques (quantidade) VALUES (1);

INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 1', 1, 'Descrição do Produto 1', 100.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 2', 1, 'Descrição do Produto 2', 200.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 3', 1, 'Descrição do Produto 3', 300.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 4', 1, 'Descrição do Produto 4', 400.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 5', 1, 'Descrição do Produto 5', 500.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 6', 1, 'Descrição do Produto 6', 600.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 7', 1, 'Descrição do Produto 7', 700.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 8', 1, 'Descrição do Produto 8', 800.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 9', 1, 'Descrição do Produto 9', 900.00);
INSERT INTO Produtos (nome, idEstoque, descricao, valor) VALUES ('Produto 10', 1, 'Descrição do Produto 10', 1000.00);


INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-01', 1, 1);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-02', 2, 2);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-03', 3, 3);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-04', 4, 4);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-05', 5, 5);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-06', 6, 6);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-07', 7, 7);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-08', 8, 8);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-09', 9, 9);
INSERT INTO Pedidos (data, idProduto, idCliente) VALUES ('2021-01-10', 10, 10);

INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (1, 1, 1);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (2, 2, 2);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (2, 3, 3);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (5, 4, 4);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (5, 5, 5);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (7, 6, 6);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (7, 7, 7);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (8, 8, 8);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (8, 9, 9);
INSERT INTO ItemPedido (idPedido, idProduto, quantidade) VALUES (10, 10, 10);


INSERT INTO Orcamentos (data, valorTotal, imposto, desconto, idPedido, idCliente, efetivado) VALUES ('2021-01-01', 100.00, 10.00, 0.00, 1, 1, true);
INSERT INTO Orcamentos (data, valorTotal, imposto, desconto, idPedido, idCliente, efetivado) VALUES ('2021-01-02', 200.00, 20.00, 0.00, 2, 2, true);
INSERT INTO Orcamentos (data, valorTotal, imposto, desconto, idPedido, idCliente, efetivado) VALUES ('2021-01-03', 300.00, 30.00, 0.00, 3, 3, true);
INSERT INTO Orcamentos (data, valorTotal, imposto, desconto, idPedido, idCliente, efetivado) VALUES ('2021-01-04', 400.00, 40.00, 0.00, 4, 4, true);
INSERT INTO Orcamentos (data, valorTotal, imposto, desconto, idPedido, idCliente, efetivado) VALUES ('2021-01-05', 500.00, 50.00, 0.00, 5, 5, true);


