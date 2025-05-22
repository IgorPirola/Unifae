from datetime import datetime
import time
import sys
import os

users = {"Igor":"1234", "Giovana":"12345"}

def iniciarSessao():
    os.system('cls')
    print("====================================\n")
    print("1. Criar usuario \n2. Fazer login \n3. Voltar")
    print("\n====================================\n")
    opcao = '0'
    while True:
        opcao = input("Escolha uma opção: ")
        if(opcao == '1' or opcao == '2' or opcao == '3'):
            os.system('cls')
            break
        else:
            print("Opção invalida!")

    match opcao:
        case '1':
            user = input("Digite o usuario: ")
            passw = input("Digite a senha: ")
            users[user] = passw
            iniciarSessao()
        case '2':
            while True:
                print("Digite 0 para voltar")
                user = input("Digite o usuario: ")
                if user == '0':
                    iniciarSessao()
                passw = input("Digite a senha: ")
                if passw == users.get(user, ""):
                    print("Entrou com sucesso! ")
                    break
                else:
                    print("Usuario ou senhas invalidas!")

        case '3':
            tela()

def tela():
    os.system('cls')
    print("====================================\n")
    print("I-SO v1.0")
    print("Data:", definirData())
    print("\n====================================")
    print("\n1. Iniciar Sessão \n2. Reiniciar \n3. Desligar \n------------------------------------")
    opcao = '0'
    while True:
        opcao = input("Escolha uma opção: ")
        if(opcao == '1' or opcao == '2' or opcao == '3'):
            break
        else:
            print("Opção invalida!")
    
    match opcao:
        case '1':
            iniciarSessao()
        case '2':
            print("Reiniciando.")
            time.sleep(2)
            print("Reiniciando..")
            time.sleep(2)
            print("Reiniciando...")
            tela()
        case '3':
            sys.exit(0)

def definirData():
    data_atual = datetime.now()
    return data_atual.strftime('%d/%m/%Y hora: %H:%M')

tela()