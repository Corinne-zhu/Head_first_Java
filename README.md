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
      

## Chapter 6： 認識Java 的API
* **比較ArrayList 與一般數組**
   
   | 数组            | ArrayList                |  备注      |
   |-------------------|-----------------------------|----------|
   |创建时必须确定大小。<br>*new String[2];* |只需要创建此类型的对象，无需指定大小。<br>*new ArrayList<String> ();* |  |
   |存放对象时必须指定位置(介于0 ~ length -1 )<br>*myList[1] =  b;*      |不必指定位置<br>*MyList.add(b);*      |     |


* **運用ArrayList()代替數組改善上一章中的猜字Bug：三次猜同一個數字**


* **增加上章猜字遊戲的難度**
   1. 增加一個7*7 的單元格；
   2. 3個目標區域， 每個區域佔連續的三個空間；
   3. 實現方式
      * DotCom類: 
      * GameHelper類
      * DotComBust 類：
      
      
         
   | 實例變量        | 方法                |  备注      |
   |----------------|--------------------|------------|
   | name           |                    |設置DotCom 的名稱 |
   | locationCells  |                    |設置DotCom 的區域|
   |                |checkYourself       |判斷是否被擊中？|


   | 實例變量        | 方法                |  备注      |
   |----------------|--------------------|------------|
   |                |getUserInput        |獲取user 鍵盤猜的單元格地址|
   |                |placeDotCom         |隨機獲取每個DotCom佔據的單元格空間|


   | 實例變量        | 方法                |  备注      |
   |----------------|--------------------|------------|
   | GameHelper 對象        |                    |調用該對象的方法 |
   | DotCom的ArrayList集合  |                    |存放需要猜測的三個DotCom地址|
   | numOfGuesses          |                    |累加user 猜的次數     |
   |                   |setUpGame       |初始化程式<br>創建三個DotCom 對象並放到ArrayList集合中<br>隨機設置三個DotCom 的區域|
   |                  |startPlaying      |獲取user 的輸入位置並判斷是否正確？ |
   |                  |checkUserGuess    |判斷目標區域與user 輸入的區域是否一致？|
   |                  |finishGame        |返回用戶猜的次數|  


   



  


  

   



   

        

      


   


    

     
     
      






  


  


         

          
    
       
        

        
        
  




  

  

