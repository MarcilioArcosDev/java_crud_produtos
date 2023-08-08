create table produto(
	id  serial  primary key,
	nome  varchar(100)  not null,
	descricao  varchar(250) not null,
	preco  numeric(18,2),
	quantidade  integer not null
);

insert into produto(nome, descricao, preco, quantidade)
values('Notebook Dell', 'Core i7 SSA 8GB', 6000.0, 10);

update produto
	set
		nome = 'Notebook Acer',
		descricao = 'Core i5 8GB SSD',
		preco = 5000.0,
		quantidade = 15
	where 
		id = 1;
		
delete from produto where id = 3;		

select * from produto order by id;