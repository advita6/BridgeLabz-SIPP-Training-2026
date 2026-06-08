public class VariableTypes{

    static int x;
    int y;


    static void m1(){
        System.out.println("m1");
        System.out.println(x);
    }

    void m2(){
        System.out.println("m2");
        System.out.println(x);
    }

    public static void main(String[] args){
        int x=10;
        int e=45;

        System.out.println(x);
        VariableTypes obj=new VariableTypes();
        System.out.println(obj.y);

        m1();
        obj.m2();
    }
}