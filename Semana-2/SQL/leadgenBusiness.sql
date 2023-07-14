/*¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?*/

SELECT sum(billing.amount), billing.charged_datetime FROM billing
WHERE billing.charged_datetime LIKE '2012-03%';

/*¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del cliente
 con una identificación de 2?*/
 
SELECT b.amount, c.client_id FROM billing b
JOIN clients c ON c.client_id = b.client_id
WHERE c.client_id = 2;

/*¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?*/

SELECT s.domain_name, c.client_id FROM sites s
JOIN clients c ON c.client_id = s.client_id
WHERE c.client_id = 10;

/*¿Qué consulta ejecutaría para obtener el número total de sitios creados por mes
 por año para el cliente con una identificación de 1? ¿Qué pasa con el cliente = 20*/
 
SELECT  YEAR(created_datetime) AS year, MONTH(created_datetime) AS month, COUNT(*) AS total_sites FROM sites s
JOIN clients c ON c.client_id = s.client_id
WHERE c.client_id = 1
GROUP BY YEAR(created_datetime), MONTH(created_datetime) -- Se agrupa por año y mes para que cuente la cantidad de sitios
ORDER BY YEAR(created_datetime), MONTH(created_datetime);

/*id = 20*/
SELECT  YEAR(created_datetime) AS year, MONTH(created_datetime) AS month, COUNT(*) AS total_sites FROM sites s
JOIN clients c ON c.client_id = s.client_id
WHERE c.client_id = 20
GROUP BY YEAR(created_datetime), MONTH(created_datetime)
ORDER BY YEAR(created_datetime), MONTH(created_datetime);

/*¿Qué consulta ejecutaría para obtener el número total de clientes potenciales
 generados para cada uno de los sitios entre el 1 de enero de 2011 y el 15 de febrero
 de 2011?*/
 
SELECT sites.domain_name,COUNT(*) FROM sites
JOIN leads ON leads.site_id = sites.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-02-15'
GROUP BY sites.domain_name;


/*¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número
 total de clientes potenciales que hemos generado para cada uno de nuestros clientes
 entre el 1 de enero de 2011 y el 31 de diciembre de 2011?*/
SELECT clients.first_name, COUNT(leads.first_name) AS cuenta_leads FROM clients
JOIN sites ON sites.client_id = clients.client_id
JOIN leads ON leads.site_id = sites.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-12-31'
GROUP BY clients.first_name
ORDER BY cuenta_leads DESC;

/*¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número
 total de clientes potenciales que hemos generado para cada cliente cada mes entre
 los meses 1 y 6 del año 2011?*/
 
SELECT clients.first_name, COUNT(leads.leads_id) FROM clients
JOIN sites ON sites.client_id = clients.client_id
JOIN leads ON leads.site_id = sites.site_id
WHERE YEAR(leads.registered_datetime) = 2011 AND MONTH(leads.registered_datetime) BETWEEN 1 AND 6
GROUP BY clients.first_name
ORDER BY clients.first_name;

/*¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número
 total de clientes potenciales que hemos generado para cada uno de los sitios
 de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?
 Solicite esta consulta por ID de cliente. Presente una segunda consulta que
 muestre todos los clientes, los nombres del sitio y el número total de clientes
 potenciales generados en cada sitio en todo momento.*/
 
SELECT concat(clients.first_name,' ', clients.last_name ), sites.domain_name, COUNT(leads.first_name), MAX(leads.registered_datetime) FROM clients
JOIN sites ON sites.client_id = clients.client_id
JOIN leads ON leads.site_id = sites.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-12-31'
GROUP BY sites.domain_name, clients.first_name, clients.last_name,clients.client_id
ORDER BY clients.client_id;

/*Escriba una sola consulta que recupere los ingresos totales recaudados de cada
 cliente para cada mes del año. Pídalo por ID de cliente.*/
 
SELECT clients.first_name,SUM(billing.amount),clients.client_id, MONTH(billing.charged_datetime) FROM billing
JOIN clients ON clients.client_id = billing.client_id
GROUP BY MONTH(billing.charged_datetime), clients.client_id, clients.first_name
ORDER BY clients.client_id;

/*10) Escriba una sola consulta que recupere todos los sitios que posee cada cliente.
 Agrupe los resultados para que cada fila muestre un nuevo cliente.*/
 
SELECT clients.first_name, clients.last_name, GROUP_CONCAT(sites.domain_name SEPARATOR ' / ') AS concatenated_domains
FROM sites
JOIN clients ON clients.client_id = sites.client_id
GROUP BY clients.first_name, clients.last_name, clients.client_id
ORDER BY clients.client_id;





