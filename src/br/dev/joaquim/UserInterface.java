package br.dev.joaquim;

import java.util.Random;
import java.util.Scanner;
import br.dev.joaquim.bank.BankAccount;

/**
 * Classe que representa a interface do usuário para interagir com o sistema bancário.
 * <p>
 * Esta classe permite a criação de contas bancárias e a realização de operações como
 * depósito, saque e consulta de saldo.
 * </p>
 */
public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private BankAccount account;

    /**
     * Exibe uma mensagem de boas-vindas e inicia o processo de criação de conta.
     */
    private void welcome() {
        System.out.println("Bem-vindo ao sistema bancário");
        System.out.print("Vamos criar sua conta, informe seu nome: ");
        String holderName = input.nextLine();
        int accountNumber = 1000 + (new Random()).nextInt(8999);
        System.out.println("Criamos uma conta com o número: " + accountNumber + ", com saldo igual a 0 (zero).");
        this.account = new BankAccount(accountNumber, 0, holderName);
    }

    /**
     * Exibe o menu de opções para o usuário.
     */
    private void showMenu() {
        System.out.println("\n\n-----------------------");
        System.out.println("Escolha uma das opções:");
        System.out.println("\t1. Verificar dados da conta.");
        System.out.println("\t2. Depositar.");
        System.out.println("\t3. Sacar.");
        System.out.println("\t4. Sair.");
        System.out.print("opção > ");
    }

    /**
     * Inicia a execução da interface do usuário.
     */
    public void start() {
        welcome();
        if (account == null)
            return;

        while (true) {
            showMenu();
            try {
                int choice = readOption();
                switch (choice) {
                    case 1:
                        System.out.println("\n" + this.account);
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Até a próxima.");
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                waitUser();
            } catch (NumberFormatException ex) {
                System.out.println("Valor informado não é um número");
            }
        }
    }

    /**
     * Realiza um depósito na conta do usuário.
     */
    private void deposit() {
        System.out.print("\nInforme o valor a ser depositado: ");
        double value = readValue();
        account.deposit(value);
        System.out.println("Depósito realizado com sucesso.");
    }

    /**
     * Realiza um saque na conta do usuário.
     */
    private void withdraw() {
        System.out.print("\nInforme o valor a ser sacado: ");
        double value = readValue();
        account.withdraw(value);
        System.out.println("Saque realizado com sucesso");
    }

    /**
     * Lê a opção escolhida pelo usuário no menu.
     * 
     * @return A opção escolhida como um número inteiro.
     */
    private int readOption() {
        String choiceString = input.nextLine();
        return Integer.parseInt(choiceString);
    }

    /**
     * Lê um valor numérico inserido pelo usuário.
     * 
     * @return O valor inserido como um número decimal.
     */
    private double readValue() {
        String line = input.nextLine();
        return Double.parseDouble(line);
    }

    /**
     * Aguarda o usuário pressionar ENTER para continuar.
     */
    private void waitUser() {
        System.out.println("pressione ENTER para continuar...");
        input.nextLine();
    }
}
