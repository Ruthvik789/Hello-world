import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator extends JFrame implements ActionListener {
    JTextField textField;
    String operator;
    double num1, num2;

    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton;

    public GUICalculator() {
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        textField = new JTextField();
        textField.setBounds(50, 25, 250, 50);
        textField.setEditable(false);
        add(textField);
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        dotButton = new JButton(".");

        JButton[] ops = {addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton};
        for (JButton b : ops) b.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 250, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(numberButtons[0]);
        panel.add(dotButton);
        panel.add(eqButton);
        panel.add(addButton);

        add(panel);
        clrButton.setBounds(50, 420, 250, 40);
        add(clrButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == dotButton) textField.setText(textField.getText() + ".");

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+": textField.setText(String.valueOf(num1 + num2)); break;
                case "-": textField.setText(String.valueOf(num1 - num2)); break;
                case "*": textField.setText(String.valueOf(num1 * num2)); break;
                case "/": 
                    if(num2 != 0) textField.setText(String.valueOf(num1 / num2));
                    else textField.setText("Error: /0");
                    break;
            }
        }
        if (e.getSource() == clrButton) textField.setText("");
    }

    public static void main(String[] args) {
        new GUICalculator();
    }
}