SELECT 
    cont.continent_name, 
    SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN continents cont 
    ON cc.continent_id = cont.continent_id
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;