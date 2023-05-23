select product_id, round(sum(total_price) / sum(units), 2) as average_price
from (select p.product_id, p.price * u.units as total_price, u.units
      from Prices p
               join UnitsSold u on p.product_id = u.product_id
      where u.purchase_date >= p.start_date
        and u.purchase_date <= p.end_date) temp
group by product_id;