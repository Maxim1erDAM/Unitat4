# **1ER DAM. Desarrotllament D'Aplicacions Multiplataforma. EDD. Entorns de Desenvolupament.**

***2019- Editat per Máxim Sánchez Porta***

# Index:
>
>***[1. Introducció a Gradle](https://github.com/Maxim1erDAM/EinaGradle/blob/master/Readme.md#1-introducci%C3%B3-a-gradle)***
>
>***[2. Instal·lació de Gradle](https://github.com/Maxim1erDAM/EinaGradle/blob/master/Readme.md#2-installaci%C3%B3-de-gradle)***
>
>***[3. Eixemple amb Gradle i creació d'un projecte](https://github.com/Maxim1erDAM/EinaGradle/blob/master/Readme.md#3-exemple-amb-gradle-i-creaci%C3%B3-dun-projecte)***


# UNITAT 4. Automatització amb Gradle.

## 1. Introducció a Gradle

Fins ara hem vist dues eines per tal de crear projectes en Java i gestionar les seues dependències: Ant i Maven. Ant, com hem vist és una eina molt versàtil, però deixa al desenvolupador la responsabilitat de definir totes les tasques que s'han de fer i com fer-les, el que porta a grans fitxers de construcció (build.xml), que a més poden ser molt complexos. Maven, per la seua banda, ens ho dóna tot predefinit, i els fitxers de configuració (pom.xml) no són excessivament complexos. A més, dóna suport a tot el cicle de vida de construcció. L'inconvenient que suposa és que quan volem realitzar algun projecte que no s'ajuste als arquetipus que té predefinits, pot arribar a ser bastant complex. Per altra banda, al tractar-se d'una eina tan completa, també creix en complexitat, fins al punt de, com hem vist a l'exemple  generar fitxers de construcció pom.xml més llargs que el propi codi de l'aplicació.

En aquest context, el 2008 apareix Gradle que pretén integrar el millor de cada eina: les tasques i la personalització d'Ant, la potència, el cicle de construcció i proves tipus Maven, o la gestió de dependències d'altres eines com Ivy. A més, segueix un paradigma de convenció sobre configuració: Totes les opcions de configuració tenen valors per defecte comuns o útils, de manera que només s'hauran de modificar per a casos especials.

Una altra diferència important és que Gradle no fa ús de fitxers de configuració XML, sinò d'un llenguatge específic de domini (Domain-Specific Language o DSL), inspirat en el llenguatge de programació Groovy.

Per altra banda, Gradle disposa d'una arquitectura de plugins variats: compilació de projecte Java, Groovy, Maven, generació de documentació, proves, etc.

Anem a seguir el mateix procediment que per a Maven, i crearem un projecte en Gradle.

# 2. Instal·lació de Gradle

Gradle es troba als dipòsits de programari d'Ubuntu, pel que podem instal·lar-lo amb apt:

```
 sudo apt-get update
```

```
 sudo apt-get install gradle
```
Nosaltres instalarem la nostra versió que es troba al repositori bionic de ieseljust: 
```
sudo add-apt-repository ppa:ieseljust/bionic
sudo apt-get update
```
```
sudo apt install gradle-5.1
```
Com veurem, el paquet arrossega moltes dependències. Diem que sí a tot, i una vegada instal·lat, podem comprovar la versió amb:

```
$ gradle -v

------------------------------------------------------------
Gradle 5.1
------------------------------------------------------------

Build time:   2019-01-02 18:57:47 UTC
Revision:     d09c2e354576ac41078c322815cc6db2b66d976e

Kotlin DSL:   1.1.0
Kotlin:       1.3.11
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          11.0.5 (Private Build 11.0.5+10-post-Ubuntu-0ubuntu1.118.04)
OS:           Linux 4.15.0-20-generic amd64


```

Com podem veure, se'ns mostra informació sobre la versió de Gradle (5.1), Groovy (2.5.4), Ant (1.9.13), JVM (11.0.5), entre d'altres, així com el sistema operatiu.

# 3. Exemple amb Gradle i creació d'un projecte

Anem a veure com fariem amb Gradle el projecte per a un Hola Món típic.


En primer lloc, creem el directori del projecte i accedim a ell:

```
$ mkdir helloGradle
$ cd helloGradle
```

Per tal de crear un projecte nou en Gradle, farem ús de l'ordre gradle init. Per a això, ens ubiquem en una carpeta buida, invoquem gradle init i anem seguint l'assistent:

```
$ gradle init

Select type of project to generate:
  1: basic
  2: groovy-application
  3: groovy-library
  4: java-application
  5: java-library
  6: kotlin-application
  7: kotlin-library
  8: scala-library
Enter selection (default: basic) [1..8] 4

Select build script DSL:
  1: groovy
  2: kotlin
Enter selection (default: groovy) [1..2] 1

Select test framework:
  1: junit
  2: testng
  3: spock
Enter selection (default: junit) [1..3] 1

Project name (default: gradle): helloGradle
Source package (default: helloGradle): com.ieseljust.edd

BUILD SUCCESSFUL in 17s
2 actionable tasks: 2 executed

```

Com veiem, se'ns executa un assistent que ens demana el tipus de projecte (java application), el llenguatge per definir el projecte (groovy), el framework de test (junit) i el nom del projecte (helloGradle).
Creació del projecte amb una sola ordre

Gradle també permet indicar-li mitjançant paràmetres les diferents característiques del projecte a generar. Així, podem fer exactament el mateix que amb l'assistent anterior de la següent forma:


I ara, llancem el gradle init amb els paràmetres corresponents al tipus d'aplicació, al tipus de test, al tipus de llenguatge per al build.gradle, el nom del projecte i el nom complet del paquet:

```
$ gradle init   --type java-application \
                --test-framework junit \
                --dsl groovy \
                --project-name helloGradle \
                --package com.ieseljust.edd
```
Captura de la meua máquina virtual:
![ImatgeGradleBuildCompilacio](/Imatges/asistente%20gradle5.1%20parte%202.png)

Com veurem, si ho fem així, el projecte es genera directament, sense fer-nos cap pregunta.

Estructura del projecte

Hajam procedit bé amb l'assistent o bé generant directament el projecte, aquest presenta la següent estructura de directoris:

```
.
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── ieseljust
    │               └── edd
    │                   └── calc
    │                       ├── App.java
    │                       └── Calculadora.java
    └── test
        └── java
            └── com
                └── ieseljust
                    └── edd
                        └── AppTest.java

12 directories, 7 files

```


El contingut del fitxer App.java és :

```
package com.ieseljust.edd.calc;

import com.ieseljust.edd.calc.Calculadora;
import static java.lang.Math.*;

public class App {
    private static float operand1;
    private static float operand2;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("\nSintaxi incorrecta. La calculadora necessita 2 números.");
            System.exit(-1);
        }

        operand1=Float.parseFloat(args[0]);
        operand2=Float.parseFloat(args[1]);

        Calculadora myCalc=new Calculadora();

        System.out.println("La suma entre "+operand1+" i "+operand2+" és "+myCalc.suma(operand1, operand2));
        System.out.println("La resta entre "+operand1+" i "+operand2+" és "+myCalc.resta(operand1, operand2));
        System.out.println("La multiplicació entre "+operand1+" i "+operand2+" és "+myCalc.multiplica(operand1, operand2));
        System.out.println("La divisió entre "+operand1+" i "+operand2+" és "+myCalc.divideix(operand1, operand2));
	System.out.println("El número major entre els números pasat com a arguments, que són: "+operand1+" i "+operand2+". El major es el número:"+myCalc.majorque(operand1, operand2));
	System.out.println("La mitja entre els números pasat com a arguments, que són: "+operand1+" i "+operand2+". El mitja es el número:"+myCalc.mitja(operand1, operand2));
	System.out.println("El operand 1 és: "+operand1+". El operand1: "+myCalc.esPrim(operand1)+" és prim.");
	System.out.println("El operand 1 és: "+operand1+". El numero primo siguiente és: "+myCalc.siguienteprimo(operand1)+" .");
        System.out.println("Última operació realitzada: "+myCalc.getLastOp()+"; Últim resultat: "+myCalc.getLastResult());
    }
}


```
## 3.2 Afegint dependències

Moltes vegades, als nostres projectes necessitarem algunes funcionalitats que no proporcionen les pròpies llibreríes de Java, i ho farem mitjançant llibreríes de tercers. Per exemple, quan hajam de treballar amb fitxers JSON necessiterem una llibreria que ens permeta entendre aquest tipus de fitxers, o quan hajam de treballar amb connectors a bases de dades, necessitarem llibreries que s'encarreguen de facilitar-nos les connexions.

Un dels llocs de referència per tal de trobar és el repositori de Maven (https://mvnrepository.com/), que a banda de Maven, permet utilitzar les llibreríes en qualsevol tipus de projectes.

Com a exemple, anem a veure com inclouriem una llibrería externa dins les nostres dependències. Anem a utilitzar la llibrería Apache Commons Math, amb funcions matemàtiques addicionals. Per a això, busquem mitjançant el quadre de cerca de la web del repositori Maven alguna llibreria que continga Math i veurem que aquesta ens apareix la primera:

# Búsqueda de la llibrería math

Ara editarem el fitxer build.gradle del nostre projecte, i modificarem dues de les seccions que apareixen. En primer lloc, cal modificar la secció de repositoris, per tal d'afegir el repositori de Maven, per a això, localitzem la secció repositories, i afegim la línia mavenCentral() a aquest. Ens quedarà de la següent forma:


```
repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}
```

Ara haurem d'apegar el codi proporcionat pel repositori de Gradle a la secció dependencies. Aquesta quedarà de la següent manera:

```
dependencies {
    // This dependency is found on compile classpath of this component and consumers.
    implementation 'com.google.guava:guava:26.0-jre'

    // Use JUnit test framework
    testImplementation 'junit:junit:4.12'

    // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    compile group: 'org.apache.commons', name: 'commons-math3', version: '3.6.1'
}
```


Veiem ara el contingut del fitxer de projecte build.gradle :
```

plugins {
    // Apply the java plugin to add support for Java
    id 'java'

    // Apply the application plugin to add support for building an application
    id 'application'
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

dependencies {
    // This dependency is found on compile classpath of this component and consumers.
    implementation 'com.google.guava:guava:26.0-jre'

    // Use JUnit test framework
    testImplementation 'junit:junit:4.12'

    // https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver
    compile group: 'org.mongodb', name: 'mongo-java-driver', version: '3.12.1'
    // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    compile group: 'org.apache.commons', name: 'commons-math3', version: '3.6.1'

}

// Define the main class for the application
mainClassName = 'com.ieseljust.edd.calc.App'

```

De moment, el que ens interessa és veure la secció de plugins, en la que indiquem que es tracta d'una aplicació java, i que la classe principal és com.ieseljust.edd.calc.App. La secció de repositoris i dependències ens servirà quan treballem amb llibreries externes. Tingueu en compte que si la vostra classe principal -la que conté el mètode main- està implementat un fitxer diferent a App.java, com per exemple Calcula.java, caldrà canviar també el mainClassName per a que faça referència a aquesta classe, així com si es troba en alguna subcarpeta -com.ieseljust.edd.calc.Calculadora si es tracta de Calculadora.java dins la carpeta/subpaquet calc.

## 3.3. Construcció i execució del projecte

Una vegada hem vist l'esquelet del projece, podem construir-lo amb l'ordre gradle build, des de la carpeta principal del projecte:

```
$ gradle build

BUILD SUCCESSFUL in 20s
7 actionable tasks: 7 executed
```
![ImatgeGradleBuildCompilacio](/Imatges/asistente%20gradle%201.png)

Amb açò, compila, processa els recursos i genera les classes i l'empaquetat jar de l'aplicació. Si ens fixem, tenim una nova carpeta build amb el resultat de la construcció del paquet:

```.
├── build
│   ├── classes
│   │   └── java
│   │       ├── main
│   │       │   └── com
│   │       │       └── ieseljust
│   │       │           └── edd
│   │       │               └── calc
│   │       │                   ├── App.class
│   │       │                   └── Calculadora.class
│   │       └── test
│   │           └── com
│   │               └── ieseljust
│   │                   └── edd
│   │                       └── AppTest.class
│   ├── distributions
│   │   ├── einaGradle.tar
│   │   └── einaGradle.zip
│   ├── libs
│   │   └── einaGradle.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   └── com.ieseljust.edd.AppTest.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── com.ieseljust.edd.html
│   ├── scripts
│   │   ├── einaGradle
│   │   └── einaGradle.bat
│   ├── test-results
│   │   └── test
│   │       ├── binary
│   │       │   ├── output.bin
│   │       │   ├── output.bin.idx
│   │       │   └── results.bin
│   │       └── TEST-com.ieseljust.edd.AppTest.xml
│   └── tmp
│       ├── compileJava
│       ├── compileTestJava
│       └── jar
│           └── MANIFEST.MF
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── ieseljust
    │               └── edd
    │                   └── calc
    │                       ├── App.java
    │                       └── Calculadora.java
    └── test
        └── java
            └── com
                └── ieseljust
                    └── edd
                        └── AppTest.java

41 directories, 26 files

```

Si volem veure les diferents fases per les que passa la construcció de l'aplicació, podem utilitzar l'opció -i de Gradle: gradle build -i.

Per altra banda, si volem netejar el projecte i tornar a la configuració anterior, farem:

```
$ gradle clean
```

Finalment, per tal d'executar l'aplicació, només haure d'invocar gradle run per executar aquest, pero l'aplicació de gradle i els diferents directoris de Java han d'estar correctament configurants:

```
$ gradle run

```
Finalment, per saber comandes adicionals i per a les tasques relacionades amb Gradle:
```
$ gradle --help

```
```
$ gradle tasks
```
Ara, quan construïm el projecte, automàticament es descarregarà la llibreria commons-math3 , al realitzar el build.

L'eixida del programa serà una cosa semblant a aquesta:
```
alumne@alumne-VirtualBox:~/Escritorio/einagradle/projecte$ gradle run --args="4 5"

> Task :run
La suma entre 4.0 i 5.0 és 9.0
La resta entre 4.0 i 5.0 és -1.0
La multiplicació entre 4.0 i 5.0 és 20.0
La divisió entre 4.0 i 5.0 és 0.8
El número major entre els dos números pasats com a arguments, que són: 4.0 i 5.0. El major es el número:5.0
La mitja entre els números pasat com a arguments, que són: 4.0 i 5.0. El mitja es el número:4.5
L'operand 1 és: 4.0. L'operand1:  NO  és prim.
L'operand 1 és: 4.0. El numero primo seguent és: 5.0 .
Última operació realitzada: siguienteprimohasta97; Últim resultat: 5.0

BUILD SUCCESSFUL in 13s
2 actionable tasks: 1 executed, 1 up-to-date
```

Podem utilitzar qualsevol dels mecanismes i IDEs què hem vist.
