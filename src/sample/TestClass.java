package sample;

public class TestClass {
    @Save
    private char ch;
    @Save
    public String str;
    @Save
    boolean fla;

    private int number;

    public TestClass(char ch, String str, boolean fla, int number) {
        this.ch = ch;
        this.str = str;
        this.fla = fla;
        this.number = number;
    }

    public TestClass() {
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isFla() {
        return fla;
    }

    public void setFla(boolean fla) {
        this.fla = fla;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "ch=" + ch +
                ", str='" + str + '\'' +
                ", fla=" + fla +
                ", number=" + number +
                '}';
    }
}
