package dating_office_lib;

import static dating_office_lib.User.*;


public class Main {
    private static final java.util.logging.Logger log = java.util.logging.Logger
            .getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {
        User user = new User("1","2","3","4","57","6","7", "67");
        user.write();
        User user1 = new User("2","3","4","6","5","6","7","8");
        user1.write();
        user.updateReqInt("32", "19");
        user1.updateInfo("222","222","222","222","222");
    }
}

