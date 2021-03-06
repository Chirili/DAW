--------------------------------------------------------
-- Archivo creado  - jueves-diciembre-20-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PELICULAS
--------------------------------------------------------

  CREATE TABLE "VIDEOCLUB"."PELICULAS" 
   (	"COD_PELICULA" NUMBER(6,0), 
	"TITULO" VARCHAR2(60 BYTE), 
	"GENERO" VARCHAR2(20 BYTE), 
	"NACIONALIDAD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRESTAMOS
--------------------------------------------------------

  CREATE TABLE "VIDEOCLUB"."PRESTAMOS" 
   (	"COD_SOCIO" NUMBER(5,0), 
	"COD_PELICULA" NUMBER(6,0), 
	"FECHA_ALQUILER" DATE, 
	"FECHA_DEVOLUCION" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SOCIOS
--------------------------------------------------------

  CREATE TABLE "VIDEOCLUB"."SOCIOS" 
   (	"COD_SOCIO" NUMBER(5,0), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"FECHA_NACIMIENTO" DATE, 
	"LOCALIDAD" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into VIDEOCLUB.PELICULAS
SET DEFINE OFF;
Insert into VIDEOCLUB.PELICULAS (COD_PELICULA,TITULO,GENERO,NACIONALIDAD) values ('111111','Pepito','suspense','Espa�ola');
Insert into VIDEOCLUB.PELICULAS (COD_PELICULA,TITULO,GENERO,NACIONALIDAD) values ('222222','Grillo','comedia','Francesa');
REM INSERTING into VIDEOCLUB.PRESTAMOS
SET DEFINE OFF;
REM INSERTING into VIDEOCLUB.SOCIOS
SET DEFINE OFF;
Insert into VIDEOCLUB.SOCIOS (COD_SOCIO,NOMBRE,FECHA_NACIMIENTO,LOCALIDAD) values ('33333','Felipe',to_date('21/01/65','DD/MM/RR'),'Sevilla');
Insert into VIDEOCLUB.SOCIOS (COD_SOCIO,NOMBRE,FECHA_NACIMIENTO,LOCALIDAD) values ('44444','Ramon',to_date('21/08/75','DD/MM/RR'),'Granada');
--------------------------------------------------------
--  DDL for Index PK_SOCI
--------------------------------------------------------

  CREATE UNIQUE INDEX "VIDEOCLUB"."PK_SOCI" ON "VIDEOCLUB"."SOCIOS" ("COD_SOCIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_PELI
--------------------------------------------------------

  CREATE UNIQUE INDEX "VIDEOCLUB"."PK_PELI" ON "VIDEOCLUB"."PELICULAS" ("COD_PELICULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_PRESTA
--------------------------------------------------------

  CREATE UNIQUE INDEX "VIDEOCLUB"."PK_PRESTA" ON "VIDEOCLUB"."PRESTAMOS" ("COD_SOCIO", "COD_PELICULA", "FECHA_ALQUILER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table SOCIOS
--------------------------------------------------------

  ALTER TABLE "VIDEOCLUB"."SOCIOS" ADD CONSTRAINT "CK_LOCALI" CHECK (localidad NOT IN('Ja�n','C�rdoba')) ENABLE;
  ALTER TABLE "VIDEOCLUB"."SOCIOS" ADD UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VIDEOCLUB"."SOCIOS" ADD CONSTRAINT "PK_SOCI" PRIMARY KEY ("COD_SOCIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRESTAMOS
--------------------------------------------------------

  ALTER TABLE "VIDEOCLUB"."PRESTAMOS" ADD CONSTRAINT "CK_DEVOLU" CHECK (fecha_devolucion>fecha_alquiler) ENABLE;
  ALTER TABLE "VIDEOCLUB"."PRESTAMOS" ADD CONSTRAINT "PK_PRESTA" PRIMARY KEY ("COD_SOCIO", "COD_PELICULA", "FECHA_ALQUILER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PELICULAS
--------------------------------------------------------

  ALTER TABLE "VIDEOCLUB"."PELICULAS" ADD CONSTRAINT "CK_GENER" CHECK (genero IN('drama','comedia','suspense')) ENABLE;
  ALTER TABLE "VIDEOCLUB"."PELICULAS" ADD CONSTRAINT "CK_NACIO" CHECK (nacionalidad IN('Francesa','Espa�ola','Alem�n')) ENABLE;
  ALTER TABLE "VIDEOCLUB"."PELICULAS" ADD CONSTRAINT "PK_PELI" PRIMARY KEY ("COD_PELICULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRESTAMOS
--------------------------------------------------------

  ALTER TABLE "VIDEOCLUB"."PRESTAMOS" ADD CONSTRAINT "FK_PRESTA_PELI" FOREIGN KEY ("COD_PELICULA")
	  REFERENCES "VIDEOCLUB"."PELICULAS" ("COD_PELICULA") ENABLE;
  ALTER TABLE "VIDEOCLUB"."PRESTAMOS" ADD CONSTRAINT "FK_PRESTA_SOCI" FOREIGN KEY ("COD_SOCIO")
	  REFERENCES "VIDEOCLUB"."SOCIOS" ("COD_SOCIO") ENABLE;
