import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        String[] list = { "lolo", "A", "909", "<;>", "tata", "." };

        for (String str : decode(encode(Arrays.asList(list)))) {
            System.out.println(str);
        }

    }

    public static String encode(List<String> list) {

        String out = "";

        for (String string : list) {
            out = out + string.length() + "<" + string;
        }

        return out;
    }

    public static List<String> decode(String str) {

        List<String> out = new ArrayList<>();
        String newString = "";
        boolean hasString = true;
        int separatorIndex = 0;
        int blockStartIndex = 0;
        int stringSize = 0;

        if (str.length() < 3)
            return out;

        while (hasString) {
            separatorIndex = str.indexOf("<", blockStartIndex);
            stringSize = Integer.parseInt(str.substring(blockStartIndex, separatorIndex));
            newString = str.substring(separatorIndex + 1, separatorIndex + 1 + stringSize);
            out.add(newString);

            if (str.length() < separatorIndex + stringSize + 3) {
                hasString = false;
            } else {
                blockStartIndex = separatorIndex + stringSize + 1;
            }
        }
        return out;
    }
}
