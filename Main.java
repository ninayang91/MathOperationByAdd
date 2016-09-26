import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	//Implement the multiply, subtract, divide for integers. Use only the add operator
	//write negate, abs in separate methods since we use it a lot
	//in multiply, divide, there could be negative values
		
		public static int negate(int a){
			int d=(a>0)?-1:1;
			int neg=0;
			while(a!=0){
				neg+=d;//*
				a+=d;//*nice design
			}
			return neg;

		}
		public static int abs(int a){
			return (a>=0)?a:negate(a);
		}
		
		public static int minus(int a, int b){
			return a+negate(b);
		}
		
		public static int multiply2(int a, int b){
			if(a<b)return multiply2(b,a);//*nice design
			int sum=0;
			for(int i=abs(b);i>0;i--){
				sum+=a;
			}
			if(b<0) sum=negate(sum);
			return sum;
		}
		
		public static int divide2(int a, int b) throws java.lang.ArithmeticException{
			if(b==0)throw new java.lang.ArithmeticException("Error");
			int count=0;
			int sign=1;
			if((a<0&&b>0)||(a>0&&b<0))sign=-1;
			a=abs(a);b=abs(b);
			for(int sum=b;sum<=a;sum+=b){
				count++;
			}
			if(sign==-1)count=negate(count);
			return count;
		}
		
		public static int multiply(int m, int n){//m+n
			if(Math.abs(m)<Math.abs(n))return multiply(n,m);
			int sign=1;
			if((m<0 && n>0)||(m>0 && n<0))sign=-1;
			m=Math.abs(m);n=Math.abs(n);
			int sum=0;
			for(int i=1; i<=n;i++){
				sum +=m;
			}
			if(sign==-1)return subtract(0,sum);
			return sum;
		}
		
		public static int subtract(int m, int n){//m-n
			int temp=0;
			if(n<0) return m+Math.abs(n);
			for(int i=1;i<=n;i++){
				temp += -1;
			}
			return m+temp;
		}
		
		public static int divide(int m, int n){//m/n
			if(n==0) return -1;
			int count=0;
			int sign=1;
			if((m<0 && n>0)||(m>0 && n<0))sign=-1;
			m=Math.abs(m);n=Math.abs(n);
			for(int result=n;result<=m;result+=n){
				count++;
			}
			if(sign==-1)return subtract(0,count);
			return count;
			
		}
		


}
