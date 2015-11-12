// test20: more inheritance
//
// correct output: 999

class test20 {
    public static void main(String[] args) {
        System.out.println(new C23().init(new B23()));
    }
}

class A23 {
    int i1;
    int i2;
    int i3;

    public int init(A23 a) {

        i2 = a.getI1();

        System.out.println(1111);
        i3 = 222;
        i1 = this.setI1(i2 + i3);
        System.out.println(i1);
        return i1;
    }

    public int getI1() {

        return i1;
    }

    public int setI1(int i) {
        System.out.println(786565);
        return i;
    }
}

class B23 extends A23 {
    int i1;
    int i4;

    public int init(A23 a) {

        A23 a_local;
        System.out.println(3333);
        a_local = new A23();
        System.out.println(3333);
        i4 = a.getI1();
        System.out.println(999999);
        System.out.println(i4);
        i1 = this.setI1(i4);
        return a_local.init(this);//111
    }

    public int getI1() {

        return i1;
    }

    public int setI1(int i) {
      System.out.println(77777);
        return i + 111;
    }
}

class C23 extends B23 {
    int i1;
    int i5;

    public int init(A23 a) {
        i5 = 333;
        System.out.println(1111111);
        i1 = this.setI1(i5);
        System.out.println(i1);
        return a.init(this);
    }

    public int getI1() {
        System.out.println(99999);
        return i1;
    }

    public int setI1(int i) {
        System.out.println(22222);

        return i*2;
    }
}
