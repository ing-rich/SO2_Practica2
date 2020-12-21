### Universidad de San Carlos de Guatemala
### Facultad de ingeniería
### Escuela de vacaciones diciembre 2020
---
#### Manual técnico
#### Practica 2
#### Grupo 9
### Problema 1
**Tabla de contenidos**

[TOCM]

[TOC]

En el primer problema se dicta la situación de cinco filósofos, el cual dice literalmente lo siguiente:

>Había una vez 5 filósofos que vivían juntos, la vida de cada filósofo consiste básicamente en pensar y comer, la única comida que contribuida a sus esfuerzos pensantes era el espagueti, por lo que todas las noches se sentaban los 5 a cenar. En la cena, sentados los 5 filósofos en una mesa redonda que tiene una fuente de espagueti, van a existir 5 platos uno para cada filósofo, van a existir 5 tenedores, uno al lado de cada plato (izquierda y derecha). Entonces cada que un filósofo quiera ir a comer irá al lugar asignado en la mesa, y usando los dos tenedores que se encuentran al lado de cada plato, los usará para comer el espagueti. Dos filósofos no pueden utilizar el mismo tenedor a la vez.

### Análisis del problema
Según la descripción anterior del problema, no todos los filósofos pueden cenar a la vez, dado que cada uno necesita de dos tenedores para poder hacerlo y estos solamente cuentan con 5 de ellos; tomando esto en consideración la optimización debe permitir el máximo que para este caso serían 2 filósofos comiendo a la vez, mientras los otros 3 continuaran pensando. algunos de los problemas que se pueden encontrar será el bloqueo entre ellos, por lo que ninguno de ellos podrá comer nunca, y también se puede dar el caso en que un filósofo acapare todo el sistema, impidiendo que los demás coman.

### Problemas encontrados
Durante el desarrollo se encontraron 2 problemas con el sistema debido a la concurrencia y a los recursos mutuos, los cuales se describen a continuación:
- deadlock: El primer problema encontrado fue este ya que al momento de tomar todos un tenedor y ninguno soltarlos, el sistema se bloqueaba infinitamente y ninguno de los filósofos podía comer o regresar al estado de pensar;
- condición de carrera: este segundo problema se dio al eliminar el bloqueo, ya que pasado un tiempo solo lograba comer uno de los 5 filósofos, y solía ser el que lograra tomar primero los dos tenedores, obligando a los otros a continuar pensando.

### Desarrollo e implementación de los algoritmos
El sistema posee un recurso compartido que es el de los tenedores, de forma que este causa los problemas antes mencionados al ser este un sistema con hilos concurrentes.

#### soluciones propuestas
- En la primera versión del sistema se decidió que todos los filósofos entraran al sistema y tomaran el tenedor de su izquierda, posterior a ello debían consultar si el tenedor de la derecha estaba disponible, de ser así lo tomaban y procedían a comer, en caso contrario se dejaban esperando por un tiempo en el cual intentarían nuevamente tomar el tenedor de la derecha y si de nuevo no lo lograban tomar, soltaban el tenedor izquierdo y pasaban al estado de pensar.

- La primer versión provoco los problemas de deadlock descritos en la sección anterior, es por ello que se procedía a crear una segunda versión, en este caso se eliminaron los procesos lógicos desarrollados y se optó por el uso de  **Reentrantlock**  en los tenedores, de forma que ahora solo se tenía la opción de tomar o dejar el tenedor por medio de las funciones **lock** y **unlock** respectivamente; del lado del filósofo se procedía a obtener tanto el tenedor izquierdo como el derecho de forma secuencial, y  entrar en el estado de comer y al final soltar ambos tenedor

- La segunda versión provocaba el problema de condición de carrera, ya que pasado un tiempo en el sistema solo comía un filósofo a la vez, esto genero una tercera versión que corrigiera estos problemas, para ello se hizo uso de un portero, el cual permitiera el acceso solamente a 4 filósofos a la vez en el comedor, de forma que se agregó un tercer estado el cual es **Ingreso al comedor**  para evitar conflictos entre los hilos, en esta ocasión al portero se le implementaron dos funciones del tipo **synchronized**  una que permite el acceso a los 4 filósofos y la segunda que va liberando espacios en el comedor; con esta implementación final se eliminaron los problemas mencionados anteriormente y se logró un funcionamiento óptimo del sistema, permitiendo que 2 filósofos comieran al mismo tiempo, mientras los otros se mantenían pensando o esperando obtener los tenedores.

### Solución final
En esta sección se describe el proceso completo y los algoritmos implementados para desarrollo del sistema.

El sistema fue desarrollado pensando en un ambiente completamente gráfico, es por ello que el uso de variables primitivas es escaso y en su lugar se utilizan JComponentes.

