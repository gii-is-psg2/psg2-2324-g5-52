# Monitorización del Acuerdo de cliente de PetClinic Services (PSG2-2324-G5-52)

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

# Introducción

As a group, create a **technical report** (in Spanish) titled “Monitorización del Acuerdo de cliente de PetClinic Services (PSG2-2324-GX-XY)” which sums up the work performed to monitor the CA. For each request enumerated in A3.5, this document must contain at least a report of the degree to which the associated SLT is fulfilled, as well as the time elapsed between creating the issue in GitHub and its closure. You can use screenshots of iTop and GitHub that show when the issues were opened and closed. **Each member of the group should review at least one request** and assign it to another member. The assigned member should create a corresponding issue in GitHub and implement the request, updating both the issue in GitHub and the user request or incident in iTop once it is implemented. The technical report must be stored in a **docs** folder within the same repository using the Markdown syntax, updating the stored versions as the group works with it following the strategy defined in S1.

## Pricing plans description

![Captura iTop A3.5.a Vista cliente](../static/sprint3/CapturaiTopA3.5.aCliente.png)

![Captura iTop A3.5.a Vista Panel de incidencias](../static/sprint3/CapturaiTopA3.5.aPanel.png)


Como se puede ver en las capturas, la petición se abre en iTop el 3 de mayo a las 10:28 y se asigna a las 12:29, dando lugar a un TTO de 5 segundos, este tiempo tan pequeño se debe a que fue asignado por el creador de la request de forma automatica por error, dando lugar a un TTR de 72 horas.

Se cumple al 100% el SLT asociado, ya que la urgencia es media (hemos supuesto que es usuario basic) y la prioridad es media:
  - Nos daría un TTO objetivo de 32 horas y el TTO ha sido de 5 segundos.
  - Nos daría un TTR objetivo de 82 horas y el TTR ha sido de 72 horas.

Cabe destacar que la taea habia sido ralizada antes de las 72 horas pero no ha sido marcada como resuelta hasta el dia 6 por lo que se ha decidido contemplar la hora de resolución de iTop.

![Captura A3.5.a Github 1](../static/sprint3/A3-5-a-1.png)

Como se puede ver, en Github se creó la issue el dia 4 de mayo, 24 horas después de asignarse.

![Captura A3.5.a Github 2](../static/sprint3/A3-5-a-2.png)

Entrando en más detalle, podemos ver que se movió a la pipeline de To Do inmediatamente y se procedió a su implementación, cabe destacar que se movio directamente a in review ya que la tarea se realizo muy rapidamente, momento en el que se marca como resuelta en iTop y se mueve a In Review con su respectiva pull request.

Tras la revisión del equipo, se hace merge de la rama a la rama de desarrollo, el despliegue de la nueva versión se realiza el domingo 5 de mayo por la mañana, momento en el que todas las issues se pasan a Done.

Tras este análisis se pueden sacar 2 conclusiones:
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que se implementa la funcionalidad solicitada o se corrije un bug, entonces podemos decir que para esta tarea, el SLT se cumple al 100%, ya que transcurren 72 horas desde que se asigna hasta que se implementa.
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que todo el equipo la aprueba y se despliegan los nuevos cambios, entonces el cumplimiento del SLT para el TTR sería del 100%, ya que transcurren 48 horas desde la asignación hasta el despliegue de los cambios, el TTO sería del 100% ya que sí se asignó en el tiempo acordado.

Por último, cabe destacar que el equipo ha acordado hacer el despliegue de la nueva versión cuando todos los cambios solicitados estuvieran correctamente implementados y revisados a través de las pull requests, cosa que ha retrasado bastante todos los tiempos.



## Identify current plan task

![Captura iTop A3.5.b Vista cliente](../static/sprint3/CapturaiTopA3.5.bCliente.png)

![Captura iTop A3.5.b Vista Panel de incidencias](../static/sprint3/CapturaiTopA3.5.bPanel.png)

Como se puede ver en las capturas, la petición se abre en iTop el 3 de mayo a las 12:04 y se asigna a las 12:20, dando lugar a un TTO de 16 minutos, bastante rápido gracias a la comunicación del equipo de soporte y el poco volumen de incidencias y trabajo.
Además, se resolvió a las 18:01 del mismo día, dando lugar a un TTR de 5 horas y 56 minutos.

