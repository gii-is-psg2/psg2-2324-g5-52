# Análisis de la capacidad y el riesgo de PetClinic Services (PSG2-2324-g5-52)

# Universidad de Sevilla   

## Escuela Técnica Superior de Ingeniería Informática

### **Grupo de Prácticas G5-52**
  
  ![Logo US](/docs/static/Logo_US.png)

### Grado en Ingeniería Informática – Ingeniería del Software 

#### Proceso Software y Gestión II
### Product Owner: Carlos Guillermo Müller Cejas
### Curso 2023 – 2024

### Miembros del equipo
- Benjamín Ignacio Maureira Flores
- David Godoy Fernández
- Miguel Hernández Sánchez
- Rafael David Caro Medina
- Ramón José Guerrero Romero

## Introducción



## TCO

### CapEx: es el coste de adquirir, mantener o mejorar activos fijos.

| Item | Descripción | Coste en euros/periodos | Numero de periodos | Total en euros |
|------|-------------|-------------------------|--------------------|----------------|
| 1    |Equipo hardware | Se asume un coste medio de 600 en renovaciones/año | 2 | 1200,00 |
| 2    |Servidores | 208,34 | 24 | 5000,16 |
| 3    |Licencias de herramientas software | 0 | 24 | 0 |
| 4    |Licencias de sistemas operativo (Windows 11) | 145,00/año | 1 | 145,00 x 5 = 725,00 |
| 5    |Licencia de almacenamiento en la nube (Google Cloud) | 1,83/GB | 24 | 21,6 x 1000 = 21600 |
| 6    |Técnicos de almacenamiento hardware (2 técnicos) | 45,00/técnico | 24 | 1080,00 |
| 7    |Equipo de desarrollo (5 personas) | 1250,00/desarrollador | 24 | 1250,00 x 5 = 6250,00 |
|      |    |    | Total | 35855,16 |

Se establece como 0 las licencias software dado que se usan los servicios que utilizamos o sólo disponen de una versión gratuita o el plan usado durante el desarrollo es el gratuito. Esto se refiere a las herramientas de Clockify, GitHub, ZenHub, SonarQube, entre otros.

### OpEx: es el coste permanente del "día a día" de la empresa para su correcto funcionamiento.

| Item | Descripción | Coste en euros/periodos | Numero de periodos | Total en euros |
|------|-------------|-------------------------|--------------------|----------------|
| 1    |Salarios (*)(**) | 15200 | 24 | 364800,00|
| 2    |Gastos de transporte a la sede de reunión (ETSII) | 40,00/miembro: 40*5 = 200 (***) | 24 | 4800,00 |
| 3    |Mantenimiento del servidor | 1500,00 | 24 | 36000,00 |
| 4    |Alojamiento de la aplicación en la nube | 0,00 | 24 | 0,00 |
| 5    |Gastos luz y agua | 1000,00/mes | 24 | 24000,00 |
|      |    |    | Total | 429600,00 |

### (*)Tabla auxiliar para los salarios según rol:

| Item | Rol | Coste en euros/hora | Numero de horas al mes | Total en euros |
|------|-------------|-------------------------|--------------------|----------------|
| 1    |Scrum Master | 30,00/h | 80 | 2400,00|
| 2    |Desarrollador | 20,00/h | 80 | 1600,00 x 4 = 6400,00 |
| 3    |Equipo Soporte | 10,00/h | 80 | 800,00 x 5 = 4000,00 |
|      |    |    | Total | 12800,00 |

### (**)El gasto en el salario anual total sería de: 182400€ y puede variar entre un 0.5 %(+-912,00) y 3%(+-5472).

### (***)El precio está calculado haciendo un promedio del precio de la gasolina en un mes y estando todo el equipo a unos 20 km de distancia de la empresa.



## Análisis de capacidad del servicio extendido de PetClinic

Aquí se muestran las [xxxxxxxx] preguntas del catálogo de operaciones discutidas en clase para las APIs implementadas en la aplicación PetClinic del grupo PSG2-2324-G5-52 con sus respectivas respuestas:

[xxxxxxxxxxxxxxxxxxxxx]




## Análisis de los riesgos de operación y mantenimiento

En esta sección haremos un análisis detallado sobre los riesgos de operación y mantenimiento por el servicio incluido en el Acuerdo con el Cliente, tomando en consideración las condiciones descritas en las estimaciones del TCO, que el coste de las APIs cada 6 meses puede variar entre un 2% y 10%, y que el coste de los servicios usados por el nuestro pueden variar entre un 2% y 10%:

### 1- ¿En qué medida aumenta el riesgo del precio ofrecido por el prosumidor si sube el precio un 20%?

El riesgo del precio sería bajo, ya que en el sector existe poca competencia, y los consumidores están dispuestos a pagar más oir sus tarifas debido al valor ofrecido por nuestro servicio.

### 2- ¿Cuál es la tarifa que puedo ofrecer por 12€ con un margen de beneficio del 20%?



### 3- ¿Cuál es la tarifa que puedo ofrecer por 42€ con un margen de beneficio del 40%?



### 4- ¿Qué plan debo adquirir para ser capaz de ofrecer un TTR de 2h 24x7 sin riesgos?



### 5- ¿Qué plan debo adquirir para ser capaz de ofrecer un 99% de disponibilidad sin riesgo?

Todos los planes disponibles aseguran un 99% de disponibilidad por lo que se podría adquirir cualquiera de ellos.

### 6- ¿Cuánto aumentaría el OpEx/mes si mis proveedores aumentan un 10%?

El OpEx/mes aumentaría en 1790,00/mes si todos los costes aumentaron un 10% (se ha calculo teniendo en cuenta el coste total del OpEx, dividido por 24 que son los periodos y esto multiplicado por 0,1 haciendo referencia al 10%).









