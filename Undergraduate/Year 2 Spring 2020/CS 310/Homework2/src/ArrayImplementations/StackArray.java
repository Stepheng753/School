package ArrayImplementations;

public class StackArray<E> {
	
	    private int top=-1;
	    private static final int MAX_ITEMS = 10;
	    private E items[];
	 
	    @SuppressWarnings("unchecked")
		public StackArray() {
	        items = (E[]) new Object[MAX_ITEMS];
	        System.out.println("Stack Created!");
	    }
	 
	    public void push(E e) {
	        if (isFull()==true) {
	           System.out.println("Stack Full!");
	        }
	        else{
	        	top=top+1;
	        	items[top] = e;
	        }
	    }
	 
	  
	    public E pop() {
	    	 if (isEmpty()==true) {
		           System.out.println("Stack Empty!");
		        }
	    	 else{
	    	
	        E e = (E) items[top];
	        items[top] = null;
	        top = top-1;
	        return e;
	    	 }
			return null;
	    }
	 
	    public boolean isFull() {
	    	 if (top == items.length-1) {
	    		 return true;
	    	 }
	    	 return false;
	    }
	    
	    public boolean isEmpty(){
	    	 if (top==-1) {
	    		 return true;
	    	 }
	    	 return false;
	    }
	    
	     
	    @Override
	    public String toString()
	    {
	    	System.out.println("Array:");
	        System.out.print("{");
	         for(int i = 0; i < items.length ;i++) {
	             System.out.print(items[i]+" ");
	    }
	         System.out.print("}");
			return "";
		}

		public void countPosNeg() {
	    	int posNum = 0;
	    	int negNum = 0;
	    	E [] temp = items.clone();
	    	while (!isEmpty()) {
				E popVal = pop();
				if ((Integer) popVal > 0) {
					posNum++;
				}
				if ((Integer) popVal < 0) {
					negNum++;
				}
			}
			items = temp.clone();
			System.out.println("Amount of Positive Numbers: " + posNum);
			System.out.println("Amount of Negative Numbers: " + negNum);
		}

	public void countPosNeg1() {
		int posNum = 0;
		int negNum = 0;
		for (int i = 0; i <= top; i++) {
			if ((Integer) items[i] > 0) {
				posNum++;
			}
			if ((Integer) items[i] < 0) {
				negNum++;
			}
		}
		System.out.println("Amount of Positive Numbers: " + posNum);
		System.out.println("Amount of Negative Numbers: " + negNum);
	}


	public boolean sameStack(StackArray <E> s2) {
	    	E s1pop = pop();
	    	E s2pop = s2.pop();
	    	if(s1pop == null && s2pop == null) {
	    		return true;
			}
	    	if(s1pop == s2pop) {
	    		return sameStack(s2);
			}
	    	else {
	    		return false;
			}
		}


	    public static void main(String[] args) 
	    {
	    	
	    	// Code reference for countPosNeg method
	    	StackArray<Integer> intStack = new StackArray<Integer>();
	    	 	intStack.push(10);
		        intStack.push(10);
		        intStack.push(30);
		        intStack.push(-40);
	    	// call countPosNeg here
		        System.out.println("intStack before counting");
		        System.out.println(intStack);

		        intStack.countPosNeg1();
	    	 System.out.println("intStack after counting");
		        System.out.println(intStack);
		        
	    	// Code reference for sameStack method
	       StackArray<Integer> stack = new StackArray<Integer>();
	       StackArray<Integer> stack2 = new StackArray<Integer>();
	 
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	        stack.push(40);
	        stack2.push(10);
	        stack2.push(20);
	        stack2.push(30);
	        stack2.push(40);
	         
	       
	        System.out.println(stack);
	        System.out.println(stack2);
	        
	        //Calling comparison method
	       System.out.println(stack.sameStack(stack2));
	    }



}
