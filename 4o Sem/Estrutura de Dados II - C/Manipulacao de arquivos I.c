#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

struct Embaixadores {
	char nomeCurso[50];
	char nome[50];
	char ra[50];
	struct Embaixadores *prox;
};
struct Embaixadores *emba = NULL;

void inserirNoFim(struct Embaixadores **principal, char nome[50], char nomeCurso[50], char ra[50]) {
    struct Embaixadores *aux = malloc(sizeof(struct Embaixadores));
    strcpy(aux->nome, nome);
    strcpy(aux->nomeCurso, nomeCurso);
    strcpy(aux->ra, ra);
    aux->prox = NULL;

    if (*principal == NULL) {
        *principal = aux;
        return;
    }

    struct Embaixadores *ultimo = *principal;
    while (ultimo->prox != NULL) {
        ultimo = ultimo->prox;
    }
    ultimo->prox = aux;
}

void quebraStr(char str[150]){
    char *pedaco = strtok(str, ",");
    char nome[50], ra[50], nomeCurso[50];
    int i=0;
	
    while(pedaco != NULL) {
    	switch(i){
    		case 0:
    			strcpy(nomeCurso, pedaco);
    			break;
    			
    		case 1:
    			strcpy(nome, pedaco);
    			break;
    		
    		case 2:
    			strcpy(ra, pedaco);
    			break;
		}
		i++;
        pedaco = strtok(NULL, ",");
	}
	inserirNoFim(&emba, nome, nomeCurso, ra);
}

void leitura(){
	char str[20][150];
    int i = 0;
    
    FILE *arq = fopen("embaixadores.txt", "r");
    
    while (fgets(str[i], sizeof(str[i]), arq) != NULL){
        quebraStr(str[i]);
        i++;
    }
    fclose(arq);
}

void trocarEmbaixador(int num){
	struct Embaixadores *aux;
	aux = emba;
	int i=1;
	
	while(aux != NULL && i != num){
		aux = aux->prox;
		i++;
	}
	
	fflush(stdin);
	if (i == num && aux != NULL){
		printf("Digite o nome do novo embaixador: ");
		gets(aux->nome);
		printf("Digite o RA do novo embaixador: ");
		gets(aux->ra);
		
		//Adiciona um \n no fim do RA para a função salvaArquivo não salvar os embaixadores na mesma linha
		strcat(aux->ra, "\n");
	} else {
		printf("Não foi possivel ler o indice\n");
	}
}

void imprimeLista(){
	struct Embaixadores *aux;
	aux = emba;
	int i = 1;
	
	while(aux != NULL){
		printf("Indice: %d\n", i);
		printf("Curso: %s\n", aux->nomeCurso);
		printf("Nome: %s\n", aux->nome);
		printf("RA: %s\n", aux->ra);
		aux = aux->prox;
		i++;
	}
}

void salvaArquivo(){
	struct Embaixadores *aux;
	aux = emba;
	
	FILE *arq = fopen("embaixadores.txt", "w");
	
	while(aux != NULL){
		fprintf(arq, "%s,%s,%s", aux->nomeCurso, aux->nome, aux->ra);
		aux = aux->prox;
	}
	fclose(arq);
}

void menu(){
	int i = 0;
	int num;
	while(i >= 0 && i < 3){
		printf("\n------------menu-----------\n");
		printf("Opção 1: Listar embaixadores\n");
		printf("Opção 2: Trocar um embaixador\n");
		printf("Opção 3: Finalizar programa\n");
		printf("-----------------------------\n");
		printf("Opção: ");
		scanf("%d", &i);
		printf("\n");
		switch(i){
			case 1:
				imprimeLista();
				break;
				
			case 2:
				printf("Caso você não saiba o indice, digite 0 e liste os embaixadores primeiro\n");
				printf("Digite o indice desejado: ");
				scanf("%d", &num);
				trocarEmbaixador(num);
				break;
			
			case 3:
				salvaArquivo();
				printf("Finalizando...");
				break;
				
			default:
				printf("Opção invalida!");
				i = 0;
				break;
		}
	}
}

int main(){
	setlocale(LC_ALL, "portuguese");
	leitura();
	menu();
	
	return 0;
}
