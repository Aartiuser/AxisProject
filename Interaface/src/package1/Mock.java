package package1;

import java.util.*;

public class Mock {
    public static void main(String[] args) {
        String str;
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        String s[] = str.split(",");
        int num[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            num[i] = Integer.parseInt(s[i]);
        ArrayList arr=new ArrayList();
        for (int i = 0; i < s.length; i++)
            arr.add(num[i]);
        Set st=new LinkedHashSet();
        st.addAll(arr);
        arr.clear();
        arr.addAll(st);
            System.out.print(arr);
    }
}

