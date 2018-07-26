package com.uiframe.samples;

public class Snippet {
	public static void main(String[] args){
//		List<Object> a = testWrap();
		int b = testBasic();
		System.out.println(b);

	}
	
	
	public static  int testBasic(){
        int i = 1; 
        try{
            i=3;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
        }

}

//	public static   List<Object> testWrap(){
//	        List<Object> list = new ArrayList<>();
//	        try{
//	            list.add("try");
//	            System.out.println("try block");
//	            return list;
//
//	        }catch(Exception e){
//	            list.add("catch");
//	            System.out.println("catch block");
//	            return list;
//	        }finally{
//	            
//	            list.add("finally");
//	            System.out.println("finally block ");
//	        }
//	}
}

