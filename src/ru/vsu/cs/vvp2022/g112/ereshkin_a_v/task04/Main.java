package ru.vsu.cs.vvp2022.g112.ereshkin_a_v.task04;

import java.util.Scanner;

public class Main {
    // Изобретаем велосипед
    public static int abs(int x){
        return (x < 0) ? -x : x;
    }
    //Поиск суммы подходящих элементов от A до B
    public static int getSum(int A, int B){
        // Переменная для хранения промежуточной суммы
        // по мере прохождения цикла она будет увеличиваться.
        int sum = 0;
        for (int i = A; i <= B; i++) {
            // Если число подходит, то прибавляем его, иначе прибавляем 0
            sum += (isNumberValid(i)) ? i : 0;
        }
        return sum;
    }
    public static int getLength(int x){
        // Берём значение x и присваиваем его переменной copyOfX
        int copyOfX = x;
        // Задаём переменной промежуточного результата начальное значение 1
        int length = 1;
        // Нюанс: в Java деление целого числа на целое число возвращает не округлённое, а целую часть
        while ( (copyOfX/=10) > 0) {
            length++;
        }
        return length;
    }
    public static boolean isNumberValid(int x){
        //Берём число по модулю (нам знак числа не важен)
        int number = abs(x);
        // Получаем длину числа x
        int length = getLength(x);
        // Если число состоит только из одной цифры сразу возвращаем false
        if (number == 0 || length == 1){
            return false;
        }
        // Вводим счётчики для нечётных и чётных чисел
        int oddCount = 0;
        int evenCount = 0;
        //Проходимся по каждому разряду и записываем результат в соответствующие переменные.
        while (number > 0){
            // Проверяем на чётность остаток от деления на 10 путём
            // проверки остатка от деления на 2 ОСТАТКА ОТ ДЕЛЕНИЯ
            if ((number % 10) % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
            number /= 10;
            length--;
        }
        // Если количество чётных и нечётных цифр равно, то возвращаем истину, иначе ложь.
        return oddCount == evenCount;
    }
    public static void main(String[] args) {
        //Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите А: ");
        int a = scanner.nextInt();

        System.out.print("Введите B: ");
        int b = scanner.nextInt();

        System.out.printf("Сумма подходящих чисел от %d до %d: %d.", a, b, getSum(a, b));
    }
}