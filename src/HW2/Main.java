package HW2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"4", "3", "2", "1"}};
        String[][] arr2 = {{"1", "2", "3", "4", "5", "6"}, {"1", "2", "3", "4"}};
        String[][] arr3 = {{"1", "2", "3", "4"}, {"1", "2", "зз", "4"}};
        String[][] arr4 = new String[][]{{"3", "3", "3", "3"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}, {}};

        try {
            System.out.println("сумма элементов массива = " + check(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("сумма элементов массива = " + check(arr2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("сумма элементов массива = " + check(arr3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("сумма элементов массива = " + check(arr4));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("сумма элементов массива = " + check(new String[][]{{"3", "3", "3", "3"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}, {}}));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int check(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            for (int c = 0; c < array[i].length; c++) {
                try {
                    sum += Integer.parseInt(array[i][c]);
                } catch (IllegalArgumentException e) {
                    String message = "в " + (i + 1) + " ряду, " + (c + 1) + " ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return sum;
    }
}
