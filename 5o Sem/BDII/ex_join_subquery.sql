# Comando JOIN
# 1. Listar os nomes dos departamentos e dos seus gerentes.
select d.nome as Departamento, f.nome as Gerente from departamento d join funcionario f on d.id = f.departamentoID where f.id = d.gerente;

# 2. Mostrar os nomes dos funcionários e os nomes dos departamentos que eles trabalham.
select f.nome as Funcionario, d.nome as Departamento from funcionario f left join departamento d on d.id = f.departamentoID;

# 3. Mostrar o nome dos funcionários e o nome de seus supervisores.
select f1.nome as Funcionario, f2.nome as Supervisor from funcionario f1 join funcionario f2 on f2.id = f1.supervisor;


# Subconsultas
#1. Qual o nome do funcionário que possui o maior salário?
select nome from funcionario where salario = (select max(salario) from funcionario);

#2. Listar o nome dos funcionários que não são gerentes.
select nome from funcionario where id not in (select gerente from departamento);

#3. Listar o nome dos funcionários que não trabalham em nenhum departamento.
select nome from funcionario where departamentoID not in (select id from departamento where id) or departamentoID is null;

#4. Listar o nome dos departamentos que não possuem funcionários.
select nome as Departamento from departamento where id not in (select departamentoID from funcionario where departamentoID is not null);

#5. Listar o nome dos departamentos que possuem funcionários.
select nome as Departamento from departamento where id in (select departamentoID from funcionario);

#6. Listar os nomes dos funcionários que possuem salário maior do que o salário de todos os funcionários do departamento 1.
select nome from funcionario where salario > (select sum(salario) from funcionario where departamentoID = 1);


#Outras consultas
#1. Listar os nomes dos funcionários que não possuem supervisor.
select nome from funcionario where supervisor is null or supervisor not in (select id from funcionario);

#2. Listar os nomes dos funcionários que trabalham nos departamentos 1 ou 2.
select nome from funcionario where departamentoID in(1, 2);

#3. Listar os nomes dos funcionários que ganham entre 2000.00 e 3000.00.
select nome from funcionario where salario between 2000 and 3000;

#4. Listar os nomes dos funcionários que possuem sobrenome ‘Silva’.
select nome from funcionario where nome like('%Silva%');

#5. Listar a quantidade de funcionários em cada departamento.
select d.nome as Departamento, count(f.id) as Qtd_Func from funcionario f join departamento d on f.departamentoID = d.id group by d.nome;

#6. Listar para os departamentos com mais de 3 funcionários, o número do departamento e a quantidade de funcionários.
select d.id as ID_Dep, count(f.id) as Qtd_Func from departamento d join funcionario f on f.departamentoID = d.id group by d.id having count(f.id) > 3;