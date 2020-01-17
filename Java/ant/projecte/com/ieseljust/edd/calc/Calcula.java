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

