#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>

struct Embaixador{
    char nome[100];
    char ra[8];
    char curso[30];
    struct Embaixador *noEsq;
    struct Embaixador *noDir;
};

struct Embaixador *raiz = NULL;

void preOrdem(struct Embaixador *raiz){
 
 
  //Passo 1 - Visitar a raiz
    if(raiz!= NULL){
    	printf("%s %s %s\n",raiz->nome,
        raiz->ra, raiz->curso );
       
        //Passo2 - Percorrer a subarvore à
       //esquerda em pré ordem
       preOrdem(raiz->noEsq);
       
       //Passo3 - Percorrer a subarvore à
       //direita em pré ordem
       preOrdem(raiz->noDir);
    }
}

void posOrdem(struct Embaixador *raiz){

    if(raiz!= NULL){
    	
    	//Passo 1 - Percorrer a subarvore à
		//esquerda em pos ordem
		posOrdem(raiz->noEsq);
       
    	//Passo 2 - Percorrer a subarvore à
		//direita em pos ordem
		posOrdem(raiz->noDir);
       
		//Passo 3 - Visitar a raiz
		printf("%s %s %s\n",raiz->nome, raiz->ra, raiz->curso);
    }
}

void inOrdem(struct Embaixador *raiz){

    if(raiz!= NULL){
    	
    	//Passo 1 - Percorrer a subarvore à
		//esquerda em in ordem
		inOrdem(raiz->noEsq);
       
       //Passo 2 - Visitar a raiz
		printf("%s %s %s\n",raiz->nome, raiz->ra, raiz->curso);
       
    	//Passo 3 - Percorrer a subarvore à
		//direita em in ordem
		inOrdem(raiz->noDir);	
    }
}

int grauDeUmNo(struct Embaixador *raiz){
	int i = 0;
	if (raiz != NULL){
		if(raiz->noEsq != NULL) i++;
		if(raiz->noDir != NULL) i++;
	}
	return i;
	
}

int totalNos(struct Embaixador *raiz){
	int i=0;
	if(raiz!= NULL){
    	i++;
		if (raiz->noEsq != NULL) i += totalNos(raiz->noEsq);
		if (raiz->noDir != NULL) i += totalNos(raiz->noDir);	
    }
    return i;
	    
}

int buscaEmbaixador(char *curso, struct Embaixador *raiz){
	
	if(raiz != NULL){
		if (strcmp(raiz->curso, curso) == 0){
			printf("\nEmbaixador: %s\nRA: %s", raiz->nome, raiz->ra);
			return 1;
		} else {
			buscaEmbaixador(curso, raiz->noEsq);
			buscaEmbaixador(curso, raiz->noDir);
		}
	}
}


int main(){
	setlocale(LC_ALL, "portuguese");
	int achou = 0;
	
    raiz = malloc(sizeof(struct Embaixador));
    strcpy(raiz->nome, "Leo");
    strcpy(raiz->ra, "12345-6");
    strcpy(raiz->curso, "Engenharia de Software");
     
    raiz->noEsq = malloc(sizeof(struct Embaixador));
    strcpy(raiz->noEsq ->nome, "Luis");
    strcpy(raiz->noEsq->ra, "33333-3");
    strcpy(raiz->noEsq->curso, "Direito");

	raiz->noDir = malloc(sizeof(struct Embaixador));
    strcpy(raiz->noDir->nome, "Felipe");
    strcpy(raiz->noDir->ra, "22222-2");
    strcpy(raiz->noDir->curso, "Enfermagem");
     
    raiz->noEsq->noEsq = raiz->noEsq->noDir = NULL;    
   
    raiz->noDir->noEsq = raiz->noDir->noDir = NULL;    
     
	printf("Percurso em Pre ordem: \n");
    preOrdem(raiz);
    
    printf("\nPercurso em Pos ordem: \n");
    posOrdem(raiz);
    
    printf("\nPercurso em In-ordem: \n");
    inOrdem(raiz);
    
    printf("\nGrau da raiz: %d", grauDeUmNo(raiz));
    printf("\nTotal nós: %d", totalNos(raiz));
    
    if (buscaEmbaixador("Engenharia de Software", raiz) == 0){
    	printf("\nCurso não cadastrado");
	}
}
