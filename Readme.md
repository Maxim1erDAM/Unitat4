# **1ER DAM. Desarrotllament D'Aplicacions Multiplataforma. EDD. Entorns de Desenvolupament.**

***2019- Editat per Máxim Sánchez Porta***


# Index:



>### UNITAT 4. Automatització amb Make.
>
>***[1.-Com instalar Git i Make en Ubuntu 18.](https://github.com/Maxim1erDAM/Unitat4#1-com-instalar-git-i-make-en-ubuntu-18)***
>
>***[2. Com utilitzar Git Part 1](https://github.com/Maxim1erDAM/Unitat4#2-com-utilitzar-git-part-1)***
>
>***[3. Make i el fitxer Makefile](https://github.com/Maxim1erDAM/Unitat4/blob/master/Readme.md#3-make-i-el-fitxer-makefile)***
>
>***[4. Com utilitzar Git Part 2](https://github.com/Maxim1erDAM/Unitat4/blob/master/Readme.md#4-com-utilitzar-git-part-2)***

#    **-Activitat pràctica-**



# UNITAT 4. Automatització amb Make.


## 1.-Com instalar Git i Make en Ubuntu 18.

>***`Actualizar llistat de repositoris de Ubuntu:`***  

sudo apt update

>***`Instalar git:`***  

sudo apt install git


>***`Instalar gcc i make:`***  

sudo apt install gcc make

## 2.-Com utilitzar Git Part 1.

>***`Descarregar el nostre repositori complet de Github a un directori per a treballar:`***  
>***`El nom del repositori deu ser el mateix que el repositori del sistema local. En aquest cas, será “Unitat-4”. Per aixó, abans que res, hi ha que iniciar sessió en Github al introduir la comanda.
Una vegada fet aixó es creará el repositori i será posible pujar o sincronitzar el contingut del repositori local en el repositori de GitHub. Per a conectar el directori al repositori remot de GitHub hi ha que executar la comanda "git remote add origin git clone https://github.com/USUARIGITHUB/REPOSITORI.git" `***  


>***`Eixemple, sincronizant el repositori dins de un directori anomenat "EJERCICIO", amb la comanda "git clone https://github.com/USUARIGITHUB/REPOSITORI.git":`***  

cd EJERCICIO/

git clone https://github.com/USUARIGITHUB/REPOSITORI.git

>***`En el meu cas:`***  

git clone https://github.com/Maxim1erDAM/Unitat-4.git



>***`Després de descarregar-lo, ens situarem en el directori i sincronitzarem el directori amb el repositori de Github.`***  
"git remote add origin https://github.com/USUARIGITHUB/REPOSITORI.git" :`***  

>***`Eixemple:`***  



cd Unitat-4/

git remote add origin https://github.com/Maxim1erDAM/Unitat-4.git

## 3.-Make i el fitxer Makefile
>***`Modificarem els fitxers, en este cas son els fitxers escrits en C del exercici "Calcula":calc.c, calc.h i calcula.c amb companyia del fitxer Makefile de make.`***  

![ImatgeFitxers](Imatges/CAPTURA%20FINAL%20FITXERS.png)

>***`Executem tots els TARGETS del makefile amb "sudo make TARGET", tambe utilitzem "sudo make dist" per a crear un directori "dist" amb el compilat de calcula al directori fill, i "sudo make distclean" per a eliminar eixe directori: `***  

![ImatgePostCompilacioTARGETSPart1](Imatges/Eixeple%20de%20compilacio%20i%20targets%20de%20Makefile%20i%20CMAKE%20part%201.png)

>***`Com s'elimina el directori "dist" amb el target "distclean": `***  

![ImatgePostCompilacioTARGETSPart2](Imatges/Eixeple%20de%20compilacio%20i%20targets%20de%20Makefile%20i%20CMAKE%20part%202.png)

>***`Executem el archiu "calcula" compilat del makefile amb "sudo make calc.o" i "sudo make calcula": `*** 

![Execuciocalcula](Imatges/EXECUCIOCALCULA.png)

## 4.-Com utilitzar Git Part 2.
>***`Al modificar els fitxers tindrem que sincronizarlos amb el nostre repositori local de GIT amb "git add" : `***  

git add NOMDEFITXER

>***`Una vegada fet aixó tindrem que escriure un COMMIT per a anotar els canvis que hem realitzat:`***  
>***`Eixemple que mos mostra els canvis del COMMIT:`***  


![ImatgePushARepoPart1](Imatges/Git-Github%20PARTE%201.png)
![ImatgePushARepoPart2](Imatges/Git-Github%20PARTE%202.png)

>***`Crearem un fitxer .gitignore per a que no incluisca els fitxers .o compilats de el directori del repositori:`***  
>***`Eixemple:`***  

![CreacioArchiu.gitignore](Imatges/Creació%20de%20fitxer%20.gitignore%20incluint%20commit%20i%20fent%20push%20al%20branch%20master.png)

>***`Así un eixemple de push de les Imatges del ejercici:`***  
>***`Eixemple:`***  

![PujadaD'imatges](Imatges/captura%20final%20edd%20pujada%20imatges.png)


>***`Así un eixemple de push de tot el contingut al final del ejercici:`***  
>***`Eixemple:`*** 

![PushFinal1](Imatges/push%20final%201.png)

![PushFinal2](Imatges/push%20final%202.png)

>***`Así no mos deixa fer el COMMIT pero perque el contingut no a cambiat a la rama MASTER:`***  
>***`Eixemple:`***  

![PushFinal3](Imatges/push%20final%203.png)

>***`Así torne a copiar tot el contingut de un primer repositori anomenat "Unitat-4" a un segon repositori anomenat "Unitat4", utilitzant la ordre "git remote add NOMDEORIGE https://github.com/USUARIGITHUB/REPOSITORI.git":`***  
>***`Eixemple, en el meu cas:`***

git remote add origin2 https://github.com/Maxim1erDAM/Unitat4.git



![Copiantsegorepositori](Imatges/COPIANT%20CONTINGUT%20A%20UN%20SEGON%20REPOSITORI.png)


>***`Así es quan finalment puc fer el push, despres de fer el commit relatiu a origin2:`***  
>***`Eixemple:`*** 

![Copiantsegorepositori](Imatges/COPIANT%20CONTINGUT%20A%20UN%20SEGON%20REPOSITORI%202.png)
