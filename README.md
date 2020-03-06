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

   2. 使用 ==來判別兩個引用是否都指向同一個對象

          ```
             
             Foo a  = new Foo();
             Foo b  = new Foo();
             Foo c = a ;
             if (a == b ) { //false  }
             if (c == c ) { //true   }
             if (b == c ) { //false  }
              

          ```

   3. 使用equals()來判斷兩個對象是否在**意義上**相等

## Chapter 5: 編寫程序
* **粗糙版猜數值遊戲：**
  1. SimpleDotCom()類 :比較用戶猜的地址與目標地址是否一致？
  
  2. SimpleDotComTestDrive() 類： 指定用戶猜的地址與目標地址進行比較， 沒有人機交互的模式。
  
* **精進版猜數值遊戲：**
   1. 增加GameHelper() 類 ： 增加人機交互的功能，user 可以在鍵盤輸入猜的地址。
   

* **關於循環**
   1. 基本的for 循環
       ```   
  
            for(int i = 0 ; i < 100 ; i++ ){ // 重複執行的部分}

            第一階段： 初始化
            第二階段： boolean 測試
            第三階段： 重複表達式

          ```
   
   2. 比較for循環與while循環的差別
      * while 循環只有boolean 測試， 並沒有內建的初始化或重複表達式。
      * while 只適合用在不知道要循環幾次的循環上。

   3. 增強for 的循環
          ```
 
             for (String name : nameArray)  {}

                name :    聲明帶有數組單一元素的循環變量；它在循環中會有不同的值

                ：        代表"in"；

                nameArrray: 要被逐個運行的集合；


            ```
      

  


  


         

          
    
       
        

        
        
  




  

  

