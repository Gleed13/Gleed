import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Work extends JFrame{
    private JButton n0 = new JButton("0");
    private JButton n1 = new JButton("1");
    private JButton n2 = new JButton("2");
    private JButton n3 = new JButton("3");
    private JButton n4 = new JButton("4");
    private JButton n5 = new JButton("5");
    private JButton n6 = new JButton("6");
    private JButton n7 = new JButton("7");
    private JButton n8 = new JButton("8");
    private JButton n9 = new JButton("9");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("÷");
    private JButton equals = new JButton("=");
    private JButton koma = new JButton(",");
    private JButton backspace = new JButton("<");
    private JButton clean = new JButton("C");
    private JButton plusMinus = new JButton("±");
    private JButton percent = new JButton("%");
    private JLabel label = new JLabel("0");
    private boolean isKomaHere = false;
    private boolean isMinusHere = false;
    private boolean plusing = false;
    private boolean minusing = false;
    private boolean multiplying = false;
    private boolean dividing = false;
    private boolean action = false;
    private double var = 0;
    private double NaN = var/0;
    private double Infinity = (var + 1)/0;

    public Work() {
        super("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1,1,199, 247);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ActionListener AL = new ButtonEventListener();

        label.setHorizontalAlignment(SwingConstants.RIGHT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.5;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        add(label, c);

        c.gridwidth = 1;
        c.ipady = 10;

        c.gridy = 1;

        c.gridx = 0;
        add(backspace, c);
        backspace.addActionListener(AL);

        c.gridx = 1;
        add(clean, c);
        clean.addActionListener(AL);

        c.gridx = 2;
        add(plusMinus, c);
        plusMinus.addActionListener(AL);

        c.gridx = 3;
        add(percent, c);
        percent.addActionListener(AL);

        c.gridy = 2;

        c.gridx = 0;
        add(n7, c);
        n7.addActionListener(AL);

        c.gridx = 1;
        add(n8, c);
        n8.addActionListener(AL);

        c.gridx = 2;
        add(n9, c);
        n9.addActionListener(AL);

        c.gridx = 3;
        add(plus, c);
        plus.addActionListener(AL);

        c.gridy = 3;

        c.gridx = 0;
        add(n4, c);
        n4.addActionListener(AL);

        c.gridx = 1;
        add(n5, c);
        n5.addActionListener(AL);

        c.gridx = 2;
        add(n6, c);
        n6.addActionListener(AL);

        c.gridx = 3;
        add(minus, c);
        minus.addActionListener(AL);

        c.gridy = 4;

        c.gridx = 0;
        add(n1, c);
        n1.addActionListener(AL);

        c.gridx = 1;
        add(n2, c);
        n2.addActionListener(AL);

        c.gridx = 2;
        add(n3, c);
        n3.addActionListener(AL);

        c.gridx = 3;
        add(multiply, c);
        multiply.addActionListener(AL);

        c.gridy = 5;

        c.gridx = 0;
        add(n0, c);
        n0.addActionListener(AL);

        c.gridx = 1;
        add(koma, c);
        koma.addActionListener(AL);

        c.gridx = 2;
        add(equals, c);
        equals.addActionListener(AL);

        c.gridx = 3;
        add(divide, c);
        divide.addActionListener(AL);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String bText = e.getActionCommand();
            String tmp = label.getText();

            if (bText.equals("C")) {
                action = false;
                isKomaHere = false;
                isMinusHere = false;
                plusing = false;
                minusing = false;
                multiplying = false;
                dividing = false;
                label.setText("0");
                var = 0;
            }
            else if (!tmp.equals("ERROR")) {
                if (bText.equals("+") || bText.equals("-") || bText.equals("*") || bText.equals("÷") || bText.equals("=")) {
                    if (plusing) {
                        plusing = false;
                        tmp = (var + Double.valueOf(tmp) + "");
                        label.setText(tmp);
                    }
                    else if (minusing) {
                        minusing = false;
                        tmp = (var - Double.valueOf(tmp) + "");
                        label.setText(tmp);
                    }
                    else if (multiplying) {
                        multiplying = false;
                        tmp = (var * Double.valueOf(tmp) + "");
                        label.setText(tmp);
                    }
                    else if (dividing) {
                        dividing = false;
                        tmp = (var / Double.valueOf(tmp) + "");
                        label.setText(tmp);
                    }

                    if (bText.equals("+")) {
                        plusing = true;
                        minusing = false;
                        multiplying = false;
                        dividing = false;
                        var = Double.valueOf(tmp);
                    }
                    else if (bText.equals("-")) {
                        minusing = true;
                        plusing = false;
                        multiplying = false;
                        dividing = false;
                        var = Double.valueOf(tmp);
                    }
                    else if (bText.equals("*")) {
                        multiplying = true;
                        plusing = false;
                        minusing = false;
                        dividing = false;
                        var = Double.valueOf(tmp);
                    }
                    else if (bText.equals("÷")) {
                        dividing = true;
                        plusing = false;
                        minusing = false;
                        multiplying = false;
                        var = Double.valueOf(tmp);
                    }
                    action = true;
                }
                else if(bText.equals("%")) {
                    tmp = (var / 100 * Double.valueOf(tmp) + "");
                    label.setText(tmp);
                }
                else if (bText.equals("<")) {
                    if (action) {
                        return;
                    }
                    else {
                        if (tmp.substring(tmp.length() - 1).equals(".")) {
                            isKomaHere = false;
                        }
                        tmp = tmp.substring(0, tmp.length() - 1);
                        if (tmp.equals("-") || tmp.equals("")) {
                            isMinusHere = false;
                            label.setText("0");
                        } else {
                            label.setText(tmp);
                        }
                    }
                }
                else if (bText.equals("±")) {
                    if (!action) {
                        if (!tmp.equals("0")) {
                            if (!isMinusHere) {
                                isMinusHere = true;
                                tmp = "-" + tmp;
                                label.setText(tmp);
                            } else {
                                isMinusHere = false;
                                tmp = tmp.substring(1);
                                label.setText(tmp);
                            }
                        }
                    }
                }
                else if (bText.equals(",")) {
                    if (!action) {
                        if (!isKomaHere) {
                            isKomaHere = true;
                            tmp += ".";
                            label.setText(tmp);
                        }
                    }
                    else {
                        action = false;
                        isKomaHere = true;
                        isMinusHere = false;
                        label.setText("0.");
                    }
                }
                else {
                    if (!action) {
                        if (tmp.equals("0")) {
                            label.setText(bText);
                        } else {
                            tmp += bText;
                            label.setText(tmp);
                        }
                    }
                    else {
                        action = false;
                        isKomaHere = false;
                        isMinusHere = false;
                        label.setText(bText);
                    }
                }
                if (tmp.equals(NaN + "") || tmp.equals(Infinity + "")) {
                    label.setText("ERROR");
                }
                else if (tmp.length() > 1) {
                    if (tmp.substring(tmp.length() - 2).equals(".0")) {
                        label.setText(tmp.substring(0, tmp.length() - 2));
                    }
                }
            }
        }
    }
}












