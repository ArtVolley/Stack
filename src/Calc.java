// Калькулятор арифметических формул.
public class Calc extends Compf
{
    private StackInt s;
    private static int char2six(char c)
    {
        if (c == 'a')
        {
            return 10;
        }
        if (c == 'b')
        {
            return 11;
        }
        if (c == 'c')
        {
            return 12;
        }
        if (c == 'd')
        {
            return 13;
        }
        if (c == 'e')
        {
            return 14;
        }
        if (c == 'f')
        {
            return 15;
        }
        return (int)c - (int)'0';
    }
    protected int symOther(char c)
    {
        if (c < '0' || c > '9' && c < 'a' || c > 'f')
        {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c)
    {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
        }
    }
    protected void nextOther(char c) {
        if(N)
        {
            {
                int num = ((s.pop()) * 16) + (char2six(c));
                if (num >= 14745)
                {
                    System.out.println("Введите число меньше 3999");
                    System.exit(0);
                }
                else
                {
                    s.push(num);
                    N = true;
                }
            }
        }
        else
        {
            s.push((char2six(c)));
            N = true;
        }
    }
    public String int2Rome(int num)
    {
        String Rome = "";
        if (num < 0)
        {
            Rome += "-";
            num = -num;
        }
        if (num/1000 >= 1)
        {
            for (int i = num/1000; i > 0; i--)
            {
                Rome += "M";
            }
            num = num%1000;
        }
        if (num/900 >= 1)
        {
            for (int i = num/900; i > 0; i--)
            {
                Rome += "CM";
            }
            num = num%900;
        }
        if (num/500 >= 1)
        {
            for (int i = num/500; i > 0; i--)
            {
                Rome += "D";
            }
            num = num%500;
        }
        if (num/400 >= 1)
        {
            for (int i = num/400; i > 0; i--)
            {
                Rome += "CD";
            }
            num = num%400;
        }
        if (num/100 >= 1)
        {
            for (int i = num/100; i > 0; i--)
            {
                Rome += "C";
            }
            num = num%100;
        }
        if (num/90 >= 1)
        {
            for (int i = num/90; i > 0; i--)
            {
                Rome += "XC";
            }
            num = num%90;
        }
        if (num/50 >= 1)
        {
            for (int i = num/50; i > 0; i--)
            {
                Rome += "L";
            }
            num = num%50;
        }
        if (num/40 >= 1)
        {
            for (int i = num/40; i > 0; i--)
            {
                Rome += "XL";
            }
            num = num%40;
        }
        if (num/10 >= 1)
        {
            for (int i = num/10; i > 0; i--)
            {
                Rome += "X";
            }
            num = num%10;
        }
        if (num/9 >= 1)
        {
            for (int i = num/9; i > 0; i--)
            {
                Rome += "IX";
            }
            num = num%9;
        }
        if (num/5 >= 1)
        {
            for (int i = num/5; i > 0; i--)
            {
                Rome += "V";
            }
            num = num%5;
        }
        if (num/4 >= 1)
        {
            for (int i = num/4; i > 0; i--)
            {
                Rome += "IV";
            }
            num = num%4;
        }
        if (num/1 >= 1)
        {
            for (int i = num/1; i > 0; i--)
            {
                Rome += "I";
            }
            num = num%1;
        }
        return Rome;
    }
    public Calc()
    {
        s = new StackInt();
    }
    public final void compile(char[] str)
    {
        super.compile(str);
        int result = s.top();
        System.out.println("" + int2Rome(result));
        N = false;
    }
}