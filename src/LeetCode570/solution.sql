select name
from (select a.name, count(*) as num
      from Employee a
               left join Employee b on a.id = b.managerId
      group by a.id) tmp
where tmp.num >= 5;