![N|Interfaz](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/interfaz.png)

Para mostrar gráficamente todo el proceso o funcionamiento del sistema, se implementó el manejo de estados basados en colores para los componentes del filósofo y los tenedores los cuales son:

|  Filosofo | Tenedor   |
| ------------ | ------------ |
|  Azul: significa que el filósofo está pensando |Rojo: significa que el tenedor fue tomado por alguno de los filósofos adyacentes   |
|  Verde: Esto significa que el filósofo está comiendo |Verde: en este estado el tenedor esta libre, por lo cual puede ser tomado por uno de los filósofos adyacentes   |
| Blanco: este color se da cuando el filósofo logra obtener uno de los 4 lugares dados por el portero y está esperando por los tenedores para proceder a comer |

Para iniciar la simulación del sistema solo bastara con darle clic al botón, que literalmente dice **Iniciar** de la misma forma si se desea finalizar la simulación se debe presionar el botón que dice **Terminar**

![N|Inicio](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/iniciar.png)

### Código en java

1. Al iniciar la simulación se llama una función que crea dos arreglos de Labels de 5 posiciones, uno pertenecerá a los componentes de los filósofos y el otro a los componentes de los tenedores, ya que como se mencionó en otras secciones son estos los que se utilizan para representar de forma visual el funcionamiento
2. Después de creados los arreglos se asigna a cada posición la referencia de los labels gráficos, esto se hizo de esta manera para controlarlos de forma más sencilla.
3. Estos componentes se trasladan en el constructor de la instancia hacia una clase llamada controladora la cual manipula el inicio y fin de la simulación.

```java
private void iniciarSimulacion(){
        JLabel [] FilosofosLbl = new JLabel[5];
        JLabel [] TenedoresLbl = new JLabel[5];
        FilosofosLbl[0] = this.Filosofo1;
        FilosofosLbl[1] = this.Filosofo2;
        FilosofosLbl[2] = this.Filosofo3;
        FilosofosLbl[3] = this.Filosofo4;
        FilosofosLbl[4] = this.Filosofo5;
        TenedoresLbl[0] = this.tenedor1;
        TenedoresLbl[1] = this.tenedor2;
        TenedoresLbl[2] = this.tenedor3;
        TenedoresLbl[3] = this.tenedor4;
        TenedoresLbl[4] = this.tenedor5;
        c = new Controladora(TenedoresLbl,FilosofosLbl);
        c.iniciarSimulacion();
    }
```

4. Se invoca la función **iniciarSimulación** esta hace uso de 3 for

> el primero será para crear los objetos de tipo tenedor, a la cual se les trasladan por referencia los componentes label, para que de esta forma puedan cambiar el color según el estado 

> el segundo crea los objetos de tipo filosofo, este recibe el componente label del filósofo, y calcula los objetos tenedor que le corresponden, creados anteriormente, se le asigna uno como izquierda y otro como derecho y por último se le envía la instancia de la clase portero, la cual controla los accesos al comedor.

> El tercero únicamente hace un recorrido por las instancias de los filósofos e invoca a la función **start** que da inicio al bucle de los hilos

```java
public void iniciarSimulacion(){
        for(int i=0;i<5;i++){
            tenedores[i] = new Tenedor(tenedoresLbl[i]);
        }
        for(int i=0; i<5; i++){
            filosofos[i] = new Filosofo(filosofosLbl[i],tenedores[(i+4)%5],tenedores[i],this.portero);
        }
        for(int i=0; i<5;i++){
            filosofos[i].start();
        }
    }
```
5. Después de lo anterior los filósofos entran en un bucle que mantiene en funcionamiento a los hilos, sobrescribiendo el método **run** de la clase **Thread**
```Java
@Override
    public void run() {
        while (iniciar) {
            try {
                pensar();
                this.portero.ingresarFilosofo();
                this.cambiarColor(3);
                comer();
                this.portero.sacarFilosofo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Proceso finalizado!");
    }
```
6. Dentro de este bucle los filósofos siempre inician pensando, para esto se llama al método pensar, el cual hace uso de la función **Sleep** con un tiempo random entre 0.5 y 2 segundos que pasara el filósofo pensando.
```java
private void pensar() {
        this.cambiarColor(1);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(2000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```
