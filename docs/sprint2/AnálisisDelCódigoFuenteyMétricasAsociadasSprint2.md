# Análisis del Código Fuente y Métricas Asociadas - Sprint 2

# Universidad de Sevilla   

## Escuela Técnica Superior de Ingeniería Informática

### **Grupo de Prácticas G5-52**
  
  ![Logo US](/docs/static/Logo_US.png)

### Grado en Ingeniería Informática – Ingeniería del Software 

### Proceso Software y Gestión II
### Product Owner: Carlos Guillermo Müller Cejas
### Curso 2023 – 2024

## Introducción

En este documento se realizará un análisis del código fuente del proyecto gracias a la herramienta SonarQube. Se tendrán en cuenta la release del sprint1 y la de este sprint2 y se estudiarán las diferentes métricas asociadas.

## Release del Sprint1
### Frontend

#### Dashboard

![SonarQube Frontend Dashboard](/docs/static/sprint2FrontendDashboard.png)

- Métricas:
  - Bugs: esta métrica indica la cantidad de bugs que ha detectado en el código. En nuestro caso hay 4.
  - Reliability: En nuestro caso, la nota es una C al haber ya que al menos uno cuenta como un _major bug_.
  - Vulnerabilities: esta métrica indica la cantidad de vulnerabilidades que ha detectado en el código. En nuestro caso no hay ninguna.
  - Security: En nuestro caso la nota es una A, porque no ha encontrado ninguna vulnerabilidad.
  - Security Hotspots: mide la cantidad de potenciales vulnerabilidades que necesitan ser revisadas manualmente para determinar si lo son o no. En nuestro caso, tenemos 2 Security Hotspot.
  - Reviewed: Porcentaje de security hostpost revisados. En nuestro caso es 0.
  - Security Review: Tenemos de nota una E porque el security hotspot que tenemos no lo hemos revisado aún.
  - Debt: la deuda técnica que tenemos en el proyecto con las code smells que ha detectado. En nuestro caso tenemos una deuda técnica de 3 días y 2 horas.
  - Code Smells: cantidad de code smells que ha detectado. En nuestro caso son 164.
  - Maintainability: indica la mantenibilidad de nuestro código teniendo en cuenta la deuda técnica. En nuestro caso es una A porque es menor al 5%.
  - Coverage: indica la cobertura de las pruebas unitarias en nuestro código. En nuestro caso es 0 porque no disponemos de pruebas unitarias.
  - Duplications: indica las duplicidades de códigos encontradas. En nuestro caso es del 15.3%.

#### Bugs potenciales

Nuestro frontend tiene 4 bugs:

1. _/src/auth/register/index.js_

    En este archivo se encuentra el siguiente extracto de código:
    ```js
    if (response.status === 200) {
        return response.json();
    } else {
        return response.json();
    }
    ```
    El if no tiene sentido ya que siempre va a realizar la misma acción. Por lo tanto deberíamos de quitar el bloque condicional o hacer algo diferente en el caso de que la respuesta del fetch sea 200.

2. _/src/global.css_

    El bug en este archivo es el siguiente:
    ```css
    * {
        font-family: 'american-typewriter';
    }
    ```

    Si ninguna de las fuentes definidas en la delcaración `font-family` está disponible en el navegador del usuario, el navegador mostrará el texto utilizando su fuente por defecto. Se recomienda definir siempre una fuente genérica para cada font-family para obtener una situación menos degradada que confiar en la fuente por defecto del navegador. 

    Ejemplo de arreglo:

    ```css
    * {
        font-family: 'american-typewriter', Helvetica, Arial, Verdana, Tahoma;
    }
    ```
