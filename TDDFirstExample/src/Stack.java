
public class Stack {
	private int size = 0;
	private int[] values = new int[2];

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {
		values[size++] = i;
	}

	public int pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return values[--size];
	}
	
	public int getSize(){
		return size;
		}

	public void clear() throws EmptyStackException{
		int k = getSize();
		
		if (isEmpty()){
			throw new EmptyStackException();
			}
		else {
			for(int i=0;i<k;i++)
				{
				pop();
				}

		}
	}
}
