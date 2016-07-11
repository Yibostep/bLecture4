package enshu4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class OrderListLoader {
    private HashMap<String, String> item;
    
    public OrderListLoader(String fname) {
        FileReader fr;
        try {
        // 入力用のファイルリーダを生成
        fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
        System.out.println(fname + "がオープンできません。");
        return;
        }
        // 行単位で読み込むバッファ付きリーダを生成
        BufferedReader br = new BufferedReader(fr);
        String line;
        
        // 行単位で読み込むバッファ付きリーダを生成
        int [] value = new int[20];
        //List<Integer> value = new ArrayList<>();
        String [] name = new String [20];
        //List<String> name = new ArrayList<>();
        try {
            int j=0;
        while ((line = br.readLine()) != null) {
            int i=0;
            int k = j+1;
            if(line.startsWith(";"))continue;
            if(line.equals(""))continue;
            if(line.startsWith(" ")){
                String line_new = line.trim();
                int index = line_new.indexOf(" ");
                int len = line_new.length();
                int sub = line_new.length()-index;
                if(sub>1){
                    name[j] = line_new.substring(0,index);
                    value[k] = Integer.parseInt(line_new.substring(len-1,len));
                    i += 2;
                    j += 2;
                    continue;
                }
            }
            int index = line.indexOf(" ");
                int len = line.length();
                int sub = line.length()-index;
                name[j] = line.substring(0,index);
                value[k] = Integer.parseInt(line.substring(len-1,len));
                i += 2;
                j += 2;
        }
        br.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
        
        
        int k,l = 0;
        int sum = 0;
        for(int j=0; j<20; j+=2){
            int t=0;
            for(k=0; k<=(j/2); k++){
                if(name[j].equals(name[k])){
                t=1;
                l=k;
                }
            }
            
            if(name[j]==null){break;
            }else if(j==0){
                System.out.println(name[j]+ " x " + value[j+1]);
            }else if(t==1){
                System.out.println(name[j]+ " x " + (value[j+1]+value[l+1]));
            }else{
                System.out.println(name[j]+ " x " + value[j+1]);
                }
            }
        }
    

public static void main(String[] args) { 
    new OrderListLoader("test.txt");
}

}
