import java.util.Scanner;

class runCode{
  private String source;
  private int index = 0;
  private int now = 0;
  private byte[] inputSource;
  private int inputIndex = 0;

  // bf実行の際に利用する配列の初期化。配列のインデックスをメモリの値として扱う。
  int[] brainFuckList = new int[1024];

  public runCode(String s){
    source = s;
    for(int i = 0; i < brainFuckList.length; i++) brainFuckList[i] = 0;

    if(source.contains(",")) readInput();

    this.run();
  }

  public void run(){
    for (int i = 4; i < source.length(); i++) {
      judgeOrder(source.substring(i, i+1));
    }
  }

  public void judgeOrder(String order){
    switch (order) {
      case "+":
        brainFuckList[index]++;
        break;
      case "-":
        brainFuckList[index]--;
        break;
      case "<":
        index--;
        break;
      case ">":
        index++;
        break;
      case ".":
        System.out.print((char)brainFuckList[index]);
        break;
      case ",":
        try{
          brainFuckList[index] = (int)inputSource[inputIndex];
          inputIndex++;
        }catch(Exception e){

        }
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