3. _/src/static/css/owner/consultations.css_

    Bug:
    ```css
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:after,
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:before {
    display: inline-block;
    transition: all 0.4s ease;
    width: 100%;
    text-align: center;
    position: absolute;
    line-height: 2em;
    font-weight: bold;
    color: #fff;
    position: absolute;
    top: 0;
    left: 0;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    border-radius: 4px;
    }
    ```

    En este extracto de css, el único problema es que la propiedad position está repetida. En este caso no es un problema grave ya que valen lo mismo. Pero en el caso de que no valiesen lo mismo sólo la última instancia de una propiedad duplicada determina el valor real que se utilizará para él. Por ello, lo marca como un bug.

4. _/src/static/css/owner/editPet.css_

    Bug:
    ```css
    .edit-pet-form-container{
        max-width: 600px;
        height: 800px;
        width: 90%;
        height: 90%;
        margin-top: 10%;
    }
    ```
    
    En este caso se repite la propiedad height pero en este caso cambiando su valor, por lo tanto sólo la última instancia sería la que resultaría válida. Para solucionar esto deberíamos de quitar la que no se utilice.

#### Tipos de Code Smells

1. _'variable' is already declared in the upper scope_:
   1. Description: La variable que se está declarando ya está siendo declarada en otro lugar del código anteriormente.
   1. Por qué es un Code Smell: Sobreescribir o hacer shadowing a una variable declarada en un ámbito externo puede tener un fuerte impacto en la legibilidad, y por tanto en la mantenibilidad, de un trozo de código. Además, podría llevar a los mantenedores a introducir errores porque piensan que están usando una variable pero en realidad están usando otra.
   1. Gravedad: Es de gravedad _major_ ya que dificulta la legibilidad y el mantenimiento del código haciéndolo propenso a tener bugs.
   1. Solución: Eliminar todas las declaraciones posteriores a la primera y pasarlas a asignaciones.

1. _Remove this useless assignment to variable "variable name"_:
   1. Description: Una variable asignada no se usa.
   1. Por qué es un Code Smell: Calcular o recuperar un valor sólo para luego sobrescribirlo o tirarlo, podría indicar un error grave en el código. Incluso si no es un error, es en el mejor de los casos un desperdicio de recursos. Por lo tanto, todos los valores calculados deben ser utilizados.
   1. Gravedad: Es de gravedad _major_ ya que hace el código propenso a errores graves y desperdicia recursos.
   1. Solución: Eliminar la asignaciones de variables que no se utilicen.
1. _Remove the declaration of a unused variable_:
   1. Description: Una variable declarada no se usa.
   1. Por qué es un Code Smell: Si se declara una variable local o una función local pero no se utiliza, es código muerto y debe eliminarse. De este modo, mejorará la capacidad de mantenimiento, ya que los desarrolladores no se preguntarán para qué se utiliza la variable o la función.
   1. Gravedad: Es de gravedad _minor_ ya que es código muerto que entorpece el mantenimiento.
   1. Solución: Eliminar la declaraciones de variables que no se utilicen.
1. _Refactor this function to reduce its Cognitive Complexity from 29 to the 15 allowed_:
   1. Description: Una función es demasiado compleja.
   1. Por qué es un Code Smell: La Cognitive Complexity es una medida de lo difícil que es entender el flujo de control de una función. Las funciones con una Cognitive Complexity alta serán difíciles de mantener.
   1. Gravedad: Es de gravedad _critical_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: Extraer código a otras funciones para reducir su complejidad.
1. _Refactor this function to always return the same type_:
   1. Description: La función no devuelve siempre el mismo tipo de variable.
   1. Por qué es un Code Smell: A diferencia de los lenguajes fuertemente tipados, JavaScript no impone un tipo de retorno en una función. Esto significa que diferentes caminos a través de una función pueden devolver diferentes tipos de valores, lo que puede ser muy confuso para el usuario y significativamente más difícil de mantener.
   1. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: Hacer que la función devuelva el mismo tipo de retorno de la función.
1. _Extract this nested ternary operation into an independent statement_:
   1. Description: Hay una operación ternaria anidada a otra haciendo que el código sea poco entendible.
   1. Por qué es un Code Smell: Anidar operadores ternarios hace más complejo el código haciéndolo más díficil de mantener al no entender bien a los que se refiere.
   1. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: Extraer la operación ternaria anidada.
