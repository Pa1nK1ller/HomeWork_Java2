import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        //Создаем массив персонажей
        Actions[] actions = new Actions[3];

        actions[0] = new Cat("Барсик ", rnd.nextInt(15), rnd.nextInt(15));
        actions[1] = new Man("Василий Петрович ", rnd.nextInt(10), rnd.nextInt(10));
        actions[2] = new Robot("C3P0-Helper ", rnd.nextInt(7), rnd.nextInt(7));

        //создаем массив с препятсвиям рандомной высоты и длины
        Obstacle[] obstacles = new Obstacle[5];
        //Можно зарандомить через цикл
        obstacles[0] = new Treadmill("1", rnd.nextInt(15));
        obstacles[1] = new Wall("2", rnd.nextInt(15));
        obstacles[2] = new Wall("3", rnd.nextInt(15));
        obstacles[3] = new Treadmill("4", rnd.nextInt(15));
        obstacles[4] = new Wall("5", rnd.nextInt(15));
        //проверка прохождения препятствий
        boolean res;
        for (int i = 0; i < actions.length; i++) {
            res = true;
            for (int j = 0; j < obstacles.length; j++) {
                res = obstacles[j].move(actions[i]);
                if (!res) {
                    break;
                }
            }
            System.out.println(res?"Все препятствия пройдены\n":"Препрятствия не удалось пройти\n");
        }

    }
}
