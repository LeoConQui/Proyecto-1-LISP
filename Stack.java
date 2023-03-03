public class Stack<T> implements IStack<T> {
    private Node<T> top;
	int count;
	
	public Stack() {
		top = null;
		count = 0;
	}
	
	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count() == 0;
	}

	@Override
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		
		count++;
	}

    @Override
    public T top() {
        if (isEmpty()) {
			return null;
		} else {
			return top.getValue();
		}
    }

    @Override
    public T pop() {
        if (isEmpty()) {
			return null;
		} else {
			Node<T> temp = top;
			top = top.getNext();
			count--;
			
			return temp.getValue();
		}
    }

    @Override
    public T set() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    
}
