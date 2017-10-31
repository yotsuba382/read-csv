import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class ReadCSV {
 
  public static void main(String[] args) {

    String[] string_csv = {"person1_a.csv","person1_i.csv","person1_u.csv",
                            "person2_a.csv","person2_i.csv","person2_u.csv"};

    int label = 0;
    for(int i=0; i<6 ; i++){
      try {

        File csv = new File(string_csv[i]); // CSVデータファイル
        
        if(i==3) label = 1; 
 
        BufferedReader br = new BufferedReader(new FileReader(csv));
 
        // 最終行まで読み込む
        String line = "";
        int count = 1;

        while ((line = br.readLine()) != null) {
 
        count = 1; 
          // 1行をデータの要素に分割
          StringTokenizer st = new StringTokenizer(line, ",");
 
          System.out.print(label+" "); //label
          while (st.hasMoreTokens()) {
            // 1行の各要素をスペース" "区切りで表示
            System.out.print(count+":"+st.nextToken()+" ");
            count++;
          }
          System.out.println();
        }
        br.close();
 
      } catch (FileNotFoundException e) {
        // Fileオブジェクト生成時の例外捕捉
        e.printStackTrace();
      } catch (IOException e) {
        // BufferedReaderオブジェクトのクローズ時の例外捕捉
        e.printStackTrace();
      }
    }
  }
}