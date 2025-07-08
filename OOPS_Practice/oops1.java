package OOPS_Practice;

// 1. circle

//class Circle {
//    public double radius;
//    public double perimeter(){
//        return 2*Math.PI*radius;
//    }
//    public double area(){
//        return Math.PI*radius*radius;
//    }
//}
//
//public class oops1 {
//    public static void main(String[] args) {
//        Circle c1 = new Circle();
//        c1.radius=34;
//        System.out.println("Perimeter of circle is " + c1.perimeter());
//        System.out.println("Area of circle is " + c1.area());
//    }
//}


// 2. Rectangle

//class Rectangle{
//    public double length;
//    public double breadth;
//    public double perimeter(){
//        if (isSquare()){
//        return 0;
//         }
//        return 2*(length+breadth);
//    }
//    public double area(){
//        if(isSquare()){
//        return 0;
//        }
//        return length*breadth;
//    }
//    public boolean isSquare(){
//        return length==breadth;
//    }
//}
//
//public class oops1{
//    public static void main(String[] args){
//        Rectangle r1 = new Rectangle();
//        r1.length=33.2;
//        r1.breadth=12.22;
//        System.out.println("perimeter: " + r1.perimeter());
//        System.out.println("area: " + r1.area());
//        System.out.println("isSquare: " + r1.isSquare());
//
//        Rectangle r2 = new Rectangle();
//        r2.length=33.2;
//        r2.breadth=33.2;
//        System.out.println("perimeter: " + r2.perimeter());
//        System.out.println("area: " + r2.area());
//        System.out.println("isSquare: " + r2.isSquare());
//    }
//}

// 3.Students

//class Students{
//    public int rollNo;
//    public String name;
//    public String course;
//    public double m1,m2,m3,m4;
//    public double total(){
//        return m1+m2+m3+m4;
//    }
//    public double average(){
//        return total()/4;
//    }
//    public char grade(){
//        if (average()>=70){
//            return 'A';
//        }
//        else if(average()<=60 && average()>=69){
//            return 'B';
//        }
//        else return 'C';
//    }
//    public String displayInfo(){
//        return name + " roll no: " + rollNo + " of branch" + course + " has scored an avg of " + average() + " and got grade " + grade();
//    }
//
//}
//
//public class oops1 {
//    public static void main(String[] args){
//        Students s1 = new Students();
//        s1.name = "ram";
//        s1.rollNo = 21;
//        s1.course = "cse";
//        s1.m1 = 60;
//        s1.m2 = 90;
//        s1.m3 = 87.5;
//        s1.m4 = 66.9;
//        System.out.println(s1.displayInfo());
//}
//
//        }
