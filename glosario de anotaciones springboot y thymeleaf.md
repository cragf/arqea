# importante #
* cada controlador representa una ruta diferente parte del url de la pagina
* cada parte de la ruta empieza por `/`
* árbol de paquetes = *(paq principal -> (paq sb -> (conexiones,controladores,modelos -> (dto,dao),),resources -> (static,templates)))*
## Model
Es una clase especial de SB que almacena información en forma parecida a un map
## @SpringBootApplication
Va en el método main y básicamente es el que dice que, efectivamente, estas desarrollando en SB. Siempre usar el método `SpringApplication.run(SbmavenApplication.class, args)`
## @Controller
Manda información a la página en forma a traves de un método principal anotado con `@GetMapping`. el metodo que devuelve se llama `info`
## @RestController
Un controlador que manda la información en forma de .json para leerse en el navegador a traves de un método principal anotado con `@GetMapping`. el metodo que devuelve se llama como la parte final de la ruta despues del /
## @RequestMapping("direcion")
Es una seccion de la direccion url, `("direcion")`
## @GetMapping("direcion")
Es la parte final de la dirección a la que el controlador va a mandar la informacion `("direcion")` equivale a `@RequestMapping(path "direcion" method = GET)`
## @ModelAtribute("nombre")
Almacena información para ser mandada a la página principal con thymeleaf
## @RequestParam
Lee datos de un formulario de la página los cuales se muestran temporalmente en la url `[nombre del metodo]([parametros])?[nombre de variable]=[valor]`
## @PathVariable
En el @GetMapping debe haber un elemento variable en la ruta identificado por `{mensaje}` y el método principal debe recibir una variable del mismo nombre `mensaje` `@PathVariable [tipo de variable] [variable]`

# Thymeleaf #
* las directivas de th se colocan dentro de la etiqueta html, en plan <[etiqueta] th:(...) = ${"[contenido]"}>
* en los corchetes (*contenido*) la informacion se maneja a través del objeto que se devuelve en el metodo principal del controlador
* el [condicion] ? [resultadotrue] : [resultadofalse] se puede usar en thymeleaf analizando condicionales traídas desde el controlador
### :text
el contenido de la etiqueta sera el especificado en los corchetes
### :each
crea una copia de la etiqueta por cada elemento en la lista devuelta desde el controlador th:each = *nombre del elemento que se referirá mas tarde* ${*nombre en el controlador*}
### :data-
Crea un atributo para cualquier elemento html para que este pueda ser referido en el .js
### :if
Funciona igual que el if en java. Todo su contenido debe estar dentro del *${}*. Si se da true entonces se ejecuta la directiva th que le sigue dentro de la etiqueta html