7. El siguiente paso en el algoritmo es darle acceso al filósofo, para ello se hace uso del portero y se llama a su método **ingresarFilosofo** este método implementa el uso de **Synchronized** y hace uso de un **wait** de forma que si no hay espacios disponibles causa una pausa en el hilo del filósofo hasta que se le pueda otorgar uno de los cuatro lugares.
```java
public synchronized void ingresarFilosofo() throws InterruptedException{
        while(filósofos==0){
            this.wait();
        }
        filósofos--;
}
```
8. Dado que el filósofo pudo obtener uno de los lugares se llama al método **comer**, en donde sucede algo similar que, con el portero, ya que acá el filósofo primero intenta obtener los tenedores para poder comer y dado que los obtiene procede a simular que está comiendo por medio de una llamada al método **sleep** en un tiempo aleatorio entre 0,5 y 2 segundos. cuando este tiempo finaliza se llama a los métodos **dejarTenedor** correspondiente a cada tenedor asignado al filósofo, liberando los tenedores para que otro filosofo pueda comer.
```java
private void comer() {
        tomarTenedores();
        this.cambiarColor(2);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(2000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tenedorDer.dejarTenedor();
        this.tenedorIzq.dejarTenedor();
        this.cambiarColor(1);
    }
```
- tomarTenedor
Este método se encuentra en la clase **Tenedor** y hace uso del método **lock** de **Reentrantlock** esto lo que hace es bloquear al objeto tenedor, para que de esa forma no lo pueda tomar otro filosofo de igual forma provoca una condición de espera para el filósofo hasta que le sea notificado que el tenedor ya fue liberado y pueda proceder a tomarlo, este bloqueo dura hasta que se llame al método **dejarTenedor**
```java
public void tomarTenedor() {
        this.bloqueo.lock();
        this.estado = false;
        cambiarColor();
    }
```
- dejarTenedor
Este método realiza una acción contraría al anterior ya que quitaba el bloqueo provocado en un principio, esto se logra con el método **unlock** este a su vez notifica que se ha liberado el objeto para que pueda ser tomado por otro que espere por él.
```java
public void dejarTenedor() {
        this.estado = true;
        cambiarColor();
        bloqueo.unlock();
    }
```
9. Finalizado el proceso anterior para comer se llama al método **sacarFilosofo** el cual libera el espacio ocupado por el filosofo e informa por medio del método notify() para intentar que entre un nuevo filosofo al comedor.
```java
public synchronized void sacarFilosofo() {
        filósofos++;
        this.notify();
    }
```
10. Con lo anteriormente descrito se finaliza el flujo y se inicia nuevamente el bucle con el filósofo pensando.

                
### Diagrama de flujo
![N|Inicio](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/diagramaFlujo.png)

### Clases
- Problema1
	- Constructor
	- Atributos
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| static void | main​(java.lang.String[] args) |
- problema1GUI
	- Constructor
	- Atributos
		| Tipo | Atributo |
		| ------------ | ------------ |
		| JLabel | Filosofo1 |
		| JLabel | Filosofo2 |
		| JLabel | Filosofo3 |
		| JLabel | Filosofo4 |
		| JLabel | Filosofo5 |
		| JLabel | tenedor1 |
		| JLabel | tenedor2 |
		| JLabel | tenedor3 |
		| JLabel | tenedor4 |
		| JLabel | tenedor5 |
		| Controladora | c |
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| void | iniciarSimulacion() |
		| void | iniciarBotonActionPerformed(java.awt.event.ActionEvent evt) |
		| void | terminarBotonActionPerformed(java.awt.event.ActionEvent evt) |
- Controladora
	- Constructor
		| |
		| ------------ |
		| Controladora(JLabel [] tenedoresLbl, JLabel [] filosofosLbl) |
	- Atributos
		| Tipo | Atributo |
		| ------------ | ------------ |
		| Filosofo [] | filosofos |
		| JLabel[] | filosofosLbl |
		| Portero | portero |
		| Tenedor [] | tenedores |
		| JLabel [] | tenedoresLbl |
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| void | iniciarSimulacion() |
		| void | detenerSimulacion() |
- Filosofo
	- Constructor
		| |
		| ------------ |
		| Filosofo(JLabel etiquetaFilosofo) |
		| Filosofo(JLabel filosofoLbl, Tenedor tenedorIzq, Tenedor tenedorDer) |
		| Filosofo(JLabel filosofoLbl, Tenedor tenedorIzq, Tenedor tenedorDer,Portero portero) |
	- Atributos
		| Tipo | Atributo |
		| ------------ | ------------ |
		| JLabel | etiquetaFilosofo |
		| Boolean | iniciar |
		| Portero | portero |
		| Tenedor | tenedorDer |
		| Tenedor | tenedorIzq |
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| void | cambiarColor(int codigo) |
		| void | comer() |
		| void | detener() |
		| void | pensar() |
		| void | run() |
		| void | tomarTenedores() |
- Portero
	- Constructor
	- Atributos
		| Tipo | Atributo |
		| ------------ | ------------ |
		| int | filosofos |
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| synchronized void | ingresarFilosofo() |
		| synchronized void | sacarFilosofo() |
