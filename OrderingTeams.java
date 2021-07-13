import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class OrderingTeams {
    public static void main(String[] a) throws IOException {
        FastReader reader=new FastReader();
        int n=reader.nextInt();
        for(int i=0;i<n;i++){
            int[][]team=new int[3][3];
            for(int j=0;j<9;j++){
                team[j/3][j%3]=reader.nextInt();
            }
            if(help(team)) System.out.println("yes");
            else System.out.println("no");
        }
        
    }
    public static boolean help(int[][]team){
        Arrays.sort(team, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else if(o1[1]!=o2[1]) return o1[1]-o2[1];
                else return o1[2]-o2[2];
            }
        });
        for(int i=1;i<3;i++){
            if(team[i][0]==team[i-1][0]){
                if(team[i][1]<team[i-1][1]||team[i][2]<team[i-1][2])
                    return false;
                else if(team[i][1]==team[i-1][1]&&team[i][2]==team[i-1][2]) return false;
            }
            else{
                if(team[i][1]<team[i-1][1]||team[i][2]<team[i-1][2])
                    return false;
            }
        }
        return true;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}