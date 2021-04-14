import java.util.*;

public class Main{
  public int[][] group1;
  public int[][]  group2;
  private List<int[]> pairings = new ArrayList<int[]>();

  private boolean personINpairing(int a,int group){
    for (int x=0;x<pairings.size();x++){
      if (pairings.get(x)[group] == a) {return true;}
    }
    return false;
  }
  public Integer findPartner(int personB){
    for (int x=0;x<pairings.size();x++){
      if (pairings.get(x)[1] == personB) {
        return pairings.get(x)[0];
      }
    }
    return null;

  }
  public Integer findRanking(int personB, int personA){
    int rank = 0;
    for (int x : group2[personB]){
       if (x == personA){
         return rank;
       }
       rank += 1;
    }
    return null;
  }
  public void printPairings(){
    System.out.println("start");
    for (int[] x : pairings){
      System.out.println(Arrays.toString(x));
    }
  }
  public void go_through(){
    //int[] a = {1,1};
    //pairings.add(a);
    /*List<Integer> word2 = new ArrayList<Integer>();
    word2.add(2);
    for (int a: word2){
      System.out.println(a);
    }*/
    int rank_new;
    Integer crush_partner;
    int rank_old;
    int personA;
    int personB;
    int[] match = new int[2];
    while (pairings.size() < 2){
      personA = 0;
      System.out.println("new\n\n");
    for (int[] personARankings: group1){

      if(!personINpairing(personA,0)){
        System.out.println(personA);
        System.out.println(personINpairing(personA,0));
        personB = personARankings[0];
        System.out.println(personB);
        rank_new = findRanking(personB,personA);
        crush_partner = findPartner(personB);
        System.out.println(crush_partner);
        if (crush_partner != null){
          rank_old = findRanking(personB,crush_partner);
          if (rank_new < rank_old){
            group1[crush_partner] = Arrays.copyOfRange(personARankings, 1, group1[crush_partner].length);
            match[0] = crush_partner;
            match[1] = personB;
            pairings.remove(match);
            match[0] = personA;
            match[1] = personB;
            pairings.add(match);

          }else{
            group1[personA] = Arrays.copyOfRange(personARankings, 1, personARankings.length);
          }
        }else {
          printPairings();
          match[0] = personA;
          match[1] = personB;
          System.out.println("j");
          System.out.println(Arrays.toString(match));
          //System.out.println(Arrays.copyOfRange(match, 1, match.length));
          //System.out.println(Arrays.toString(match));
          pairings.add(match);
          printPairings();
        }

      }
      printPairings();
      personA += 1;
    }

    }

  }

  public Main(int[][] groupA, int[][] groupB){
    //int[] h = {1,2,3};
    //System.out.println(h.toString());

    group1 = groupA;
    group2 = groupB;
    go_through();
    pairings.clear();
    int[] match = new int[2];
    match = {1,2};
    //pairings.add(match);
    }
  public static void main(String args[]){
    int[][] myNum = {{1,0}, {1, 0}};
    Main obj = new Main(myNum, myNum);
    obj.printPairings();
    System.out.println(obj.personINpairing(1,0));


  }
}
