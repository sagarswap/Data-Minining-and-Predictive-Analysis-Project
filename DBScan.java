package project;
import java.io.*;
import java.util.Scanner;
public class DBScan 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new File("D:\\Programming\\NetBeans\\Codes\\Project\\src\\project\\output.txt"));
        int tran=scanner.nextInt();
        int attr=scanner.nextInt();
        int data[][]=new int[tran][attr];
        int ans[]=new int[tran];
        int i=0, j=0;
        while(scanner.hasNextInt())
        {
            data[i][j]=scanner.nextInt();
            j++;
            if(j==attr)
            {
                j=0;
                i++;
            }
        }
        
        System.out.print("Enter the radius :\t");
        int radius=Integer.parseInt(br.readLine());
        System.out.print("Enter min number of neighbours =\t");
        int neigh=Integer.parseInt(br.readLine());
    }
    
}
