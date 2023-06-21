import java.util.*;

public class Main {
    public static void main(String[] args) {

        String data ="hree rings for the Elven-kings under the sky,\n" +
                "Seven for the Dwarf-lords in their halls of stone,\n" +
                "Nine for mortal men doomed to die,\n" +
                "One for the Dark Lord on his dark throne;\n" +
                "In the Land of Mordor where the shadows lie.\n" +
                " \n" +
                "One ring to rule them all, one ring to find them,\n" +
                "One ring to bring them all, and in the darkness bind them;\n" +
                "In the Land of Mordor where the shadows lie.";
        Map<String, HashMap<Character,Integer>> map =new HashMap<>();
        int n=1;
        for(int i=0 ; i<data.length()-n;i++){
            if(!map.containsKey(data.substring(i,i+n-1))){
                HashMap<Character,Integer> tempHashMap= new HashMap<>();
                tempHashMap.put(data.charAt(i+n),1);
                map.put(data.substring(i,i+n-1),tempHashMap);
            }
            else{
                if(map.get(data.substring(i,i+n-1)).containsKey(data.charAt(i+n)))
                map.get(data.substring(i,i+n-1)).put(data.charAt(i+n), map.get(data.substring(i,i+n-1)).get(data.charAt(i+n)) + 1);
                else
                    map.get(data.substring(i,i+n-1)).put(data.charAt(i+n),1);


            }
        }

        String test =data;
        for (int i= 0 ; i<50;i++){
            int max = Collections.max(map.get(test.substring(test.length()-n,test.length()-1)).values());
            List<Character> keys = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : map.get(test.substring(test.length()-n,test.length()-1)).entrySet()) {
                if (entry.getValue()==max) {
                    keys.add(entry.getKey());
                }
                int temp=0;
                if(keys.size()>1){
                     temp= (int) (Math.random()*100%keys.size());
                }
                if(keys.size()==0){
                    char tempChar= (char) (Math.random()%'z'+'a');
                    test = test + tempChar;
                }
                else
                    test = test +keys.get(temp);
            }
        }
        System.out.println(test);

    }
}