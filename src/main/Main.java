package main;

import cases.Case;
import cases.OperationRiptide;
import generator.Generator;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Case c1 = new OperationRiptide();

        Scanner sc = new Scanner(System.in);
        Generator generator = new Generator(c1);

        while(true)
        {
            System.out.println("Open case? (Yes - 1, No - 2)\n");
            String input = sc.nextLine();
            if(input.equals("1"))
            {
                generator.drop();
            }
            else if(input.equals("2"))
            {
                break;
            }
            System.out.println("\n");
        }
    }
}