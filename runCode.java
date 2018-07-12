class runCode{
  private String source;
  private int index = 0;
  private int now = 0;
  // bf実行の際に利用する配列の初期化。配列のインデックスをメモリの値として扱う。
  int[] brainFuckList = new int[1024];

  public runCode(String s){
    source = s;
    // System.out.println(s);
    for(int i = 0; i < brainFuckList.length; i++) brainFuckList[i] = 0;
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
      default:
        break;
    }
  }
}
