-- Avance de proyecto
-- Integrantes:
-- - Kevin Morales
-- - Geanpier Desiderio
-- - Carla Cumba
-- - Julio Pugo
-- - Francisco Cornejo
-- Script de implementación de la base de datos

Create database if not exists timeskill;
Use timeskill;
-- Tabla Cliente
Create table Cliente (
    id_cliente int auto_increment primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(100) not null unique,
    creditos int not null default 5,
    fecha_registro date not null,
    reputacion decimal(3,2) not null default 0,
    ciudad varchar(50) not null);

-- Tabla Cliente_Telefono (atributo multivaluado)
Create table Cliente_Telefono (
    id_cliente int not null,
    telefono varchar(20) not null,
    primary key (id_cliente, telefono),
    foreign key (id_cliente) references Cliente(id_cliente)
);

-- Tabla Habilidad
Create table Habilidad (
    id_habilidad int auto_increment primary key,
    nombre varchar(50) not null unique,
    descripcion varchar(200),
    categoria enum(
        'artes',
        'idiomas',
        'programacion',
        'ciencias_exactas',
        'humanidades',
        'otros'
    ) not null
);

-- Tabla Domina (relación Cliente - Habilidad)
Create table Domina (
    id_cliente int not null,
    id_habilidad int not null,
    experiencia int not null check (experiencia >= 0),
    nivel_dominio enum('bajo','medio','alto') not null,
    certificado boolean not null default false,
    primary key (id_cliente, id_habilidad),
    foreign key (id_cliente) references Cliente(id_cliente),
    foreign key (id_habilidad) references Habilidad(id_habilidad)
);

-- Tabla Tutoria
Create table Tutoria (
    id_tutoria int auto_increment primary key,
    id_cliente_guia int not null,
    id_cliente_aprendiz int not null,
    id_habilidad int not null,
    fecha_tutoria date not null,
    duracion_servicio int not null check (duracion_servicio > 0),
    estado enum('pendiente','completada','cancelada') not null default 'pendiente',
    comentario varchar(200),
    calificacion decimal(3,2) check (calificacion between 0 and 5),
    constraint fk_tutoria_guia foreign key (id_cliente_guia) references Cliente(id_cliente),
    constraint fk_tutoria_aprendiz foreign key (id_cliente_aprendiz) references Cliente(id_cliente),
    constraint fk_tutoria_habilidad foreign key (id_habilidad) references Habilidad(id_habilidad),
    constraint chk_guia_aprendiz_diferente check (id_cliente_guia <> id_cliente_aprendiz)
);

-- Tabla Transaccion
Create table Transaccion (
    id_transaccion int auto_increment primary key,
    id_tutoria int not null unique,
    fecha_transaccion date not null,
    creditos_transferidos int not null check (creditos_transferidos >= 0),
    foreign key (id_tutoria) references Tutoria(id_tutoria)
);

-- Inserts 
use timeskill;


-- 1) CLIENTE (20)
Insert into Cliente (nombre, apellido, correo, creditos, fecha_registro, reputacion, ciudad)
values
('Juan','Perez','juan@mail.com',5,'2025-01-01',4.2,'Quito'),
('Maria','Lopez','maria@mail.com',6,'2025-01-02',4.6,'Cuenca'),
('Carlos','Mora','carlos@mail.com',4,'2025-01-03',3.8,'Guayaquil'),
('Ana','Ruiz','ana@mail.com',7,'2025-01-04',4.7,'Loja'),
('Luis','Vega','luis@mail.com',3,'2025-01-05',3.5,'Manta'),
('Elena','Cruz','elena@mail.com',6,'2025-01-06',4.1,'Ambato'),
('Pedro','Ramos','pedro@mail.com',5,'2025-01-07',3.9,'Ibarra'),
('Diana','Mejia','diana@mail.com',8,'2025-01-08',4.8,'Quito'),
('Jorge','Salas','jorge@mail.com',4,'2025-01-09',3.6,'Machala'),
('Lucia','Paredes','lucia@mail.com',6,'2025-01-10',4.0,'Cuenca'),
('Miguel','Lima','miguel@mail.com',7,'2025-01-11',4.6,'Guayaquil'),
('Paola','Nunez','paola@mail.com',5,'2025-01-12',3.7,'Loja'),
('Oscar','Bravo','oscar@mail.com',4,'2025-01-13',3.4,'Manta'),
('Rosa','Cedeño','rosa@mail.com',6,'2025-01-14',4.3,'Ambato'),
('Diego','Fierro','diego@mail.com',5,'2025-01-15',3.9,'Ibarra'),
('Natalia','Rios','natalia@mail.com',7,'2025-01-16',4.5,'Quito'),
('Victor','Silva','victor@mail.com',3,'2025-01-17',3.2,'Machala'),
('Carmen','Pino','carmen@mail.com',8,'2025-01-18',4.9,'Cuenca'),
('Raul','Espinoza','raul@mail.com',6,'2025-01-19',4.4,'Guayaquil'),
('Sofia','Villalba','sofia@mail.com',5,'2025-01-20',4.0,'Riobamba');



