import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] res = new String[n];
        List<String> letterLog = new ArrayList<>(), digitLog = new ArrayList<>();
        for(String log : logs) {
            String[] tmp = log.split(" ");
            if (Character.isDigit(tmp[1].charAt(0)))
                digitLog.add(log);
            else letterLog.add(log);
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int index1 = a.indexOf(" "), index2 = b.indexOf(" ");
                return a.substring(index1 + 1).compareTo(b.substring(index2 + 1));
            }
        };
        letterLog.sort(cmp);
        int index = 0;
        for(String s : letterLog)
            res[index++] = s;
        for(String s : digitLog)
            res[index++] = s;
        return res;
    }
}
