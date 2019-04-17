package controller;

import service.Servcises;

/**
 * Author: S M Ashiqur Rahman
 * Date: 10/03/2019
 * Topic: CRUD using File System
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
        
        Servcises s = new Servcises();
		s.add("10001","Rayyan","2");
        //s.add("10002", "Reyna", "6");
        
        //s.search("10001");
        
   //  s.add("10003", "Me", "20");
      //s.delete("10003");
   //   s.update("10003", "10004", "Bob", "25");
        
    }
}