1. _Remove this commented out code_:
   1. Description: Hay código que está comentado y no se usa.
   1. Por qué es un Code Smell: Comentar código sobrecarga los programas y reduce su legibilidad.
   1. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
1. _Unnecessary semicolon_:
   1. Description: Hay dos punto y coma juntos.
   1. Por qué es un Code Smell: No deberían de haber dos, porque con uno ya funciona.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
1. _'library' import is duplicated_:
   1. Description: Se importa dos veces la misma librería.
   1. Por qué es un Code Smell: No deberían de haber dos, porque con uno ya funciona.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar uno de los dos imports o si se están importando dos objetos por separado en dos imports unirlos en uno solo.
1. _Remove this unused import of 'library'_:
   1. Description: Se importa dos veces la misma librería.
   1. Por qué es un Code Smell: No deberían de haber dos, porque con uno ya funciona.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar uno de los dos imports o si se están importando dos objetos por separado en dos imports unirlos en uno solo.
1. _Remove this unused import of 'library'_:
   1. Description: Se importa una librería que no se utiliza.
   1. Por qué es un Code Smell: No hay ninguna razón para importar librerías que no utilizas y hacerlo aumenta innecesariamente la carga.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar la importación.

1. _Unexpected empty arrow function_:
   1. Description: Es una omisión involuntaria y debe corregirse para evitar un comportamiento inesperado en la producción. Todavía no cuenta con apoyo, o nunca lo tendrá. En este caso, se debe lanzar una excepción en los idiomas donde ese mecanismo esté disponible. El método es una anulación intencional en blanco. En este caso, un comentario anidado debería explicar el motivo de la anulación del espacio en blanco.
   1. Por qué es un Code Smell: La presencia de una función de flecha vacía o una expresión de función de flecha que no tiene un propósito claro se considera un "Code Smell" porque puede llevar a confusión, desperdicio de recursos y potencial de errores futuros. Es importante eliminar o explicar adecuadamente este tipo de código para mejorar la claridad y mantenibilidad del software.
   1. Gravedad: Es de gravedad _critical_ ya que puede ser un problema que puede originar bugs.
   1. Solución: Eliminar la función de flecha vacía, si la función de flecha no tiene ningún propósito y no se utiliza en ninguna parte del código, la solución más simple es eliminarla por completo.
1. _Immediately return this expression instead of assigning it to the temporary variable "variableName"_:
   1. Description: Declarar una variable sólo para devolverla o lanzarla inmediatamente es una mala práctica.
   1. Por qué es un Code Smell: Algunos desarrolladores argumentan que esta práctica mejora la legibilidad del código, porque les permite nombrar explícitamente lo que se devuelve. Sin embargo, esta variable es un detalle de implementación interna que no está expuesto a quienes llaman al método. El nombre del método debería ser suficiente para que quienes llaman sepan exactamente qué se devolverá.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminamos la variable temporal y devolvemos la expresión directamente. Esto simplifica el código y lo hace más claro y directo. 

### Backend

#### Dashboard

![SonarQube Backend Dashboard](/docs/static/sprint2BackendDashboard.png)

