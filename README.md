# Head First Java
Learning the book of Head First Java

## Chapter 1： 基本概念
* **循環**
* **隨機數**

## Chapter 2：類和對象
* **猜數字遊戲**

## Chapter 3： 數據類型和引用
* **裝載Primitive 類型的數組**
* **裝載引用類型的數組**

## Chapter 4: 對象的行為
* **方法的參數與返回類型**
* **封裝**
* **實例變量永遠都會有默認值。**
  1. integers  ==> 0
  2. floating points ==> 0.0
  3. booleans ==> false
  4. references ==> null
* **實例變量與局部變量之間的差別**
   1. 實例變量聲明在類中；
   2. 局部變量聲明在方法中；
   3. 局部變量在使用前必須初始化。 
* **primitive 主數據類型 VS 引用數據類型**
    1. 使用 == 來比對primitive 主數據類型
    
          ```
             
              byte b = 3 ;
              int  a = 3 ;
              if ( a==b ){ //true }

          ```

       2.使用 ==來判別兩個引用是否都指向同一個對象

          ```
             
             Foo a  = new Foo();
             Foo b  = new Foo();
             Foo c = a ;
             if (a == b ) { //false  }
             if (c == c ) { //true   }
             if (b == c ) { //false  }
              

          ```




       3.使用equals()來判斷兩個對象是否在**意義上**相等

         

          
    
       
        

        
        
  




  

  

