import java.awt.Label;

/**
	 * 航班类
	 * @author Chen cyh19991002@gmail.com
	 * @version v1.0 Copyright(C),2019-2020
	 */
public class Flight implements FlightInterface{
	private String flightName;//航班名
	private int row;//座位排数
	private int rowLenth;//每排座位数
	private int[] fail= {-1};//返回预定号
	private Passenger[] passengerList;//预订座位的旅客
	/**
	 * 航班类的构造方法
	 * @param FlightName 航班名
	 * @param rows 多少排座位
	 * @param rowLength 每排座位数
	 * @throws 抛出异常类
	 */
	public Flight(String FlightName,int rows,int rowLength)throws Exception {
		// TODO Auto-generated constructor stub
		if(FlightName==null||FlightName.trim().length()==0||rows<=0||rowLength<=0)
			throw new Exception("Error");
		else {
			this.flightName=flightName;
			this.row=rows;
			this.rowLenth=rowLength;
			this.passengerList=new Passenger[row*rowLength];//(a)创建航班座位
			for(int i=0;i<row*rowLenth;i++)
				passengerList[i]=null; //所有座位没有被预订
		}
	}

	@Override
	public int[] reserve(String[] names) {
		// TODO Auto-generated method stub
		if(names.length>rowLenth)
			return fail;
		int i=0,j=0,k=0;
		//true--能安排,false--不能安排
		boolean flag=false;
		//在一排找相邻且没有被预订的座位，座位个数是names.length
		LabelA:for(i=0;i<=row-1;i++) {
			for(j=0;j<=rowLenth-names.length;j++) {
				//在本行从j到j+names.length-1找这样的空座位
				for(k=j;k<=j+names.length-1;k++) {
					if(passengerList[i*rowLenth+k]!=null)
						break;
				}
				if(k>j+names.length-1) {//已找到，从第i行第j列开始
					flag=true;//设置已找到标记
					break LabelA;//退出整个循环
				}
			}
		}
		if(!flag)
			return fail;
		//从第i行第j列开始分配座位
		int[]bn=new int[names.length];//每一个旅客返回一个预定号
		for(k=j;k<=j+names.length-1;k++) {
			bn[k-j]=i*rowLenth+k+1;//产生预定号,names[0]对应bn[0]
			passengerList[i*rowLenth+k]=new Passenger(names[k-j], i*rowLenth+k+1, i, k);
		}
		return bn;
	}

	@Override
	public boolean cancel(int bookingNumber) {
		// TODO Auto-generated method stub
		boolean Status=false;
		for(int i=0;i<row*rowLenth;i++) {
			if(passengerList[i]!=null&&bookingNumber==passengerList[i].getBookingNumber())
			{
				Status=true;
				passengerList[i]=null;
				break;
			}
		}
		return Status;
	}

	@Override
	public Passenger[] getPassengerList() {
		// TODO Auto-generated method stub
		return passengerList;
	}
}