- Métricas:
  - Bugs: esta métrica indica la cantidad de bugs que ha detectado en el código. En nuestro caso hay 6.
  - Reliability: En nuestro caso, la nota es una C ya que al menos un bug se considera _major bug_.
  - Vulnerabilities: esta métrica indica la cantidad de vulnerabilidades que ha detectado en el código. En nuesto caso no hay ninguna.
  - Security: En nuestro caso la nota es una A, porque no ha encontrado ninguna vulnerabilidad.
  - Security Hotspots: mide la cantidad de potenciales vulnerabilidades que necesitan ser revisadas manualmente para determinar si lo son o no. En nuestro caso, tenemos 1 Security Hotspot.
  - Reviewed: Porcentaje de security hostpost revisados. En nuestro caso es 0.
  - Security Review: Tenemos de nota una E porque el security hotspot que tenemos no lo hemos revisado aún.
  - Debt: la deuda técnica que tenemos en el proyecto con las code smells que ha detectado. En nuestro caso tenemos una deuda técnica de 1 dia.
  - Code Smells: cantidad de code smells que ha detectado. En nuestro caso son 243.
  - Maintainability: indica la mantenibilidad de nuestro código teniendo en cuenta la deuda técnica. En nuestro caso es una A porque es menor al 5%.
  - Coverage: indica la cobertura de las pruebas unitarias en nuestro código. En nuestro caso es 0 porque no disponemos de pruebas unitarias.
  - Duplications: indica las duplicidades de códigos encontradas. En nuestro caso es del 0%.

#### Bugs potenciales

Nuestro backend tiene 6 bugs:

1. _/src/main/petclinic/clinic/ClinicService.java_

    Bug:
    ```java
    @Transactional
	public Clinic update(Clinic clinic, int clinicId) throws DataAccessException {
		
		Clinic clinicToUpdate = clinicRepository.findById(clinicId).get();
		if (clinic.getClinicOwner() != null){
			BeanUtils.copyProperties(clinic, clinicToUpdate, "id", "owners");
		}else{
			BeanUtils.copyProperties(clinic, clinicToUpdate, "id", "clinicOwner", "owners");
		}
		return save(clinicToUpdate);
	}
    ```

    En la línea:
    ```java 
    Clinic clinicToUpdate = clinicRepository.findById(clinicId).get();
    ```
    Se accede directamente a un optional sin antes hacer una comprobación de si contiene a un objeto o no.
    Tendría que tener un condicional antes como por ejemplo:
    ```java
    Optional<Clinic> clinicToUpdateOpt = clinicRepository.findById(clinicId);
    if(!clinicToUpdateOpt.isPresent())
        return null;
    Clinic clinicToUpdate = clinicToUpdateOpt.get();
    ```

2. _/src/main/petclinic/clinicOwner/ClinicOwnerService.java_
   
   Bug:
   ```java
   @Transactional(readOnly = true)
	public ClinicOwner findById(int clinicOwnerId) throws DataAccessException {
		return clinicOwnerRepository.findById(clinicOwnerId).get();
	}
    ```
    En este caso ocurre lo mismo que anteriormente, debería de haber un condicional antes que verifique que se puede acceder al optional. Se solucionaría de la misma forma que el anterior.

