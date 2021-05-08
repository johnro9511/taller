--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: orden_serv_ent(character varying, integer, character varying, integer, time without time zone, character varying, character varying, integer, character varying, character varying, character varying, character varying, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION orden_serv_ent(character varying, integer, character varying, integer, time without time zone, character varying, character varying, integer, character varying, character varying, character varying, character varying, character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $_$
declare

   pidPlac    alias for $1; -- placa(ord_ser_ent)
   pIdMar    alias for $2; --  id_marca(auto)
   pIdMod    alias for $3; --  modelo(auto)
   pIdCol    alias for $4; --  id_color(auto)
   pIdHora    alias for $5; -- hora_ent(ord_ser_ent)
   pidDiag    alias for $6; -- diagnostico(orde_serv_ent)
   pIdFoto    alias for $7; -- foto_ent(ord_serv_ent)
   pIdCli     alias for $8; -- id_cliente(cliente)
   pIdNom     alias for $9; -- nom_cliente(cliente)
   PidApe     alias for $10; -- apellido(cliente)
   pIdMail    alias for $11; -- email(cliente)
   pIdTel     alias for $12; -- telefono(cliente)
   pIdDom     alias for $13; -- domicilio(cliente)

   vresult      integer;
   det_serv     RECORD;
   det_aut      RECORD;

   cont_ord integer;
   
BEGIN
  
  vresult := 1;
  cont_ord := 0;
  
  -- Buscando el detalle de resultados
  select into det_aut * from auto where No_placa = pidPlac;
   
  IF NOT FOUND THEN
    raise notice 'AUTO NO REGISTRADO';
        
    -- insertando en la tabla auto
    insert into auto values (pidPlac,pIdMar,pIdMod,pIdCol);

    -- insertando en la tabla cliente
    insert into cliente values (pIdCli,pidPlac,pIdNom,PidApe,pIdDom,pIdMail,pIdTel);

        
    -- Buscando servicios realizados  
    select into det_serv * from orden_servicio order by No_orden desc limit 1;

    IF NOT FOUND THEN
      cont_ord := cont_ord + 1;

      insert into orden_servicio (No_orden,fec_orden,id_cliente,No_placa,hora_ent,diagnostico,foto_diag)
        values (cont_ord,current_date,pIdCli,pidPlac,pIdHora,pidDiag,pIdFoto);
            raise notice 'ORDEN REGISTRADA EN NULL';

      ELSE
        cont_ord := det_serv.No_orden + 1;

        insert into orden_servicio (No_orden,fec_orden,id_cliente,No_placa,hora_ent,diagnostico,foto_diag)
          values (cont_ord,current_date,pIdCli,pidPlac,pIdHora,pidDiag,pIdFoto);
          raise notice 'ORDEN REGISTRADA';

        RETURN 2;

      END IF;    
    
    ELSE
     -- Buscando servicios realizados  
      select into det_serv * from orden_servicio order by No_orden desc limit 1;

      IF FOUND THEN
        cont_ord := det_serv.No_orden + 1;

        insert into orden_servicio (No_orden,fec_orden,id_cliente,No_placa,hora_ent,diagnostico,foto_diag)
          values (cont_ord,current_date,pIdCli,pidPlac,pIdHora,pidDiag,pIdFoto);
          
          raise notice 'ORDEN REGISTRADA';

      END IF;    
  
  END IF;
   
  RETURN vresult;
END;
$_$;


ALTER FUNCTION public.orden_serv_ent(character varying, integer, character varying, integer, time without time zone, character varying, character varying, integer, character varying, character varying, character varying, character varying, character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: auto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE auto (
    no_placa character varying NOT NULL,
    id_marca integer,
    modelo character varying,
    id_color integer
);


ALTER TABLE auto OWNER TO postgres;

--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    no_placa character varying NOT NULL,
    nombre character varying,
    apellidos character varying,
    domicilio character varying,
    email character varying,
    telefono character varying
);


ALTER TABLE cliente OWNER TO postgres;

--
-- Name: color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE color (
    id_color integer NOT NULL,
    desc_color character varying
);


ALTER TABLE color OWNER TO postgres;

--
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE marca (
    id_marca integer NOT NULL,
    desc_marca character varying
);


ALTER TABLE marca OWNER TO postgres;

--
-- Name: orden_servicio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orden_servicio (
    no_orden integer NOT NULL,
    fec_orden date DEFAULT CURRENT_DATE,
    id_cliente integer,
    no_placa character varying,
    hora_ent time without time zone,
    hora_sal time without time zone,
    diagnostico text,
    foto_diag character varying,
    serv_realizado text,
    foto_serv_real character varying
);


ALTER TABLE orden_servicio OWNER TO postgres;

--
-- Data for Name: auto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY auto (no_placa, id_marca, modelo, id_color) FROM stdin;
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (id_cliente, no_placa, nombre, apellidos, domicilio, email, telefono) FROM stdin;
\.


--
-- Data for Name: color; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY color (id_color, desc_color) FROM stdin;
1	AMARILLO
2	VERDE
3	BLANCO
4	ROJO
5	AZUL
6	NEGRO
7	GRIS
8	NARANJA
9	CAFE
10	ROSA
\.


--
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY marca (id_marca, desc_marca) FROM stdin;
1	NISSAN
2	CHEVROLET
3	VOLKSWAGEN
4	KIA
5	HONDA
6	TOYOTA
7	FORD
8	MAZDA
9	DODGE
10	JEEP
11	AUDI
12	MERCEDES BENZ
13	HYUNDAI
14	SUZUKI
15	CHRYSLER
16	FERRARI
17	LAMBORGHINI
\.


--
-- Data for Name: orden_servicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY orden_servicio (no_orden, fec_orden, id_cliente, no_placa, hora_ent, hora_sal, diagnostico, foto_diag, serv_realizado, foto_serv_real) FROM stdin;
\.


--
-- Name: auto auto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (no_placa);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente, no_placa);


--
-- Name: color color_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY color
    ADD CONSTRAINT color_pkey PRIMARY KEY (id_color);


--
-- Name: marca marca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (id_marca);


--
-- Name: orden_servicio orden_servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_servicio
    ADD CONSTRAINT orden_servicio_pkey PRIMARY KEY (no_orden);


--
-- Name: auto auto_id_color_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_id_color_fkey FOREIGN KEY (id_color) REFERENCES color(id_color);


--
-- Name: auto auto_id_marca_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_id_marca_fkey FOREIGN KEY (id_marca) REFERENCES marca(id_marca);


--
-- Name: cliente cliente_no_placa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_no_placa_fkey FOREIGN KEY (no_placa) REFERENCES auto(no_placa);


--
-- Name: orden_servicio orden_servicio_id_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_servicio
    ADD CONSTRAINT orden_servicio_id_cliente_fkey FOREIGN KEY (id_cliente, no_placa) REFERENCES cliente(id_cliente, no_placa);


--
-- PostgreSQL database dump complete
--

