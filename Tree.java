package arvorebinaria;

public interface Tree {

	public boolean insert(int x);
	public boolean remove(int x);
	public boolean contains(int x);
	public int size();
	public int height();
}