3. _/src/main/java/org/springframework/samples/petclinic/adoption/AdoptionService.java_

   Bug:
   ```java
    @Transactional
	public AdoptionRequest save(AdoptionRequestForm adoptionRequestForm, User userNewOwner) throws DataAccessException, Exception {
        Optional<Owner> newOwner = ownerService.optFindOwnerByUser(userNewOwner.getId());
        if(!newOwner.isPresent()){
            throw new DataAccessException("The user is not an owner"){};
        }
        Pet pet = petService.findPetById(adoptionRequestForm.getPetId());
        if(pet.getOwner().getId() == newOwner.get().getId()){
            throw new DataAccessException("You cannot adopt your own pet"){};
        }
        if(!pet.getOnAdoption()){
            throw new DataAccessException("Pet is not on adoption"){};
        }
        
        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setOriginalOwner(pet.getOwner());
        adoptionRequest.setNewOwner(newOwner.get());
        adoptionRequest.setPetToAdopt(pet);
        adoptionRequest.setDescription(adoptionRequestForm.getDescription());
        adoptionRepository.save(adoptionRequest);
        return adoptionRequest;
	}
   ```
   En este caso el bug consiste en que no estamos empleando el uso de equals en la condición del if, ya que lo estamos haciendo con la expresión "==" de java. Deberia utilizarse una funcion "equal()" para evitar posibles errores en la condición.

   4. _/src/main/java/org/springframework/samples/petclinic/adoption/AdoptionService.java_

   Bug:
   ```java
    @Transactional
    public AdoptionRequest acceptAdoptionRequest(Integer requestId, User userId) throws DataAccessException {
        Optional<Owner> originalOwner = ownerService.optFindOwnerByUser(userId.getId());
        if(!originalOwner.isPresent()){
            throw new DataAccessException("The user is not an owner"){};
        }
        Optional<AdoptionRequest> adoptionRequest = adoptionRepository.findById(requestId);
        if(!adoptionRequest.isPresent()){
            throw new DataAccessException("Adoption Request not found"){};
        }
        AdoptionRequest adoptionRequestToAccept = adoptionRequest.get();
        if(adoptionRequestToAccept.getOriginalOwner().getId() != originalOwner.get().getId()){
            throw new DataAccessException("You are not the original owner of the pet"){};
        }
        Pet pet = adoptionRequestToAccept.getPetToAdopt();
        pet.setOnAdoption(false);
        pet.setOwner(adoptionRequestToAccept.getNewOwner());
        petService.savePet(pet);
        adoptionRequestToAccept.setAdmitted(true);
        desactiveAdoptionRequest(adoptionRequestToAccept.getPetToAdopt().getId());
        return adoptionRepository.save(adoptionRequestToAccept);
    }
    ```
    Esta es la misma situación que el caso anterior a excepción de que en la condición de equals en vez de consistir en comprobar si una igualdad se cumple consiste en comprobar si la igualdad no se cumple, esto se ha implementado con la expresión de java "!=" mientras que se deberia haber implementado como en el caso anterior con una función "notEqual()".


   5. _/src/main/java/org/springframework/samples/petclinic/petHotelRoom/PetHotelRoomService.java_

   Bug:
   ```java
   @Transactional(readOnly = true)
	public PetHotelRoom update(PetHotelRoom petHotelRoom, Integer id) throws DataAccessException{
		if (petHotelRoomRepository.findById(id).isEmpty())
			throw new DataAccessException("Non existing booking"){
		};
		PetHotelRoom toUpdate = petHotelRoomRepository.findById(id) == null ? petHotelRoomRepository.findById(id).get() : null;
		BeanUtils.copyProperties(petHotelRoom, toUpdate, "id");
		return save(toUpdate);
	}
   ```
   Se debe comprobar que la condición implementada en la variable toUpdate no debe ser null ademas de eliminar el null-check.

   6. _/src/main/java/org/springframework/samples/petclinic/petHotelRoom/PetHotelRoomService.java_

   Bug:
   ```java
   @Transactional(readOnly = true)
	public PetHotelRoom update(PetHotelRoom petHotelRoom, Integer id) throws DataAccessException{
		if (petHotelRoomRepository.findById(id).isEmpty())
			throw new DataAccessException("Non existing booking"){
		};
		PetHotelRoom toUpdate = petHotelRoomRepository.findById(id) == null ? petHotelRoomRepository.findById(id).get() : null;
      BeanUtils.copyProperties(petHotelRoom, toUpdate, "id");
		return save(toUpdate);
   }
   ```
   Se debe añadir una condición que compruebe si el PetHotelRoom a actualizar existe, esto se implementa en un if de forma que se cumpla la función isPresent().

#### Tipos de Code Smells

1. _Remove this commented out code_:
   1. Description: Hay código que está comentado y no se usa.
   1. Por qué es un Code Smell: Comentar código sobrecarga los programas y reduce su legibilidad.
   1. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
1. _Provide the parametrized type for this generic_
   1. Description: No hay un tipo parametrizado para un tipo genérica.
   1. Por qué es un Code Smell: Los tipos genéricos no deberían usarse sin procesar (sin parámetros de tipo) en declaraciones de variables o valores de retorno. Al hacerlo, se elude la comprobación de tipos genéricos y se aplaza la detección de código inseguro al tiempo de ejecución.
   1. Gravedad: Es de gravedad _major_ ya que resultar en futuros bugs.
   1. Solución: Especificar un tipo parametrizado.
