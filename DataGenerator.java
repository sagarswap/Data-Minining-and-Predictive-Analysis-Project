package project;
import java.io.*;
import java.util.Random;

public class DataGenerator 
{
    public static void main(String Args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Random rand=new Random();
        FileWriter writer = new FileWriter("D:\\Programming\\NetBeans\\Codes\\Project\\src\\project\\output.txt");  
        BufferedWriter bw = new BufferedWriter(writer);  
        System.out.print("Enter number of atrributes :\t");
        int attr=Integer.parseInt(br.readLine()); //stores number of attributes
        System.out.print("Enter number of transactions :\t");
        int tran=Integer.parseInt(br.readLine()); //stores number of transactions
        System.out.print("Enter skewness :\t");
        int skew=Integer.parseInt(br.readLine()); 
//stores the upper limit of the dataset, increasing its value without increasing 'tran' will reduce the density of points
        System.out.print("Enter number of potential clusters :\t");
        int clus=Integer.parseInt(br.readLine()); //stores number of clusters to be present in dataset
        bw.write(tran+" "+ attr+" "+clus+   "\n");
        long data[][]=new long[tran][attr];
        int adder=skew/clus;
        int base=0;
        int itemchecker=tran/clus;
        for(int i=0, k=0;i<tran;i++, k++)
        {
            String str=new String();
            if(k==itemchecker)
            {
                k=0;
                base+=adder;
            }
            for(int j=0;j<attr;j++)
            {
                data[i][j]=base+rand.nextInt(adder);
                str=str+data[i][j]+" ";
            }
            str=str+"\n";
            bw.write(str);
        }
        bw.flush();
        bw.close();
    }
}
