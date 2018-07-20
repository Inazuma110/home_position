import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

class runCode{
  private String source;
  private int index = 0;
  private int now = 0;
  private byte[] inputSource;
  private int inputIndex = 0;
  Deque<Integer> whileIndex;

  // bf実行の際に利用する配列の初期化。配列のインデックスをメモリの値として扱う。
  int[] brainFuckList = new int[100000000];

  public runCode(String s){
    source = s;
    whileIndex = new ArrayDeque<>();
    for(int i = 0; i < brainFuckList.length; i++) brainFuckList[i] = 0;

    if(source.contains(",")) readInput();

    this.run();
  }

  public void run(){
    for (now = 4; now < source.length(); now++) {
      judgeOrder(source.substring(now, now+1));
    }
  }

  public void judgeOrder(String order){
    switch (order) {
      case "j":
        brainFuckList[index]++;
        break;
      case "k":
        brainFuckList[index]--;
        break;
      case "h":
        index--;
        break;
      case "l":
        index++;
        break;
      case "s":
        System.out.print((char)brainFuckList[index]);
        break;
      case "a":
        try{
          brainFuckList[index] = (int)inputSource[inputIndex];
          inputIndex++;
        }catch(Exception e){

        }
        break;
      case "d":
        whileIndex.addFirst(now);
        break;
      case "f":
        if(brainFuckList[index] > 0) now = whileIndex.peek();
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
