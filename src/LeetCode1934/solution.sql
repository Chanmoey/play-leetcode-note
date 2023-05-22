select s.user_id,
       ifnull(round(sum(action = 'confirmed') / sum(action = 'confirmed' or action = 'timeout'), 2),
              0) as confirmation_rate
from Signups s
         left join Confirmations c
                   on s.user_id = c.user_id
group by user_id;