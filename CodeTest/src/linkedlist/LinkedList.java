package linkedlist;

public class LinkedList<E> {
	
	/**
     * Not exactly the best object orientation, but we'll manage
     */
    static <E> E deleteNode(LinkedListNode<E> node) {
        if(node == null || node.getNext() == null) return null;

        E retval = node.getData();
        LinkedListNode<E> next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext()); 
        return retval;
    }

    public LinkedListNode<E> getHead() {
		return head;
	}

	public void setHead(LinkedListNode<E> head) {
		this.head = head;
	}

	public LinkedListNode<E> getTail() {
		return tail;
	}

	public void setTail(LinkedListNode<E> tail) {
		this.tail = tail;
	}



	private LinkedListNode<E> head;
    private LinkedListNode<E> tail;

    public LinkedList() {
        this.head = new LinkedListNode<E>();
        this.tail = new LinkedListNode<E>();
        head.setNext(tail);
    }

    public void addLast(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null
        tail.setData(e);
        tail.setNext(node);
        tail = node;
    }
    
    

    public void addFirst(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null;
        node.setNext(head.getNext());;
        node.setData(e); 
        head.setNext(node);
    }

    public E deleteFirst() {
        LinkedListNode<E> first = head.getNext();
        head.setNext(first.getNext());
        return first.getData();
    }

    public E deleteLast() {
        // cannot do without iteration of the list! :-(
        throw new UnsupportedOperationException();
    }

    public LinkedListNode<E> findFirst(E e) {
        LinkedListNode<E> curr = head.getNext();
        while(curr != null) {
            if(curr.getData() != null && curr.getData().equals(e)) return curr;
            curr = curr.getNext();
        }
        return null;
    }

    public void print() {
        LinkedListNode<E> curr = head.getNext();
        while(curr.getNext() != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }
    

    public void print(LinkedListNode<E> head) {
        LinkedListNode<E> curr = head.getNext();
        while(curr.getNext() != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addLast("Apple");
        list.addLast("Bear");
        list.addLast("Chair");
        list.addLast("Dirt");

        //list.print();

        LinkedListNode<String> bear = list.findFirst("Bear");
        deleteNode(bear);

        list.print();
    }

}
