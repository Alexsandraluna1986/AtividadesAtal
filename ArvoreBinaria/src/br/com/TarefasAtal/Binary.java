package br.com.TarefasAtal;
import java.util.LinkedList;
import java.util.Queue;

public class Binary {

    private int[] tree;          // Array para armazenar a árvore
    private final int CAPACITY;  // Capacidade máxima do array
    private int size;            // Tamanho atual da árvore

    public Binary(int capacity) {
        this.CAPACITY = capacity;
        this.tree = new int[CAPACITY];
        this.size = 0;

        // Inicializa todos os elementos como -1 (indicando ausência de valor)
        for (int i = 0; i < CAPACITY; i++) {
            tree[i] = -1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int value) {
        if (size >= CAPACITY) {
            System.out.println("A árvore está cheia!");
            return;
        }

        int index = 0;
        while (index < CAPACITY) {
            if (tree[index] == -1) {
                tree[index] = value;
                size++;
                if (index == 0) {
                    System.out.println("Inserindo " + value + " como raiz");
                } else {
                    int parentIndex = (index - 1) / 2;
                    if (value < tree[parentIndex]) {
                        System.out.println("Inserindo " + value + " à esquerda de " + tree[parentIndex]);
                    } else {
                        System.out.println("Inserindo " + value + " à direita de " + tree[parentIndex]);
                    }
                }
                return;
            } else if (value < tree[index]) {
                index = 2 * index + 1; // Vai para o filho esquerdo
            } else {
                index = 2 * index + 2; // Vai para o filho direito
            }
        }
    }

    public void breadthFirstTraversal() {
        System.out.println("Percorrendo em largura:");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Começa pela raiz

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index < CAPACITY && tree[index] != -1) {
                System.out.print(tree[index] + " ");
                queue.add(2 * index + 1); // Adiciona filho esquerdo
                queue.add(2 * index + 2); // Adiciona filho direito
            }
        }
        System.out.println();
    }
}
