/*
	File content all functions
	of main program.
*/
#include "distance.h"

extern float miles_fact;

float convert_to_miles(float kms){
	return kms / miles_fact;
}

void load_value(float *kilometers){
	printf("Please, enter a Km. value: ");
	scanf("%f",kilometers);
}
