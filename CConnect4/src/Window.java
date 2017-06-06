import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private JPanel menu = new bg();
    private JPanel information = new bg();
    private JPanel option = new bg();
    private JPanel game = new bg2();

    private JLabel l = new JLabel("Connect 4");
    private JLabel ai = new JLabel("Player vs AI");
    private JLabel pl = new JLabel("Player vs Player");
    private JLabel instr = new JLabel("Instructions");
    private JLabel text1 = new JLabel("Четыре в ряд или Connect four - игра для двоих,");
    private JLabel text2 = new JLabel("в которой игроки ходят по очереди, роняя фишки");
    private JLabel text3 = new JLabel("в ячейки вертикальной доски. Цель игры —");
    private JLabel text4 = new JLabel("расположить раньше противника подряд по горизонтали,");
    private JLabel text5 = new JLabel("вертикали или диагонали четыре фишки своего цвета");
    private JLabel P1 = new JLabel("P1");
    private JLabel P2 = new JLabel("P2");
    private JLabel Ai = new JLabel("Ai");
    private JLabel won1 = new JLabel("wins!");
    private JLabel won2 = new JLabel("wins!");

    private JButton start = new JButton("Start PvP");
    private JButton info = new JButton("Instructions");
    private JButton options = new JButton("Options");
    private JButton vsPlayer = new JButton("vs Player");
    private JButton vsAi = new JButton("vs AI");
    private JButton easy = new JButton("Easy");
    private JButton normal = new JButton("Normal");
    private JButton hard = new JButton("Hard");
    private JButton back1 = new JButton("back");
    private JButton back2 = new JButton("back");
    private JButton back3 = new JButton("menu");
    private JButton restart = new JButton("restart");

    private Font f1 = new Font("Impact", Font.PLAIN, 72);
    private Font f = new Font("Impact", Font.PLAIN, 30);

//игровые поля
    private boolean vsAI = false;
    private int dif = 1;

    private int[][] array = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    private int mMovedX = 0;
    private int mMovedY = 0;

    private int O = 0;
    private int win = 0;

//конструктор
    public Window() {
        super("Connect 4");


    //layouts
        menu.setLayout(null);
        information.setLayout(null);
        option.setLayout(null);
        game.setLayout(null);


    //заглавные надписи
        l.setFont(f1);
        l.setBounds(247, 86, 500, 100);
        menu.add(l);

        ai.setFont(f1);
        ai.setBounds(229, 86, 500, 100);
//        option.add(ai);

        pl.setFont(f1);
        pl.setBounds(170, 86, 500, 100);
        option.add(pl);

        instr.setFont(f1);
        instr.setBounds(210, 36, 500, 100);
        information.add(instr);

        P1.setFont(f1);
        P1.setBounds(30, 190, 100, 60);
        game.add(P1);

        P2.setFont(f1);
        P2.setBounds(695, 190, 100, 60);
//        game.add(P2);

        Ai.setFont(f1);
        Ai.setBounds(702, 190, 100, 60);
//        game.add(Ai);

        won1.setFont(f);
        won1.setBounds(31, 235, 100, 60);
//        game.add(won1);

        won2.setFont(f);
        won2.setBounds(698, 235, 100, 60);
//        game.add(won2);


    //обычные надписи
        text1.setFont(f);
        text1.setBounds(88, 130, 800, 100);
        information.add(text1);

        text2.setFont(f);
        text2.setBounds(75, 200, 800, 100);
        information.add(text2);

        text3.setFont(f);
        text3.setBounds(108, 270, 800, 100);
        information.add(text3);

        text4.setFont(f);
        text4.setBounds(15, 340, 800, 100);
        information.add(text4);

        text5.setFont(f);
        text5.setBounds(37, 410, 800, 100);
        information.add(text5);


    //кнопки меню
        start.setFont(f);
        start.setBounds(296, 210, 201, 50);
        start.setBackground(Color.WHITE);
        menu.add(start);

        options.setFont(f);
        options.setBounds(296, 300, 201, 50);
        options.setBackground(Color.WHITE);
        menu.add(options);

        info.setFont(f);
        info.setBounds(296, 390, 201, 50);
        info.setBackground(Color.WHITE);
        menu.add(info);

    //кнопки опций
        vsPlayer.setFont(f);
        vsPlayer.setBounds(296, 210, 201, 50);
        vsPlayer.setBackground(Color.GRAY);
        option.add(vsPlayer);

        vsAi.setFont(f);
        vsAi.setBounds(296, 300, 201, 50);
        vsAi.setBackground(Color.WHITE);
        option.add(vsAi);

        easy.setFont(f);
        easy.setBounds(321, 360, 151, 40);
        easy.setBackground(Color.WHITE);
//        option.add(easy);

        normal.setFont(f);
        normal.setBounds(321, 410, 151, 40);
        normal.setBackground(Color.GRAY);
//        option.add(normal);

        hard.setFont(f);
        hard.setBounds(321, 460, 151, 40);
        hard.setBackground(Color.WHITE);
//        option.add(hard);

    //кнопки "назад" + "рестарт"
        back1.setFont(f);
        back1.setBounds(15, 520, 100, 40);
        back1.setBackground(Color.WHITE);
        option.add(back1);

        back2.setFont(f);
        back2.setBounds(15, 520, 100, 40);
        back2.setBackground(Color.WHITE);
        information.add(back2);

        back3.setFont(f);
        back3.setBounds(10, 525, 110, 40);
        back3.setBackground(Color.WHITE);
        game.add(back3);

        restart.setFont(f);
        restart.setBounds(300, 0, 200, 40);
        restart.setBackground(Color.WHITE);
        game.add(restart);
    }

