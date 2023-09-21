package lotofacil;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LotofacilGUI extends JFrame {
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    public LotofacilGUI() {
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        // Adiciona os ActionListeners aos botões
        jButtonAposta1.addActionListener(new Aposta1ActionListener());
        jButtonAposta2.addActionListener(new Aposta2ActionListener());
        jButtonAposta3.addActionListener(new Aposta3ActionListener());
    }

    public static void main(String[] args) {
        new LotofacilGUI();
    }

    class Aposta1ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
            try {
                int numero = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null, "Você apostou de 0 a 100: " + numero);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um número válido.");
            }
        }
    }

    class Aposta2ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Digite um valor de A a Z:");
            // Adicione sua lógica para lidar com a aposta de A a Z aqui
            JOptionPane.showMessageDialog(null, "Você apostou de A a Z: " + input);
        }
    }

    class Aposta3ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Digite um número par ou ímpar:");
            // Adicione sua lógica para lidar com a aposta par ou ímpar aqui
            JOptionPane.showMessageDialog(null, "Você apostou par ou ímpar: " + input);
        }
    }
}
