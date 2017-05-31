import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class Main1 {
    private Game g;

    public Main1() {
        Window w = new Window();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);
        w.setResizable(false);
        w.setSize(800, 600);
        w.setLocationRelativeTo(null);
        w.addMenuPanel();
//        w.addOptionsPanel();
//        w.addInformationPanel();

        w.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.removeMenuPanel();
                w.addGamePanel();
                w.gameRemoveAi();
                w.gameRemoveP2();
                if (w.getVsAI()) w.gameAddAi();
                else w.gameAddP2();
                g = new Game(w.getVsAI());
                w.setO(g.getO());
                w.setArray(g.getArray());
                w.setWin(0);
                w.update();
            }
        });
        w.getInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.removeMenuPanel();
                w.addInformationPanel();
                w.update();
            }
        });
        w.getOptionsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.removeMenuPanel();
                w.addOptionsPanel();
                w.update();
            }
        });

        w.getBack1Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.removeOptionsPanel();
                w.addMenuPanel();
                w.update();
            }
        });
        w.getBack2Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.removeInformationPanel();
                w.addMenuPanel();
                w.update();
            }
        });
        w.getBack3Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int b = JOptionPane.showConfirmDialog(null, "are you sure?", "exit to menu", 0);
                if (b==0) {
                    w.removeGamePanel();
                    w.addMenuPanel();
                    w.update();
                }
            }
        });
        w.getRestartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int b = JOptionPane.showConfirmDialog(null, "are you sure?", "restart the game", 0);
                if (b==0) {
                    g = new Game(w.getVsAI());
                    w.gameRemoveWon1();
                    w.gameRemoveWon2();
                    w.setO(g.getO());
                    w.setArray(g.getArray());
                    w.setWin(0);
                    w.update();
                }
            }
        });

        w.getVsAiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!w.getVsAI()) {
                    w.setVsAI(true);
                    w.optionRemovePlayer();
                    w.optionAddAI();
                    w.changeColors();
                    w.getStartButton().setText("Start PvAi");
                    w.update();
                }
            }
        });
        w.getVsPlayerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (w.getVsAI()) {
                    w.setVsAI(false);
                    w.optionRemoveAI();
                    w.optionAddPlayer();
                    w.changeColors();
                    w.getStartButton().setText("Start PvP");
                    w.update();
                }
            }
        });

        w.getGamePanel().addMouseListener(new MouseListener() {
            int mPressedX;
            int mPressedY;
            int mReleasedX;
            int mReleasedY;
            int mClickedX;
            int mClickedY;
            @Override
            public void mouseClicked(MouseEvent e) {
//                if (w.getWin()==0) {
//                    mClickedX = e.getX();
//                    mClickedY = e.getY();
//                    for (int i = 0; i < 7; i++) {
//                        if (mClickedX>150+70*i&&mClickedX<221+70*i&&mClickedY>60&&mClickedY<516) {
//                            g.turn(i);
//                            w.setO(g.getO());
//                            w.setArray(g.getArray());
//                            w.setWin(g.getWin());
//                            break;
//                        }
//                    }
//                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (w.getWin()==0) {
                    mPressedX = e.getX();
                    mPressedY = e.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (w.getWin()==0) {
                    mReleasedX = e.getX();
                    mReleasedY = e.getY();
                    for (int i = 0; i < 7; i++) {
                        if ((mPressedX>150+70*i&&mPressedX<221+70*i&&mPressedY>60&&mPressedY<516)
                                &&(mReleasedX>150+70*i&&mReleasedX<221+70*i&&mReleasedY>60&&mReleasedY<516)) {
                            g.turn(i);
                            w.setO(g.getO());
                            w.setArray(g.getArray());
                            w.setWin(g.getWin());
                            break;
                        }
                    }
                    if (w.getWin()==1) {
                        w.gameAddWon1();
                    } else
                    if (w.getWin()==2) {
                        w.gameAddWon2();
                    }
                    w.update();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        w.getGamePanel().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                w.setmMovedX(e.getX());
                w.setmMovedY(e.getY());
                w.update();
            }
        });}
}
