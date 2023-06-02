# Implementar um programa
# Funções
#   Mostre o número de processadores/núcleos
#   Calcule e mostre o quadrado de um número da fila
#   Crie uma fila com 10 números inteiros
#   Crie uma lista de processos para executar a função de cálculo do quadrado
#     Mostrar id do processo corrente
#   Chamar as funções na parte principal

from multiprocessing import Process, Queue, current_process
import os

def mostraProcessadores():
    print(f"Processadores: {os.cpu_count()}")

def calculaQuadrado(fila):
    value = fila.get()
    nome = current_process().name
    print(f"{nome} recebeu: {value} pid: {os.getpid()}")
    print(f"Quadrado: {value**2}")

def principal():
    mostraProcessadores()
    fila = Queue()
    fila.put(1)
    fila.put(2)
    fila.put(3)
    fila.put(4)
    fila.put(5)
    fila.put(6)
    fila.put(7)
    fila.put(8)
    fila.put(9)
    fila.put(10)

    processos = []
    for i in range(10):
        processos.append(Process(target=calculaQuadrado, args=(fila,)))
    for p in processos:
        p.start()
    for p in processos:
        p.join()

if __name__ == "__main__":
    principal()