1. _Declare this local variable with "var" instead_
   1. Description: Una variable local no se está declarando con "var".
   1. Por qué es un Code Smell: Aunque no siempre es posible o más limpio utilizar esta nueva forma de declarar una variable, cuando el tipo de la izquierda es el mismo que el de la derecha en una asignación, el uso de var dará como resultado un código más conciso.
   1. Gravedad: Es de gravedad _info_ ya que tal como está no supone un problema de ningún tipo.
   1. Solución: Cambiar la asignación para que sea con "var".
1. _Replace this lambda with a method reference_
   1. Description: Existe una lambda que puede ser reemplazado con un _method reference_
   1. Por qué es un Code Smell: Method/constructor son, en general, más compactas y legibles que el uso de lambdas, por lo que son preferibles.
   1. Gravedad: Es de gravedad _minor_ ya que solo empeora un poco la legibilidad del código.
   1. Solución: Cambiar la lambda por un _method reference_
1. _Replace the type spcefication in this constructor call with the diamond operator ("<>")_
   1. Description: Se debería de usar "<>".
   1. Por qué es un Code Smell: En lugar de tener que declarar el tipo de una Lista tanto en su declaración como en su constructor, ahora puedes simplificar la declaración del constructor con <>, y el compilador inferirá el tipo.
   1. Gravedad: Es de gravedad _minor_ ya que solo empeora un poco la legibilidad del código.
   1. Solución: Usar "<>".
1. _Remove this unused import of 'library'_:
   1. Description: Se importa una librería que no se utiliza.
   1. Por qué es un Code Smell: No hay ninguna razón para importar librerías que no utilizas y hacerlo aumenta innecesariamente la carga.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar la importación.
1. _Replace this use of System.out or System.err by a logger_:
   1. Description: Las salidas estándar no deben utilizarse directamente para registrar nada.
   1. Por qué es un Code Smell: Se tiene que cumplir que el usuario pueda recuperar los logs fácilmente, que sean uniformes, que se deben de registrar realmente y los logs sensibles se tienen que guardar de forma segura.
   1. Gravedad: Es de gravedad _major_ ya que si se solucionase se podrían arreglar bugs fácilmente mirando los logs.
   1. Solución: Cambiar _System.out_ por _System.err_
1. _Remove the declaration of thrown exception, as it cannot be thrown from method's body_:
   1. Description: Las declaraciones "throws" no deben ser superfluas.
   1. Por qué es un Code Smell: No puede ser listada múltiples veces, una subclase de otra excepción listada o completamente innecesaria porque el tipo de excepción no puede ser lanzado.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Quitar la excepción.
1. _Inject this field value directly into "configure", the only method that uses it_:
   1. Description: La inyección de métodos debe utilizarse en las clases "@Configuration".
   1. Por qué es un Code Smell: Cuando se utiliza @Autowired, las dependencias deben resolverse cuando se instancia la clase, lo que puede provocar una inicialización temprana de los beans o hacer que el contexto busque el bean en lugares donde no debería. Para evitar este problema y optimizar la carga del contexto, las dependencias deben solicitarse lo más tarde posible. Esto significa utilizar inyección de parámetros en lugar de inyección de campos para las dependencias que sólo se utilizan en un único método @Bean.
   1. Gravedad: Es de gravedad _critical_ ya que puede ser un problema que puede originar bugs.
   1. Solución: Inyectar el valor a "configure".
1. _Remove the parentheses around the parameter_:
   1. Description: Los paréntesis deben eliminarse de un único parámetro de entrada lambda cuando se infiere su tipo.
   1. Por qué es un Code Smell: Hay dos sintaxis posibles para una lambda que sólo tiene un parámetro de entrada con un tipo inferido: con y sin paréntesis alrededor de ese único parámetro. La sintaxis más simple, sin paréntesis, es más compacta y legible que la que tiene paréntesis, por lo que es preferible.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar los paréntesis alrededor del parámetro.
