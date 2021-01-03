insert into universities values (1, 'Sorbonne');
insert into lectors (id, first_name, last_name, salary, degree, university_id) values (1, 'ganibal', 'lector', 200, 0, 1), (2, 'fredy', 'cruger', 700, 1, 1), (3, 'mad', 'man', 200, 2, 1);
insert into departments (id, department_name, lector_id ) values (1, 'A', 1), (2, 'B', 1);
insert into lector_department (lector_id, department_id) values (1,2), (1,1), (2,1), (3,1);
