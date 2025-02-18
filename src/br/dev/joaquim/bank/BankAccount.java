package br.dev.joaquim.bank;

/**
 * Representa uma conta bancária com número da conta, saldo e nome do titular.
 * <p>
 * Esta classe permite operações básicas de depósito e saque, além de fornecer
 * informações sobre a conta, como número, saldo e nome do titular.
 * </p>
 */
public class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    /**
     * Construtor padrão que inicializa uma conta sem valores definidos.
     */
    public BankAccount() {
    }

    /**
     * Construtor que inicializa uma conta com número da conta, saldo e nome do titular.
     *
     * @param accountNumber      Número da conta.
     * @param balance            Saldo inicial da conta.
     * @param accountHolderName  Nome do titular da conta.
     */
    public BankAccount(int accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    /**
     * Retorna o número da conta.
     *
     * @return Número da conta.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return Saldo da conta.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Retorna o nome do titular da conta.
     *
     * @return Nome do titular da conta.
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Realiza um depósito na conta.
     * <p>
     * O valor depositado deve ser positivo. Caso contrário, uma exceção será lançada.
     * </p>
     *
     * @param value Valor a ser depositado.
     * @throws IllegalArgumentException Se o valor for negativo.
     */
    public void deposit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }

        this.balance += value;
    }

    /**
     * Realiza um saque na conta.
     * <p>
     * O valor sacado deve ser positivo e não pode exceder o saldo disponível.
     * Caso o valor seja negativo ou superior ao saldo, uma mensagem de erro será exibida.
     * </p>
     *
     * @param value Valor a ser sacado.
     * @throws IllegalArgumentException Se o valor for negativo.
     */
    public void withdraw(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }

        if (value > this.balance) {
            // Não deveria ser assim, não pode ter print na classe
            System.out.println("O valor R$ " + value + " é superior ao saldo [R$ " + this.balance + "]");
        }

        this.balance -= value;
    }

    /**
     * Retorna uma representação textual da conta.
     * <p>
     * O formato retornado é: "Conta [número] de [titular] têm R$ [saldo] de saldo".
     * </p>
     *
     * @return String formatada com os dados da conta.
     */
    @Override
    public String toString() {
        return "Conta " + accountNumber + " de " + accountHolderName + " têm R$ " + balance + " de saldo";
    }
}