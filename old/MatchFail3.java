public class Main{
  public int[][] group1;
  public int[][]  group2;
  private List<List<Integer>> pairings = new ArrayList<List<Integer>>();

  private boolean personINpairing(int a,int group){
    for (int x=0;x<pairings.size();x++){
      if (pairings.get(x).get(group) == a) {return true;}
    }
    return false;
  }
  public Integer findPartner(int personB){
    for (int x=0;x<pairings.size();x++){
      if (pairings.get(x).get(1) == personB) {
        return pairings.get(x).get(0);
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
      System.out.println(x);
    }
  }
  public void go_through(){
    int rank_new;
    Integer crush_partner;
    int rank_old;
    int personA;
    int personB;
    int[] match = new int[2];
    while (pairings.size() < 2){
      personA = 0;
    for (int[] personARankings: group1){

      if(!personINpairing(personA,0)){

        personB = personARankings[0];
        rank_new = findRanking(personB,personA);
        crush_partner = findPartner(personB);
        if (crush_partner != null){
          rank_old = findRanking(personB,crush_partner);
          if (rank_new < rank_old){
            group1[crush_partner] = Arrays.copyOfRange(personARankings, 1, group1[crush_partner].length);
            pairings.remove(Lists.newArrayList(crush_partner,personB));
            pairings.add(Lists.newArrayList(personA,personB));
          }else{
            group1[personA] = Arrays.copyOfRange(personARankings, 1, personARankings.length);
          }
        }else {
          printPairings();
          pairings.add(Lists.newArrayList(personA,personB));
          printPairings();
        }

      }
      printPairings();
      personA += 1;
    }

    }

  }

  public Main(int[][] groupA, int[][] groupB){


    group1 = groupA;
    group2 = groupB;
    go_through();

    }
  public static void main(String args[]){
    int[][] myNum = {{1,0}, {1, 0}};
    Main obj = new Main(myNum, myNum);
    obj.printPairings();
    System.out.println(obj.personINpairing(1,0));


  }
}
