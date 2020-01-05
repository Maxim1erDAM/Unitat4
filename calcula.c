#include <stdio.h>
#include "calc.h"


int major(int op1, int op2){
	if (op1>op2){
		return (op1);
	}
	if (op2>op1){
		return (op2);
	}
}

int menor(int op1, int op2){
	if (op1<op2){
		return (op1);
	}
	if (op2<op1){
		return (op2);
	}
}

int main(void){
	int a=10;
	int b=5;
	printf("La suma de %d i %d és %d\n", a, b, suma(a,b));
	printf("La resta entre %d i %d és %d\n", a, b, resta(a,b));
	printf("La multiplicació de %d i %d és %d\n", a, b, multiplica(a,b));
	printf("La divisió entre %d i %d és %d\n", a, b, divideix(a,b));
	printf("El major entre %d i %d és %d\n", a, b, major(a,b));
	printf("El menor entre %d i %d és %d\n", a, b, menor(a,b));
}
