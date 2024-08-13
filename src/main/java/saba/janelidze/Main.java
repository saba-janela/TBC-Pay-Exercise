package saba.janelidze;


public class Main {

    public static void main(String[] args) throws Exception {
        Startup.startup();

        Testing.testing();

        Cleanup.cleanup();
    }
}