-- 2) CLIENTE_TELEFONO (20) 
Insert into Cliente_Telefono (id_cliente, telefono)
values
(1,'0981000001'),(2,'0981000002'),(3,'0981000003'),(4,'0981000004'),
(5,'0981000005'),(6,'0981000006'),(7,'0981000007'),(8,'0981000008'),
(9,'0981000009'),(10,'0981000010'),(11,'0981000011'),(12,'0981000012'),
(13,'0981000013'),(14,'0981000014'),(15,'0981000015'),(16,'0981000016'),
(17,'0981000017'),(18,'0981000018'),(19,'0981000019'),(20,'0981000020');



-- 3) HABILIDAD (20)
Insert into Habilidad (nombre, descripcion, categoria)
values
('Python','Programación básica','programacion'),
('Java','POO','programacion'),
('SQL','Consultas','programacion'),
('HTML','Estructura web','programacion'),
('CSS','Estilos','programacion'),
('JavaScript','Interactividad','programacion'),
('Calculo','Derivadas','ciencias_exactas'),
('Algebra','Matrices','ciencias_exactas'),
('Fisica','Mecanica','ciencias_exactas'),
('Quimica','Reacciones','ciencias_exactas'),
('Ingles','Conversación','idiomas'),
('Frances','Básico','idiomas'),
('Excel','Hojas de cálculo','otros'),
('PowerPoint','Presentaciones','otros'),
('Redaccion','Académica','humanidades'),
('Oratoria','Hablar en público','humanidades'),
('Estadistica','Probabilidad','ciencias_exactas'),
('Investigacion','Metodología','humanidades'),
('Fotografia','Digital','artes'),
('Guitarra','Ritmica','artes');




-- 4) DOMINA (30) 
Insert into Domina (id_cliente, id_habilidad, experiencia, nivel_dominio, certificado)
values
(1,1,3,'alto',TRUE),
(2,2,4,'alto',TRUE),
(3,3,1,'medio',FALSE),
(4,4,5,'alto',TRUE),
(5,5,1,'bajo',FALSE),
(6,6,3,'medio',TRUE),
(7,7,2,'medio',FALSE),
(8,8,4,'alto',TRUE),
(9,9,1,'bajo',FALSE),
(10,10,3,'medio',TRUE),
(11,11,4,'alto',TRUE),
(12,12,2,'medio',FALSE),
(13,13,1,'bajo',FALSE),
(14,14,3,'medio',TRUE),
(15,15,2,'medio',FALSE),
(16,16,4,'alto',TRUE),
(17,17,1,'bajo',FALSE),
(18,18,5,'alto',TRUE),
(19,19,3,'medio',TRUE),
(20,20,4,'alto',TRUE);


