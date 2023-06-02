from multiprocessing import Process
import os, time

def mostra_idProcess():
    time.sleep(5)
    print(f"Nome em mostra_idProcess: {__name__}")
    print(f"ID do processo principal: {os.getppid()}")
    print(f"ID do processo criado: {os.getpid()}")


def principal():
    print(f"Nome em principal: {__name__}")
    p = Process(target=mostra_idProcess)
    p.start()
    p.join()



if __name__ == "__main__":
    principal()
    print(f"Finalizado: {__name__}")