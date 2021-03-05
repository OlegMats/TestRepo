//updates short variant of Factories.java
//small refactoring of some methods
interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation_B1 implements Service { // here you can see the first amend

    Implementation_B1() {
    }

    public void method1() {
        System.out.println("Implementation1 method1");
    }

    public void method2() {
        System.out.println("Implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation_B1();
    }
}

class Implementation_B2 implements Service { // another one change _ -> _B

    Implementation_B2() {
    }

    public void method1() {
        System.out.println("Implementation2 method1");
    }

    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation_B2();
    }
}
public class Factories {
    public static void serviceConsumer(ServiceFactory serFact) {
        Service ser = serFact.getService();
        ser.method1();
        ser.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation_B1Factory());  // finally main
        serviceConsumer(new Implementation_B2Factory());
    }
    // the end
}