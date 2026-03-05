import java.util.Scanner;
public class StringEditing{
    public static int edit(String x,String y){
        int n=x.length();
        int m=y.length();
        int[][] c=new int[n+1][m+1];
        c[0][0]=0;
        for(int i=1;i<=n;i++){
            c[i][0]=c[i-1][0]+1;
        }
        for(int j=1;j<=m;j++){
           c[0][j]=c[0][j-1]+1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1)==y.charAt(j-1)) c[i][j]=c[i-1][j-1];
                else c[i][j]=1+Math.min(c[i-1][j],Math.min(c[i-1][j-1],c[i][j-1]));
            }
        }
        return c[n][m];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string to change :");
        String x=sc.next();
        System.out.print("Enter the final word:");
        String y=sc.next();
        System.out.println("The minimum cost to convert "+x+" to "+y+" is "+edit(x,y));
    }
}
