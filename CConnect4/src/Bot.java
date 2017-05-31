public class Bot {
    private int botAr[][] = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
    private int botCur;
    private int plaCur;
    private boolean possibleTurns[] = new boolean[7];


    public int turn(int[][] a, int c) {
        fillArray(a);
        botCur = c;
        if (botCur == 2) plaCur = 1;
        else plaCur = 2;
        return AI1();
    }

    public boolean isGameOver() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (botAr[i][j] != 0 && botAr[i][j] == botAr[i][j + 1] && botAr[i][j + 1] == botAr[i][j + 2] && botAr[i][j + 2] == botAr[i][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (botAr[i][j] != 0 && botAr[i][j] == botAr[i + 1][j] && botAr[i + 1][j] == botAr[i + 2][j] && botAr[i + 2][j] == botAr[i + 3][j]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (botAr[i][j] != 0 && botAr[i][j] == botAr[i + 1][j + 1] && botAr[i + 1][j + 1] == botAr[i + 2][j + 2] && botAr[i + 2][j + 2] == botAr[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (botAr[i][j] != 0 && botAr[i][j] == botAr[i + 1][j - 1] && botAr[i + 1][j - 1] == botAr[i + 2][j - 2] && botAr[i + 2][j - 2] == botAr[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private int AI1() {

        checkForPossibleTurns();

        if (checkWin()) {
//            System.out.println("win");
//            printDatShit(getWin());
            return getCorrectTurn( getWin(), (int)(Math.random()*getMustPlayTurns(getWin())) );
        }

        if (checkLose()) {
//            System.out.println("lose");
//            printDatShit(getLose());
            return getCorrectTurn( getLose(), (int)(Math.random()*getMustPlayTurns(getLose())) );
        }

        checkForPossibleTurns2();

        if (checkWin2()) {
//            System.out.println("win2");
//            printDatShit(getWin2());
            return getCorrectTurn( getWin2(), (int)(Math.random()*getMustPlayTurns(getWin2())) );
        }

        if (checkWin2a()) {
//            System.out.println("win2a");
//            printDatShit(getWin2a());
            return getCorrectTurn( getWin2a(), (int)(Math.random()*getMustPlayTurns(getWin2a())) );
        }

        if (checkLose2()) {
//            System.out.println("lose2");
//            printDatShit(getLose2());
            return getCorrectTurn( getLose2(), (int)(Math.random()*getMustPlayTurns(getLose2())) );
        }

        checkForPossibleTurns3();

        if (getPossibleTurns()==0) {
            checkForPossibleTurns();
            return getCorrectTurn( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
        else {
            return  getCorrectTurn( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
    }

    public void printDatShit(boolean[] b) {
        for (int i = 0; i < 7; i++) {
            System.out.println(b[i]);
        }
    }

    private void checkForPossibleTurns() {
        for (int i = 0; i < 7; i++) {
            if (botAr[5][i] == 0) possibleTurns[i] = true;
            else possibleTurns[i] = false;
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        if (isGameOver()) {
                            botAr[j][i] = 0;
                            return true;
                        }
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
        return false;
    }
    private boolean[] getWin() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        if (isGameOver()) mustPlay[i] = true;
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
        return mustPlay;
    }

    private boolean checkLose() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = plaCur;
                        if (isGameOver()) {
                            botAr[j][i] = 0;
                            return true;
                        }
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
        return false;
    }
    private boolean[] getLose() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = plaCur;
                        if (isGameOver()) mustPlay[i] = true;
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
        return mustPlay;
    }

    private void checkForPossibleTurns2() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        if (checkLose2()) possibleTurns[i] = false;
                        tmp = j;
                        break;
                    }
                }
                if (botAr[5][i] == 0) {
                    for (int j = 0; j < 6; j++) {
                        if (botAr[j][i] == 0) {
                            botAr[j][i] = plaCur;
                            if (isGameOver()) possibleTurns[i] = false;
                            botAr[j][i] = 0;
                            break;
                        }
                    }
                }
                botAr[tmp][i] = 0;
            }
        }
    }

    private boolean checkWin2() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                boolean win = true;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        tmp = j;
                        break;
                    }
                }
                for (int j = 0; j < 7; j++) {
                    if (botAr[5][j] == 0) {
                        for (int k = 0; k < 6; k++) {
                            if (botAr[k][j] == 0) {
                                botAr[k][j] = plaCur;
                                if (!checkWin()) win = false;
                                botAr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
                botAr[tmp][i] = 0;
                if (win) return true;
            }
        }
        return false;
    }
    private boolean[] getWin2() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                boolean win = true;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        tmp = j;
                        break;
                    }
                }
                for (int j = 0; j < 7; j++) {
                    if (botAr[5][j] == 0) {
                        for (int k = 0; k < 6; k++) {
                            if (botAr[k][j] == 0) {
                                botAr[k][j] = plaCur;
                                if (!checkWin()) win = false;
                                botAr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
                botAr[tmp][i] = 0;
                if (win) mustPlay[i] = true;
            }
        }
        return mustPlay;
    }

    private boolean checkWin2a() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        tmp = j;
                        break;
                    }
                }
                if (checkWin()) {
                    boolean[] m = getWin();
                    for (int j = 0; j < 7; j++) {
                        if (m[j]) {
                            for (int k = 0; k < 6; k++) {
                                if (botAr[k][j] == 0) {
                                    botAr[k][j] = plaCur;
                                    if (!checkLose() && checkWin2()) {
                                        return true;
                                    }
                                    botAr[k][j] = 0;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                botAr[tmp][i] = 0;
            }
        }
        return false;
    }
    private boolean[] getWin2a() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        tmp = j;
                        break;
                    }
                }
                if (checkWin()) {
                    boolean[] m = getWin();
                    for (int j = 0; j < 7; j++) {
                        if (m[j]) {
                            for (int k = 0; k < 6; k++) {
                                if (botAr[k][j] == 0) {
                                    botAr[k][j] = plaCur;
                                    if (!checkLose() && checkWin2()) {
                                        mustPlay[i] = true;
                                    }
                                    botAr[k][j] = 0;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                botAr[tmp][i] = 0;
            }
        }
        return mustPlay;
    }

    private boolean checkLose2() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                int tmp = 0;
                boolean win = true;
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = plaCur;
                        tmp = j;
                        break;
                    }
                }
                for (int j = 0; j < 7; j++) {
                    if (botAr[5][j] == 0) {
                        for (int k = 0; k < 6; k++) {
                            if (botAr[k][j] == 0) {
                                botAr[k][j] = botCur;
                                if (!checkLose()) win = false;
                                botAr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
                botAr[tmp][i] = 0;
                if (win) return true;
            }
        }
        return false;
    }
    private boolean[] getLose2() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        if (!checkLose2()) mustPlay[i] = true;
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
        return mustPlay;
    }

    private void checkForPossibleTurns3() {
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) {
                for (int j = 0; j < 6; j++) {
                    if (botAr[j][i] == 0) {
                        botAr[j][i] = botCur;
                        if (checkLose2()) possibleTurns[i] = false;
                        botAr[j][i] = 0;
                        break;
                    }
                }
            }
        }
    }

    private int getMustPlayTurns(boolean[] b) {
        int s = 0;
        for (int i = 0; i < 7; i++) {
            if (b[i]) s++;
        }
        return s;
    }
    private int getPossibleTurns() {
        int s = 0;
        for (int i = 0; i < 7; i++) {
            if (possibleTurns[i]) s++;
        }
        return s;
    }
    private int getCorrectTurn(boolean[] b, int var) {
        int s = 0;
        for (int i = 0; i < 7; i++) {
            if (b[i]) {
                if (s==var) {
                    return i;
                }
                else s++;
            }
        }
        return -1;
    }

    private void fillArray(int[][] b) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                botAr[i][j] = b[i][j];
            }
        }
    }
}










