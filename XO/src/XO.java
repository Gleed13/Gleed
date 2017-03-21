import java.util.Scanner;
class XO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte[][] array = new byte[7][8]; //{{0, 0, 0, 0, 0, 0, 0, 0}x7}
        byte enter; //для ввода данных с клавиатуры
        byte current = 0; //внутрипрограмная переменная для заполнения массива array
        boolean pl; //показыввает, чей ход
        byte win = 0; //показывает, выигран ли матч
        String player1;
        String player2;

        //вводятся имена игроков, а также выбирается, кто ходит первым
        System.out.print("Введите имя первого игрока: ");
        player1 = scan.nextLine();
        System.out.println("");
        System.out.print("Введите имя второго игрока: ");
        player2 = scan.nextLine();
        System.out.println("");
        double rng = Math.round(Math.random());
        if (rng == 1)
            pl = false;
        else
            pl = true;

        //начало игры
        while (win == 0) {
            //вывод картинки
            System.out.println("");
            System.out.println("");
            System.out.println("+-1-+-2-+-3-+-4-+-5-+-6-+-7-+-8-+");
            for (byte i = 6; i >= 0; i--) {
                System.out.print("|");
                for (byte j = 0; j < 8; j++) {
                    if (array[i][j] == 0) {
                        System.out.print("   |");
                    } else if (array[i][j] == 1) {
                        System.out.print(" X |");
                    } else if (array[i][j] == 2) {
                        System.out.print(" O |");
                    }
                }
                System.out.println("");
                System.out.println("+---+---+---+---+---+---+---+---+");
            }

            //кто ходит?
            if (!pl) {
                pl = true;
                System.out.println("Твой ход, " + player1 + " (Х)!");
                current = 1;
            } else {
                System.out.println("Твой ход, " + player2 + " (О)!");
                pl = false;
                current = 2;
            }

            //ввод фигуры
            do {
                System.out.println("Выбери столбец, куда должен попасть твой элемент:");
                enter = scan.nextByte();
            }
            while ((enter < 1 || enter > 8) || array[6][enter-1] != 0);

            //проверка и установление фигуры в массив
            for (byte i = 0; i < 7; i++) {
                if (array[i][enter-1] == 0) {
                    array[i][enter-1] = current;
                    break;
                }
            }

            //проверка на наличие win-а
            label :
            for (byte k = 0; k < 1; k++) {
                byte counter = 0;
                for (byte i = 0; i < 7; i++) {
                    for (byte j = 0; j < 5; j++) {
                        if (array[i][j] != 0 && array[i][j] == array[i][j + 1] && array[i][j + 1] == array[i][j + 2] && array[i][j + 2] == array[i][j + 3]) {
                            win = 1;
                            current = array[i][j];
                            break label;
                        }
                    }
                }
                for (byte i = 0; i < 4; i++) {
                    for (byte j = 0; j < 8; j++) {
                        if (array[i][j] != 0 && array[i][j] == array[i + 1][j] && array[i + 1][j] == array[i + 2][j] && array[i + 2][j] == array[i + 3][j]) {
                            win = 1;
                            current = array[i][j];
                            break label;
                        }
                    }
                }
                for (byte i = 0; i < 4; i++) {
                    for (byte j = 0; j < 5; j++) {
                        if (array[i][j] != 0 && array[i][j] == array[i + 1][j + 1] && array[i + 1][j + 1] == array[i + 2][j + 2] && array[i + 2][j + 2] == array[i + 3][j + 3]) {
                            win = 1;
                            current = array[i][j];
                            break label;
                        }
                    }
                }
                for (byte i = 0; i < 4; i++) {
                    for (byte j = 3; j < 8; j++) {
                        if (array[i][j] != 0 && array[i][j] == array[i + 1][j - 1] && array[i + 1][j - 1] == array[i + 2][j - 2] && array[i + 2][j - 2] == array[i + 3][j - 3]) {
                            win = 1;
                            current = array[i][j];
                            break label;
                        }
                    }
                }
                for (byte i = 0; i < 8; i++) {
                    if (array[6][i] != 0) counter++;
                    if (counter == 8) win = 2;
                }
            }
        }
        //вывод картинки
        System.out.println("");
        System.out.println("");
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (byte i = 6; i >= 0; i--) {
            System.out.print("|");
            for (byte j = 0; j < 8; j++) {
                if (array[i][j] == 0) {
                    System.out.print("   |");
                } else if (array[i][j] == 1) {
                    System.out.print(" X |");
                } else if (array[i][j] == 2) {
                    System.out.print(" O |");
                }
            }
            System.out.println("");
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
        if (win == 1) {
            if (current == 1)
                System.out.println(player1 + " ПОБЕЖДАЕТ!!!");
            else
                System.out.println(player2 + " ПОБЕЖДАЕТ!!!");
        }
        else System.out.println("У НАС НИЧЬЯ!!!");
    }
}
