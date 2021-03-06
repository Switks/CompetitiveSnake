package multi_snake;

import java.io.Serializable;
import java.util.ArrayList;

public class Apple implements Serializable{
	
	/*
	 * @param serialVersionUID is needed in order to serialize a class in order to
	 * create an Apple object and send it and receive it successfully.
	 * 
	 * Apples class just manages two different coordinates and spawns an apple for
	 * the snake to eat meanwhile making sure it doesn't spawn inside of the snake
	 * through iterating across the "tail_list" and checking Tail Object coordinates
	 * using getters of the Tail class.
	 */
	
	private static final long serialVersionUID = 2L;
	private int x, y, index;
	
	Apple(ArrayList<Tail> tail_list, ArrayList<Apple> apple_list, int board_size, int index) {
		spawn_apple(tail_list, apple_list, board_size, index);
	}
	public int get_x() {
		return x;
	}
	public int get_y() {
		return y;
	}
	public int get_index() {
		return index;
	}
	
	public void spawn_apple(ArrayList<Tail> tail_list, ArrayList<Apple> apple_list, int board_size, int index) {
		x = (int) ((Math.random() * (board_size)));
		y = (int) ((Math.random() * (board_size)));
		for (Apple apple : apple_list) {
			for (Tail tail : tail_list) {
				if ((x == tail.get_x() && y == tail.get_y()) || (x == apple.get_x() && x == apple.get_y() && apple.get_index() != index))
					spawn_apple(tail_list, apple_list, board_size, index);
			}
		}
		
	}
	
}
