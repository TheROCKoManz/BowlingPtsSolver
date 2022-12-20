package Workspace.Bowling;

import java.io.IOException;
import java.lang.*;
import java.util.*;
import java.util.concurrent.Callable;

import static java.lang.Math.round;

class BowlingProblem
{
    public static void main(String[] args)
    {
        boolean loop = false;
        do
        {
            System.out.println("\n\n\n");
            BowlingScores results = new BowlingScores();
            Scanner input = new Scanner(System.in);
            System.out.print("Would you like to process another set of bowler scores?"+
                    "\nPlease enter 'Y' to continue or 'N' to exit: ");
            char choice = input.next().charAt(0);
            loop = (choice=='Y' || choice=='y' || choice=='1');

        }while(loop);
    }
}

class BowlingScores
{
    Vector<Integer> scores = new Vector<>(1);
    int max;
    int min;
    int avg;

    public BowlingScores()
    {
        getScores();
        features();
        showstats();
    }

    public void getScores()
    {
        Scanner inp = new Scanner(System.in);
        for(int gameno=1; gameno<=6; gameno++)
        {
            System.out.print("Enter score for Game-"+gameno+": ");
            try
            {
                int score= inp.nextInt();
                if(score<0 || score>300)
                {
                    System.out.println("\nScore must be between 0 and 300.\nPlease try again.\n");
                    gameno--;
                }
                else
                    scores.add(score);
            }
            catch (InputMismatchException e)
            {
                gameno--;
                System.out.println("\nScores must be Numeric, Whole numbers only, no decimals.\nPlease Try Again.\n");
                inp.nextLine();
            }
        }
    }
    public void features()
    {
        min=scores.get(0);
        max=scores.get(0);
        int sum=0;
        avg=0;
        for(Integer i:scores)
        {
            sum+=i;
            if(i<min)
                min=i;
            if(i>max)
                max=i;
        }
        avg = (int)round((double)sum/6);
    }

    public void showstats()
    {
        System.out.println("\n\n\n\n=============================================================================");
        System.out.print("  ");
        for(int gameno=1; gameno<=6; gameno++)
            System.out.print("Game "+gameno+": "+scores.get(gameno-1)+"\t");
        System.out.println("\n=============================================================================");

        System.out.println("\nHighest Score: "+max);
        System.out.println("Lowest Score: "+min);
        System.out.println("Average Score: "+avg);
    }
}
