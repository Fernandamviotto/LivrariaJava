-- Tabela: Usuario
CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY, -- ID do usuário (auto incrementado)
    nome VARCHAR(100) NOT NULL,    -- Nome do usuário
    email VARCHAR(100) NOT NULL,   -- E-mail do usuário
    data_cadastro DATE NOT NULL,   -- Data de cadastro
    qtd_livros_emprestados INT DEFAULT 0 -- Quantidade de livros atualmente emprestados
);

-- Tabela: Livro
CREATE TABLE Livro (
    id_livro SERIAL PRIMARY KEY,    -- ID do livro (auto incrementado)
    titulo VARCHAR(255) NOT NULL,   -- Título do livro
    autor VARCHAR(100) NOT NULL,    -- Autor do livro
    editora VARCHAR(100) NOT NULL,  -- Editora do livro
    ano_publicacao INT,             -- Ano de publicação
    disponibilidade BOOLEAN DEFAULT TRUE -- Disponibilidade (true: disponível, false: emprestado)
);

-- Tabela: Emprestimo
CREATE TABLE Emprestimo (
    id_emprestimo SERIAL PRIMARY KEY,   -- ID do empréstimo (auto incrementado)
    id_usuario INT,                     -- Chave estrangeira para o Usuário
    id_livro INT,                       -- Chave estrangeira para o Livro
    data_emprestimo DATE NOT NULL,      -- Data do empréstimo
    data_devolucao_prevista DATE NOT NULL, -- Data de devolução prevista
    data_devolucao_real DATE,           -- Data de devolução realizada (pode ser nula se ainda não devolvido)
    status VARCHAR(20) CHECK (status IN ('ativo', 'concluido', 'em_atraso')) NOT NULL, -- Status do empréstimo
    multa DECIMAL(10, 2) DEFAULT 0.0,   -- Multa aplicada em caso de atraso
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT fk_livro FOREIGN KEY (id_livro) REFERENCES Livro(id_livro)
);