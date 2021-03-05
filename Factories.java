//inner classes

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    public static ServiceFactory factory =
            new ServiceFactory() {
                public Service getService() {
                    return new Implementation1();
                }
            };

    private Implementation1() {
    }

    public void method1() {
        System.out.println("Implementation1 method1");
    }

    public void method2() {
        System.out.println("Implementation1 method2");
    }
}

class Implementation2 implements Service {
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementation2();
        }
    };

    private Implementation2() {
    }

    public void method1() {
        System.out.println("Implementation2 method1");
    }

    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

public class Factories {
    public static void serviceUser(ServiceFactory serFact) {
        Service ser = serFact.getService();
        ser.method1();
        ser.method2();
    }

    public static void main(String[] args) {
        serviceUser(Implementation1.factory);
        serviceUser(Implementation2.factory);
    }
}