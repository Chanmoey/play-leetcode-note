select viewer_id as id from Views where viewer_id = author_id group by viewer_id order by viewer_id;

select distinct viewer_id as id from Views where viewer_id = author_id order by viewer_id;