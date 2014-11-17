insert into grau_instituicao (descricao)
values ('Ensino fundamental incompleto'), ('Ensino fundamental completo'), ('Ensino fundamental cursando'),
	   ('Ensino médio incompleto'), ('Ensino médio completo'), ('Ensino médio cursando'),
	   ('Ensino superior incompleto'), ('Ensino superior completo'), ('Ensino superior cursando');


insert into perfil (descricao)
values ('Administrador'),('Palestrante'), ('Participante'), ('Recepção'), ('Gestor');

insert into endereco (cep, logradouro, numero, bairro, cidade, estado, complemento)
values ('25563325', 'Avenida Londres', '152', 'Olaria', 'Rio de Janeiro','RJ', ''),
('85502693', 'Rua Lonrenço Jorge', '21', 'Olaria', 'Rio de Janeiro','RJ', 'casa 2'),
('85996523', 'Rua Domingues Queiroz', '855', 'Barra da Tijuca', 'Rio de Janeiro','RJ', ''),
('25569632', 'Avenia Nintendo', '447', 'Recreio', 'Rio de Janeiro','RJ', 'Ap.:908');

insert into participante (nome, nomesocial, senha, sexo, cpf, data_nascimento, telefone_residencial, telefone_celular, email, cod_grauist, cod_perfil, cod_endereco)
values ('Maria Lucia', 'MLucia', 'maria21', 'F', '21552632233','1995-11-08', '02125569638', '02175956332', 'MariaLucia@email.com', '8', '3', '6'),
('Maria Eugênia', 'Maria001', '8559652', 'F', '89965223544', '1998-01-09', '02145889655', '02178859663', 'eugeninha@gmail.com', '5', '4', '7'),
('Gustavo Lima', 'cantorgus', '9963352', 'M', '26635626666', '1996-12-30','02145422366', '02155524112', 'GusLima@hotmail.com', '6', '2', '7'),
('Matheus', 'Math', 'nachos', 'M', '14552563695', '1992-04-15','02148555963', '021994522563', 'mathdosnachos@bol.com', '8', '4', '8'),
('Allan', 'All', 'macacosaoamor', 'M', '14552633562', '1998-03-29','02124522256', '021978558960', 'allan@hotmail.com', '9', '5', '9'),
('Maria Eugênia', 'Maria001', '8559652', 'F', '89965223544', '1990-09-27','02145889655', '02178859663', 'eugeninhagmail.com', '5', '4', '1'),
('Vivane Nogueira', 'Vivi', 'eusou10', 'F', '45885965236', '1998-12-19','02124552635', '021979799795', 'eugeninhagmail.com', '4', '2', '9');

insert into participante (nome, nomesocial, senha, sexo, cpf, data_nascimento, telefone_residencial, telefone_celular, email, cod_grauist, cod_perfil, cod_endereco)
values ('Gustavo Ramos', 'Gutao', 'meunomee', 'M', '48559632156','1993-12-06', '02127855826', '02178599632', 'GUTINHO@gamil.com', '8', '3', '6'),
('Marcia Golveia', 'Marcinha', '5885marcia', 'F', '74458555569', '1998-08-28', '02138552635', '02175563221', 'maria_golveia@gmail.com', '5', '4', '7'),
('Roberto Maia', 'RMaia', 'eusoudmais', 'M', '59996599623', '1996-05-26','02125662366', '02198559632', 'maiaroberto@hotmail.com', '6', '2', '7'),
('Jocecreide Nazaré', 'aguaazul', 'nachos', 'F', '78859666523', '1999-04-25','02128526363', '021988895636', 'jocecreide@bol.com', '8', '4', '8'),
('Geremias Lucemburgo', 'Lucemburgo', 'papelcomfolhas', 'M', '45855269633', '1998-09-30','02196659663', '021978558960', 'LUCEMBURGO@hotmail.com', '9', '5', '9'),
('Mariana Redardos', 'Marianaccdc', 'semcor', 'F', '02556963335', '1995-09-27','02125569633', '02175885989', 'Retardos@gmail.com', '5', '4', '1');

insert into palestrante (cod_participante)
values (20), (5), (22);

insert into evento (codigo, nome, descricao, data_inicio, data_fin, local, status)
values (1, 'Semana Tecnógica', 'Semana de integração tecnológica na FAETERJ', '2014-02-18', '2014-02-24', 'FAETERJ', '0');

insert into tipo (descricao)
values ('Workshop'),
	   ('Palestra'),
	   ('Mini Curso'),
	   ('Apresentação de TCC');

insert into atividade (nome, resumo, data, hora, duracao, descricao, status, cod_tipo, cod_evento)
values ('Apresentação Geral', 'Apresentação da FAETERJ e do curso de Análise de Sistemas', '2015-02-18', '00:08:00', '2', 'Apresentação da faculdade tecnológica e do curso de Análise de Sistemas', 0, 2,1),
       ('Mini Curso JAVA', 'Curso de introdução a JAVA', '2015-02-19', '00:14:00', '3', 'Curso de JAVA com foco principal em alunos do 2º a 3º período', 0, 3,1);



select * from atividade_palestrante