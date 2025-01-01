#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

struct Arvore{
	char simboloA[10];
	char direcao[20];
	char simboloB[10];
	
	struct Arvore *noEsq;
	struct Arvore *noDir;
};
struct Arvore *inicio = NULL;

void validaArvore(struct Arvore *raiz){
	
	if(raiz == NULL){
		printf("Arvore vazia");
		return;
	}
	
	if(strcmp(raiz->direcao, "esquerda") == 0){
		if(raiz->noEsq != NULL){
			strcpy(raiz->noEsq->simboloA, raiz->simboloB);
		} else {
			raiz->noEsq = malloc(sizeof(struct Arvore));
			strcpy(raiz->noEsq->simboloA, raiz->simboloB);
			raiz->noEsq->noEsq = NULL;
			raiz->noEsq->noDir = NULL;
		}
	}

	if(strcmp(raiz->direcao, "direita") == 0){
		if(raiz->noDir != NULL){
			strcpy(raiz->noDir->simboloA, raiz->simboloB);
		} else {
			raiz->noDir = malloc(sizeof(struct Arvore));
			strcpy(raiz->noDir->simboloA, raiz->simboloB);
			raiz->noDir->noEsq = NULL;
			raiz->noDir->noDir = NULL;
		}
	} 
	
	if(raiz->noEsq != NULL) validaArvore(raiz->noEsq);
	if(raiz->noDir != NULL) validaArvore(raiz->noDir);
	
	inicio = raiz;
	
}

void inserirNaArvore(struct Arvore *raiz, char simboloA[10], char direcao[20], char simboloB[10]){
	// Está inserindo em Pré Ordem
	
	struct Arvore *aux = malloc(sizeof(struct Arvore));
	
	strcpy(aux->simboloA, simboloA);
	strcpy(aux->direcao, direcao);
	strcpy(aux->simboloB, simboloB);
	
	if (raiz == NULL){
		raiz = aux;
		raiz->noDir = NULL;
		raiz->noEsq = NULL;
		inicio = raiz;
		return;
	}
	
	if(raiz->noEsq == NULL){
		raiz->noEsq = aux;
		raiz->noEsq->noEsq = NULL;
		raiz->noEsq->noDir = NULL;
		return;
	}
	
	if(raiz->noDir == NULL){
		raiz->noDir = aux;
		raiz->noDir->noEsq = NULL;
		raiz->noDir->noDir = NULL;
		return;
	}
	
	if(raiz->noEsq->noEsq == NULL || raiz->noEsq->noDir == NULL){
		inserirNaArvore(raiz->noEsq, simboloA, direcao, simboloB);
	}else {
		inserirNaArvore(raiz->noDir, simboloA, direcao, simboloB);
	}

}

void leitura(){
	char simboloA[10], direcao[20], simboloB[10];
    int i = 0;
    
    FILE *arq = fopen("dados.txt", "r");
    
    while (
    	fscanf(arq, "%s", simboloA),
    	fscanf(arq, "%s", direcao),
    	fscanf(arq, "%s", simboloB) == 1
    	){	
    		inserirNaArvore(inicio, simboloA, direcao, simboloB);
	}
    
    fclose(arq);
}

void imprimeLista(struct Arvore *aux){

	if(aux != NULL){
		printf("%s-", aux->simboloA);
		imprimeLista(aux->noEsq);
		imprimeLista(aux->noDir);
	}
	
}

int main(){
	setlocale(LC_ALL, "portuguese");
	leitura();
	
	printf("Lista do Arquivo em Pré Ordem: ");
	imprimeLista(inicio);
	
	validaArvore(inicio);
	
	printf("\nLista Validada em Pré Ordem:   ");
	imprimeLista(inicio);
}

