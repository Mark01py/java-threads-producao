import java.awt.Container;
import javax.swing.*;

public class Calculadora extends JFrame {
    private JTextField txtDisplay;
    private JButton[] btnNumeros = new JButton[10];
    private JButton btnSoma, btnSub, btnMul, btnDiv, btnIgual, btnClear;
    private String operador = "";
    private double num1 = 0;

    private Container ctn;

    public Calculadora() {
        setSize(300, 400);
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ctn = getContentPane();
        ctn.setLayout(null);

        txtDisplay = new JTextField();
        txtDisplay.setBounds(20, 20, 240, 40);
        txtDisplay.setEditable(false);
        ctn.add(txtDisplay);

        for (int i = 0; i <= 9; i++) {
            btnNumeros[i] = new JButton(String.valueOf(i));
            int finalI = i;
            btnNumeros[i].addActionListener(e -> {
                txtDisplay.setText(txtDisplay.getText() + finalI);
            });
        }

        btnSoma = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");
        btnIgual = new JButton("=");
        btnClear = new JButton("C");

        btnSoma.addActionListener(e -> setOperacao("+"));
        btnSub.addActionListener(e -> setOperacao("-"));
        btnMul.addActionListener(e -> setOperacao("*"));
        btnDiv.addActionListener(e -> setOperacao("/"));
        btnClear.addActionListener(e -> txtDisplay.setText(""));

        btnIgual.addActionListener(e -> {
            try {
                double num2 = Double.parseDouble(txtDisplay.getText());
                double resultado = 0;
                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(null, "Divisão por zero!");
                            return;
                        }
                        resultado = num1 / num2; break;
                }
                txtDisplay.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erro de entrada.");
            }
        });

        int x = 20, y = 80;
        for (int i = 1; i <= 9; i++) {
            btnNumeros[i].setBounds(x, y, 60, 40);
            ctn.add(btnNumeros[i]);
            x += 70;
            if (i % 3 == 0) {
                x = 20;
                y += 50;
            }
        }

        btnNumeros[0].setBounds(20, y, 60, 40);
        ctn.add(btnNumeros[0]);

        btnSoma.setBounds(230, 80, 50, 40);
        btnSub.setBounds(230, 130, 50, 40);
        btnMul.setBounds(230, 180, 50, 40);
        btnDiv.setBounds(230, 230, 50, 40);
        btnIgual.setBounds(90, y, 60, 40);
        btnClear.setBounds(160, y, 60, 40);

        ctn.add(btnSoma);
        ctn.add(btnSub);
        ctn.add(btnMul);
        ctn.add(btnDiv);
        ctn.add(btnIgual);
        ctn.add(btnClear);

        setVisible(true);
    }

    private void setOperacao(String op) {
        try {
            num1 = Double.parseDouble(txtDisplay.getText());
            operador = op;
            txtDisplay.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um número primeiro.");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
