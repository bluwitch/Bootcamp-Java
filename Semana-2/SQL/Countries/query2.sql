-- 1]
SELECT customer.first_name, customer.last_name, customer.email, address.address FROM customer 
JOIN address ON address.address_id = customer.address_id
JOIN city ON city.city_id = address.city_id
WHERE city.city_id = 312;

-- 2]
SELECT film.title, film.description, film.release_year, film.rating, film.special_features, category.name FROM film
JOIN film_category ON film_category.film_id = film.film_id 
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Comedy';

-- 3]
SELECT film.title, COUNT(film_actor.actor_id) FROM film
JOIN film_actor ON film_actor.film_id = film.film_id
GROUP BY film.title;

-- Resolviendo consigna
SELECT actor.actor_id, actor.first_name, actor.last_name, film.title, film.description, film.release_year FROM film
JOIN film_actor ON film_actor.film_id = film.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.actor_id = 5;

-- 4]
SELECT customer.first_name, customer.last_name, city.city, city.city_id FROM customer
JOIN address ON address.address_id = customer.address_id
JOIN city ON city.city_id = address.city_id
JOIN store ON store.store_id = customer.store_id
WHERE store.store_id = 1
AND city.city_id IN (1, 42, 312, 459);

-- 5]
SELECT * FROM film 
JOIN film_actor ON film_actor.film_id = film.film_id
WHERE film.rating = 'G' AND film.special_features LIKE '%behind the scene%' AND film_actor.actor_id = 15;


-- 6]
SELECT film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name FROM actor
JOIN film_actor ON film_actor.actor_id = actor.actor_id
JOIN film ON film.film_id = film_actor.film_id
WHERE film.film_id = 369;

-- 7]
SELECT film.title, film.description, film.release_year, film.special_features, category.name, payment.amount FROM film
JOIN film_category ON film_category.film_id = film.film_id
JOIN category ON category.category_id = film_category.category_id
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
JOIN payment ON payment.rental_id = rental.rental_id
WHERE category.name = 'Drama' AND payment.amount = 2.99;

-- 8]
SELECT film.title, film.description, film.release_year, film.rating, film.special_features, category.name, actor.first_name, actor.last_name FROM film
JOIN film_actor ON film_actor.film_id = film.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
JOIN film_category ON film_category.film_id = film.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE actor.first_name = 'SANDRA' AND actor.last_name = 'KILMER';