import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class lotofacilInterface extends JFrame {
    private JFrame jFrameTela = new JFrame();
    private JPanel tela = new JPanel();
    private JButton numeroButton = new JButton("Aposta Número");
    private JButton letraButton = new JButton("Aposta Letra");
    private JButton parImparButton = new JButton("Aposta Par / Impar");
    private JLabel menu = new JLabel("Menu LOTOFÁCIL");
    private JOptionPane janelaOp = new JOptionPane();

    public lotofacilInterface() throws IOException {
        this.setTitle("Apostas");
        this.setSize(300, 300);
        tela.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        tela.setBackground(new Color(255, 255, 255));
        tela.add(menu);
        tela.add(numeroButton);
        tela.add(letraButton);
        tela.add(parImparButton);
        this.getContentPane().add(tela);
        this.setLocationRelativeTo(null); // centralizar janela
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        numeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaOp.setBackground(new Color(255, 255, 255));
                String resultado = janelaOp.showInputDialog(null, "Digite um número de 0 a 100: ");
                tela.add(janelaOp);
                int valor = Integer.parseInt(resultado);
                String retorno = apostaNum(valor);
                janelaOp.showMessageDialog(null, retorno);
            }
        });
        letraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaOp.setBackground(new Color(255, 255, 255));
                String resultado = janelaOp.showInputDialog(null, "Digite uma letra de A a Z: ");
                tela.add(janelaOp);
                String retorno = apostaLetra(resultado.charAt(0));
                janelaOp.showMessageDialog(null, retorno);
            }
        });
        parImparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaOp.setBackground(new Color(255, 255, 255));
                String resultado = janelaOp.showInputDialog(null, "Digite um número par ou ímpar: ");
                tela.add(janelaOp);
                int valor = Integer.parseInt(resultado);
                String retorno = apostaParImpar(valor);
                janelaOp.showMessageDialog(null, retorno);
            }
        });
    }

    public static String apostaNum(int valor) {
        Random rdm = new Random();
        String resultado = "";
        int sorteio = rdm.nextInt(100);
        System.out.println(sorteio);
        if (valor >= 0 && valor <= 100) {
            if (valor == sorteio) resultado = "Você ganhou R$ 1.000,00 reais.";
            else resultado = "Que pena! O número sorteado foi: " + sorteio;
        } else {
            resultado = "Valor inválido!";
        }
        return resultado;
    }

    public static String apostaLetra(char letra) {
        char letraPremiada = 'L';
        String resultado = "";
        if (Character.isLetter(letra)) {
            if (Character.toUpperCase(letra) == letraPremiada) resultado = "Você ganhou R$ 500,00 reais.";
            else resultado = "Que pena! A letra sorteada foi: " + letraPremiada;
        } else {
            resultado = "Valor inválido!";
        }
        return resultado;
    }

    public static String apostaParImpar(int valor) {
        String resultado = "";
        Random rdm = new Random();
        int sorteio = rdm.nextInt(2);
        if (valor % 2 == sorteio) {
            resultado = "Você ganhou R$ 1.000,00 reais.";
        } else {
            if (sorteio == 1)
                resultado = "Que pena! O número digitado é par e a premiação foi para números ímpares.";
            else resultado = "Que pena! O número digitado é impar e a premiação foi para números pares.";
        }
        return resultado;
    }

    public static void main(String[] args) throws IOException {
        new lotofacilInterface();
    }
}