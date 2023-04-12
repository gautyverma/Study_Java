package next.com_2_Interface;

@FunctionalInterface
public interface Operation<T> {

  T operate(T value1, T value2);
}
