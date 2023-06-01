package yuanyouzi.entity;


import lombok.Data;

@Data
public class User  {
    private long id;

    private String  password;

    private int p1;

    private int p2;

    private int state;

    private int state1;

    private int state2;

    private int state3;

    private int state4;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public int getState2() {
        return state2;
    }

    public void setState2(int state2) {
        this.state2 = state2;
    }

    public int getState3() {
        return state3;
    }

    public void setState3(int state3) {
        this.state3 = state3;
    }

    public int getState4() {
        return state4;
    }

    public void setState4(int state4) {
        this.state4 = state4;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }


}
