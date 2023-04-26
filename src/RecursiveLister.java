import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RecursiveLister {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }
        );
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Recursive Lister");
        JButton startButton = new JButton("Select Directory");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    listFiles(selectedFile);
                }
            }
        }
        );
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );
        JTextArea textArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JLabel titleLabel = new JLabel("Recursive Lister");
        frame.add(startButton, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(quitButton, BorderLayout.SOUTH);
        frame.add(titleLabel, BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}

