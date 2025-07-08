package OOPS_Practice;

// data hiding

//class Rectangle{
//    private int length;
//    private int breadth;
//    public int getLength(){
//        return length;
//    }
//    public void setLength(int l){
//        length = l;
//    }
//    public int getBreadth(){
//        return breadth;
//    }
//    public void setBreadth(int b){
//        breadth = b;
//    }
//    public int area(){
//        return length*breadth;
//    }
//}
//
//public class oops2 {
//    public static void main(String[] args) {
//        Rectangle r1 = new Rectangle();
//        r1.setLength(34);
//        r1.setBreadth(2);
//        System.out.println(r1.area());
//    }
//}

// Constructors

class Rectangle{
    private int Length;
    private int Breadth;

    public int getLength() {
        return Length;
    }
    public int getBreadth(){
        return Breadth;
    }
    public Rectangle(){
        Length = 5;
        Breadth = 8;
    }
    public Rectangle(int l,int b){
        Length = l;
        Breadth = b;
    }
    public Rectangle(int s){
        Length=Breadth=s;
    }

}

public class oops2{
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5);
        System.out.println(r1.getLength());
        System.out.println(r1.getBreadth());
    }
}
