/*
有一个圆形和长方形。
都可以获取面积，对于面积如果出现非法的数值，视为是获取面积出现问题。
问题通过异常来表示。
现有对这个程序进行基本设计。

*/
class NoValueException extends RuntimeException
{
	NoValueException(String message)
	{
		super(message);
	}
}
interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	Rec(int len,int wid)//throws NoValueException
	{
		if (len<=0 || wid<=0)
			throw new NoValueException("出现非法值");

		this.len = len;
		this.wid = wid;
		
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}

class Circle implements Shape
{
	private int radius;
	public static final double PI = 3.14;
	Circle(int radius)
	{
		if(radius<=0)
			throw new RuntimeException("非法数值");
		this.radius = radius;
	}

	public void getArea()
	{
		System.out.println(radius*PI);
	}
}

class ExceptionPractice
{
	public static void main(String[] args)
	{
		Rec r = new Rec(-3,4);
		r.getArea();
		System.out.println("over");

		Circle c = new Circle(-8);
		System.out.println("over");
		/*
		try
		{
			Rec r = new Rec(3,-4);
			r.getArea();
		}
		catch (NoValueException e)
		{
			System.out.println(e.toString());
		}
		System.out.println("over");
		//由操作者输入非法值造成的异常错误不应该去处理它，
		遇到这种情况应该直接停止程序运行，
		这就需要自定义异常去继承RuntimeException。
		*/
	}
}