package br.dev.joaquim;

/**
 * Classe principal que inicializa a aplicação bancária.
 * <p>
 * Esta classe contém o método `main`, que é o ponto de entrada do programa.
 * Ela cria uma instância da interface do usuário (`UserInterface`) e inicia a execução.
 * </p>
 */
public class App {
    /**
     * Método principal que inicializa a interface do usuário e inicia a execução do programa.
     * 
     * @param args Argumentos da linha de comando (não são utilizados neste programa).
     */
    public static void main(String[] args) {
        UserInterface main = new UserInterface();
        main.start();
    }
}
