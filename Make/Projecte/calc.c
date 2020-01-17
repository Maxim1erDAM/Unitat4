int suma(int op1, int op2){
	return (op1+op2);
}
int resta(int op1, int op2){
	return (op1-op2);
}
int multiplica(int op1, int op2){
	return (op1*op2);
}
int divideix(int op1, int op2){
	return (op1/op2);
} 

int majorque(int op1, int op2){
	if (op1>op2){
		return (op1);
	}
	else{
		return (op2);
	}
}

int mitja(int op1, int op2){
	int mitjana=((op1+op2)/2);
	return mitjana;
}
