package lambdasinaction.chapter01;

@FunctionalInterface
public interface Calculator {

    double calculate(int a, int b);

    public default int subtract(int a, int b) {
	return a - b;
    }

    public default int add(int a, int b) {
	return a + b;
    }

    @Override
    public String toString();
}
