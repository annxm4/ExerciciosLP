import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListaDeTarefasGUI {
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private DefaultListModel<Tarefa> tarefasListModel = new DefaultListModel<>();
    private JList<Tarefa> tarefasList = new JList<>(tarefasListModel);
    private JTextField nomeTarefaField = new JTextField(20);

    public ListaDeTarefasGUI() {
        JFrame frame = new JFrame("Aplicativo de Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome da Tarefa:"));
        inputPanel.add(nomeTarefaField);
        inputPanel.add(new JButton(new AbstractAction("Adicionar Tarefa") {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        }));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Remover Tarefa") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerTarefa();
            }
        }));
        buttonPanel.add(new JButton(new AbstractAction("Gerar JSON") {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarJson();
            }
        }));
        buttonPanel.add(new JButton(new AbstractAction("Ler JSON") {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerJson();
            }
        }));

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(tarefasList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void adicionarTarefa() {
        String nomeTarefa = nomeTarefaField.getText();
        Tarefa tarefa = new Tarefa();
        tarefa.setCod_tarefa(tarefas.size());
        tarefa.setNome_tarefa(nomeTarefa);
        tarefas.add(tarefa);
        tarefasListModel.addElement(tarefa);
        nomeTarefaField.setText("");
    }

    private void removerTarefa() {
        int selectedIndex = tarefasList.getSelectedIndex();
        if (selectedIndex >= 0) {
            tarefas.remove(selectedIndex);
            tarefasListModel.remove(selectedIndex);
        }
    }

    private void gerarJson() {
        Gson gson = new Gson();
        String json = gson.toJson(tarefas);
        try {
            FileWriter writer = new FileWriter("tarefas.json");
            writer.write(json);
            writer.close();
            JOptionPane.showMessageDialog(null, "JSON gerado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar JSON.");
        }
    }

    private void lerJson() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("tarefas.json"));
            Type listType = new TypeToken<ArrayList<Tarefa>>() {}.getType();
            tarefas = gson.fromJson(br, listType);
            tarefasListModel.clear();
            for (Tarefa tarefa : tarefas) {
                tarefasListModel.addElement(tarefa);
            }
            JOptionPane.showMessageDialog(null, "JSON lido com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao ler JSON.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaDeTarefasGUI());
    }
}