Se cumple al 100% el SLT asociado, ya que la urgencia es alta (hemos supuesto que es usuario Platinum) y la prioridad es alta:
  - Nos daría un TTO objetivo de 10 horas y el TTO ha sido de 16 minutos.
  - Nos daría un TTR objetivo de 24 horas y el TTR ha sido de 5 horas y 56 minutos.

Cabe destacar que se ha marcado como resuelta en iTop una vez estaba la funcionalidad implementada, a falta de la revisión del equipo y el merge a la rama de desarrollo y posterior despliegue.

![Captura A3.5.b Github 1](../static/sprint3/CapturaA3.5.bGithub1.png)

Como se puede ver, en Github se creó la issue a las 12:31 del 3 de mayo, 11 minutos después de asignarse.

![Captura A3.5.b Github 2](../static/sprint3/CapturaA3.5.bGithub2.png)

Entrando en más detalle, podemos ver que se movió a la pipeline de In Progress inmediatamente y se procedió a su implementación, dando lugar a un primer commit a las 18:01, momento en el que se marca como resuelta en iTop y se mueve a In Review con su respectiva pull request.

Tras la revisión del equipo, se hace merge de la rama a la rama de desarrollo el 4 de mayo a las 21:26 y el despliegue de la nueva versión se realiza el domingo 5 de mayo por la mañana, momento en el que todas las issues se pasan a Done.

Tras este análisis se pueden sacar 2 conclusiones:
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que se implementa la funcionalidad solicitada o se corrije un bug, entonces podemos decir que para esta tarea, el SLT se cumple al 100%, ya que transcurren 5 horas y 56 minutos desde que se asigna hasta que se implementa.
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que todo el equipo la aprueba y se despliegan los nuevos cambios, entonces el cumplimiento del SLT para el TTR sería del 0%, ya que transcurren más de 24 horas desde la asignación hasta el despliegue de los cambios, pero del TTO sería del 100% ya que sí se asignó en el tiempo acordado.

Por último, cabe destacar que el equipo ha acordado hacer el despliegue de la nueva versión cuando todos los cambios solicitados estuvieran correctamente implementados y revisados a través de las pull requests, cosa que ha retrasado bastante todos los tiempos.


## Remove the "Plan" page fot pet owners

![Captura iTop A3.5.c Vista normal](../static/sprint3/A3-5-c-1.png)

![Captura iTop A3.5.c Vista cliente](../static/sprint3/A3-5-c-2.png)

![Captura iTop A3.5.c Vista Panel de incidencias](../static/sprint3/A3-5-c-3.png)

Como se puede ver en las capturas, la petición se abre en iTop el 3 de mayo a las 11:13 y se asigna a las 11:30, dando lugar a un TTO de 17 minutos, bastante rápido gracias a la comunicación del equipo de soporte y el poco volumen de incidencias y trabajo. Además, se resolvió a las 12:18 del día 05 de mayo, dando lugar a un TTR de 2 días, 1 hora y 48 minutos.

Se cumple al 100% el SLT asociado, ya que la urgencia es media (hemos supuesto que es usuario Gold) y la prioridad es media:
  - Nos daría un TTO objetivo de 24 horas y el TTO ha sido de 17 minutos.
  - Nos daría un TTR objetivo de 72 horas y el TTR ha sido de 2 días, 1 hora y 48 minutos.
  
Cabe destacar que se ha marcado como resuelta en iTop una vez estaba la funcionalidad implementada, a falta de la revisión del equipo y el merge a la rama de desarrollo y posterior despliegue.

![Captura github A3.5.c Issue](../static/sprint3/A3-5-c-4.png)

![Captura github A3.5.c Issue 2](../static/sprint3/A3-5-c-5.png)

Tras la revisión del equipo, se hace merge de la rama a la rama de desarrollo (develop) y el despliegue de la nueva versión, cuando todas las issues se pasan a Done.

Tras este análisis se pueden sacar 2 conclusiones:
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que se implementa la funcionalidad solicitada o se corrije un bug, entonces podemos decir que para esta tarea, el SLT se cumple al 100%, ya que transcurren 2 días, 1 hora y 48 minutos desde que se asigna hasta que se implementa.
- Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que todo el equipo la aprueba y se despliegan los nuevos cambios, entonces el cumplimiento del SLT para el TTR sería del 0%, ya que transcurren más de 24 horas desde la asignación hasta el despliegue de los cambios, pero del TTO sería del 100% ya que sí se asignó en el tiempo acordado.

