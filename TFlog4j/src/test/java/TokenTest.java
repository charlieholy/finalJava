import org.junit.Test;

import java.util.StringTokenizer;

public class TokenTest {
    @Test
    public void foo(){
        String value = "INFO,stdio";
        StringTokenizer st = new StringTokenizer(value, ",");
        while (st.hasMoreTokens()){
            String n = st.nextToken();
            if(n != null)
            System.out.println(n);
        }

    }
}
