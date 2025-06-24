SELECT MAX(num) AS num from (
 select num
 from MyNumbers
 group by num
 having count(*)=1)as A;
