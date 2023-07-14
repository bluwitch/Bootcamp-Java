-- 1]
SELECT countries.name, languages.language, languages.percentage FROM countries 
JOIN languages ON languages.country_id = countries.id
WHERE languages.language = 'Slovene';

-- 2]
SELECT countries.name, COUNT(*) AS total_cities
FROM countries
JOIN cities ON countries.code = cities.country_code
GROUP BY countries.name
ORDER BY total_cities DESC;

-- 3]
SELECT * 
FROM cities 
WHERE country_code = 'MEX' AND population > 500000 
ORDER BY population DESC;

-- 4]
SELECT  countries.name, languages.language, languages.percentage
FROM countries
JOIN languages ON countries.id = languages.country_id
WHERE languages.percentage > 89
ORDER BY languages.percentage ASC;

-- 5]
SELECT name,surface_area,population FROM countries WHERE surface_area < 501 AND population > 100000;

-- 6]
SELECT * FROM countries WHERE  LOWER(government_form) LIKE '%monarchy%'; -- Para todas las monarquias (LOWER praa buscar mayusculas y minusculas)
SELECT * FROM countries WHERE government_form = 'Constitutional Monarchy'; -- monarquia constitucional

-- Resolucion de la consigna
SELECT * FROM countries 
WHERE government_form = 'Constitutional Monarchy' 
AND capital > 200 AND life_expectancy > 75;


-- 7]
SELECT countries.name,cities.name
FROM countries
JOIN cities ON countries.code = cities.country_code
WHERE countries.code = 'ARG' AND LOWER(district) = 'buenos aires' AND cities.population > 500000;


-- 8]
SELECT region, COUNT(*) AS nro_paises
FROM countries
GROUP BY region
ORDER BY nro_paises DESC;