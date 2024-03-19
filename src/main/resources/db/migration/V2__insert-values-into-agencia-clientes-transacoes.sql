INSERT INTO agencia (numero, endereco)
VALUES (1, 'Rua Oscar Freire, 40'),
       (2, 'Avenida Paulista, 123'),
       (3, 'Avenida Brigadeiro Faria Lima, 456'),
       (4, 'Avenida Rebouças, 789');

INSERT INTO clientes (cpf_cnpj, nome, sobrenome, telefone, saldo, senha, email, endereco, ativo, fk_numero_agencia)
VALUES ('59483726184', 'Maria', 'Antonieta', '11987654321', 1000.0, 'TomCruise', 'mariaAntonieta@gmail.com',
        'Avenida Paulista, 100', 1, 1),
       ('83195746822', 'Gustavo', 'Soares', '11987654322', 2500.0, 'AngelinaJoli', 'gustavoSoares@hotmail.com',
        'Rua Oscar Freire, 200', 1, 2),
       ('63958127395', 'Cleiton', 'Rasta', '11987654323', 500.0, 'JohnnyDepp', 'cleitonRasta@gmail.com',
        'Rua Augusta, 300', 0, 3),
       ('72639481928', 'Geova', 'Bomfim', '11987654324', 3000.0, 'JenniferAnis', 'geovaBomfim@hotmail.com',
        'Avenida Rebouças, 400', 1, 4),
       ('18574930281', 'Felipe', 'Alcantara', '11987654325', 1500.0, 'TomHanks', 'felipeAlcantara@app.com',
        'Rua João Cachoeira, 500', 1, 2),
       ('93527846102', 'Ana', 'Silva', '11987654326', 2000.0, 'JuliaRoberts', 'ana.silva@yahoo.com',
        'Rua dos Limões, 100', 1, 1),
       ('32784610935', 'Carlos', 'Santos', '11987654327', 3500.0, 'LeonardoDiCa', 'carlos.santos@yahoo.com',
        'Avenida das Rosas, 200', 1, 2),
       ('51029384765', 'Marina', 'Oliveira', '11987654328', 800.0, 'MerylStreep', 'marina.oliveira@yahoo.com',
        'Rua das Flores, 300', 0, 3),
       ('10928746538', 'Rodrigo', 'Almeida', '11987654329', 4500.0, 'AngelinaJoli', 'rodrigo.almeida@yahoo.com',
        'Avenida dos Pássaros, 400', 1, 4),
       ('20837465910', 'Luciana', 'Pereira', '11987654330', 1500.0, 'BradPitt', 'luciana.pereira@yahoo.com',
        'Rua das Pedras, 500', 1, 4);

INSERT INTO transacoes (conta_favorecido, valor, data, fk_numero_conta)
VALUES (2, 500.0, '2024-01-17 08:00:00', 1),
       (3, 200.0, '2024-02-17 08:30:00', 2),
       (4, 1000.0, '2024-03-17 09:00:00', 2),
       (5, 300.0, '2024-04-17 10:00:00', 3),
       (6, 150.0, '2024-05-17 10:30:00', 4),
       (7, 200.0, '2024-06-17 11:00:00', 5),
       (8, 700.0, '2024-07-17 12:00:00', 6),
       (9, 250.0, '2024-08-17 12:30:00', 7),
       (10, 400.0, '2024-09-17 13:00:00', 8),
       (1, 100.0, '2024-10-17 14:00:00', 9);