Por último, cabe destacar que el equipo ha acordado hacer el despliegue de la nueva versión cuando todos los cambios solicitados estuvieran correctamente implementados y revisados a través de las pull requests, cosa que ha retrasado bastante todos los tiempos.

## API Weather for PetClinic

![Captura iTop A3.5.d Weather Vista Panel de incidencias](../static/sprint3/weather%20itop%20resuelto.png)

Como se puede ver en las capturas, la petición se abre en iTop el 2 de mayo a las 15:16 y se asigna a las 16:24, dando lugar a un TTO de 1 hora y 8 minutos, bastante rápido gracias a la comunicación del equipo de soporte y el poco volumen de incidencias y trabajo. Además, se resolvió a las 11:39 del día 5 de mayo, dando lugar a un TTR de 68h.

Se cumple totalmente el SLT asociado, ya que la urgencia es baja al ser el usuario BASIC y la prioridad es baja al ser una nueva funcionalidad que no afecta considerablemente a la plataforma:

- Nos daría un TTO objetivo de 52 horas y el TTO ha sido de 1 horas y 8 minutos.
- Nos daría un TTR objetivo de 104 horas y el TTO ha sido de 68 horas.

Cabe destacar que se ha marcado como resuelta en iTop una vez estaba la funcionalidad revisada por el equipo y mergeada a la rama de desarrollo a falta del posterior despliegue.

![Captura github 1 A3.5.d Weather](../static/sprint3/github%201%20weather%20in%20visits.png)

Como se puede ver, en GitHub se creó la issue el mismo día en la que fue asignada la incidencia en iTop.

![Captura github 2 A3.5.d Weather](../static/sprint3/github%202%20weather%20in%20visits.png)

Entrando en más detalle, podemos ver que se movió a la pipeline de To Do inmediatamente y se procedió a su implementación. Más tarde se pasó la tarea a Done.

Tras este análisis se pueden sacar 2 conclusiones:

Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que se implementa la funcionalidad solicitada o se corrije un bug, entonces podemos decir que para esta tarea, el SLT se cumple al 100%, ya que transcurre menos de un día.
Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que todo el equipo la aprueba y se despliegan los nuevos cambios, entonces el cumplimiento del SLT para el TTR sería del 100% en este caso, ya que transcurren 68 horas desde la asignación hasta el despliegue de los cambios.


## API Traffic for PetClinic

![Captura iTop A3.5.d Traffic Vista Panel de incidencias](../static/sprint3/trafico%20itop%20resuelto.png)

Como se puede ver en las capturas, la petición se abre en iTop el 2 de mayo a las 16:13 y se asigna a las 16:26, dando lugar a un TTO de 13 minutos, bastante rápido gracias a la comunicación del equipo de soporte y el poco volumen de incidencias y trabajo. Además, se resolvió a las 11:37 del día 5 de mayo, dando lugar a un TTR de 68h.

Se cumple totalmente el SLT asociado, ya que la urgencia es baja al ser el usuario BASIC y la prioridad es baja al ser una nueva funcionalidad que no afecta considerablemente a la plataforma:

- Nos daría un TTO objetivo de 52 horas y el TTO ha sido de 13 minutos.
- Nos daría un TTR objetivo de 104 horas y el TTO ha sido de 68 horas.

Cabe destacar que se ha marcado como resuelta en iTop una vez estaba la funcionalidad revisada por el equipo y mergeada a la rama de desarrollo a falta del posterior despliegue.

![Captura github 1 A3.5.d Traffic](../static/sprint3/github%201%20traffic.png)

Como se puede ver, en GitHub se creó la issue el mismo día en la que fue asignada la incidencia en iTop.

![Captura github 2 A3.5.d Traffic](../static/sprint3/github%202%20traffic.png)

En este caso no se conectó a tiempo la pull request a la issue de Zenhub y no se muestran los datos de cuando se movió entre las diferentes columnas.

Tras este análisis se pueden sacar 2 conclusiones:

Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que se implementa la funcionalidad solicitada o se corrije un bug, entonces podemos decir que para esta tarea, el SLT se cumple al 100%, ya que transcurre menos de un día.
Si para el TTR se tiene en cuenta el tiempo desde que se asigna hasta que todo el equipo la aprueba y se despliegan los nuevos cambios, entonces el cumplimiento del SLT para el TTR sería del 100% en este caso, ya que transcurren 68 horas desde la asignación hasta el despliegue de los cambios.