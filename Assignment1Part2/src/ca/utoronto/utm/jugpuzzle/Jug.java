package ca.utoronto.utm.jugpuzzle;

/**
 * Model a Jug and its contained liquid. The Jug has a non-negative amount of
 * liquid, and a capacity, the maximum amount of liquid the Jug can hold. At all
 * times 0<=amount<=capacity.
 * 
 * @author arnold
 *
 */
public class Jug {

	private int capacity = 0; // Always 0<=capacity
	private int amount = 0; // Always 0<=amount<=capacity

	/**
	 * Construct a Jug with the specified integers 0<=amount<=capacity.
	 * If invalid capacity or amount are presented, a Jug with 
	 * amount=capacity=0 is created.
	 * 
	 * @param capacity
	 *            a non negative integer
	 * @param amount
	 *            an integer such that 0<=amount<=capacity
	 */
	public Jug(int capacity, int amount) {
		if (0 <= amount && amount <= capacity) {
			this.setCapacity(capacity);
			this.add(amount);
		}
	}

	/**
	 * Create an empty Jug of the specified capacity. See Jug(amount, capacity)
	 * for details.
	 * @param capacity
	 */
	public Jug(int capacity) {
		this(capacity, 0);
	}

	/**
	 * Set the capacity of this to c if possible, otherwise this
	 * is unchanged.
	 * 
	 * @param c
	 *            the target capacity, with 0<=c
	 */
	private void setCapacity(int c) {
		if (c < 0)
			return;
		if (c < this.amount)
			return;
		this.capacity = c;
	}

	/**
	 * Fill this from other Jug, either emptying other or filling this.
	 * Spilling this into this leaves this unchanged.
	 * @param other
	 *            a different Jug whose contents will spill into this
	 */
	public void spillInto(Jug other) {
		if (this == other)
			return;
		else
			this.remove(other.add(this.amount));

	}

	/**
	 * Add up to addAmount into this Jug, or until this is full.
	 * 
	 * @param addAmount
	 *            non-negative integer amount to be added to this
	 * @return the amount actually added to this
	 */
	public int add(int addAmount) {
		if (addAmount < 0)
			return 0;
		int freeSpace = this.capacity - this.amount;
		if (addAmount > freeSpace){
			addAmount = freeSpace;
		}
		this.amount = this.amount + addAmount;

		return addAmount;
	}

	/**
	 * @return the amount currently in this
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return the capacity of this
	 */
	public int getCapacity() {
		return capacity;
	}

	// remove up to removeAmount from this Jug
	// @return the amount actually removed
	/**
	 * Remove up to removeAmount from this Jug, or until this is empty
	 * 
	 * @param removeAmount
	 *            the non-negative integer amount to be removed from this
	 * @return the amount actually removed from this
	 */
	public int remove(int removeAmount) {
		if (removeAmount < 0)
			return 0;
		if (removeAmount > this.amount){
			removeAmount = this.amount;
		}
		this.amount = this.amount - removeAmount;

		return removeAmount;
	}

	/**
	 * @return a String representation of this
	 */
	public String toString() {
		return "(" + amount + "/" + capacity + ")";
	}
}