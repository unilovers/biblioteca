CREATE TABLE   alunos   (
    cd_aluno   int PRIMARY KEY NOT NULL,
    nm_aluno   varchar(50) NOT NULL,
    dt_nascimento     timestamp NOT NULL,
    tp_sexo   char(1) NOT NULL,
    ds_email   varchar(100) NOT NULL,
    dt_cadastro     timestamp NOT NULL DEFAULT (NOW()),
    sn_ativo   char(1) NOT NULL DEFAULT (S)
);

CREATE TABLE   categoria   (
    cd_categoria   int PRIMARY KEY NOT NULL,
    ds_categoria   varchar(50) NOT NULL
);

CREATE TABLE   bibliotecario   (
    cd_bibliotecario   int PRIMARY KEY NOT NULL,
    nm_bibliotecario   varchar(50) NOT NULL,
    cd_senha   varchar(200) NOT NULL,
    dt_nascimento     timestamp NOT NULL,
    tp_sexo   char(1) NOT NULL,
    ds_email   varchar(100) NOT NULL,
    dt_cadastro     timestamp NOT NULL DEFAULT (NOW()),
    sn_ativo   char(1) NOT NULL DEFAULT (S)
);

CREATE TABLE   livro   (
    cd_livro   int PRIMARY KEY NOT NULL,
    nm_livro   varchar(50) NOT NULL,
    cd_bibliotecario   int NOT NULL,
    cd_categoria   int NOT NULL,
    cd_autor   int NOT NULL,
    cd_aluno   int,
    cd_professor   int,
    sn_locado   char(1) NOT NULL DEFAULT (N),
    dt_cadastro     timestamp NOT NULL DEFAULT (NOW()),
    sn_ativo   char(1) NOT NULL DEFAULT (S)
);

CREATE TABLE   autor   (
    cd_autor   int PRIMARY KEY NOT NULL,
    nm_autor   varchar(50) NOT NULL,
    dt_cadastro     timestamp NOT NULL DEFAULT (NOW())
);

CREATE TABLE   professor   (
    cd_professor   int PRIMARY KEY NOT NULL,
    nm_professor   varchar(50) NOT NULL,
    dt_cadastro     timestamp NOT NULL DEFAULT (NOW()),
    sn_ativo   char(1) NOT NULL DEFAULT (S)
);

ALTER TABLE   livro   ADD FOREIGN KEY (  cd_autor  ) REFERENCES   autor   (  cd_autor  );

ALTER TABLE   livro   ADD FOREIGN KEY (  cd_categoria  ) REFERENCES   categoria   (  cd_categoria  );

ALTER TABLE   livro   ADD FOREIGN KEY (  cd_aluno  ) REFERENCES   alunos   (  cd_aluno  );

ALTER TABLE   livro   ADD FOREIGN KEY (  cd_professor  ) REFERENCES   professor   (  cd_professor  );

ALTER TABLE   livro   ADD FOREIGN KEY (  cd_bibliotecario  ) REFERENCES   bibliotecario   (  cd_bibliotecario  );
