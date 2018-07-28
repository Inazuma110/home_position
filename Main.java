import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main{
  public static void main(String[] args){
    // 別ファイルのソースコードを保存するためのString型変数。
    String sourceCode = null;

    // ファイルを受け取る。
    try{
      File file = null;
      // ファイル名が入力されてないときの処理
      if(args.length == 1)
        file = new File("./" + args[0]);
      else{
        System.out.println("ファイル名の入力が正しくありません。");
        System.exit(0);
      }
      // ファイルがあるかないかで分岐.
      if(file.exists()){
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String sourceLine;
        // ソースコードを読み取る。
        while((sourceLine = br.readLine()) != null) sourceCode += sourceLine;
        fr.close();
      }else{
        // ファイル名が正しくないときの処理。
        System.out.println("ファイルが見つかりませんでした。");
        System.exit(0);
      }
      // 例外
    }catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // runCodeインスタンスを作成。
    RunCode rc = new RunCode(sourceCode);
  }
}