-- 5) TUTORIA (20) 
Insert into Tutoria (id_cliente_guia, id_cliente_aprendiz, id_habilidad, fecha_tutoria, duracion_servicio, estado, comentario, calificacion)
values
(1,5,1,'2025-02-01',2,'pendiente',NULL,NULL),
(2,6,2,'2025-02-02',2,'completada','Muy claro',4.6),
(4,7,4,'2025-02-03',1,'pendiente',NULL ,NULL),
(6,3,6,'2025-02-04',2,'completada','Práctico',4.3),
(8,9,8,'2025-02-05',1,'completada','Bien',4.2),
(10,1,10,'2025-02-06',2,'completada','Claro',4.0),
(11,12,11,'2025-02-07',2,'cancelada','...',0),
(14,13,14,'2025-02-08',1,'completada','Útil',4.2),
(16,15,16,'2025-02-09',2,'cancelada','...',0),
(18,17,18,'2025-02-10',2,'pendiente',NULL,NULL),
(19,4,19,'2025-02-11',1,'cancelada','...',0),
(20,2,20,'2025-02-12',2,'completada','Buen ritmo',4.4),
(1,10,1,'2025-02-13',3,'completada','Avanzado',4.9),
(2,11,2,'2025-02-14',2,'completada','Muy buena explicacion',4.7),
(4,12,4,'2025-02-15',1,'cancelada','...',0),
(6,13,6,'2025-02-16',2,'completada','bien',4.5),
(8,14,8,'2025-02-17',1,'completada','Mal servicio',2.4),
(11,15,11,'2025-02-18',2,'pendiente',NULL,NULL),
(16,3,16,'2025-02-19',1,'pendiente', NULL ,NULL),
(18,6,18,'2025-02-20',2,'pendiente',NULL,NULL);


-- 6) TRANSACCION  
Insert into Transaccion (id_tutoria, fecha_transaccion, creditos_transferidos)
values
(2,'2025-02-02',2),(4,'2025-02-04',2),(5,'2025-02-05',1),
(6,'2025-02-06',2),(7,'2025-02-07',2),(8,'2025-02-08',1),
(9,'2025-02-09',2),(11,'2025-02-11',1),(12,'2025-02-12',2),
(13,'2025-02-13',3),(14,'2025-02-14',2),(15,'2025-02-15',1),
(16,'2025-02-16',2),(17,'2025-02-17',1);

-- Consultas

-- Consulta 1: ¿Qué clientes cumplen las condiciones para ser tutor según en Timeskill? (Experiencia ≥ 2, nivel_dominiio alto y certificado)

Select
    c.id_cliente,
    c.nombre,
    c.apellido
From Cliente c
Where c.id_cliente In (
    Select
        d.id_cliente
    From Domina d
    Where d.experiencia >= 2
      And d.nivel_dominio = 'alto'
      And d.certificado = true
);


-- Consulta 2: ¿Cuántas tutorías realizó cada cliente_guia y mostrar solo los que hicieron más tutorías que el promedio?

Select
    c.id_cliente,
    c.nombre,
    c.apellido,
    Count(t.id_tutoria) As total_tutorias
From Cliente c
Join Tutoria t
    On c.id_cliente = t.id_cliente_guia
Where t.estado="completada"
Group By c.id_cliente
Having Count(t.id_tutoria) >
(
    Select Avg(cantidad)
    From (
        Select Count(*) As cantidad
        From Tutoria
        Where estado = "completada"
        Group By id_cliente_guia
    ) As subconsulta
);


-- Consulta 3: ¿Cuántas veces se ha impartido cada habilidad, solo si fue impartida por clientes que cumplen condiciones de tutor?

Select
    h.id_habilidad,
    h.nombre,
    Count(t.id_tutoria) As veces_impartida
From Habilidad h
Join Tutoria t
    On h.id_habilidad = t.id_habilidad
Where t.id_cliente_guia In (
    Select
        d.id_cliente
    From Domina d
    Where d.experiencia >= 2
      And d.nivel_dominio = 'alto'
      And d.certificado = true
)
Group By h.id_habilidad;



-- Consulta 4:¿Qué clientes han participado tanto como cliente_guia y cliente_aprendiz?
Select c.id_cliente, c.nombre, c.apellido
From Cliente c
Where c.id_cliente in (
        Select id_cliente_guia
        From Tutoria
)
And c.id_cliente in (
        Select id_cliente_aprendiz
        From Tutoria
);




-- Consulta 5: ¿Cuántos créditos ganó cada cliente_guia y mostrar solo los que ganaron más que el promedio?
Select c.id_cliente, c.nombre, c.apellido,
       sum(tr.creditos_transferidos) As creditos_ganados
