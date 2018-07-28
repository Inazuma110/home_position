import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

class RunCode{
  // Stirng型のソースコード
  private String source;
  // 現在地。配列の何番目にいるかを表す。
  private int index = 0;
  // ソースコードの何文字目を実行しているかを表す。
  private int now = 0;
  // 入力された文字列をASCII文字コードとして10進の数字に変換。
  private byte[] inputSource;
  // 読み込んだ文字の何文字目を利用するか。
  private int inputIndex = 0;
  // dが入力されたとき、その位置を保持。両端キューをスタックとして利用。
  Deque<Integer> whileIndex;
  // bf実行の際に利用する配列の初期化。配列のインデックスをメモリの値として扱う。
  int[] homePositionArray = new int[100000000];


  /**
   * 詠みこんだファイルの実行を行う。
   * ファイルを読み込み、runメソッドを実行する。
   * @param s ファイルから読み込んだ文字列。
   */
  public RunCode(String s){
    // Mainクラスより受け取ったファイルの文字列をsourceに保持。
    source = s;
    whileIndex = new ArrayDeque<>();
    // homePositionArrayを0で初期化。
    for(int i = 0; i < homePositionArray.length; i++) homePositionArray[i] = 0;
    // ソースコードにaが含まれているとき、readInputにより入力を受け取る。
    if(source.contains("a")) readInput();
    // プログラム実行
    this.run();
  }

  /**
   * ソースコードを1文字ずつ解析し実行する。
   */
  public void run(){
    // sourceの最初の4文字は"null"なのでそこは飛ばす。
    for (now = 4; now < source.length(); now++) {
      judgeOrder(source.substring(now, now+1));
    }
  }

  /**
   * 文字を判定して、文字によって操作を変更する。
   * @param order ソースコードのnow番目の文字。
   */
  public void judgeOrder(String order){
    switch (order) {
      case "j":
        homePositionArray[index]++;
        break;
      case "k":
        homePositionArray[index]--;
        break;
      case "h":
        index--;
        break;
      case "l":
        index++;
        break;
      case "s":
        System.out.print((char)homePositionArray[index]);
        break;
        // 読み取った文字をhomePositionArrayに代入する。
      case "a":
        try{
          homePositionArray[index] = (int)inputSource[inputIndex];
          inputIndex++;
        }catch(Exception e){
          // 処理なし
        }
        break;
        // whileIndexにdの位置を保存。
      case "d":
        whileIndex.addFirst(now);
        break;
      case "f":
        // 現在地のhomePositionArrayの値が0でなければnowの値をdの位置に変更し、ループ処理をする。
        if(homePositionArray[index] > 0) now = whileIndex.peek();
        // 0ならスタックから排除。
        else whileIndex.removeFirst();
        break;
    }
  }

  /**
   * 入力された文字をByte型に変換。
   */
  public void readInput(){
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    try{
      // 入力された文字をByte型に変換。
      inputSource = input.getBytes("US-ASCII");
    }catch (Exception e){
      // 処理なし
    }
  }
}
