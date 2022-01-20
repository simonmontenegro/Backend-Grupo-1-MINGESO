--Dropear las tabla
--Esta sentencia verifica que no exista la tabla previamente
--En caso de existir, laa elimina en CASCADA, es decir,
--elimina todo el flujo asociado a la tabla

DROP TABLE IF EXISTS public.product CASCADE;

--Creacion de tablas

CREATE TABLE public.product (
  "code" serial, 
  "name" varchar(80),
  "expiration_date" date,
  "category" boolean,
  "price" double precision,
  "delete" boolean default false,
  CONSTRAINT code PRIMARY KEY (code)
);

ALTER TABLE public.product OWNER TO postgres;

DELETE FROM "product";
INSERT INTO "product" (code, name, expiration_date, category, price,delete) 
VALUES (1,'pimentón verde','10/01/2022', 'False', 600.0, 'False'),
(2,'lechuga','10/02/2022', 'False', 500.0, 'False'),
(3,'ventilador','04/07/2024', 'False', 49990.0, 'False'),
(4,'estufa','10/06/2025', 'False', 100000.0, 'False'),
(5,'aifon','01/11/2027', 'False', 650000.0, 'False');