From Cliente c
Join Tutoria t on c.id_cliente = t.id_cliente_guia
Join Transaccion tr on t.id_tutoria = tr.id_tutoria
where t.estado= "completada"
Group by c.id_cliente
Having sum(tr.creditos_transferidos) >
(
    Select avg(total)
    From (
        Select sum(tr2.creditos_transferidos) As total
        From Tutoria t2
        Join Transaccion tr2 on t2.id_tutoria = tr2.id_tutoria
        where t2.estado="completada"
        Group by t2.id_cliente_guia
    ) As sub
);


-- Consulta 6: ¿Qué clientes_guia NO cumplen condiciones de tutor, pero aun así han impartido tutorías?
Select distinct c.id_cliente, c.nombre, c.apellido
From Cliente c
Where c.id_cliente in (
    Select t.id_cliente_guia
    From Tutoria t
)
And c.id_cliente not in (
    Select d.id_cliente
    From Domina d
    Where d.experiencia >= 2
      And d.nivel_dominio = 'alto'
      And d.certificado = True
);


-- Consulta 7: ¿Qué clientes nunca han sido cliente_aprendiz en ninguna tutoría? 

Select c.id_cliente, c.nombre, c.apellido
From Cliente c
Left join Tutoria t
    on c.id_cliente = t.id_cliente_aprendiz
Where t.id_tutoria is null;



-- Consulta 8: ¿Qué habilidades nunca han sido impartidas en ninguna tutoría?
Select h.id_habilidad, h.nombre
From Habilidad h
Where h.id_habilidad not in (
    Select distinct id_habilidad
    From Tutoria
);


-- View: Desempeño de los clientes que actúan como guías dentro del sistema TimeSkill
Create view vista_desempeno_cliente_guia as
Select 
    c.id_cliente,
    c.nombre,
    c.apellido,
    count(distinct t.id_tutoria) As total_tutorias_realizadas,
    coalesce(sum(tr.creditos_transferidos),0) As total_creditos_ganados  -- Utilizamos COALESCE porque hay tutores_guia que aun no han realizado una tutoria y no han ganado creditos.
From Cliente c
Join Tutoria t 
    on c.id_cliente = t.id_cliente_guia
Left join Transaccion tr 
    on t.id_tutoria = tr.id_tutoria
Group by c.id_cliente, c.nombre, c.apellido;



-- Procedure: Completar una tutoría y actualizar la base de datos
Delimiter $$

Create Procedure sp_completar_tutoria_transferir (
    In p_id_tutoria Int,
    In p_creditos Int
)
Begin
    Declare Exit Handler For Sqlexception
    Begin
        Rollback;
    End;
    Start Transaction;
    
    If (Select Count(*)
        From Tutoria
        Where id_tutoria = p_id_tutoria
          And estado = 'pendiente') > 0
    And (
        Select Count(*)
        From Transaccion
        Where id_tutoria = p_id_tutoria
    ) = 0 Then

        Insert Into Transaccion
            (id_tutoria, fecha_transaccion, creditos_transferidos)
        Values
            (p_id_tutoria, Date(Now()), p_creditos); -- Date(Now()) porque now() da fecha y hora 

        Update Tutoria
        Set estado = 'completada'
        Where id_tutoria = p_id_tutoria;

    End If;

    Commit;
End $$

Delimiter ;
-- Se probo con id_tutoria 10
call sp_completar_tutoria_transferir (10, 2)  

-- Con id_tutoria 18 no probado para demostracion
call sp_completar_tutoria_transferir (18, 2)  


-- Trigger: Limpieza en caso de cancelación
 
Delimiter $$

Create trigger trg_tutoria_cancelada_limpia_campos
Before update on Tutoria
For each row
Begin
    If new.estado = 'cancelada' and old.estado <> 'cancelada' then
        set new.calificacion = 0;
        set new.comentario  = '...';
    end if;
end $$

Delimiter ;				

-- Se probo con id_tutoria = 20
UPDATE Tutoria
SET estado = 'cancelada'
WHERE id_tutoria = 20;
