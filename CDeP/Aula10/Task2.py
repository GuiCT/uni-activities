from multiprocessing import Process, current_process
import time

def dorme(so_um_pouco):
    nome = current_process().name
    print(f"Iniciada a soneca de {so_um_pouco} s em {nome}")
    time.sleep(so_um_pouco)
    print(f"Finaliza a soneca de {so_um_pouco} s em {nome}")


def principal():
    inicio = time.time()

    p1 = Process(name="p1", target=dorme, args=[10, ])
    p2 = Process(name="p2", target=dorme, args=[5, ])
    p3 = Process(name="p3", target=dorme, args=[2, ])

    p1.start()
    p1.join()
    p2.start()
    p2.join()
    p3.start()
    p3.join()

    fim = time.time()

    print(f"Tempo transcorrido: {fim - inicio}")


if __name__ == "__main__":
    principal()
