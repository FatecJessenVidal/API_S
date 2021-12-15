# Criando o Banco de dados:
create database pi_grupo6
default character set utf8
default collate utf8_general_ci;

# Selecionando o Banco de dados:
use pi_grupo6;

# Criando a tabela Usuário:
create table usuario(
id_user int not null auto_increment,
nome_user varchar(40) not null,
cpf_user char(11) not null,
login_user varchar(20) not null,
senha_user varchar(20) not null,
tipo_user varchar(20) not null,
primary key(id_user)
) default charset = utf8;

# Criando o usuário administrador:
insert into usuario(nome_user, cpf_user, login_user, senha_user, tipo_user)
values('Administrador', '00000000000', 'Admin', 'admin', 'Administrador');

# Criando a tabela Cliente:
create table cliente(
id_cli int not null auto_increment,
nome_cli varchar(40) not null,
cpf_cnpj_cli char(14) not null,
rua_cli varchar(40) not null,
numero_cli int not null,
complemento_cli varchar(20),
bairro_cli varchar(20) not null,
cidade_cli varchar(20) not null,
estado_cli char(2) not null,
cep_cli int not null,
telefone_cli char(12),
primary key(id_cli)
) default charset = utf8;

#Criando a tabela conta de Luz:
create table conta_luz(
id_contaluz int not null auto_increment,
id_cliente_contaluz int not null
references cliente(id_cli),
cod_identif_contaluz int not null,
grupo_subgrupo_contaluz char(10) not null,
tpfornecimento_contaluz char(15) not null,
modtarifaria_contluz char(15) not null,
rotleitura_contluz char(20) not null,
codfiscal_contaluz char(10) not null,
classe_subclasse_contaluz char(20) not null,
tensaonominal_contaluz char(15) not null,
medidor_contaluz int not null,
id_clienteconsumo_contaluz int not null
references cliente(id_cli),
valortotal_contaluz float not null,
numeroinstalacao_contaluz int not null,
consumo_contluz int not null,
datavenc_contaluz date not null,
contames_contaluz char(20),
bandtarifárias varchar(300) not null,
emissao_contaluz date not null,
leituraanterior_contaluz date not null,
leituraatual_contaluz date not null,
prevproxleit_contaluz date not null,
diasfatura_contaluz int not null,
avisos_contaluz varchar(150),
leit_ant_contaluz float not null,
leit_atual_contaluz float not null,
const_mult_contaluz float not null,
primary key(id_contaluz)
)default charset = utf8;

# Verificando as tabelas criadas:
select * from usuario;
select * from cliente;
select * from conta_luz;