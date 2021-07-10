package app;

import java.util.Scanner;

import classes.MotorJogo;
import classes.Personagem;

public class Jogo {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        MotorJogo motor = new MotorJogoDuelo();

        System.out.println("=================");
        System.out.println("DUELO DE TALENTOS");
        System.out.println("=================");

        System.out.println("\nEscolha seu personagem: ");
        motor.obterPersonagens().forEach(personagem -> {
            System.out.println(personagem);
        });

        System.out.print("ID do personagem que quer jogar: ");
        int idPersonagem = sc.nextInt();
        sc.nextLine();

        Personagem meuJogador = motor.obterPersonagem(idPersonagem);
        System.out.printf("\n\nVocê escolheu %s. \nDigite ENTER para continuar.", meuJogador.getNome());
        sc.nextLine();

        Personagem adversario = motor.escolherAdversario();
        System.out.printf("\n\nSeu adversário sera %s (%s).", adversario.getNome(), adversario.getTipo());

        Thread.sleep(1000);

        System.out.println("\n\nAs apresentações vão começar...");
        
        Thread.sleep(1500);

        int resultadoMeuJogador = meuJogador.apresentarHabilidade();
        System.out.printf("\nVocê se apresentou e obteve nota %d.\n", resultadoMeuJogador);

        System.out.println("\nAgora, seu adversário irá se apresentar...");
       
        Thread.sleep(1500);

        int resultadoAdversario = adversario.apresentarHabilidade();
        System.out.printf("\nSeu adversário se apresentou e obteve nota %d.\n", resultadoAdversario);

        System.out.println("\nCalculando resultados...");

        Thread.sleep(2000);

        if(resultadoMeuJogador > resultadoAdversario) {
            System.out.println("\nPARABÉNS!! VOCÊ VENCEU O DESAFIO DE TALENTOS!!!");
        } else if (resultadoAdversario > resultadoMeuJogador) {
            System.out.println("\nInfelizmente não foi dessa vez que você venceu. Tente novamente");
        } else {
            System.out.println("EMPATE!!");
        }

        sc.close();
    }
}