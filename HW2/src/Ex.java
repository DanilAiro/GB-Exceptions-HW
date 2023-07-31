import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
//
// Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//
// Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//
// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение,что пустые строки вводить нельзя.

public class Ex {
    public static void main(String[] args) {
        // 1 и 4 задача
        readFloat();

        // 2 задача
        Ex2();

        // 3 задача
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[1] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }


    public static void readFloat() {
        Scanner sc = new Scanner(System.in);
        boolean isOver = false;

        System.out.print("Введите значение типа float: ");
        while (!isOver) {
            String temp = sc.nextLine();
            if (checkFloat(temp)) {
                System.out.println("Введено значение - " + Float.parseFloat(temp));
                isOver = true;
            } else {
                System.out.print("Повторите: ");
            }
        }
    }

    public static boolean checkFloat(String temp) {
        try {
            if (temp.equals("")) {
                throw new EmptyStringException();
            } else {
                Float.parseFloat(temp);
                return true;
            }
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void Ex2() {
        int d = 0;
        int[] intArray = new int[10];
        double catchedRes1 = 0;
        if (d != 0) {
            catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

}