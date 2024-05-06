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
