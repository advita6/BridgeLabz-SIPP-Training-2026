SELECT 
    cd.country_name, 
    cd.death_count, 
    cv.vaccines_administered, 
    cv.vaccination_status
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv 
    ON cd.country_id = cv.country_id;