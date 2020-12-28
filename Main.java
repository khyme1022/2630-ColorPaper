import java.util.*;
import java.io.*;

class Main {
  public static int[][] arr;
  public static int w_cnt=0;
  public static int b_cnt=0;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    StringTokenizer st;
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0;j<N;j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    square(0,0,N,N);
    System.out.print(w_cnt+"\n"+b_cnt);
  }
  public static void square(int x1,int y1,int x2,int y2){
    boolean tf = true;
    for(int i=x1;i<x2;i++){
      if(!tf) break;
      for(int j=y1;j<y2;j++){
        if(!tf) break;
        if(arr[i][j]!=arr[x1][y1]) tf=false;
      }
    }
    if(tf&&arr[x1][y1]==1) b_cnt++;
    else if(tf&&arr[x1][y1]==0) w_cnt++;
    else {
      int x = (x1+x2)/2;
      int y = (y1+y2)/2;
      square(x1,y1,x,y);
      square(x1,y,x,y2);
      square(x,y1,x2,y);
      square(x,y,x2,y2);
    }
  }
}