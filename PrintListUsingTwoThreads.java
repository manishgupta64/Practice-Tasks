import java.util.Arrays;
import java.util.List;

public class PrintListUsingTwoThreads 
{
	public static void main(String[] args) 
	{
		// object of MyData class to be shared b/w two thread
		MyData data = new MyData();
		
		Thread t = new Thread( new MyThread( data ) );
		t.start();
		
		Thread t1 = new Thread( new MyThread( data ) );
		t1.start();

	}

}

// This class objects will be shared by multiple threads.
class MyData 
{
	private List< Integer > list = Arrays.asList( 1,2,3,4,5 );

	private int index = 0;
	
	private boolean listFree = true;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isListFree() {
		return listFree;
	}

	public void setListFree(boolean listFree) {
		this.listFree = listFree;
	}

}

class MyThread implements Runnable
{
	MyData data;
	
	MyThread( MyData data )
	{
		this.data = data;
	}
	
	@Override
	public void run()
	{
		synchronized (data) {
			while( data.getIndex() < data.getList().size() )
			{
				if( data.isListFree() )
				{
					data.setListFree( false );
					System.out.println( Thread.currentThread().getName() + "  prints  " + data.getList().get( data.getIndex() ) );
					data.setIndex( data.getIndex() + 1 );
					data.notify();
				}
				else
				{
					try 
					{
						System.out.println( Thread.currentThread().getName() + " is waiting;");
						data.setListFree(true);
						data.wait();
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println( Thread.currentThread().getName()  +  " has finished.");
	}
	
}
