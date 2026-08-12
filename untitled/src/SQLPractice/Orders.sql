CREATE TABLE customers(
                          id SERIAL PRIMARY KEY,
                          full_name VARCHAR(100),
                          email VARCHAR(100) UNIQUE NOT NULL,
                          is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE orders(
                       id SERIAL PRIMARY KEY,
                       customer_id INTEGER REFERENCES customers(id) ON DELETE CASCADE,
                       amount NUMERIC(10,2) CHECK(amount>=0),
                       created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE products(
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100),
                         price NUMERIC(10, 2)
);

ALTER TABLE orders ADD COLUMN product_id INTEGER REFERENCES products(id);

INSERT INTO customers (full_name, email) VALUES
                                             ('Анна', 'anna@mail.com'),
                                             ('Мария', 'maria@mail.com'),
                                             ('Вика', 'oleg@mail.ru');
iNSERT INTO products (name, price) VALUES
                                       ('Кружка', 350),
                                       ('Блокнот', 200),
                                       ('Наушники', 2500);

SELECT id, full_name FROM customers;
SELECT id, name FROM products;
INSERT INTO orders(customer_id, product_id) VALUES
                                                ('1', '1'),
                                                ('1', '2'),
                                                ('2', '1');

SELECT * FROM orders;

SELECT c.full_name, o.id, p.name
FROM orders o
         JOIN customers c ON o.customer_id=c.id
         JOIN products p ON o.product_id=p.id;

SELECT c.full_name AS name, o.id
FROM customers c
         LEFT JOIN orders o ON c.id=o.customer_id;

SELECT p.name, o.id AS order_name
FROM products p
         FULL JOIN orders o ON p.id = o.product_id;

INSERT INTO orders (customer_id, amount) VALUES
                                             (1, 350),
                                             (1, 200),
                                             (2, 500),
                                             (2, 150),
                                             (2, 100);

SELECT c.full_name AS name, COALESCE(SUM(amount), 0)
FROM customers c
         LEFT JOIN orders o ON customer_id = c.id
GROUP BY c.id;

SELECT full_name, SUM(amount)
FROM customers c
         LEFT JOIN orders o ON customer_id = c.id
GROUP BY c.id
HAVING SUM(amount)>300;

ALTER TABLE customers ADD COLUMN phone VARCHAR(15) UNIQUE;

UPDATE customers
SET phone = '+79001234567'
WHERE id =1;

UPDATE customers
SET phone = '+79007654321'
WHERE id =3;

SELECT full_name, COALESCE(phone, 'не указан')
FROM customers;

INSERT INTO products(name, price) VALUES
    ('Шоколадка', 100) RETURNING id;

SELECT p.name
FROM products p
WHERE NOT EXISTS(
    SELECT 1
    FROM orders o
    WHERE o.product_id = p.id
);

WITH totals AS(
    SELECT customer_id, SUM(o.amount) AS total_spent
    FROM orders o
    GROUP BY customer_id
)
SELECT c.full_name , t.total_spent
FROM totals t
         JOIN customers c ON c.id=t.customer_id
WHERE t.total_spent > (SELECT AVG(amount)
                       FROM orders);


EXPLAIN SELECT * FROM orders WHERE customer_id=1;

CREATE INDEX idx_orders_customer_id ON orders (customer_id);

SELECT COUNT(*) FROM orders;
SELECT COUNT(*) FROM orders WHERE customer_id = 1;

EXPLAIN ANALYZE SELECT * FROM orders WHERE customer_id = 1;

SELECT phone FROM customers WHERE id=2;

BEGIN;
UPDATE customers SET phone='+79007654322' WHERE id=2;
SELECT phone FROM customers WHERE id=2;
ROLLBACK;

SELECT phone FROM customers WHERE id=2;


ALTER TABLE products ADD COLUMN attributes JSONB;

UPDATE products SET attributes='{"цвет": "желтый", "высота": "10см"}'
WHERE id=1;
UPDATE products SET attributes='{"цвет": "коричневый", "материал": "картон"}'
WHERE id=2;
UPDATE products SET attributes='{"цвет": "белый"}'
WHERE id=3;

SELECT name FROM products WHERE attributes@>'{"материал": "картон"}';
SELECT attributes->>'цвет' FROM products WHERE name='Наушники';


INSERT INTO customers(full_name, email)
VALUES ('Анютка', 'anna@mail.com')
    ON CONFLICT (email) DO UPDATE SET fuLl_name= EXCLUDED.full_name;

SELECT full_name from customers WHERE email='anna@mail.com';

