package lab9.prob12;
import java.util.Optional;

public class MySingletonOfNullable {
	private static MySingletonOfNullable instance = null;
    public static int counter = 0;
	private MySingletonOfNullable() {
        counter++;
	}
	//Uses ofNullable in place of null checks
	public static MySingletonOfNullable getInstance() {
		return Optional.ofNullable(instance).orElseGet(MySingletonOfNullable::init);
	}

	private static MySingletonOfNullable init() {
		instance = new MySingletonOfNullable();
		return instance;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			getInstance();
            System.out.println(MySingletonOfNullable.counter);
        }

	}
}