//menu панелька
    class bg extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setBackground(Color.WHITE);

            Graphics2D g2 = (Graphics2D)g;

            g2.setPaint(Color.CYAN.darker());
            g2.setStroke(new BasicStroke(2.0f));

            int x = getWidth();
            int y = getHeight();
            for (int i = 0; i < 40; i++) {
                g2.drawLine(10+x*i/40, 0, 10+x*i/40, y);
            }
            for (int i = 0; i < 36; i++) {
                g2.drawLine(0, 8+x*i/40, x, 8+x*i/40);
            }
        }
    }

//game панелька
    class bg2 extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setBackground(Color.WHITE);

            Graphics2D g2 = (Graphics2D)g;

            g2.setPaint(Color.CYAN.darker());
            g2.setStroke(new BasicStroke(2.0f));

            int x = getWidth();
            int y = getHeight();
            for (int i = 0; i < 40; i++) {
                g2.drawLine(10+x*i/40, 0, 10+x*i/40, y);
            }
            for (int i = 0; i < 36; i++) {
                g2.drawLine(0, 8+x*i/40, x, 8+x*i/40);
            }

            g2.setPaint(Color.BLUE);
            g2.fillRect(130, 40, getWidth()-260, getHeight()-80);
            g2.setPaint(Color.BLUE.darker());
            g2.drawRect(128, 38, getWidth()-256, getHeight()-76);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    g2.setPaint(Color.BLUE.darker());
                    g2.fillOval(152 + Math.round((getWidth() - 300) * j / 7), 442 - Math.round((getHeight() - 120) * i / 6),
                            67, 67);
                    if (array[i][j]==0) {
                        g2.setPaint(Color.GRAY);
                        g2.fillOval(153 + Math.round((getWidth() - 300) * j / 7), 443 - Math.round((getHeight() - 120) * i / 6),
                                65, 65);
                        g2.setPaint(Color.GRAY.brighter());
                        g2.fillOval(154 + Math.round((getWidth() - 300) * j / 7), 444 - Math.round((getHeight() - 120) * i / 6),
                                63, 63);
                    }
                    else if (array[i][j]==1) {
                        drawO1(153 + Math.round((getWidth() - 300) * j / 7), 443 - Math.round((getHeight() - 120) * i / 6), g2);
                    }
                    else if (array[i][j]==2) {
                        drawO2(153 + Math.round((getWidth() - 300) * j / 7), 443 - Math.round((getHeight() - 120) * i / 6), g2);
                    }
                    if (mMovedX>150+70*j&&mMovedX<221+70*j&&mMovedY>60&&mMovedY<516&&array[5][j]==0) {
                        if (O==1) {
                            drawO1(153 + Math.round((getWidth() - 300) * j / 7), 443 - (getHeight() - 196), g2);
                        } else if (O==2&&!vsAI) {
                            drawO2(153 + Math.round((getWidth() - 300) * j / 7), 443 - (getHeight() - 196), g2);
                        }
                    }
                }
            }
            if (O==1) {
                drawO1(29, 283, g2);
            }
            if (O==2) {
                drawO2(698, 283, g2);
            }
        }
    }


