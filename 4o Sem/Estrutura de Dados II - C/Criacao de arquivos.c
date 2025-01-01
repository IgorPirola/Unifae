#include <stdio.h>
main(){
	FILE *fp;
	char nome[50];
	int i;
	
	if ((fp=fopen ("nomes.txt","w")) != NULL){
		for(i=0; i<10; i++){
			printf("Escreva um nome: ");
			gets(nome);
			fprintf(fp, "Nome %d: %s\n", i+1, nome);
		}
	}
	fclose(fp);
}
