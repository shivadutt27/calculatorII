import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Calculator {
  private double num1;
  private double num2;
  private String operator;
  private double result;

  private List<String> lists = new ArrayList<>();
  // private List<String> operators = new ArrayList<>();

  public Calculator() {
    this.result = 0.0;
  }

  private boolean checkNums(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException ex) {
      System.out.println("Invalid Number");
      return false;
    }

  }

  public void performOperation(String str) {
    lists.add(str);
  }

  public double getResults() {
    for (int i = 0; i < lists.size(); i++) {
      while (lists.contains("*")) {
        int getIdx = lists.indexOf("*") - 1;
        int getIdx2 = lists.indexOf("*") +1;
        System.out.println("num1:"+lists.get(lists.indexOf("*") - 1));
        System.out.println("num2:"+lists.get(lists.indexOf("*") + 1));
        num1 = Double.parseDouble(lists.get(lists.indexOf("*") - 1));
        num2 = Double.parseDouble(lists.get(lists.indexOf("*") + 1));
        result = num1 * num2;
        System.out.println("result:"+result+"\n");
        //lists.remove(lists.indexOf("*") -1);
        lists.set(getIdx, String.valueOf(result));
        lists.remove(getIdx2);
        lists.remove(lists.indexOf("*"));
        
        //lists.add(getIdx, String.valueOf(result));
        
      }

      for(String s: lists)
        {System.out.println(s);}
      while (lists.contains("+")) {
        int getIdx = lists.indexOf("+") - 1;
        int getIdx2 = lists.indexOf("+") + 1;
        num1 = Double.parseDouble(lists.get(lists.indexOf("+") - 1));
        num2 = Double.parseDouble(lists.get(lists.indexOf("+") + 1));
        result= num1 + num2;
        lists.set(getIdx, String.valueOf(result));
        lists.remove(getIdx2);
        lists.remove(lists.indexOf("+"));
      }
    }

    return result;
  }

}