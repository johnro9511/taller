drop function orden_serv_ent(varchar,integer,varchar,integer,time,varchar,varchar,integer,varchar,varchar,varchar,varchar,varchar);
create or replace function orden_serv_ent(varchar,integer,varchar,integer,time,varchar,varchar,integer,varchar,varchar,varchar,varchar,varchar) returns integer as $$
declare

  pidPlac   alias for $1; -- placa(ord_ser_ent)
  pIdMar    alias for $2; --  id_marca(auto)
  pIdMod    alias for $3; --  modelo(auto)
  pIdCol    alias for $4; --  id_color(auto)
  pIdHora   alias for $5; -- hora_ent(ord_ser_ent)
  pidDiag   alias for $6; -- diagnostico(orde_serv_ent)
  pIdFoto   alias for $7; -- foto_ent(ord_serv_ent)
  pIdCli    alias for $8; -- id_cliente(cliente)
  pIdNom    alias for $9; -- nom_cliente(cliente)
  PidApe    alias for $10; -- apellido(cliente)
  pIdMail   alias for $11; -- email(cliente)
  pIdTel    alias for $12; -- telefono(cliente)
  pIdDom    alias for $13; -- domicilio(cliente)

  vresult      integer;
  det_serv     RECORD;
  det_aut      RECORD;

  cont_ord integer;
   
BEGIN
  
  vresult := 1;
  cont_ord := 0;
  
  -- Buscando el detalle de autos
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
$$ language plpgsql;


begin work;
select orden_serv_ent('JRM52',2,'2020',8,'12:35:21','CAMBIO DE VIDRIO','C:/evidencias/foto3.jpg',1,'JOHN RO','MALDONADIC','jmaldonadic@gmail.com','962-190-0297','TAPACHULA');
commit work;
