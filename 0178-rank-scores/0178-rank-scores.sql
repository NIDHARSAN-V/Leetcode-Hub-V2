SELECT 
  p.Score,  
  (
    SELECT COUNT(DISTINCT s.Score) 
    FROM Scores s 
    WHERE p.Score <= s.Score
  ) AS `rank`
FROM Scores p
ORDER BY `rank`;
