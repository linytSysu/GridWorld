/**
 * The Java Calculator
 * @author Linyiting
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    // The first number
    private JTextField txt1 = new JTextField();
    // The second number
    private JTextField txt2 = new JTextField();
    // The button which show the operator
    private JButton operator = new JButton();
    // The button which show the result
    private JButton result = new JButton();

    private JButton equal = new JButton("=");
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private JButton ok = new JButton("OK");
    
    // The calculator function
    private void calFunction(String s1, String s2, String s3) {
        try {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int num3 = 0;
            if (s3.equals("+")) {
                num3 = num1+num2;
            } else if (s3.equals("-")) {
                num3 = num1-num2;
            } else if (s3.equals("*")) {
                num3 = num1*num2;
            } else if (s3.equals("/")) {
                num3 = num1/num2;
            }
            result.setText(String.valueOf(num3));
        } catch(Exception e) {
            return;
        }
    }

    /**
     * The ActionListener which for the buttons "add", "sub", "mul", "div"
     * When these buttons clicked, the operator button will show the operator
     */
    private ActionListener operEvent = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String op = ((JButton)e.getSource()).getText();
            operator.setText(op);
        }
    };

    private ActionListener okEvent = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String s1 = txt1.getText();
            String s2 = txt2.getText();
            String s3 = operator.getText();
            calFunction(s1, s2, s3);
        }
    };
    // The constcutor function
    public Calculator() {
        // GridLayout paraments
        final int rows = 2, cols = 5;
        final int width = 5, height = 5;
        setLayout(new GridLayout(rows, cols, width, height));
        // Set the JTextField's content to be center
        txt1.setHorizontalAlignment(JTextField.CENTER);
        txt2.setHorizontalAlignment(JTextField.CENTER);
        // Set the buttons to be disable
        operator.setEnabled(false);
        equal.setEnabled(false);
        result.setEnabled(false);
        // Add ActionListener for the buttons
        add.addActionListener(operEvent);
        sub.addActionListener(operEvent);
        mul.addActionListener(operEvent);
        div.addActionListener(operEvent);
        ok.addActionListener(okEvent);
        // Add the JTextField and JButton to the JFrame
        add(txt1);
        add(operator);
        add(txt2);
        add(equal);
        add(result);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(ok);
    }
    // Main Function, call the static run function of UIFramework
    public static void main(String[] args) {
        final int width = 370, height = 165;
        UIFramework.run(new Calculator(), width, height);
    }
}
