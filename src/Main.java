import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MyFileScanner scanner = new MyFileScanner("input.txt");
        ArrayList<String> lines = scanner.getLines();
        String steps = lines.get(0);
        Integer[] leftOrRight = new Integer[steps.length()];
        int counter = 0;
        for(char c : steps.toCharArray()){
            if(c == 'L') {
                leftOrRight[counter] = 0;
            } else {
                leftOrRight[counter] = 1;
            }
            counter++;
        }
        //System.out.println(steps);

        HashMap<String, String[]> map = new HashMap<>();
        for(int i = 2; i < lines.size(); i++){
            String[] splitLine = lines.get(i).split(" = |\\(|, |\\)");
            map.put(splitLine[0], new String[]{splitLine[2], splitLine[3]});
        }
        /*
        for( Map.Entry<String, String[]> element : map.entrySet()){
            System.out.println(element.getKey() + ": (" + element.getValue()[0] + ", " + element.getValue()[1] + ")");
        }*/
        String result = "AAA";
        int counterForResults = 0;
        int counterForSteps = 0;
        while(!Objects.equals(result, "ZZZ")) {
            result = map.get(result)[leftOrRight[counterForSteps]];
            counterForResults++;
            if(counterForSteps < leftOrRight.length - 1){
                counterForSteps++;
            } else {
                counterForSteps = 0;
            }
        }

        System.out.println("Result is: " + counterForResults + " steps");
    }
}