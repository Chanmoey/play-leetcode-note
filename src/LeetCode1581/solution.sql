SELECT customer_id,
       COUNT(customer_id) AS count_no_trans
# 找到未下单的记录
FROM (SELECT v.customer_id AS customer_id, t.transaction_id AS transaction_id
      FROM Visits v
               LEFT JOIN Transactions t ON v.visit_id = t.visit_id) tmp

WHERE transaction_id IS NULL
GROUP BY customer_id;
