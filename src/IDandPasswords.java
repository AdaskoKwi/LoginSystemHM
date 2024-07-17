import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDandPasswords(){
        logininfo.put("Adam","Java");
        logininfo.put("Janek","OpelInsignia");
        logininfo.put("Karolina","H&M");
    }
    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
