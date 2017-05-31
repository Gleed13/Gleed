public class Game {
    private int[][] array = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};

    private Bot bot;
    private boolean vsAI;
    private int O;
    private int win = 0;
//конструктор
    public Game(boolean vsAI) {
        this.vsAI = vsAI;
        O = (int)(1+Math.random()*2);
        if (vsAI) {
            bot = new Bot();
            if (O==2) {
                putIn(bot.turn(array, O));
                O = 1;
            }
        }
    }
//сделать ход
    public void turn(int t) {
        if (array[5][t]==0 && win==0) {
            putIn(t);
            if (isGameOver()) {
                if (O==1) win = 1;
                else win = 2;
            } else
            if (isDraw()) win = 3;
            else {
                if (O==1) O = 2;
                else O = 1;
                if (vsAI) {
                    putIn(bot.turn(array, O));
                    if (isGameOver()) win = 2;
                    else if (isDraw()) win = 3;
                    else O = 1;
                }
            }
        }
    }


    public int getWin() {
        return win;
    }

    public int getO() {
        return O;
    }
    public void setO(int o) {
        O = o;
    }

    public int[][] getArray() {
        return array;
    }
    public void reset() {
        win = 0;
        O = (int)(1+Math.random()*2);
        if (vsAI) {
            bot = new Bot();
            if (O==2) {
                putIn(bot.turn(array, O));
                O = 1;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = 0;
            }
        }
    }
    public void putIn(int o) {
        for (int i = 0; i < 6; i++) {
            if (array[i][o] == 0) {
                array[i][o] = O;
                break;
            }
        }
    }

    public boolean isDraw() {
        int d = 0;
        for (int i = 0; i < 7; i++) {
            if (array[5][i]!=0) {
                d++;
                if (d==7) return true;
            }
        }
        return false;
    }
    public boolean isGameOver() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] != 0 && array[i][j] == array[i][j + 1] && array[i][j + 1] == array[i][j + 2] && array[i][j + 2] == array[i][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (array[i][j] != 0 && array[i][j] == array[i + 1][j] && array[i + 1][j] == array[i + 2][j] && array[i + 2][j] == array[i + 3][j]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] != 0 && array[i][j] == array[i + 1][j + 1] && array[i + 1][j + 1] == array[i + 2][j + 2] && array[i + 2][j + 2] == array[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (array[i][j] != 0 && array[i][j] == array[i + 1][j - 1] && array[i + 1][j - 1] == array[i + 2][j - 2] && array[i + 2][j - 2] == array[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}













