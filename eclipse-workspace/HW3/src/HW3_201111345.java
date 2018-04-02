import java.util.*;

public class HW3_201111345 {
	public static void main(String args[])
	{
		
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		
		int k = r.nextInt(100);
				
		int count = 1;
		int bound_Min = 0;
		int bound_Max = 100;
		boolean outflag = true; //입력값이 범위를 벗어난 경우 line20을 재출력하지 않게 하기 위해 사용하는 변수.
		outLabel:
		while(true)
		{
			boolean flag = true; //출력문 제어하기 위한 변수.
			if(count == 1 && outflag)
			{
				System.out.println("수를 맞추어 보세요");
				System.out.printf("%d-%d\n",bound_Min, bound_Max);
				//System.out.println(k);
			}
			System.out.print(count + ">>");
			int temp = scan.nextInt();
			if((temp > 99 || temp < 0) || (temp < bound_Min || temp > bound_Max))
			{
				System.out.printf("다시 입력해 주세요. (%d-%d)\n",bound_Min, bound_Max);
				outflag = false; // 18line을 재출력하지 않기 위해 이용.
				continue;
			}
			
			if(temp == k)
			{
				if(flag)						
				{
					System.out.println("맞았습니다");
					System.out.println("다시하시겠습니까? (y/n)");
				}
				while(true)
				{
					String op = scan.next();
					if(op.equals("n")||op.equals("N"))
					{
						System.out.println("Good Bye");
						break outLabel;
					}
					
					else if(op.equals("y")||op.equals("Y"))
					{
						k = r.nextInt(100);
						count = 1; // 재시작  count 초기화
						op = null; // op초기화
						outflag = true;// 한 게임 끝나면 line20 재출력하므로 ture로 set
						bound_Min = 0;
						bound_Max = 100; // 새 게임 바운더리 초기화
						continue outLabel;
					}
					
					else
					{
						System.out.println("올바를 값을 입력해주세요. (y/n)");
						op = null; // op초기화
						flag = false;//재입력시 34line이 재출력되지 않게끔 한다. loop을 벗어나면 outLabel에서 true로 초기화된다.
						continue;
					}
					
				}
				
			}
			else if(temp > k)
			{
				System.out.println("더 낮게");
				bound_Max = temp;
				System.out.printf("%d - %d\n", bound_Min, bound_Max);
			}
			else if(temp < k)
			{
				System.out.println("더 높게");
				bound_Min = temp;
				System.out.printf("%d - %d\n", bound_Min, bound_Max);
			}
			count++;

		}
	}
}