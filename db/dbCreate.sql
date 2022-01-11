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
  "delete" boolean default false
);

ALTER TABLE public.product OWNER TO postgres;