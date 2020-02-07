package com.ieseljust.edd.calc;

public class Calculadora {

    private float lastResult;

    public float floatResult;

    private String lastResultString;

    public String StringResult;

    public String result;

    public String lastOp;

    boolean primoRelativo;
	


    public float getLastResult(){

        return this.lastResult;
    }

    public String getLastResultForString(){

        return this.lastResultString;
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

    public String esPrim(float operand1){

	int contador = 2;

	boolean primoRelativo=true;
	if (operand1>1)
	    while ((primoRelativo) && (contador!=operand1)){

                if (operand1 % contador == 0)
                    primoRelativo = false;

                if (operand1 % contador != 0)
                    primoRelativo = true;
	    contador++;
	    }
	if (operand1==1)
	    primoRelativo = false;
        			
        

	if (primoRelativo==false){this.StringResult=" NO ";};
	if (primoRelativo==true){this.StringResult=" SI ";};


	result=StringResult;
	this.lastResultString=result;
	this.lastOp="esPrim";


	return result;
    }

    public float siguienteprimo (float operand1){

   	      int contador = 2;
   	      boolean primoRelativo=true;
   	      if (operand1>1)
   	      while ((primoRelativo) && (contador!=operand1)){
   	      if (operand1 % contador == 0)
                    primoRelativo = false;
   	      if (operand1 % contador != 0)
                    primoRelativo = true;
   	      
   	      if (operand1==0)
   	         floatResult = 2;
   	      if (operand1==1)
   	         floatResult = 2;
   	      if (operand1==2)
		 floatResult = 3;
   	      if (operand1>=3)
		 floatResult = 5;
   	      if (operand1>=5)
		 floatResult = 7;
   	      if (operand1>=7)
		 floatResult = 11;
   	      if (operand1>=11)
		floatResult = 13;
   	      if (operand1>=13)
                 floatResult = 17;
   	      if (operand1>=17)
                 floatResult = 19;
   	      if (operand1>=19)
                 floatResult = 23;
   	      if (operand1>=23)
                 floatResult = 29;
   	      if (operand1>=29)
                 floatResult = 31;
   	      if (operand1>=31)
                 floatResult = 37;
   	      if (operand1>=37)
                 floatResult = 41;
   	      if (operand1>=41)
                 floatResult = 43;
   	      if (operand1>=43)
                 floatResult = 47;
   	      if (operand1>=47)
                 floatResult = 53;
   	      if (operand1>=53)
                 floatResult = 59;
   	      if (operand1>=59)
                 floatResult = 61;
   	      if (operand1>=61)
                 floatResult = 67;
   	      if (operand1>=67)
                 floatResult = 71;
   	      if (operand1>=71)
                 floatResult = 73;
   	      if (operand1>=73)
                 floatResult = 79;
   	      if (operand1>=79)
                 floatResult = 83;
   	      if (operand1>=83)
                 floatResult = 89;
   	      if (operand1>=89)
                 floatResult = 97;
	      contador++;
   	      }

	
   

	this.lastResult=floatResult;
	this.lastOp="siguienteprimohasta97";


	return floatResult;
    }
 
}
