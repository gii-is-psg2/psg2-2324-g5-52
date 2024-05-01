# Implementación de iTop para la Organización PSG2-2324-G5-52

# Universidad de Sevilla   

## Escuela Técnica Superior de Ingeniería Informática

### **Grupo de Prácticas G5-52**
  
  ![Logo US](../static/Logo_US.png)

### Grado en Ingeniería Informática – Ingeniería del Software 

### Proceso Software y Gestión II
### Product Owner: Carlos Guillermo Müller Cejas
### Curso 2023 – 2024

### Miembros del equipo
- Benjamín Ignacio Maureira Flores
- David Godoy Fernández
- Miguel Hernández Sánchez
- Rafael David Caro Medina
- Ramón José Guerrero Romero


# Indice
 - [Introducción](#introducción)
 - [Creación del equipo](#creación-del-equipo)
 - [Actualización de contraseñas para usuarios cliente](#actualización-de-contraseñas-para-usuarios-cliente)
 - [Capturas de pantalla del portal iTop disponible para clientes](#capturas-de-pantalla-del-portal-itop-disponible-para-clientes)
 - [Dificultades encontradas durante la configuración de iTop](#dificultades-encontradas-durante-la-configuración-de-itop)
 - [Funcionalidades que faltan en iTop para cubrir las tareas de este Sprint](#funcionalidades-que-faltan-en-itop-para-cubrir-las-tareas-de-este-sprint)
 - [Contribuciones de cada miembro del grupo](#contribuciones-de-cada-miembro-del-grupo)

## Introducción

En este informe técnico se resumirá el trabajo realizado sobre la CMDB iTop durante el Sprint3 del proyecto PetClinic. Este trabajo incluirá la configuración de todos los elementos de iTop necesarios para dar soporte a la gestión de incidencias y peticiones de usuarios para los servicios de PetClinic, tales como Contratos de Clientes, Servicios, Subcategorías de servicios, SLAs, SLTs, etc... 

## Creación del equipo

Una vez comprobado que la organización de nuestro grupo, PSG2-2324-G5-52, tiene creados y asociados un Contacto por cada miembro del grupo, procedemos a crear el Equipo de iTop (Team) con el nombre solicitado, "PSG2-2324-G5-52 Team", asociarlo a nuestra Organización y asociarle a su vez todos los miembros de ella.

## Actualización de contraseñas para usuarios cliente

Como además de los usuarios creados en iTop para cada miembro del grupo, cada grupo tiene acceso a dos usuarios cliente que representan a dos propietarios de clínica y que accederán al portal de usuarios iTop con su propio usuario y contraseña, se procede a continuación a actulizar dichas contraseñas por unas conocidas exclusivamente por nuestro grupo.

## Capturas de pantalla del portal iTop disponible para clientes

A continuación se muestran algunas capturas de pantalla de cómo el portal iTop queda disponible para clientes, para la creación de incidencias y peticiones de usuario, y otras configuraciones realizadas.

Captura de la pantalla inicial de iTop para el cliente John Doe, ClinicOwner1 en la BD de la aplicación.

![Captura portal iTop cliente John Doe](../static/sprint3/Captura_portal_iTop_disponible_para_ClinicOwner1_antes_de_asignar_contrato.png)

Captura de pantalla inicial de creación del Equipo (Team) de iTop asociado a los servicios de PetClinic para nuestra Organización.

![Captura creación Team en iTop](../static/sprint3/Creacion_de_nuevo_Team_para_la_Organizacion.png)

Captura de pantalla del Equipo una vez creado.

![Captura de Team una vez creado](../static/sprint3/Creado_nuevo_Team_para_la%20Organizacion.png)

Captura de pantalla trás la asociación de miembros de la Organización al Equipo recien creado.

![Captura asociacion miembros a Team](../static/sprint3/Adicion_de%20miembros_al_equipo.png)

Captura de pantalla trás la asociación de CIs de la Organización al Equipo.

![Captura asociacion CIs a Team](../static/sprint3/CIs_de_la_Organizacion_asociados_al_Equipo.png)

Captura de pantalla tras la actualización de contraseña para el cliente Jane Doe

![Captura actualizacion contraseña John Doe](../static/sprint3/Actualizadas_password_para%20ClinicOwners_%20en_iTop.png)

Ambas contraseñas han sido establecidas a C0wn3r#1 y C0wn3r#2, respectivamente, para los clientes ClinicOwner1 (John Doe) y ClinicOwner2 (Jane Doe).


## Dificultades encontradas durante la configuración de iTop

Una de las grandes dificultades encontradas ha sido que la web es muy poco intuitiva para el usuario, entonces para nuestra tarea a realizar, que era crear servicios, contratos, SLA y SLTs, que a priori suena como una tarea insignificante, nos ha llevado aproximadamente 2 horas. Además, de no ser por el documento proporcionado por los profesores, habría sido imposible llevar a cabo la tarea, ya que iTop no proporciona ningún tipo de guía o ayuda.

Por otro lado, hemos tenido que repetir muchas veces la gran parte de los pasos a seguir, por ejemplo, a la hora de crear los SLTs para asignarlos a los SLA, hemos tenido que ir creando uno por uno hasta un total de 12 SLTs por cada SLA, que al final se ha hecho muy mecanico y pesado. Hubieramos agradecido que se pudiera hacer una creacion en lotes o algo parecido.

Por último, lo más destacable ha sido a la hora de crear los Customer Contracts, que en lugar de crear un contrato para cada Clinic Owner con sus SLA correspondientes a los planes de precios, iTop sólo nos permite asignar un SLA a un contrato, por tanto hemos tenido que crear 3 contratos por cliente, para cada plan de precios.

## Funcionalidades que faltan en iTop para cubrir las tareas de este Sprint

## Contribuciones de cada miembro del grupo

| Miembro                          | Contribución                                                           |
| :------------                    | :-----------                                                           |
| Benjamín Ignacio Maureira Flores | Creación de servicios y subservicios: Adoptions, Pet Hotel Room, Booking, PetClinic4ClinicOwner. Booking service: creación de contratos, SLA y SLTs. |
| David Godoy Fernández            |                                                                        |  
| Miguel Hernández Sánchez         |                                                                        |
| Rafael David Caro Medina         | Creación del Equipo (Team) en iTop y asociación de miembros y CIs      |
| Rafael David Caro Medina         | Actualización de contraseñas para usuarios Cliente                     |
| Ramón José Guerrero Romero       | Creación de los TTO y TTR asociados a la categoría Gold. Luego la asociación de todos los planes referentes a PetHotelRoom de los SLA. Posteriormente la asociación de los contratos.|

