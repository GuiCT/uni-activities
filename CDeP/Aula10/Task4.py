from multiprocessing import Process, Queue, current_process
import os

def recebeItemFila(fila):
    nome = current_process().name
    print(f"{nome} recebeu: {fila.get()} pid: {os.getpid()}")

def principal():
    fila = Queue()
    fila.put("Realize a primeira tarefa")
    fila.put("Traduza a segunda linha")
    fila.put("Calcule o terceiro valor")
    fila.put(1)
    fila.put(2)
    fila.put(3)

    # Lista de processos
    processos = []
    for i in range(6):
        processos.append(Process(target=recebeItemFila, args=(fila,)))
    for p in processos:
        p.start()
    for p in processos:
        p.join()

        
if __name__ == "__main__":
    principal()
