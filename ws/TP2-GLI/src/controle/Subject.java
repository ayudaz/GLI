package controle;

public interface Subject {
	public void addObserver(Observer o);

	public void notifier();
}
