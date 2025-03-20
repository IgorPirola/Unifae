#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main(){
	setlocale(LC_ALL, "portuguese");
	FILE *fp;
	char linha[50];
	
	fp = fopen("arq.txt", "w");
	fprintf(fp, "Meu nome é Igor Mariano Pirola\nEstou no 5º semestre de Engenharia de Software");
	fclose(fp);
	
	fp = fopen("arq.txt", "r");
	while(fgets(linha, sizeof(linha), fp) != NULL){
		printf("%s", linha);
	}
	fclose(fp);
	
	printf("\n\n");
	
	system("dir");
	
	
	if(remove("arq.txt") == 0){
		printf("\nArquivo apagado\n");
	}
	
	system("powershell -Command \"Get-EventLog -LogName System -Newest 10\"");
}
