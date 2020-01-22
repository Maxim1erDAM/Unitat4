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

![ImatgeFitxers](projecte/Imatges/CAPTURA%20FINAL%20FITXERS.png)

>***`Executem tots els TARGETS del makefile amb "sudo make TARGET", tambe utilitzem "sudo make dist" per a crear un directori "dist" amb el compilat de calcula al directori fill, i "sudo make distclean" per a eliminar eixe directori: `***  

![ImatgePostCompilacioTARGETSPart1](projecte/Imatges/Eixeple%20de%20compilacio%20i%20targets%20de%20Makefile%20i%20CMAKE%20part%201.png)

>***`Com s'elimina el directori "dist" amb el target "distclean": `***  

![ImatgePostCompilacioTARGETSPart2](projecte/Imatges/Eixeple%20de%20compilacio%20i%20targets%20de%20Makefile%20i%20CMAKE%20part%202.png)

>***`Executem el archiu "calcula" compilat del makefile amb "sudo make calc.o" i "sudo make calcula": `*** 

![Execuciocalcula](projecte/Imatges/EXECUCIOCALCULA.png)

## 4.-Com utilitzar Git Part 2.
>***`Al modificar els fitxers tindrem que sincronizarlos amb el nostre repositori local de GIT amb "git add" : `***  

git add NOMDEFITXER

>***`Una vegada fet aixó tindrem que escriure un COMMIT per a anotar els canvis que hem realitzat:`***  
>***`Eixemple que mos mostra els canvis del COMMIT:`***  


![ImatgePushARepoPart1](projecte/Imatges/Git-Github%20PARTE%201.png)
![ImatgePushARepoPart2](projecte/Imatges/Git-Github%20PARTE%202.png)

>***`Crearem un fitxer .gitignore per a que no incluisca els fitxers .o compilats de el directori del repositori:`***  
>***`Eixemple:`***  

![CreacioArchiu.gitignore](projecte/Imatges/Creació%20de%20fitxer%20.gitignore%20incluint%20commit%20i%20fent%20push%20al%20branch%20master.png)

>***`Así un eixemple de push de les Imatges del ejercici:`***  
>***`Eixemple:`***  

![PujadaD'imatges](projecte/Imatges/captura%20final%20edd%20pujada%20imatges.png)


>***`Así un eixemple de push de tot el contingut al final del ejercici:`***  
>***`Eixemple:`*** 

![PushFinal1](projecte/Imatges/push%20final%201.png)

![PushFinal2](projecte/Imatges/push%20final%202.png)

>***`Así no mos deixa fer el COMMIT pero perque el contingut no a cambiat a la rama MASTER:`***  
>***`Eixemple:`***  

![PushFinal3](projecte/Imatges/push%20final%203.png)

