import java.util.Scanner;

public class CalcTest
{
    public static void main(String[] args) throws Exception
    {
        Scanner read = new Scanner(System.in);
        Calc c = new Calc();
        while (true)
        {
            System.out.print("Введите формулу -> ");
            String form = read.nextLine();
            c.compile(form.toCharArray());
        }
    }
}