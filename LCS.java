
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author Shubham
 */
public class LCS {
    private class Cell{
       int value;
       char direction;
    } 
    char a[],b[];
    Cell c[][];
    public LCS() {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter string A:");
        String A=in.next();
        System.out.println("Enter string B:");
        String B=in.next();
        a=("0"+A).toCharArray();
        b=("0"+B).toCharArray();
        c=new Cell[a.length][b.length];
        for(int i=0;i<a.length;i++){
        for(int j=0;j<b.length;j++){
        c[i][j]=new Cell();
        }
        }
        lcs();
        displayC();
        System.out.println();
        printLCS(a.length-1,b.length-1);
    }
    void lcs(String A,String B) {
        a=(A).toCharArray();
        b=(B).toCharArray();
        c=new Cell[a.length][b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                c[i][j]=new Cell();
            }
        } 
        lcs();
        System.out.println("Length1="+A.length()+" Length2="+B.length());
        System.out.println("LCS length="+c[a.length-1][b.length-1].value);
    }
    void lcs(){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]=='0' || b[j]=='0'){
                    c[i][j].value=0;
                    c[i][j].direction='H';
                }else{
                    if(a[i]!=b[j]){
                        c[i][j].value=Integer.max(c[i-1][j].value,c[i][j-1].value);
                        if(c[i-1][j].value>=c[i][j-1].value){
                            c[i][j].direction='U';
                        }else{
                            c[i][j].direction='S';
                        }
                    }else{
                        c[i][j].value=c[i-1][j-1].value+1;
                        c[i][j].direction='D';
                    }
                }
            }
        }
    }
    void printLCS(int i,int j){
        if(i==0||j==0)
            return;
        if(c[i][j].direction=='D'){
            printLCS(i-1,j-1);
            System.out.print(a[i]);
        }else{
            if(c[i][j].direction=='U')
                printLCS(i-1,j);
            else
                printLCS(i,j-1);
        }
    }
    void displayC(){
        System.out.println();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++)
                System.out.print("["+c[i][j].value+"/"+c[i][j].direction+"]"+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new LCS();
    }
}
