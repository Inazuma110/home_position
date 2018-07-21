import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

class runCode{
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


  public runCode(String s){
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

  public void run(){
    // 全文字に対し文字列判定し、
    for (now = 4; now < source.length(); now++) {
      judgeOrder(source.substring(now, now+1));
    }
  }

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
      case "a":
        try{
          homePositionArray[index] = (int)inputSource[inputIndex];
          inputIndex++;
        }catch(Exception e){

        }
        break;
      case "d":
        whileIndex.addFirst(now);
        break;
      case "f":
        if(homePositionArray[index] > 0) now = whileIndex.peek();
        else whileIndex.removeFirst();
        break;
    }
  }

  public void readInput(){
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    try{
      inputSource = input.getBytes("US-ASCII");
    }catch (Exception e){

    }
  }
}
