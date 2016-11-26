package duotai;
//关于多态的一些理解与看法
//什么是多态
//多态的运行过程是怎样
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    } 

}






