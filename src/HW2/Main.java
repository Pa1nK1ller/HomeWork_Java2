package HW2;

public class Main {
    public static void main(String[] args) {
        int res = 0;
        String[][] arr = {{"1", "2", "3", "4"}, {"4", "3", "2", "1"}};
        String[][] arr2 = {{"1", "2", "3", "4", "5", "6"}, {"1", "2", "3", "4"}};
        String[][] arr3 = {{"1", "2", "3", "4"}, {"1", "2", "зз", "4"}};

        try {
            res = check(arr);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("сумма элементов массива = " + String.valueOf(res));

        }
        try {
            res = 0;
            res = check(arr2);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("сумма элементов массива = " + String.valueOf(res));

        }
        try {
            res = 0;
            res = check(arr3);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("сумма элементов массива = " + String.valueOf(res));

        }

    }

    public static int check(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int value;
        int row ;
        int cell;
        if (array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 1; i < 3; i++) {
            row = i;
            for (int c = 1; c < 5; c++) {
                cell = c;
                try {
                    value = Integer.parseInt(array[i - 1][c - 1]);
                    sum += value;
                } catch (IllegalArgumentException e) {
                    String message = "в " + String.valueOf(row) + " ряду, " + String.valueOf(cell) + " ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return sum;
    }
}
