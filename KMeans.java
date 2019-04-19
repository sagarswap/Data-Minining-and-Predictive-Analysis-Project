package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class KMeans {
    static int attr, num;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        double d1, d2;       
        int chk=1;
        int finalstop=0;
        Scanner scanner = new Scanner(new File("D:\\Programming\\NetBeans\\Codes\\Project\\src\\project\\output.txt"));
        num=scanner.nextInt();
        attr=scanner.nextInt();
        int clust=scanner.nextInt();
        int ans[]=new int[num];
        int data[][]=new int[num][attr];
        for(int i=0;i<num;i++)
            for(int j=0;j<attr;j++)
                data[i][j]=scanner.nextInt();
        
        double cent[][]=new double[clust][attr];
        
        int pans[]=new int[num];
        for(int i=0;i<num;i++)
            pans[i]=0;
        for(int i=0;i<clust;i++) 
            for(int j=0;j<attr;j++)
                cent[i][j]=(double)data[i][j];
        long start=System.nanoTime();  
        while(chk!=0 && finalstop<1000)
        {
            chk=0;
            for(int i=0;i<num;i++) //finds which centroid each point belongs to
            {
                double mindist=100000.0;
                int clust_ans=0;
                for(int j=0;j<clust;j++)
                {
                    double dist=0.0;
                    for(int k=0;k<attr;k++)
                        dist=dist+Math.abs(Math.pow(cent[j][k], 2)-Math.pow(data[i][k], 2));
                    dist=Math.abs(Math.sqrt(dist));
                    if(mindist>dist)
                    {
                        mindist=dist;
                        clust_ans=j+1;
                    }
                }
                ans[i]=clust_ans;
            }
            for(int i=0;i<num;i++)
            {
                if(ans[i]!=pans[i])
                    chk++;
                    
            }     
            //compute new values for centroids
            for(int i=0;i<clust;i++)
                for(int j=0;j<attr;j++)
                    cent[i][j]=0.0;
            int clust_count[]=new int[clust];
            Arrays.fill(clust_count, 0);
            for(int i=0;i<num;i++)
            {
                //System.out.print(ans[i]+" ");
                clust_count[ans[i]-1]++;
                for(int j=0;j<attr;j++)
                {
                    cent[ans[i]-1][j]+=data[i][j];
                }
            }
            for(int i=0;i<clust;i++)
                for(int j=0;j<attr;j++)
                    cent[i][j]/=clust_count[i];
            
            if(chk!=0)
                pans=Arrays.copyOf(ans, ans.length);
            else
                break;
        }
        long stop=System.nanoTime();
        for(int i=0;i<num;i++)
            System.out.println(ans[i]);
        long timeElapsed=(stop-start)/1000000;
        System.out.println("\nTime elapsed = "+timeElapsed+"milli sec");
    }   
}
