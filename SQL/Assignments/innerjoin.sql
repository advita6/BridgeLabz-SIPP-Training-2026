SELECT 
    c.country_name, 
    cc.confirmed_cases,
    cc.record_date
FROM covid_cases cc
INNER JOIN countries c 
    ON cc.country_id = c.country_id
WHERE cc.record_date = '2023-10-01' -- Replace with your target date
ORDER BY cc.confirmed_cases DESC
LIMIT 1;