select d.name as Department, e1.name as Employee, e1.salary as Salary
from Employee e1
         join Department d on e1.departmentId = d.id
where e1.salary >= (select max(salary) from Employee e2 where e2.departmentId = e1.departmentId);