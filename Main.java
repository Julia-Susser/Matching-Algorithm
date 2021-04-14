import java.util.*;

public class Main{
  public int[][] group1;
  public int[][]  group2;
  private Integer[][] pairings = new Integer[2][2];

  private boolean personINpairing(Integer personA){
    for (int x=0;x<pairings.length;x++){
      if (pairings[x][0] == personA) {
        return true;
      }
    }
    return false;
  }


  public Integer findPartner(Integer personB){
    for (Integer x=0;x<pairings.length;x++){
      if (pairings[x][1] == personB) {return pairings[x][0];}
    }
    return null;
  }


  public Integer numMatches(){
    Integer num = 0;
    for (Integer[] x: pairings){
      if (x[1]!= null){
        num +=1;
      }
    }
    return num;
  }



  public Integer findRanking(int personB, int personA){
    int rank = 0;
    for (int x : group2[personB]){
       if (x == personA) { return rank; }
       rank += 1;
    }
    return null;
  }

  public void printPairings(){
    System.out.println("start");
    for (Integer[] x : pairings){
      System.out.println(Arrays.toString(x));
    }
  }

  public void go_through(){
    int rank_new;
    Integer crush_partner;
    int rank_old;
    int personA;
    int personB;
    Integer[] match = new Integer[2];
    while (numMatches() < group1.length){
    personA = 0;

    for (int[] personARankings: group1){

      if(!personINpairing(personA)){
        personB = personARankings[0];
        rank_new = findRanking(personB,personA);
        crush_partner = findPartner(personB);

        if (crush_partner != null){
          rank_old = findRanking(personB,crush_partner);
          if (rank_new < rank_old){
            group1[crush_partner] = Arrays.copyOfRange(personARankings, 1, group1[crush_partner].length);
            match = new Integer[2];
            match[0] = null;
            match[1] = null;
            pairings[crush_partner] = match;

            match = new Integer[2];
            match[0] = personA;
            match[1] = personB;
            pairings[personA] = match;



          }else{
            group1[personA] = Arrays.copyOfRange(personARankings, 1, personARankings.length);
          }
        }else {
          match = new Integer[2];
          match[0] = 0;
          match[1] = 1;
          pairings[personA] = match;

        }

      }

      personA += 1;
    }
    }

  }


  public Main(int[][] groupA, int[][] groupB, int chooser){
      group1 = groupA;
      group2 = groupB;
      public int choosers = chooser;
      go_through();

    }



  public static void main(String args[]){
    int[][] myNum = {{1,0}, {1, 0}};
    Main obj = new Main(myNum, myNum,0);
    obj.printPairings();

  }
}
