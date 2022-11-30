import java.util.logging.*;
import java.util.Scanner;
import java.io.*;

public class LogCalculator {
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double num1 = input.nextDouble();
        System.out.println("Введите действие: ");
        String oper = input.next();
        System.out.println("Введите второе число: ");
        double num2 = input.nextDouble();
        input.close();

        Logger logger = Logger.getLogger(LogCalculator.class.getName());
        FileHandler fh = new FileHandler("Calculator_Log.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        double res = 0;
        switch (oper){
            case "+":
                res = num1 + num2;
                System.out.printf("%f %s %f = %f", num1, oper, num2, res);
                break;
            case "-":
                res = num1 - num2;
                System.out.printf("%f %s %f = %f", num1, oper, num2, res);
                break;
            case "*":
                res = num1 * num2;
                System.out.printf("%f %s %f = %f", num1, oper, num2, res);
                break;
            case "/":
                res = num1 / num2;
                System.out.printf("%f %s %f = %f", num1, oper, num2, res);
                break;
            default:
                System.out.print("Неверно введены данные");
                break;
        }
        String out = num1 + " " + oper + " " + num2 + " " + "=" + " " + res;
        logger.info(out);
    }
}