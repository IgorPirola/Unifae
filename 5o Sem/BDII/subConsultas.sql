/*Clientes que possuem pedido*/
SELECT c.nome_cli
FROM cliente c where cod_cli in (select cod_cli from pedido);


/*Clientes que não possuem pedido*/
select c.nome_cli
from cliente c where cod_cli not in (select cod_cli from pedido);


/*Clientes que possuem pedido com o vendedor Gabriel*/
select (select c.nome_cli from cliente c where c.cod_cli = p.cod_cli) as "Nome Cliente"
from pedido p where p.cod_vend in (select cod_vend from vendedor where nome_vend = 'Gabriel');


/*Exibir o nome do vendedor que possui salário maior do que pelo menos 1 vendedor de São João"*/
select nome_vend
from vendedor where salario > some(select salario from vendedor where endereco = 'São João');


/*Exibir o nome do vendedor que possui salario maior do que todos os vendedores de São João"*/
select nome_vend
from vendedor where salario > all(select salario from vendedor where endereco = 'São João');


/*Exibir o nome do cliente e a quantidade de pedidos que realizou*/
select nome_cli, (select count(*) from pedido p where c.cod_cli = p.cod_cli) as QtdPedido
from cliente c;


/* para cada produto, mostrar a quantidade de itens que foram vendidos deste produto */
select (select desc_prod from produto pr where pr.cod_prod = it.cod_prod) as Produto, sum(qtde_ped) as QtdVend
from itempedido it where cod_prod in (select cod_prod from produto) group by it.cod_prod;


/* para cada produto, mostrar a quantidade de itens que foram vendidos deste produto, mostrar também a quantidade de pedidos que comprou cada produto*/
select p.desc_prod, (select sum(qtde_ped) from itempedido it where it.cod_prod = p.cod_prod) as Qtd, (select count(num_ped) from itempedido it where p.cod_prod = it.cod_prod) as qtdPedido 
from produto p;