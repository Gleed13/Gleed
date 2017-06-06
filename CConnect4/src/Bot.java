public class Bot {
    private int botAr[][] = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };
    private int bot;
    private int pla;
    private boolean possibleTurns[] = new boolean[7];


    public int turn(int[][] a, int c, int ai) {
        fillArray(a);
        bot = c;
        if (bot == 2) pla = 1;
        else pla = 2;
        switch (ai) {
            case 0: return AI1();
            case 1: return AI2();
            case 2: return AI3();
            default:
                checkForPossibleTurns();
                return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
    }

    private int AI1() {

        checkForPossibleTurns();

        if (checkWin()) {
            System.out.println("win");
            printDatShit(getWin());
            return getCorrectTurn1( getWin(), (int)(Math.random()*getMustPlayTurns(getWin())) );
        }

        if (checkLose()) {
            System.out.println("lose");
            printDatShit(getLose());
            return getCorrectTurn1( getLose(), (int)(Math.random()*getMustPlayTurns(getLose())) );
        }

        checkForPossibleTurns2();

        if (checkWin2()) {
            System.out.println("win2");
            printDatShit(getWin2());
            return getCorrectTurn1( getWin2(), (int)(Math.random()*getMustPlayTurns(getWin2())) );
        }

        if (checkWin2a()) {
            System.out.println("win2a");
            printDatShit(getWin2a());
            return getCorrectTurn1( getWin2a(), (int)(Math.random()*getMustPlayTurns(getWin2a())) );
        }

        if (checkLose2()) {
            System.out.println("lose2");
            printDatShit(getLose2());
            return getCorrectTurn1( getLose2(), (int)(Math.random()*getMustPlayTurns(getLose2())) );
        }

        checkForPossibleTurns3();

        if (getPossibleTurns()==0) {
            checkForPossibleTurns();
            return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
        else {
            return  getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }

    }

    private int AI2() {

        checkForPossibleTurns();

        if (checkWin()) {
            System.out.println("win");
            printDatShit(getWin());
            return getCorrectTurn1( getWin(), (int)(Math.random()*getMustPlayTurns(getWin())) );
        }

        if (checkLose()) {
            System.out.println("lose");
            printDatShit(getLose());
            return getCorrectTurn1( getLose(), (int)(Math.random()*getMustPlayTurns(getLose())) );
        }

        checkForPossibleTurns2();

        if (checkWin2()) {
            System.out.println("win2");
            printDatShit(getWin2());
            return getCorrectTurn1( getWin2(), (int)(Math.random()*getMustPlayTurns(getWin2())) );
        }

        if (checkWin2a()) {
            System.out.println("win2a");
            printDatShit(getWin2a());
            return getCorrectTurn1( getWin2a(), (int)(Math.random()*getMustPlayTurns(getWin2a())) );
        }

        if (checkLose2()) {
            System.out.println("lose2");
            printDatShit(getLose2());
            return getCorrectTurn2( getLose2() );
        }

        checkForPossibleTurns3();

        if (getPossibleTurns()==0) {
            checkForPossibleTurns();
            return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
        else {
            return  getCorrectTurn2( possibleTurns );
        }

    }

    private int AI3() {

        checkForPossibleTurns();

        if (checkWin()) {
            System.out.println("win");
            printDatShit(getWin());
            return getCorrectTurn1( getWin(), (int)(Math.random()*getMustPlayTurns(getWin())) );
        }

        if (checkLose()) {
            System.out.println("lose");
            printDatShit(getLose());
            return getCorrectTurn1( getLose(), (int)(Math.random()*getMustPlayTurns(getLose())) );
        }

        checkForPossibleTurns2();

        if (checkWin2()) {
            System.out.println("win2");
            printDatShit(getWin2());
            return getCorrectTurn1( getWin2(), (int)(Math.random()*getMustPlayTurns(getWin2())) );
        }

        if (checkWin2a()) {
            System.out.println("win2a");
            printDatShit(getWin2a());
            return getCorrectTurn1( getWin2a(), (int)(Math.random()*getMustPlayTurns(getWin2a())) );
        }

        if (checkLose2()) {
            System.out.println("lose2");
            printDatShit(getLose2());
            return getCorrectTurn3( getLose2() );
        }

        checkForPossibleTurns3();

        if (getPossibleTurns()==0) {
            checkForPossibleTurns();
            return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
        else {
            return  getCorrectTurn3( possibleTurns );
        }

    }

    public void printDatShit(boolean[] b) {
        for (int i = 0; i < 7; i++) {
            System.out.print(i+1+") "+b[i]+" ");
        }
    }

    private void checkForPossibleTurns() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) possibleTurns[i] = true;
            else possibleTurns[i] = false;
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) {

                addElement(i, bot);
                if (isGameOver()) {
                    removeElement(i);
                    return true;
                }
                removeElement(i);

            }
        }
        return false;
    }
    private boolean[] getWin() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) {

                addElement(i, bot);
                if (isGameOver()) mustPlay[i] = true;
                removeElement(i);

            }
        }
        return mustPlay;
    }

    private boolean checkLose() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) {

                addElement(i, pla);
                if (isGameOver()) {
                    removeElement(i);
                    return true;
                }
                removeElement(i);

            }
        }
        return false;
    }
    private boolean[] getLose() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) {

                addElement(i, pla);
                if (isGameOver()) mustPlay[i] = true;
                removeElement(i);

            }
        }
        return mustPlay;
    }

    private void checkForPossibleTurns2() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i)) {

                addElement(i, bot);
                if (checkLose()) possibleTurns[i] = false;
                removeElement(i);

            }
        }
    }

    private boolean checkWin2() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, bot);
                boolean win = true;

                for (int j = 0; j < 7; j++) {
                    if (isOpened(j)) {

                        addElement(j, pla);
                        if (!checkWin()) win = false;
                        removeElement(j);

                    }
                }

                removeElement(i);
                if (win) return true;

            }
        }
        return false;
    }
    private boolean[] getWin2() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, bot);
                boolean win = true;

                for (int j = 0; j < 7; j++) {
                    if (isOpened(j)) {

                        addElement(j, pla);
                        if (!checkWin()) win = false;
                        removeElement(j);

                    }
                }

                removeElement(i);
                if (win) mustPlay[i] = true;

            }
        }
        return mustPlay;
    }

    private boolean checkWin2a() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, bot);
                boolean win = false;

                if (checkWin()) {

                    int tmp = getPos(getWin());
                    addElement(tmp, pla);
                    if (checkWin2() && !checkLose()) win = true;
                    removeElement(tmp);

                }

                removeElement(i);
                if (win) return true;
            }
        }
        return false;
    }
    private boolean[] getWin2a() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, bot);
                boolean win = false;

                if (checkWin()) {

                    int tmp = getPos(getWin());
                    addElement(tmp, pla);
                    if (checkWin2() && !checkLose()) win = true;
                    removeElement(tmp);

                }

                removeElement(i);
                if (win) mustPlay[i] = true;
            }
        }
        return mustPlay;
    }

    private boolean checkLose2() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, pla);
                boolean lose = true;
                for (int j = 0; j < 7; j++) {
                    if (isOpened(j)) {

                        addElement(j, bot);
                        if (!checkLose()) lose = false;
                        removeElement(j);

                    }
                }
                removeElement(i);
                if (lose) return true;

            }
        }
        return false;
    }
    private boolean[] getLose2() {
        boolean[] mustPlay = {false, false, false, false, false, false, false};
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, pla);
                boolean lose = true;
                for (int j = 0; j < 7; j++) {
                    if (isOpened(j)) {

                        addElement(j, bot);
                        if (!checkLose()) lose = false;
                        removeElement(j);

                    }
                }
                removeElement(i);
                if (lose) mustPlay[i] = true;

            }
        }
        return mustPlay;
    }

    private void checkForPossibleTurns3() {
        for (int i = 0; i < 7; i++) {
            if (isOpened(i) && possibleTurns[i]) {

                addElement(i, bot);
                if (checkLose2()) possibleTurns[i] = false;
                removeElement(i);

            }
        }
    }


    private void fillArray(int[][] b) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                botAr[i][j] = b[i][j];
            }
        }
    }

    private void addElement(int pos, int el) {
        for (int i = 0; i < 6; i++) {
            if (botAr[i][pos]==0) {
                botAr[i][pos] = el;
                break;
            }
        }
    }
    private void removeElement(int pos) {
        for (int i = 5; i >= 0; i--) {
            if (botAr[i][pos]!=0) {
                botAr[i][pos] = 0;
                break;
            }
        }
    }
    private boolean isOpened(int pos) {
        if (botAr[5][pos]==0) return true;
        return false;
    }
    private boolean isEmpty(int pos) {
        if (botAr[0][pos]==0) return true;
        return false;
    }
    private int getPos(boolean[] mustPlay) {
        for (int i = 0; i < 7; i++) {
            if (mustPlay[i]==true) return i;
        }
        return -1;
    }
    private boolean isGameOver() {

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
    private int getCorrectTurn1(boolean[] b, int var) {
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
    private int getCorrectTurn2(boolean[] b) {
        int[] scores = {-1, -1, -1, -1, -1, -1, -1};
        for (int i = 0; i < 7; i++) {
            if (b[i]) {
                scores[i] = (int)(score(i, bot)*(Math.random()));
            }
        }
        int max = -1;
        int s = -1;
        for (int i = 0; i < 7; i++) {
            if (scores[i] > max) {
                max = scores[i];
                s = i;
            }
        }
        if (s >= 0 && s < 7) return s;
        else {
            getPossibleTurns();
            return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
    }
    private int getCorrectTurn3(boolean[] b) {
        int[] scores = {-1, -1, -1, -1, -1, -1, -1};
        for (int i = 0; i < 7; i++) {
            if (b[i]) {
                scores[i] = score(i, bot);
            }
        }
        int max = -1;
        int s = -1;
        for (int i = 0; i < 7; i++) {
            if (scores[i] > max) {
                max = scores[i];
                s = i;
            }
        }
        if (s >= 0 && s < 7) return s;
        else {
            getPossibleTurns();
            return getCorrectTurn1( possibleTurns, (int)(Math.random()*getPossibleTurns()) );
        }
    }

    private int score(int pos, int el) {
        int s = 0;
        int h = -1;
        for (int i = 0; i < 6; i++) {
            if (botAr[i][pos] == 0) {
                h = i;
                break;
            }
        }


        //vertical
        int row = 1;
        int els = 0;

        //row
        for (int i = -1; i >= -3; i--) {
            try {
                if (botAr[h+i][pos] == el) els++;
            }
            catch (Exception e) {
                break;
            }
        }
        row += els;

        //elements
        if (row < 4)
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+1][pos] == 0) {
                        row++;
                        if (row >= 4) break;
                    }
                }
                catch (Exception e) {
                    break;
                }
            }

        //score
        if (row == 4) {
            s += els*2+1;
        }
        //else s+=10;


        //horizontal
        row = 1;
        els = 0;

        //row
        for (int i = -1; i >= -3; i--) {
            try {
                if (botAr[h][pos+i] == el || botAr[h][pos+i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }
        for (int i = 1; i <= 3; i++) {
            try {
                if (botAr[h][pos+i] == el || botAr[h][pos+i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }

        //elements
        if (row >= 4) {
            s++;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h][pos+i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h][pos+i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }

            //score
            //if (els==3) s+=10;
            s += els*3;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h][pos+i] == 0) {
                        s++;
                        try {
                            if (botAr[h-1][pos+i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    } else
                    if (botAr[h][pos+i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h][pos+i] == 0) {
                        s++;
                        try {
                            if (botAr[h-1][pos+i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    } else
                    if (botAr[h][pos+i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            boolean b = false;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h][pos+i] == 0) {
                        b = true;
                    } else
                    if (botAr[h][pos+i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            b = false;
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h][pos+i] == 0) {
                        b = true;
                    } else
                    if (botAr[h][pos+i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
        }


        //diagonal1
        row = 1;
        els = 0;

        //row
        for (int i = -1; i >= -3; i--) {
            try {
                if (botAr[h+i][pos+i] == el || botAr[h+i][pos+i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }
        for (int i = 1; i <= 3; i++) {
            try {
                if (botAr[h+i][pos+i] == el || botAr[h+i][pos+i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }

        //elements
        if (row >= 4) {
            s++;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos+i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos+i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }

            //score
            //if (els==3) s+=10;
            s += els*3;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos+i] == 0) {
                        s++;
                        try {
                            if (botAr[h+i-1][pos+i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    } else
                    if (botAr[h+i][pos+i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos+i] == 0) {
                        s++;
                        try {
                            if (botAr[h+i-1][pos+i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    }
                    if (botAr[h+i][pos+i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            boolean b = false;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos+i] == 0) {
                        b = true;
                    } else
                    if (botAr[h+i][pos+i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            b = false;
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos+i] == 0) {
                        b = true;
                    } else
                    if (botAr[h+i][pos+i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
        }


        //diagonal2
        row = 1;
        els = 0;

        //row
        for (int i = -1; i >= -3; i--) {
            try {
                if (botAr[h+i][pos-i] == el || botAr[h+i][pos-i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }
        for (int i = 1; i <= 3; i++) {
            try {
                if (botAr[h+i][pos-i] == el || botAr[h+i][pos-i] == 0) row++;
            }
            catch (Exception e) {
                break;
            }
        }

        //elements
        if (row >= 4) {
            s++;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos-i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos-i] == el) {
                        els++;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }

            //score
            //if (els==3) s+=10;
            s += els*3;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos-i] == 0) {
                        s++;
                        try {
                            if (botAr[h+i-1][pos-i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    }
                    if (botAr[h+i][pos-i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos-i] == 0) {
                        s++;
                        try {
                            if (botAr[h+i-1][pos-i] == 0) {
                                s += 2;
                                break;
                            }
                        }
                        catch (Exception e) {
                            break;
                        }
                        break;
                    }
                    if (botAr[h+i][pos-i] == el) {
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            boolean b = false;
            for (int i = -1; i >= -3; i--) {
                try {
                    if (botAr[h+i][pos-i] == 0) {
                        b = true;
                    } else
                    if (botAr[h+i][pos-i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
            b = false;
            for (int i = 1; i <= 3; i++) {
                try {
                    if (botAr[h+i][pos-i] == 0) {
                        b = true;
                    } else
                    if (botAr[h+i][pos-i] == el && b) {
                        s += 2;
                    }
                    else break;
                }
                catch (Exception e) {
                    break;
                }
            }
        }

        return s;
    }
}










