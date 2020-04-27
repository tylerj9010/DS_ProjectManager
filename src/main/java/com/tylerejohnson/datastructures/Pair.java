/**PAIR CLASS TO HOLD <KEY, TASK> for heap**/
package com.tylerejohnson.datastructures;

public class Pair<Key extends Comparable<Key>, Value> {
	Key key;
	Value value;
	
	public Pair() {
		
	}
	
	public Pair(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
}
