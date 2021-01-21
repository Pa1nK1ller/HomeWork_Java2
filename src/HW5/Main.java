package HW5;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        Main test = new Main();
        test.method1();
        test.method2();
    }

    private void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        count(arr);
        System.out.println("Первый метод выполнен, затрачено времени : " + (System.currentTimeMillis() - a));
    }

    private void method2() throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        long a = System.currentTimeMillis();
        Arrays.fill(arr, 1.0f);

        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        System.out.println("Вермя разделения массива : " + (System.currentTimeMillis() - a));

        Thread thread1 = new Thread(() -> {
            count(arr1);
            System.out.println("Время выполнения потока 1 :" + (System.currentTimeMillis() - a));
        });
        Thread thread2 = new Thread(() -> {
            count(arr2);
            System.out.println("Время выполнения потока 2 :" + (System.currentTimeMillis() - a));
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
        System.out.println("Время выполнения склейки массивов :" + (System.currentTimeMillis() - a));

        System.out.println("Второй метод выполнен, затрачено времени :" + (System.currentTimeMillis() - a));
    }

    private void count(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        }
    }
}



