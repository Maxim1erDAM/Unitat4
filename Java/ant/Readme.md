# **1ER DAM. Desarrotllament D'Aplicacions Multiplataforma. EDD. Entorns de Desenvolupament.**

***2019- Editat per Máxim Sánchez Porta***

# Index:
>
>***[1. Eines d'automatització en Java.](https://github.com/Maxim1erDAM/EinaANT/blob/master/Readme.md#1-eines-dautomatitzaci%C3%B3-en-java)***
>
>***[2. Apache Ant (Another Neat Tool) - Activitat Practica](https://github.com/Maxim1erDAM/EinaANT/blob/master/Readme.md#2-apache-ant-another-neat-tool---activitat-practica)***
>
>***[3. Ús d'Ant](https://github.com/Maxim1erDAM/EinaANT/blob/master/Readme.md#3-%C3%BAs-dant)***

#    **-Activitat pràctica-**

# UNITAT 4. Automatització amb Ant.
# 1. Introducció

## 1. Eines d'automatització en Java.

En Java disposem de diverses eines que ens ajuden a automatitzar les tasques de construcció d'aplicacions i gestionar les seues dependències.
En aquesta part de la unitat veurem tres de les principals eines: Apache Ant, Apache Maven i Gradle. Veurem les principals característiques d'elles, i aprendrem com crear i gestionar el cicle de construcció de l'aplicació amb cadascuna.
Posteriorment, veurem com incloure llibreríes en els nostres projectes i gestionar-ne les dependències, de manera que l'usuari o altres desenvolupadors no s'hagen de preocupar de descarregar-les i instal·lar-les pel seu compte.

-Aplicació d'exemple

Com a aplicació Java a utilitzar en l'exemple, anem a implementar l'aplicació de la calculadora que vam veure amb el make. Per a això, disposem de dos fitxers .java, organitzats de la següent forma: 

```
.
├── build.xml
└── com
    └── ieseljust
        └── edd
            └── calc
                ├── Calculadora.java
                └── Calcula.java

4 directories, 3 files
```

Una captura de la meua máquina virtual:

![ImatgeTreeEinaant](/imatgeseinaant/treeeinaANT.png)

-Com veiem, el codi font està organitzat en una estructura de carpetes.

Açò ens serveix per organitzar millor el codi de les nostres aplicacions.Generalment, les carpetes de més alt nivell especifiquen l'organització, i internament van estructurant-se segons la funcionalitat. Com podeu veure, es tracta com si fos un domini d'Intenet, però de l'inrevés (com/ieseljust/edd -> edd.ieseljust.com).

Aquesta estructura, ens determinarà el nom del paquet al que pertànyen els programes. Anem a veure el codi de cadascun. 



>***`La clase com.ieseljust.edd.calc.Calculadora es la que s'implementa al fitxer com/ieseljust/edd/calc/Calculadora.java:`*** 


```
package com.ieseljust.edd.calc;

public class Calculadora {

    private float lastResult;

    private String lastOp;

    public float getLastResult(){
        return this.lastResult;
    }

    public String getLastOp(){
        return this.lastOp;
    }

    public float suma(float operand1, float operand2){
        float result=operand1+operand2;
        this.lastResult=result;
        this.lastOp="Suma";

        return result;
    }

    public float resta(float operand1, float operand2){
        float result=operand1-operand2;
        this.lastResult=result;
        this.lastOp="Resta";

        return result;
    }

    public float multiplica(float operand1, float operand2){
        // Fem els càlculs
        float result=operand1*operand2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Multiplica";

        // I finalment retornem els resultats
        return result;
    }

    public float divideix(float operand1, float operand2){
        // Fem els càlculs
        float result=operand1/operand2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Divideix";

        // I finalment retornem els resultats
        return result;
    }

    public float majorque(float operand1, float operand2){
	float maximo = Math.max(operand1, operand2);

	float result=maximo;
	this.lastResult=result;
	this.lastOp="Majorque";
	return result;
    }
	
    public float mitja(float operand1, float operand2){
	float mitja = ((operand1+operand2)/2);

	float result=mitja;
	this.lastResult=result;
	this.lastOp="Mitja";
	return result;
    }	
}
```

Anem a explicar-lo per parts:
En primer lloc, s'indica el nom del paquet al què pertany el programa, de forma completa. Fixeu-se que ve definit per l'estructura de directoris on es troba:
    
package com.ieseljust.edd.calc

Després es defineix la classe Calculadora. Recordeu que en Java tot ha d'estar dins una classe, tant el main com les funcions (mètodes) que definim. L'estructura general d'aquesta classe Calculadora és la següent (mostrem només algunes parts):

```
public class Calculadora {

    private float lastResult;
    private String lastOp;

    public float getLastResult(){ ... }

    ...

    public float suma(float op1, float op2){ ... }
    }
}
```

Com veiem, la classe es defineix amb public class, indicant que es tracta d'una classe pública (es pot utilitzar des de fora).
Dins la classe hem definit:

-Atributs, com lastResult i lastOp, que hem definit com a private. El primer és un número en coma flotant (float) i el segon una cadena de caràcters (String). El fet de definir-los com a privats significa que directament no es pot accedir a aquests atributs des de fora de la classe. 
	
-Mètodes (funcions), com getLastResult, getLastOp, que es coneixen com a getters, i són mètodes a través dels quals podem consultar els valors dels atributs privats. També podem definir setters, que estableixen aquests valors, però no són necessaris a l'exemple. Aquests es defineixen com a public, per tal de poder utilitzar-los des de fora de la classe.
	
-Mètodes (funcions) com suma, resta, multiplica,divideix, majorque i mitja que són els qui realitzen les diferents operacions, guardant el resultat i l'operació i retornant el resultat. 

La paraula this s'utilitza per fer referència al propi objecte. Així, per exemple, this.lastOp fa referència a l'atribut lastOp del propi objecte.

La clase és "com.ieseljust.edd.calc.Calcula"

Aquesta és la classe que implementa la funcionalitat principal (el mètode main), i fa ús de la llibreria que hem creat amb la classe Calculadora.

Analitzem el codi per parts.

En primer lloc, definim el nom del paquet al que pertany el codi (package com.ieseljust.edd.calc;) i importem la llibreria Calculadora (import com.ieseljust.edd.calc.Calculadora;).

Després definim la classe pública Calcula que contindrà dos atributs de tipus float: operand1 i operand2. Com veiem al codi, aquests atributs s'han definit com a estàtics static. Açò significa que són atributs propis de la classe (no prenen valor en cada instància que generem a partir d'ella). A efectes pràctics, açò ens serveis per poder utilitzar el main dins la classe sense necessitat de crear un objecte d'aquesta. Aquests atributs ens serviran per emmagatzemar els operands sobre els què es realitzaran les operacions.


El fitxer corresponent a la classe és el fitxer com/ieseljust/edd/calc/Calcula.java:

```
package com.ieseljust.edd.calc;

import com.ieseljust.edd.calc.Calculadora;

public class Calcula {
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
        System.out.println("La mitja entre els números pasat com a arguments, que són: "+operand1+" i "+operand2+". La mitja es el número:"+myCalc.mitja(operand1, operand2));
	System.out.println("Última operació realitzada: "+myCalc.getLastOp()+"; Últim resultat: "+myCalc.getLastResult());
    }
}
```
Aquesta classe només té un mètode, el main. Dins aquest mètode fem el següent:
    
En primer lloc, i mitjançant el vector d'arguments args que rep el main, comprovem, que li passem dos paràmetres al programa (en la invocació d'aquest des de la línia d'ordres). Amb aquest vector, donem valor als atributs operand1 i operand2.

Per tal de poder utilitzar la classe Calculadora, hem de crear un objecte d'aquest tipus. Açò ho farem mitjançant l'operador new, i definint l'objecte com si definirem una variable del tipus de la classe: Calculadora myCalc=new Calculadora();.

En aquest cas, hem definit l'objecte myCalc de tipus Calculadora i li hem assignat el resultat de la creació d'un nou (new) objecte Calculadora. Ara, mitjançant MyCalc ja podem accedir a les funcionalitats que aquesta llibreria ens proporciona.

Finalment, mostrem els resultats, accedint als valors emmagatzemats d'operand1 i operand2, en aquest cas, sense this, ja que es tracta d'atributs de classe, i invocant als diferents mètodes de la llibreria a través de l'objecte myCalc; per exemple myCalc.suma(operand1, operand2).

Compilació i execució desde java i javac en terminal
Per tal de compilar directament el nostre programa, podem fer:
Com compilar de forma individual els dos fitxers:

```
$ javac com/ieseljust/edd/calc/Calculadora.java
$ javac com/ieseljust/edd/calc/Calcula.java
```

Com compilar directament tots els fitxers .java del directori calc:

```
$ javac com/ieseljust/edd/calc/*.java
```

De tota manera, javac és suficientment intel·ligent com per saber que si compile Calcula.java que importa la classe Calculadora, ha de compilar aquesta també si no existeix el fitxer .class corresponent.
Una vegada generats els fitxers de bytecode, executem la calculadora amb:

```
$ java com.ieseljust.edd.calc.Calcula num1 num2
```
Reemplaçant num1 i num2 pels números que desitgem.

El resultat al probar executarlo és:
```
alumne@alumne-VirtualBox:~/Escritorio/proves/einaant/projecte$ java com.ieseljust.edd.calc.Calcula 4 3
La suma entre 4.0 i 3.0 és 7.0
La resta entre 4.0 i 3.0 és 1.0
La multiplicació entre 4.0 i 3.0 és 12.0
La divisió entre 4.0 i 3.0 és 1.3333334
El número major entre els números pasat com a arguments, que són: 4.0 i 3.0. El major es el número:4.0
La mitja entre els números pasat com a arguments, que són: 4.0 i 3.0. La mitja es el número:3.5
Última operació realitzada: Mitja; Últim resultat: 3.5

```




# 2. Apache Ant (Another Neat Tool) - Activitat Practica

A partir del codi proporcionat, implementarem la nova funcionalitat a la calculadora MajorQue, que indique si el primer argument que li proporcionem és major que el segon. El tipus de valor de retorn haurà de ser lògic.

Feu ús d'aquest mètode en l'aplicació, escrivint, immediatament després d'escriure el resultat de la divisió, el resultat d'aquesta comparació.

Apache Ant és una llibrería de Java que ens permet automatitzar el procés de construcció d'aplicacions. El seu ús principal ha estat Java, tot i que també es pot utilitzar per a aplicacions en altres llenguatges. Inicialment va ser part del projecte Apache Tomcat, però l'any 2000 es va llençar com a projecte independent.
2.1. El fitxer build.xml

El fitxer de construcció d'Ant està escrit en XML (generalment s'anomena build.xml), i conté diversos targets, que representen les diferents fases de construcció (semblant als targets del make).

>***`Veiem un exemple per a la nostra calculadora:`***

```
<project>
    <target name="clean">
        <delete dir="classes" />
    </target>

    <target name="compile" depends="clean">
        <mkdir dir="classes" />
    <javac includeantruntime="false" srcdir="com/ieseljust/edd/calc" destdir="classes" />
    </target>

    <target name="run" depends="compile">
        <java classpath="classes" classname="com.ieseljust.edd.calc.Calcula">
            <arg value="${arg0}"/>
            <arg value="${arg1}"/>
        </java>

    </target>
</project>

```

Nota: Aquest fitxer build.xml l'haurem de crear al directori arrel del codi de la nostra aplicació. Al cas de la calculadora, haurà d'estar al mateix directori on està el directori arrel del projecte.
Com veiem, l'XML té tres etiquetes target:

>***`clean: que neteja les eixides anteriors de la construcció, concretament, eliminant la carpeta classes.`***

>***`compile: Que realitza la compilació de l'aplicació. Com veiem, depèn de clean, i el que fa és crear la carpeta classes, i invocar el compilador de java (javac). L'atribut includeantruntime s'afig per tal d'evitar un missatge d'alerta a partir de la versió 1.8.`***

>***`run: Per tal d'executar l'aplicació. Com veiem, depèn de la tasca de compilació, i el que fa és llançar java sobre la classe com.ieseljust.edd.calc.Calcula que es troba al classpath classes. A més, dins l'etiqueta que invoca la màquina virtual de Java (<java>), afegim dues etiquetes <arg>, que agafaran els arguments que passem per la línia d'ordres, amb les variables arg0 i arg1.`***


Així quedarien tots els fitxers, en una captura de la meua máquina virtual.

![ImatgeFichersEinaant](/imatgeseinaant/archiuseinaANT.png)

# 2.2. Instal·lació d'ant

Per tal de comprovar el funcionament, cal primerament instal·lar el paquet ant. La comanda, "apt-cache policy ant", si no tenim el paquet instalat, mos mostrara:

```
$ apt-cache policy ant
ant:
  Instal·lat: (cap)
  Candidat:   1.10.5-3~18.04
  Taula de versió:
     1.10.5-3~18.04 500
        500 http://archive.ubuntu.com/ubuntu bionic-updates/universe amd64 Packages
        500 http://archive.ubuntu.com/ubuntu bionic-updates/universe i386 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe amd64 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe i386 Packages
     1.10.3-1 500
        500 http://archive.ubuntu.com/ubuntu bionic/universe amd64 Packages
        500 http://archive.ubuntu.com/ubuntu bionic/universe i386 Packages
```

Com veiem, ens mostra que ant no es troba instal·lat al sistema, però tenim una versió candidata als repositoris d'Ubuntu (la 1.10.5-3~18.04). En cas d'estar instal·lada, en lloc de (cap), se'ns mostraria la versió d'aquesta.

```
alumne@alumne-VirtualBox:~/Escritorio/einaant/projecte$ apt-cache policy ant
ant:
  Instalados: 1.10.5-3~18.04
  Candidato:  1.10.5-3~18.04
  Tabla de versión:
 *** 1.10.5-3~18.04 500
        500 http://es.archive.ubuntu.com/ubuntu bionic-updates/universe amd64 Packages
        500 http://es.archive.ubuntu.com/ubuntu bionic-updates/universe i386 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe amd64 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe i386 Packages
        100 /var/lib/dpkg/status
     1.10.3-1 500
        500 http://es.archive.ubuntu.com/ubuntu bionic/universe amd64 Packages
        500 http://es.archive.ubuntu.com/ubuntu bionic/universe i386 Packages
```

Per tal d'instal·lar ant, farem:

```
$ sudo apt install ant
```

# 3. Ús d'Ant

Una vegada instal·lat, i amb el fitxer build.xml creat, podrem llençar ant amb els diferents targets. Veiem l'eixida de cadascun:

Per tal de compilar el projecte, farem:
    
```
alumne@alumne-VirtualBox:~/Escritorio/einaant/projecte$ ant compile

Buildfile: /home/alumne/Escritorio/einaant/projecte/build.xml

clean:

compile:
    [mkdir] Created dir: /home/alumne/Escritorio/einaant/projecte/classes
    [javac] Compiling 2 source files to /home/alumne/Escritorio/einaant/projecte/classes

BUILD SUCCESSFUL
Total time: 2 seconds

```

Com veiem, ens llença primerament la tasca clean. Si és la primera vegada que l'executem, com a l'exemple, veiem que no fa res, ja que no té res a netejar. Si ja tinguérem la carpeta classes creada d'altres compilacions, ara ens indicaría que ha esborrat aquesta carpeta.

Després de fer la neteja, fa la tasca de compilació, amb la que crea la carpeta classes, i invoca el compilador de java per generar el fitxer en bytecode (.class).

Una vegada feta la compilació, podem observar l'estructura generada:

```
.
├── build.xml
├── classes
│   └── com
│       └── ieseljust
│           └── edd
│               └── calc
│                   ├── Calcula.class
│                   └── Calculadora.class
└── com
    └── ieseljust
        └── edd
            └── calc
                ├── Calculadora.java
                └── Calcula.java

9 directories, 5 files

```

Com veiem, ens ha generat una carpeta classes tal i com hem indicat al target, i dins d'aquesta, ens ha replicat tota l'estructura de carpetes corresponent al paquet, amb els fitxers .class compilats a dins.
Per a l'execució:
    
```
alumne@alumne-VirtualBox:~/Escritorio/proves/einaant/projecte$ ant run -Darg0=3 -Darg1=4
Buildfile: /home/alumne/Escritorio/proves/einaant/projecte/build.xml

clean:
   [delete] Deleting directory /home/alumne/Escritorio/proves/einaant/projecte/classes

compile:
    [mkdir] Created dir: /home/alumne/Escritorio/proves/einaant/projecte/classes
    [javac] Compiling 2 source files to /home/alumne/Escritorio/proves/einaant/projecte/classes

run:
     [java] La suma entre 3.0 i 4.0 és 7.0
     [java] La resta entre 3.0 i 4.0 és -1.0
     [java] La multiplicació entre 3.0 i 4.0 és 12.0
     [java] La divisió entre 3.0 i 4.0 és 0.75
     [java] El número major entre els números pasat com a arguments, que són: 3.0 i 4.0. El major es el número:4.0
     [java] La mitja entre els números pasat com a arguments, que són: 3.0 i 4.0. La mitja es el número:3.5
     [java] Última operació realitzada: Mitja; Últim resultat: 3.5

BUILD SUCCESSFUL
Total time: 2 seconds

```
Un altra captura de la meua máquina virtual:

![ImatgeexecucioEinaant](/imatgeseinaant/rundargseinant.png)

>***`Fixeu-vos que l'ordre ant run afig els dos arguments que necessita la nostra aplicació amb -Darg0=3 -Darg1=4. És a dir, posem -D seguit del nom de l'argument tal i com s'anomena al fitxer build.xml.
Com veiem, en aquest cas, com que no havíem llençat prèviament el ant clean, la tasca clean, sí que ha esborrat el directori classes. Posteriorment, ha fet la compilació, i finalment, l'execuió.
Finalment, si volguérem netejar el projecte, fariem ús de ant clean. `***

>***`D'aquesta manera i gràcies a Git podem descarregar cualsevol aplicació de Java o C i compilarla descarregant del repositori de Github el projecte, amb la construcció de l'aplicació preparada per a les eines d'automatització de Make, Ant, Maven o Gradle.`*** 
