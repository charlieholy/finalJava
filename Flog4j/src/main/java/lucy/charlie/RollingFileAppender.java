package lucy.charlie;

public class RollingFileAppender {

    static {
        System.out.println("new instance");
    }

    public RollingFileAppender(){
        System.out.println("Roll init");
    }

    public void foo(){
        System.out.println("foo");
    }
}
