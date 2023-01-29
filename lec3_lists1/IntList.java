package lec3_lists1;

public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) { return this.first;}
		return this.rest.get(i -1);
	}
	public IntList reverse() {
		IntList reversed = null;
		IntList current = this;
		while (current != null) {
			reversed = new IntList(current.first, reversed);
			current = current.rest;
		}
		return reversed;
	}
	public IntList recursiveReverse(IntList current, IntList reversed){
		if (current == null) {return reversed;}
		return recursiveReverse(current.rest, new IntList(current.first, reversed));
	}
	public IntList recursiveReverse(){
		return recursiveReverse(this, null);
	}
	public boolean contains(int i) {
		if (rest == null) {return first == i;}
		return first == i || rest.contains(i);
	}
	public String toString() {
		if (rest == null) {
			return Integer.toString(first);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		sb.append("->");
		sb.append(rest);
		return sb.toString();
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L);
		System.out.println(L.contains(12));
	}
} 