1. _Remove hits unnecesssary cast to a type_:
   1. Description: No deben utilizarse casts redundantes.
   1. Por qué es un Code Smell: Las expresiones de casts innecesarias dificultan la lectura y comprensión del código.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Eliminar los casts innecesarios.
1. _Declare variable on a separate line_:
   1. Description: No deben declararse varias variables en la misma línea.
   1. Por qué es un Code Smell: Declarar múltiples variables en una línea es difícil de leer.
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Declarar la variable en otra línea.
1. _Make this field final_:
   1. Description: Las clases de excepción deben ser inmutables.
   1. Por qué es un Code Smell: Hacer que todos los campos de una clase Exception sean final asegura que su estado estará completamente definido al mismo tiempo que la Excepción es instanciada y que no será acutalizado o corrompido por un manejador de errores cuestionable.s
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Hacer el campo final.
1. _Remove usage of generic wildcard type_:
   1. Se recomienda encarecidamente no utilizar tipos comodín como tipos de devolución. Debido a que las reglas de inferencia de tipos son bastante complejas, es poco probable que el usuario de esa API sepa cómo usarla correctamente.
   1. Por qué es un Code Smell: Tomemos el ejemplo del método que devuelve una "Lista <? extiende Animal>". ¿Es posible añadir en esta lista un Perro, un Gato,… simplemente no lo sabemos? Y el compilador tampoco, por lo que no permitirá un uso tan directo. El uso de tipos comodín debe limitarse a los parámetros del método.
   1. Gravedad: Es de gravedad _critical_ ya que puede hacer que el código sea realmente difícil de mantener.
   1. Solución: No utilizar wildcard types.
1. _Remove hits unnecesssary cast to a list_:
   1. Description: No deben utilizarse casts redundantes.
   2. Por qué es un Code Smell: Las expresiones de casts innecesarias dificultan la lectura y comprensión del código.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar los casts innecesarios.
1. _Define and throw a dedicated exception instead of using a generic one_:
   1. Description: El uso de excepciones genéricas como Error, RuntimeException, Throwable y Exception evita que los métodos de llamada manejen excepciones verdaderas generadas por el sistema de manera diferente a los errores generados por la aplicación.
   1. Por qué es un Code Smell: El uso de excepciones genéricas como mecanismo predeterminado de manejo de errores puede indicar una falta de atención a las mejores prácticas de diseño de software, lo que potencialmente puede conducir a problemas de mantenimiento, calidad y fiabilidad a largo plazo. 
   1. Gravedad: Es de gravedad _major_ ya que si se solucionase se podrían arreglar bugs fácilmente mirando los logs.
   1. Solución: Revisa tu código para identificar los lugares donde estás utilizando excepciones genéricas como Error, RuntimeException, Throwable y Exception. Luego, identifica las situaciones específicas que podrían generar esas excepciones y define excepciones dedicadas para representar esas situaciones.
1. _Use the primitive boolean expression here_:
   1. Description: Cuando se utiliza el tipo java.lang.Boolean como expresión, se generará NullPointerException si el valor es nulo como se define en Java Language Specification §5.1.8 Unboxing Conversion.
   1. Por qué es un Code Smell: El uso de objetos Boolean en lugar de tipos primitivos boolean en expresiones condicionales o evaluaciones booleanas puede indicar una posible fuente de errores, reducir la claridad y la legibilidad del código, y desviar las convenciones de codificación comunes en Java. 
   1. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   1. Solución: Usar el tipo primitivo boolean.

## Conlusión
En resumen, aunque el aumento de bugs reportados y de la deuda técnica son consistentes entre los dos sprints, hay diferencias notables en las métricas de duplicaciones y se identifican nuevos tipos de code smells en el Sprint 2. Esto puede suponer a primera vista un descenso en la calidad del código, sin embargo, la mayor parte de deuda tecnica y lineas duplicadas vienen dadas en el frontend ya que hemos creado una nueva vista muy similar a otra.