/**
	 * 旅客类
	 * @author Chen cyh19991002@gmail.com
	 * @version v1.0 Copyright(C),2019-2020
	 */
public class Passenger implements PassengerInterface {
	private String names;
	private int bookingNumber;
	private int rows;
	private int seatPosition;
	/**
	 * 旅客类的构造方法
	 * @param names 旅客姓名
	 * @param bookingNumber 预定号
	 * @param rows 座位排数
	 * @param seatPosition 座位号
	 */
	public Passenger(String names,int bookingNumber,int rows,int seatPosition) {
		this.names=names;
		this.bookingNumber=bookingNumber;
		this.rows=rows;
		this.seatPosition=seatPosition;
	}
	public String getName() {
		return names;
	}
	public int getBookingNumber() {
		return bookingNumber;
	}
	public int getRow() {
		return rows;
	}
	public int getSeatPosition() {
		return seatPosition;
	}
}
