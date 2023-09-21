package lotofacil;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        double saldo = 0;
        String jogo = "s";
        Random aleatorio = new Random();
        Scanner scanner = new Scanner(System.in);


        int opcao = -1;


        do {

            System.out.println("* * * * * * * * * * * * * * * * * * *");
            System.out.println("*          MENU LOTOFÁCIL           *" + "        R$" + saldo);
            System.out.println("*          --------------           *");
            System.out.println("*    1)  Apostar de 0 a 100         *");
            System.out.println("*    2)  Apostar de A à Z           *");
            System.out.println("*    3)  Apostar em par ou ímpar    *");
            System.out.println("*    ---------------------------    *");
            System.out.println("*    4)  Digite 0 para sair         *");
            System.out.println("* * * * * * * * * * * * * * * * * * *");
            System.out.print("Digite a opção: ");

            opcao = scanner.nextInt();




            switch (opcao){

                case 1:
                    int numero;


                    do {
                        System.out.println("Aposta de 0 a 100:");


                        int numAleatorio = aleatorio.nextInt(100) + 1 ;
                        //System.out.println("O numero eh: " + numAleatorio);


                        System.out.println("Digite o numero:");
                        numero = scanner.nextInt();



                        if (numero > 100 || numero < 0) {

                            System.out.println("Aposta inválida! (Apenas numeros de 0 a 100)");
                            System.out.println("Deseja continuar nesse Jogo? (S/N)");
                            scanner.nextLine();
                            jogo = scanner.nextLine();
                        } else if (numero == numAleatorio) {

                            System.out.println("Parabens você ganhou R$ 1.000,00");
                            saldo += 1000;
                            System.out.println("O numero aleatorio é " + numAleatorio);
                            System.out.println("Continuar jogando? (S/N)");
                            scanner.nextLine();
                            jogo = scanner.nextLine();
                        } else {
                            System.out.println("Que pena! O número sorteado foi: " + numAleatorio);
                            System.out.println("Continuar jogando? (S/N)");
                            scanner.nextLine();
                            jogo = scanner.nextLine();

                        }
                    }while(!jogo.equalsIgnoreCase("n"));
                    System.out.println("*------* FIM JOGO 1 *------*");
                    break;
                case 2:

                    do {
                        try {
                            System.out.println("Aposta de A à Z: ");
                            int letra = aleatorio.nextInt(90 - 65 + 1) + 65;
                            char letraSorteada = (char) Character.toUpperCase(letra);
                            //System.out.println(letraSorteada);


                            int entradaLetra = System.in.read();
                            char apostaLetra = (char) Character.toUpperCase(entradaLetra);



                            if (Character.isLetter(apostaLetra) && apostaLetra >= 'A' && apostaLetra <= 'Z') {

                                if (apostaLetra == letraSorteada) {
                                    System.out.println("Você ganhou R$ 500,00 reais.");
                                    saldo += 500;
                                    System.out.println("Continuar jogando? (S/N)");
                                    jogo = scanner.next();
                                } else {

                                    System.out.println("Que pena! A letra sorteada foi: " + letraSorteada);
                                    System.out.println("Continuar jogando? (S/N)");
                                    jogo = scanner.next();
                                }
                            } else {
                                System.out.println("Aposta inválida! (Apenas apostas de A a Z)");
                                System.out.println("Deseja continuar nesse Jogo? (S/N)");
                                jogo = scanner.next();
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }while (!jogo.equalsIgnoreCase("n"));
                    System.out.println("*------* FIM JOGO 2 *------*");
                    break;
                case 3:

                    int numeroEntrada;

                    System.out.println("Apostar em par ou ímpar");




                    do {
                        System.out.println("Digite o numero:");
                        numeroEntrada = scanner.nextInt();

                        if(numeroEntrada % 2 == 0){

                            System.out.println("Você ganhou R$ 100,00");
                            saldo += 100;
                            System.out.println("Continuar jogando? (S/N)");
                            scanner.nextLine();
                            jogo = scanner.nextLine();
                        }else{

                            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                            System.out.println("Continuar jogando? (S/N)");
                            scanner.nextLine();
                            jogo = scanner.nextLine();
                        }
                    } while (!jogo.equalsIgnoreCase("n"));
                    System.out.println("*------* FIM JOGO 3 *------*");
                    break;
                case 0:
                    System.out.println("SAIR");
                default:
                    System.out.println("FIM");
                    break;

            }


        }while (opcao != 0);


    }

}