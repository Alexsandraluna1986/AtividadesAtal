package br.com.TarefasAtal;

public class Main {

    public static void main(String[] args) {
        System.out.println("Implementação usando a classe Binary (baseada em matrizes):");

        Binary binary = new Binary(15);
        binary.insert(10);
        binary.insert(5);
        binary.insert(15);
        binary.insert(3);
        binary.insert(7);
        binary.insert(12);
        binary.insert(18);

        System.out.println("\nPercurso em largura:");
        binary.breadthFirstTraversal();
    }
}
