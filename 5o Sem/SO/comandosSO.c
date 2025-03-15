#include <sys/types.h>
#include <sys/stat.h>
#include <direct.h>
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* Fun��es: 
	Criar um diret�rio com o nome "igor" no C:\
	Criar um arquivo de texto "arq.txt" dentro desse diret�rio
	Abrir o explorer na pasta
	Excluir o arquivo e a pasta
*/

int main(){
	setlocale(LC_ALL, "portuguese");
	FILE *fp;
	struct stat st = {0};
	
	// Cria��o de diret�rio e arquivo de texto
	if (stat("C:/igor", &st) == -1) {
		if(mkdir("C:/igor") == 0){
			printf("Diret�rio criado em C:\\");
			fp = fopen("C:/igor/arq.txt","w");
			fclose(fp);
		}
	}else {
		printf("Diret�rio j� existe");
	}
	
	// Comando para abrir o explorer na pasta criada
	system("explorer C:\\igor");
	
	
	// Algoritmo para escolha de exclus�o dos itens criados
	char escolha = 'M';
	while(escolha = 'M'){
		printf("\nDeseja excluir o diret�rio e o arquivo de texto? S/N\n");
		scanf(" %c", &escolha);
		
		switch(escolha){
			case 'S':
				remove("C:/igor/arq.txt");
				rmdir("C:/igor");
				printf("Diret�rio e arquivo deletados");
				return 1;
				
			case 'N':
				printf("O diret�rio e o arquivo n�o foram deletados");
				return 0;
				
			default:
				escolha = 'M';
				printf("Digite uma op��o entre S e N");
				break;
		}
	}
	return 0;
}
