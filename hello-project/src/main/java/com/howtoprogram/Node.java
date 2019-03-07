package com.howtoprogram;

public class Node<T> {
	private T data;
	private Node<T> nextNode;

	public Node(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return nextNode;
	}

	public void setNext(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
