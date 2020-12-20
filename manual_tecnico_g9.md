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

En el primer problema se dicta la situación de cinco filosofos, el cual dice literalmente lo siguiente:

>Había una vez 5 filósofos que vivían juntos, la vida de cada filósofo consiste básicamente en pensar y comer, la única comida que contribuida a sus esfuerzos pensantes era el espagueti, por lo que todas las noches se sentaban los 5 a cenar. En la cena, sentados los 5 filósofos en una mesa redonda que tiene una fuente de espagueti, van a existir 5 platos uno para cada filósofo, van a existir 5 tenedores, uno al lado de cada plato (izquierda y derecha). Entonces cada que un filósofo quiera ir a comer irá al lugar asignado en la mesa, y usando los dos tenedores que se encuentran al lado de cada plato, los usará para comer el espagueti. Dos filósofos no pueden utilizar el mismo tenedor a la vez.

### Analisis del problema
Segun la descripción anterior del problema, no todos los filosofos pueden cenar a la vez, dado que cada uno necesita de dos tenedores para poder hacerlo y estos solamente cuentan con 5 de ellos; tomando esto en consideración la optimización debe permitir el maximo que para este caso serían 2 filosofos comiendo a la vez, mientras los otros 3 continuaran pensando. algunos de los problemas que se pueden encontrar sera el bloqueo entre ellos, por lo que ninguno de ellos podra comer nunca, y tambien se puede dar el caso en que un filosofo acapare todo el sistema, impidiendo que los demas coman.

### Problemas encontrados
Durante el desarrollo se encontraron 2 problemas con el sistema debido a la concurrencia y a los recursos mutuos, los cuales se describen a continuación:
- deadlock: El primer problema encontrado fue este ya que al momento de tomar todos un tenedor y ninguno soltarlos, el sistema se bloqueaba infinitamente y ninguno de los filosofos podía comer o regresar al estado de pensar;
- condición de carrera: este segundo problema se dío al eliminar el bloqueo, ya que pasado un tiempo solo lograba comer uno de los 5 filosofos, y solía ser el que lograra tomar primero los dos tenedores, obligando a los otros a continuar pensando.

### Desarrollo e implementación de los algoritmos
El sistema posee un recurso compartido que es el de los tenedores, de forma que este causa los problemas antes mencionados al ser este un sistema con hilos concurrentes.

#### soluciones propuestas
- En la primera versión del sistema se decidio que todos los filosofos entraran  al sistema y tomaran el tenedor de su izquierda, posterior a ello debían consultar si el tenedor de la derecha estaba disponible, de ser así lo tomaban y procedían a comer, en caso contrario se dejaban esperando por un tiempo en el cual intentarían nuevamente tomar el tenedor de la derecha y si de nuevo no lo lograban tomar, soltaban el tenedor izquierdo y pasaban al estado de pensar.

- La primer versión provoco los problemas de deadlock descritos en la sección anterior, es por ello que se procedía a crear una segunda versión, en este caso se eliminaron los procesos logicos desarrollados y se opto por el uso de  **Reentrantlock**  en los tenedores, de forma que ahora solo se tenía la opción de tomar o dejar el tenedor por medio de las funciones **lock** y **unlock** respectivamente; del lado del filosofo se procedía a obtener tanto el tenedor izquierdo como el derecho de forma secuencial, y  entrar en el estado de comer y al final soltar ambos tenedor

- La segunda versión provocaba el problema de condición de carrera, ya que pasado un tiempo en el sistema solo comía un filosofo a la vez, esto genero una tercera versión que corrigiera estos problemas, para ello se hizo uso de un portero, el cual permitiera el acceso solamente a 4 filosofos a la vez en el comedor, de forma que se agrego un tercer estado el cual es **Ingreso al comedor**  para evitar conflictos entre los hilos, en esta ocasión al portero se le implementaron dos funciones del tipo **synchronized**  una que permite el acceso a los 4 filosofos y la segunda que va liberando espacios en el comedor; con esta implementación final se eliminaron los problemas mencionados anteriormente y se logro un funcionamiento optimo del sistema, permitiendo que 2 filosofos comieran al mismo tiempo, mientras los otros se mantenían pensando o esperando obtener los tenedores.

### Solución final
En esta sección se describe el proceso completo y los algoritmos implementados para desarrollo del sistema.

El sistema fue desarrollado pensando en un ambiente completamente grafico, es por ello que el uso de variables primitivas es escaso y en su lugar se utilizan JComponentes.

![N|Interfaz](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/interfaz.png)

Para mostrar graficamente todo el proceso o funcionamiento del sistema, se implemento el manejo de estados basados en colores para los componentes del filosofo y los tenedores los cuales son:

