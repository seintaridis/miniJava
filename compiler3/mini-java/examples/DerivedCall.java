class DerivedCall {
	public static void main(String[] x) {
		int i;
		B b;
		F f;
		f = new F();
		b = new B();
		i = f.foo(b);
		System.out.println(i);
	}
}

class A {
	int a;
}

class B extends A {
	int b;
}

class F {
	public int foo(A a) {
		if(true && true )
			System.out.println(5);
		else
		  System.out.println(3);
		return 0;
	}
}
