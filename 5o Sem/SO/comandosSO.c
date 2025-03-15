#include <sys/types.h>
#include <sys/stat.h>
#include <direct.h>
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* Funções: 
	Criar um diretório com o nome "igor" no C:\
	Criar um arquivo de texto "arq.txt" dentro desse diretório
	Abrir o explorer na pasta
	Excluir o arquivo e a pasta
*/

int main(){
	setlocale(LC_ALL, "portuguese");
	FILE *fp;
	struct stat st = {0};
	
	// Criação de diretório e arquivo de texto
	if (stat("C:/igor", &st) == -1) {
		if(mkdir("C:/igor") == 0){
			printf("Diretório criado em C:\\");
			fp = fopen("C:/igor/arq.txt","w");
			fclose(fp);
		}
	}else {
		printf("Diretório já existe");
	}
	
	// Comando para abrir o explorer na pasta criada
	system("explorer C:\\igor");
	
	
	// Algoritmo para escolha de exclusão dos itens criados
	char escolha = 'M';
	while(escolha = 'M'){
		printf("\nDeseja excluir o diretório e o arquivo de texto? S/N\n");
		scanf(" %c", &escolha);
		
		switch(escolha){
			case 'S':
				remove("C:/igor/arq.txt");
				rmdir("C:/igor");
				printf("Diretório e arquivo deletados");
				return 1;
				
			case 'N':
				printf("O diretório e o arquivo não foram deletados");
				return 0;
				
			default:
				escolha = 'M';
				printf("Digite uma opção entre S e N");
				break;
		}
	}
	return 0;
}