|  Filosofo | Tenedor   |
| ------------ | ------------ |
|  Azul: significa que el filosofo esta pensando |Rojo: significa que el tenedor fue tomado por alguno de los filosofos adyacentes   |
|  Verde: Esto significa que el filosofo esta comiendo |Verde: en este estado el tenedor esta libre, por lo cual puede ser tomado por uno de los filosofos adyacentes   |
| Blanco: este color se da cuando el filosofo logra obtener uno de los 4 lugares dados por el portero y esta esperando por los tenedores para proceder a comer |

Para iniciar la simulación del sistema solo bastara con darle click al boton, que literalmente dice **Iniciar** de la misma forma si se desea finalizar la simulación se debe precionar el boton que dice **Terminar**

![N|Inicio](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/iniciar.png)

### Codigo en java

1. Al iniciar la simulación se llama una función que crea dos arreglos de Labels de 5 posiciones, uno pertenecera a los componentes de los filosofos y el otro a los componentes de los tenedores, ya que como se menciono en otras secciones son estos los que se utilizan para representar de forma visual el funcionamiento
2. Despues de creados los arreglos se asigna a cada posición la referencia de los labels graficos, esto se hizo de esta manera para controlarlos de forma mas sencilla.
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

> el primero sera para crear los objetos de tipo tenedor, a la cual se les trasladan por referencia los componentes label, para que de esta forma puedan cambiar el color segun el estado 

> el segundo crea los objetos de tipo filosofo, este recibe el componente label del filosofo, y calcula los objetos tenedor que le corresponden, creados anteriormente, se le asigna uno como izquierda y otro como derecho y por ultimo se le envía la instancia de la clase portero, la cual controla los accesos al comedor.

> El tercero unicamente hace un recorrido por las instancias de los filosofos e invoca a la funcion **start** que da inicio al bucle de los hilos

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
5. Despues de lo anterior los filosofos entran en un bucle que mantiene en funcionamiento a los hilos, sobreescribiendo el metodo **run** de la clase **Thread**
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
6. Dentro de este bucle los filosofos siempre inician pensando, para esto se llama al metodo pensar, el cual hace uso de la funcion **Sleep** con un tiempo random entre 0.5 y 2 segundos que pasara el filosofo pensando.
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
7. El siguiente paso en el algoritmo es darle acceso al filosofo, para ello se hace uso del portero y se llama a su metodo **ingresarFilosofo** este metodo implementa el uso de **Synchronized** y hace uso de un **wait** de forma que si no hay espacios disponibles causa una pausa en el hilo del filosofo hasta que se le pueda otorgar uno de los cuatro lugares.
```java
public synchronized void ingresarFilosofo() throws InterruptedException{
        while(filosofos==0){
            this.wait();
        }
        filosofos--;
}
```
8. Dado que el filosofo pudo obtener uno de los lugares se llama al metodo **comer**, en donde sucede algo similar que con el portero, ya que aca el filosofo primero intenta obtener los tenedores para poder comer y dado que los obtiene procede a simular que esta comiendo por medio de una llamada al metodo **sleep** en un tiempo aleatorio entre 0,5 y 2 segundos. cuando este tiempo finaliza se llama a los metodos **dejarTenedor** correspondiente a cada tenedor asignado al filosofo, liberando los tenedores para que otro filosofo pueda comer.
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
Este metodo se encuentra en la clase **Tenedor** y hace uso del metodo **lock** de **Reentrantlock** esto lo que hace es bloquear al objeto tenedor, para que de esa forma no lo pueda tomar otro filosofo de igual forma provoca una condición de espera para el filosofo hasta que le sea notificado que el tenedor ya fue liberado y pueda proceder a tomarlo, este bloqueo dura hasta que se llame al metodo **dejarTenedor**
```java
public void tomarTenedor() {
        this.bloqueo.lock();
        this.estado = false;
        cambiarColor();
    }
```
- dejarTenedor
Este metodo realiza una acción contraría al anterior ya que quitaba el bloqueo provocado en un principio, esto se logra con el metodo **unlock** este a su vez notifica que se ha liberado el objeto para que pueda ser tomado por otro que espere por el.
```java
public void dejarTenedor() {
        this.estado = true;
        cambiarColor();
        bloqueo.unlock();
    }
```
9. Finalizado el proceso anterior para comer se llama al metodo **sacarFilosofo** el cual libera el espacio ocupado por el filosofo e informa por medio del metodo notify() para intentar que entre un nuevo filosofo al comedor.
```java
public synchronized void sacarFilosofo() {
        filosofos++;
        this.notify();
    }
```
10. Con lo anteriormente descrito se finaliza el flujo del filosofo y se inicia nuevamente el bucle con el filosofo pensando.

                
### Diagrama de flujo
![N|Inicio](https://github.com/ing-rich/SO2_Practica2/blob/main/imagenes_manual/diagramaFlujo.png)