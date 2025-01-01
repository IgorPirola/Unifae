select funcionario.nome, cargo.nome from funcionario right join cargo on funcionario.codcargo = cargo.codcargo union
select funcionario.nome, cargo.nome from funcionario left join cargo on funcionario.codcargo = cargo.codcargo;
select funcionario.nome, cargo.nome from funcionario inner join cargo on funcionario.codcargo = cargo.codcargo;
select funcionario.nome, cargo.nome from funcionario, cargo where funcionario.codcargo = cargo.codcargo;

select count(*) from funcionario;

select avg(salario) from cargo;

select nome from cargo order by nome asc;

select count(*) from funcionario inner join cargo on funcionario.codcargo = cargo.codcargo where cargo.salario < 5000;