create database locadoradecarros;
use  locadoradecarros;



Create table clientes(
cpf varchar(14) primary key not null,
nome varchar(100) not null,
endereco varchar(100) not null



  
);
create table carros(
placa_carro varchar(8) not null primary key,
estado varchar(100) not null
);

create table cliente_Carros(
cpf varchar(14)  not null,
placa_carro varchar(8) not null,
data_locada date not null ,
data_devolvido date not null,
primary key(cpf,placa_carro),
foreign key (cpf) references Clientes(cpf),
foreign key (placa_carro) references Carros(placa_carro)

);
select * from clientes a inner join carros b inner join cliente_carros c on a.cpf = c.cpf and c.placa_carro = b.placa_carro;