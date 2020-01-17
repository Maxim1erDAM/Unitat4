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
