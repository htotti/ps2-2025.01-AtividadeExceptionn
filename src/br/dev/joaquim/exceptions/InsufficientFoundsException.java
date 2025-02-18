package br.dev.joaquim.exceptions;

/**
 * Exceção lançada quando uma conta bancária não possui fundos suficientes
 * para realizar uma operação de saque.
 */
public class InsufficientFoundsException extends Exception {
    
    /**
     * Construtor que cria uma exceção com uma mensagem específica.
     * 
     * @param message Mensagem detalhando a causa da exceção.
     */
    public InsufficientFoundsException(String message) {
        super(message);
    }
}

