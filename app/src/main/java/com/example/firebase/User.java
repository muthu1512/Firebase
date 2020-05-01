package com.example.firebase;

public class User {
    String id,uname,uemail,upass,uConfirmpass;

    public User(){
    }

    public User(String id, String uname, String uemail, String upass, String uConfirmpass) {
        this.id = id;
        this.uname = uname;
        this.uemail = uemail;
        this.upass = upass;
        this.uConfirmpass = uConfirmpass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getuConfirmpass() {
        return uConfirmpass;
    }

    public void setuConfirmpass(String uConfirmpass) {
        this.uConfirmpass = uConfirmpass;
    }
}
