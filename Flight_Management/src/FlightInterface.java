/**
	 * 航班接口
	 * @author Chen cyh19991002@gmail.com
	 * @version v1.0 Copyright(C),2019-2020
	 */
public interface FlightInterface {
/**
 * 预订航班座位
 * @param names 存放旅客姓名的字符串数组
 * @return 返回存放预定号的数组
 */
	public int[] reserve(String[] names);//预订航班座位
	/**
	 * 取消预定座位
	 * @param bookingNumber 该参数指定要取消的预定号
	 * @return 返回该座位的预订状态
	 */
	public boolean cancel(int bookingNumber);//取消预定座位
	/**
	 * 获取预订了座位的旅客列表
	 * @return 返回存放旅客类对象的数组
	 */
	public Passenger[] getPassengerList();//返回旅客列表
	
}