//add-remove
    public void addMenuPanel() {
        this.add(menu);
    }
    public void removeMenuPanel() {
        this.remove(menu);
    }

    public void addOptionsPanel() {
        this.add(option);
    }
    public void removeOptionsPanel() {
        this.remove(option);
    }

    public void addInformationPanel() {
        this.add(information);
    }
    public void removeInformationPanel() {
        this.remove(information);
    }

    public void addGamePanel() {
        this.add(game);
    }
    public void removeGamePanel() {
        this.remove(game);
    }

    public void optionAddAI() {
        option.add(ai);
    }
    public void optionRemoveAI() {
        option.remove(ai);
    }
    public void optionAddPlayer() {
        option.add(pl);
    }
    public void optionRemovePlayer() {
        option.remove(pl);
    }

    public void optionAddEasy() {
        option.add(easy);
    }
    public void optionRemoveEasy() {
        option.remove(easy);
    }
    public void optionAddNormal() {
        option.add(normal);
    }
    public void optionRemoveNormal() {
        option.remove(normal);
    }
    public void optionAddHard() {
        option.add(hard);
    }
    public void optionRemoveHard() {
        option.remove(hard);
    }

    public void gameAddP2() {
        game.add(P2);
    }
    public void gameAddAi() {
        game.add(Ai);
    }
    public void gameRemoveP2() {
        game.remove(P2);
    }
    public void gameRemoveAi() {
        game.remove(Ai);
    }
    public void gameAddWon1() {
        game.add(won1);
    }
    public void gameAddWon2() {
        game.add(won2);
    }
    public void gameRemoveWon1() {
        game.remove(won1);
    }
    public void gameRemoveWon2() {
        game.remove(won2);
    }


//get component methods
    public JButton getStartButton() {
        return start;
    }
    public JButton getBack3Button() {
        return back3;
    }
    public JButton getRestartButton() {
        return restart;
    }

    public JButton getOptionsButton() {
        return options;
    }
    public JButton getVsAiButton() {
        return vsAi;
    }
    public JButton getVsPlayerButton() {
        return vsPlayer;
    }
    public JButton getEasyButton() {
        return easy;
    }
    public JButton getNormalButton() {
        return normal;
    }
    public JButton getHardButton() {
        return hard;
    }
    public JButton getBack1Button() {
        return back1;
    }

    public JButton getInfoButton() {
        return info;
    }
    public JButton getBack2Button() {
        return back2;
    }

    public JPanel getGamePanel() {
        return game;
    }


//getters and setters
    public boolean getVsAI() {
        return vsAI;
    }
    public void setVsAI(boolean b) {
        vsAI = b;
    }
    public int getDif() {
        return dif;
    }
    public void setDif(int d) {
        dif = d;
    }

    public void changeColors() {
        if (vsAI) {
            vsPlayer.setBackground(Color.WHITE);
            vsAi.setBackground(Color.GRAY);
        }
        else {
            vsPlayer.setBackground(Color.GRAY);
            vsAi.setBackground(Color.WHITE);
        }
    }
    public void changeColors2() {
        switch (dif) {
            case 0:
                easy.setBackground(Color.GRAY);
                normal.setBackground(Color.WHITE);
                hard.setBackground(Color.WHITE);
                break;
            case 1:
                easy.setBackground(Color.WHITE);
                normal.setBackground(Color.GRAY);
                hard.setBackground(Color.WHITE);
                break;
            case 2:
                easy.setBackground(Color.WHITE);
                normal.setBackground(Color.WHITE);
                hard.setBackground(Color.GRAY);
                break;
        }
    }


    public int getmMovedX() {
        return mMovedX;
    }
    public void setmMovedX(int mMovedX) {
        this.mMovedX = mMovedX;
    }
    public int getmMovedY() {
        return mMovedY;
    }
    public void setmMovedY(int mMovedY) {
        this.mMovedY = mMovedY;
    }

    public int getO() {
        return O;
    }
    public void setO(int o) {
        O = o;
    }

    public int getWin() {
        return win;
    }
    public void setWin(int win) {
        this.win = win;
    }

    public int[][] getArray() {
        return array;
    }
    public void setArray(int[][] a) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = a[i][j];
            }
        }
    }


//graphic methods
    public void drawO1(int x, int y, Graphics2D g2) {
        g2.setPaint(Color.RED.darker().darker());
        g2.fillOval(x, y,
                65, 65);
        g2.setPaint(Color.RED.darker());
        g2.fillOval(x+2, y+2,
                61, 61);
        g2.setPaint(Color.RED);
        g2.fillOval(x+4, y+4,
                57, 57);
        g2.setPaint(Color.RED.darker());
        g2.fillOval(x+7, y+7,
                51, 51);
        g2.setPaint(Color.RED);
        g2.fillOval(x+10, y+10,
                45, 45);
    }
    public void drawO2(int x, int y, Graphics2D g2) {
        g2.setPaint(Color.ORANGE.darker());
        g2.fillOval(x, y,
                65, 65);
        g2.setPaint(Color.ORANGE);
        g2.fillOval(x+2, y+2,
                61, 61);
        g2.setPaint(Color.YELLOW);
        g2.fillOval(x+4, y+4,
                57, 57);
        g2.setPaint(Color.ORANGE);
        g2.fillOval(x+7, y+7,
                51, 51);
        g2.setPaint(Color.YELLOW);
        g2.fillOval(x+10, y+10,
                45, 45);
    }


    public void update() {
        validate();
//        revalidate();
        repaint();
//        update(getGraphics());
    }
}











