#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct Agenda {
	char data[15];
	char hora[10];
	char desc[300];
	struct Agenda *prox;
};
struct Agenda *agenda = NULL;

void inserirNoFim(struct Agenda **principal, char data[15], char hora[10], char desc[300]) {
    struct Agenda *aux = malloc(sizeof(struct Agenda));
    strcpy(aux->data, data);
    strcpy(aux->hora, hora);
    strcpy(aux->desc, desc);
    aux->prox = NULL;

    if (*principal == NULL) {
        *principal = aux;
        return;
    }

    struct Agenda *ultimo = *principal;
    while (ultimo->prox != NULL) {
        ultimo = ultimo->prox;
    }
    ultimo->prox = aux;
} 

void leitura(){
	char data[20], hora[10], desc[300];
    int i = 0;
    
    FILE *arq = fopen("agenda.txt", "r");
    
    while (
    	fscanf(arq, "%s", data),
    	fscanf(arq, "%s", hora),
    	fscanf(arq, "%s", desc) == 1
    	){	
			inserirNoFim(&agenda, data, hora, desc);
	}
    
    fclose(arq);
}

void imprimeLista(){
	struct Agenda *aux;
	aux = agenda;
	int i = 1;
	
	if(aux == NULL){
		printf("Arquivo vazio");
		return;
	}
	
	while(aux != NULL){
		printf("Indice: %d\n", i);
		printf("Data: %s\n", aux->data);
		printf("Hora: %s\n", aux->hora);
		printf("Desc: %s\n\n", aux->desc);
		aux = aux->prox;
		i++;
	}
}

void adicionar(){
	char data[15], hora[10], desc[300];
	printf("Digite as informações necessarias a seguir: \n");
	printf("Data: ");
	scanf("%s", &data);
	
	printf("Hora: ");
	scanf("%s", &hora);
	
	printf("Desc: ");
	scanf("%s", &desc);
	
	inserirNoFim(&agenda, data, hora, desc);
}

void remover(int num){
	struct Agenda *aux;
	aux = agenda;
	int i=1;
	
	if(num == 1){
		agenda = agenda->prox;
		return;
	}
	
	struct Agenda *ultimo;
	while(aux != NULL && i != num){
		ultimo = aux;
		aux = aux->prox;
		i++;
	}
	
	fflush(stdin);
	if (i == num && aux != NULL){
		ultimo->prox = aux->prox;
	} else {
		printf("Não foi possivel ler o indice\n");
	}
}

void salvaArquivo(){
	struct Agenda *aux;
	aux = agenda;
	
	FILE *arq = fopen("agenda.txt", "w");
	
	while(aux != NULL){
		fprintf(arq, "%s\n%s\n%s\n\n", aux->data, aux->hora, aux->desc);
		aux = aux->prox;
	}
	fclose(arq);
}

void menu(){
	int i = 0;
	int num;
	while(i >= 0 && i < 4){
		printf("\n------------menu-----------\n");
		printf("Opção 1: Listar Agendamentos\n");
		printf("Opção 2: Adicionar um Agendamento\n");
		printf("Opção 3: Remover um Agendamento\n");
		printf("Opção 4: Finalizar programa\n");
		printf("-----------------------------\n");
		printf("Opção: ");
		scanf("%d", &i);
		printf("\n");
		switch(i){
			case 1:
				imprimeLista();
				break;
				
			case 2:
				adicionar();
				break;
			
			case 3:
				printf("Caso você não saiba o indice, digite 0 e liste os Agendamentos primeiro\n");
				printf("Digite o indice desejado: ");
				scanf("%d", &num);
				remover(num);
				break;
				
			case 4:
				salvaArquivo();
				printf("Programa finalizado");
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
}