- Tenedor
	- Constructor
		| |
		| ------------ |
		| Tenedor(JLabel tenedor) |
	- Atributos
		| Tipo | Atributo |
		| ------------ | ------------ |
		| ReentrantLock | bloqueo |
		| Boolean | estado |
		| JLabel | tenedor |
	- Metodos
		| Tipo | Metodo |
		| ------------ | ------------ |
		| void | cambiarColor() |
		| void | dejarTenedor() |
		| void | tomarTenedor() |
		
### Problema 3
En el problema 3 se plantea el sistema de una barbería con dos barberos, el cual dice lo siguiente:

>Existe una barbería en donde existen 2 barberos que la atienden y cortan el cabello a los 
>clientes que llegan y cuando no hay ninguno, se ponen a dormir. Los barberos tienen una
>silla para cortar el cabello que es donde atiende a un cliente y una sala de espera con 20
>sillas en donde pueden sentarse los clientes que llegan mientras esperan. Cuando un
>barbero termina de cortar el cabello a un cliente, regresa a la sala de espera a ver si hay
>personas esperando, si las hay trae consigo a una persona para cortarle el cabello. Si no
>hay clientes esperando, se pone a dormir en la silla para cortar cabello.

>Cada cliente que llega a la barbería observa lo que los barberos están haciendo. Si algún
>barbero se encuentra durmiendo, el cliente lo despierta y se sienta en la silla para cortar el
>cabello.Si los barberos se encuentran ocupados, entonces el cliente se coloca en una silla
>de la sala de espera. Si no hay sillas disponibles, entonces el cliente se va del lugar.


En este problema nos encontramos con los procesos siguientes:
- dormir
- cortar cabello
- despertar
- llegada del cliente
- espera

los recursos a nuestra disposición
- sillas
- barberos

#### Solucion propuesta
Los barberos contaran con un hilo cada uno ejecutandose de forma paralela, ambos utilizaran el recurso de las sillas de espera

Por otro lado se utilizara otro hilo, que estara en un bucle creando la llegada de los clientes donde estos haran uso de los recursos de los barberos

- En el caso de los barberos estos iniciaran durmiendo y hasta que un cliente los despierte continuara en este estado.
para que esto se realiza se implementaría el uso de synchronized de forma que el hilo del barbero se encuentre en wait y hasta que entre un cliente por medio de un notify se estara despertando al barbero

- Para simular el corte de cabello se haría uso de las funciones de ReentrantLock ya que con esto bloquearemos al barbero y hasta que finalice lo desbloquearemos para que realice su siguiente acción

- Hay que mencionar que sera necesarió el uso de una variable como semaforo, que nos indicara el estado en el que se encuentra el barbero, para evitar conflictos en los bloqueos y desbloqueos del barbero para cada uno de sus procesos

- Al finalizar se iniciaría un bucle en el cual se estara revisando si hay personas en las sillas de espera, mientras esto sea verdadero el barbero continuaría cortando cabello, en caso contrarío se da por terminado el proceso y se inicia nuevamente el bucle principal con el barbero durmiendo

Hilo de clientes nuevos
- Por otro lado se usa un hilo que estara creando instancias de nuevos clientes para ingresar el sistema con tiempos aleatorios, el proceso para estos consistiría en lo siguiente
 - Para utilizar un sistema de colas y evitar que los clientes nuevos sean atendidos antes que los que estan en espera, se consultaría primero que la cantidad de sillas ocupadas sea igual a 0
 - en el caso de que hay sillas ocupadas entonces se consultara si hay espacios disponibles de los 20, en caso afirmativo se le pasa la instancia del cliente nuevo a la silla disponible y se aumenta el numero de ocupadas
 - dado que no hay sillas ocupadas, lo siguiente sera verificar que el estado de alguno de los barberos sea dormido, de ser así se bloquea al barbero y empieza a correr el tiempo aleatorio del corte

Sillas de espera
- las sillas de espera manejaran un arreglo que entre sus atributos tendran un objeto cliente
	- Para evitar conflictos se usaran bloqueos que permitiran el ingreso de clientes nuevos mientras sea posible
	- cuando el contador llegue a 20, se bloqueara el sistema y sera liberado hasta que hayan nuevos espacios disponibles
	- El primer cliente en el arreglo sera tomado por el barbero al este terminar con su estado de cortar cabello
	- Se hara un corrimiento para los otros clientes en cola
	- y los nuevos iran siendo agregados al final

Lo descrito anteriormente nos permitiría obtener un solución para resolver el problema planteado, algunas consideraciones que se deben tomar en cuenta es que ambos barberos no intenten tomar al mismo cliente y que los barberos no cambien del estado dormir