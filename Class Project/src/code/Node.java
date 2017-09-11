package code;

public class Node{
  private int cost;
  private int[] state;
  public Node(int c, int[] s){
    this.cost = c;
    this.state = s;
  }
  public int getCost(){
    return this.cost;
  }
  public int[] getState(){
    return this.state;
  }
}
