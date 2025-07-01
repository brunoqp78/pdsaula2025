INSERT INTO tb_category (name) VALUES
('Super Especial'),
('Especial');


INSERT INTO tb_address (street, city, state, zip_code) VALUES
('Rua das Flores, 123', 'São Paulo', 'SP', '01234-567'),
('Avenida Brasil, 456', 'Rio de Janeiro', 'RJ', '20000-000'),
('Rua dos Coqueiros, 789', 'Belo Horizonte', 'MG', '30123-456'),
('Avenida Paulista, 1000', 'São Paulo', 'SP', '01310-200'),
('Rua da Praia, 55', 'Salvador', 'BA', '40000-000'),
('Avenida das Palmeiras, 321', 'Curitiba', 'PR', '80000-000'),
('Rua dos Pinheiros, 999', 'Porto Alegre', 'RS', '90000-000'),
('Avenida Central, 777', 'Brasília', 'DF', '70000-000'),
('Rua das Oliveiras, 222', 'Fortaleza', 'CE', '60000-000'),
('Avenida Beira-Mar, 1010', 'Recife', 'PE', '50000-000');

INSERT INTO tb_client (name, cpf, income, birth_date, children, address_fk, category_fk) VALUES
('João Silva', '123.456.789-01', 2500.00, '1985-05-15 00:00:00', 2, 1, 1),
('Maria Oliveira', '987.654.321-09', 3200.50, '1990-08-22 00:00:00', 1, 2, 2),
('Carlos Souza', '456.789.123-45', 1800.75, '1995-11-30 00:00:00', 0, 3, 1),
('Ana Pereira', '789.123.456-78', 4200.00, '1982-03-10 00:00:00', 3, 4, 1),
('Pedro Costa', '321.654.987-32', 2900.25, '1988-07-18 00:00:00', 1, 5, 1),
('Lucia Santos', '654.321.987-65', 3800.00, '1992-09-25 00:00:00', 2, 6, 2),
('Marcos Rocha', '147.258.369-14', 5100.50, '1980-12-05 00:00:00', 4, 7, 1),
('Fernanda Lima', '258.369.147-25', 2700.75, '1993-04-20 00:00:00', 0, 8, 1),
('Ricardo Alves', '369.147.258-36', 3500.00, '1987-06-12 00:00:00', 1, 9, 1),
('Juliana Castro', '951.753.852-96', 4300.25, '1991-02-28 00:00:00', 2, 10, 1);