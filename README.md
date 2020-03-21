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


## Chapter 7: 繼承與多態

* **繼承的設計方法**
   1. 具有共同屬性和行為的對象
   2. 設計代表共同狀況與行為的類
   3. 子類是否需要有特定不同的運作方式，即哪些子類需要覆蓋父類
   4. 尋找使用共同行為的子類來找出更多抽象的機會
   5. 完成類的繼承層次

* **Is a**
     - X extends Y ==> X is a Y
     - 繼承概念下的is - a 是個單向的關係！
     - 使用is a 來驗證結構的合理性

* **繼承的知識點**
     - 子類可以繼承父類的成員：實例變量和方法
     - 父類可以通過存取權限決定子類是否能夠繼承某些特定的成員；
     - 繼承下來的方法可以被覆蓋掉，***實例變量不能被覆蓋掉***；

* **繼承的意義**
     - 避免重複的程式代碼；
     - 定義出共同的協議（通過繼承來定義相關類間的共同協議，後續可以用子類來填補需要）

* **方法可以覆蓋的規則**
     - 參數必須要一樣，且返回類型必須要兼容： 子類對象得保證能夠執行父類的一切；
     - 子類不能降低方法的存取權限；


* **方法的重載**
     - 方法名稱相同， 參數不同
     - 返回類型可以不同


## Chapter 8 ：接口與抽象類

* **抽象類**
     - 抽象類除了被繼承過之外，是沒有用途，沒有值，沒有目的；
     - 不是抽象的類就稱為具體類；
     - 抽象方法沒有實體：代表此方法一定要被覆蓋；
         
           ```

            public abstract void eat();

            ```

     - 如果聲明出一個抽象方法，就必須將類也標記為抽象的。不能在非抽象類中擁有抽象方法；
     - 抽象方法的意義在於：就算無法實現出方法的內容，但還是可以定義出一組子型共同的協議；
     - 子類必須實現所有抽象的方法；
     - 抽象類可以帶有抽象和非抽象方法；


* **多態**

     - 編譯器是根據***引用類型***來判斷有哪些method可以調用， 而不是根據Object 確實的類型。

             ```

            Object o = a1.get(index) ;  //OK
            int i = o.hashCode();       //OK
            o.bark() ;     // 錯誤！Object 沒有bark()方法


            ```
     
     - 當你把對象裝進ArrayList<Object> 時， 不管它原來是什麼，你只能把它當作Object
     
     - 從ArrayList<Object> 取出引用時，引用的類型只會是Object
     - 轉換回原來的類型
       
           ```

             Object o = a1.get(index) ;
             if(o istanceOf(Dog)) {
                Dog d = (Dog) o;
                 
                // 調用Dog特有的方法
                d.roam(); 
              
             }
     
            ```

* **接口**

      - 所有接口的方法都是抽象的
      - 接口的定義
       
            ```
 
                public interface Pet{...}


            ```
      - 接口的實現
      
           ```
 
                public class Dog extends Canine implements Pets { ... }


            ```
      - 設計與實現Pet 接口
      
              ```
 
                public interface Pet{
   
                   public abstract void beFriendly();  // 接口的方法是抽象的

                   public abstract void play();
                  }


            ```


* **如何判斷應該是設計類，子類，抽象類或接口？**

     - 如果新的類無法對其他的類通過IS - A 測試時，就設計不繼承其他類的類
     - 只有在需要某類的特殊化版本時，以覆蓋或增加新的方法來繼承現有的類
     - 當你需要定義一群子類的模板，又不想讓程序員初始化此模板時， 設計出抽象的類給他們用
     - 如果想要定義出類可以扮演的角色，使用接口


## Chapter 9 : 構造器與垃圾收集器

* **實例變量與局部變量**

     - 實例變量：聲明在 **類中方法之外** 的地方 ，每個對象都有獨立的值
     - 局部變量：聲明在 **方法或方法的參數上**  ，它們是暫時的。生命週期只限於方法被放在棧上的那段期間。（也就是方法調用到執行完畢為止）
     - 局部變量生存在棧上， 實例變量存在於對象所屬的堆空間上
     - 當一個新建對象帶有對象引用的變量時，比如：CellPhone帶有Antenna ， Java 只會留下 Antenna 引用量
     
     

           ```

               public  class CellPhone{
 
                      private Antennaa ant;     // 只會留下變量空間
    
                      private Antenna ant = new Antenna();  // 在堆上佔空間

               }

            ```

* **棧和堆**

     - 棧：方法調用和局部變量；棧頂上方法是目前正在執行的；
     - 堆：所有的對象；


* **構造函數**  

     - 構造函數是被賦值給引用之前就執行，表示有機會可以介入new 的過程；
     - 可以給對象進行初始化
      
        
         
             ```

               public Duck(){
                      size = 34 ;
        
               }


            ```
     
      - 只有完全沒有設定構造函數的狀況下， 編譯器才會幫忙建一個無參數的構造函數
      - 如果已寫了一個有參數的構造函數，那麼必須手寫一個無參數的構造函數
      - 如果類有一個以上的構造函數，則參數一定要不一樣
          
             ```

               public class Mushroom {

                     public Mushroom(int size) {}
                
                     public Mushroom() {}

                     public Mushroom(boolean isMagic){}

                     public Mushroom(boolean isMagic , int size) {}

                     public Mushroom(int size, boolean isMagic)

       
               }


            ```

          
      - 構造函數在執行的時候，第一件事是執行它的父類的構造函數，這會連鎖反應到Object這個類為止。這樣的過程稱為"構造函數鏈"(Constructor Chaining)
      - 從某個構造函數調用重載的另外一個構造函數
          
           * 使用this()來從某個構造函數調用同一個類的另外一個構造函數；
           * this()只能用在構造函數中，且必須是在第一行；
           * super() 與this()不能兼得；
           * this就是個對對象本身的引用；

      - 利用super() 來調用父類的構造方法
     
         
             ```

               public class Hippo extends Animal {

                     public Hippo(String name){
 
                            super(name)
                      }
       
               }


            ```


* **垃圾回收的幾種案例**
    
      -  引用永久性的離開它的範圍
     
          ```

               public class StackRef {

                     public void foof(){
                          barf();
                       
                      }

                      public void barf(){
                          Duck d  = new Duck();    //barf()執行完畢，因此d就掛了。Duck就等著被GC
 
                      }
       
               }


            ```
     
         
      -  引用被賦值到其他的對象上
        
            
          ```

               public class ReRef {

                       Duck d  = new Duck();

                       public void  go(){
                            d = new Duck();   // 調用go() 之後，第一個Duck就沒有任何的引用
                       }
               }


            ```
     
           
          
      -  直接將引用設為null
     
            ```

               public class ReRef {

                       Duck d  = new Duck();

                       public void  go(){
                            d = null;   
                       }
               }


            ```



## Chapter 10 : 數字與靜態

* **靜態**
     * 靜態的方法不能調用非靜態的變量
     
     
          ```

             public class Duck {
	             private int size;

	             public static void main(String[] args) {
		             System.out.println("Size of duck is " +this.size); // error
	             }
              }
    
         
            // 靜態的方法是不知道堆上有哪些實例的。        

          ```   

 
     * 靜態方法也不能調用非靜態的方法
     * 如果類只有靜態的方法，你可以將構造函數標記為 private 
     * 靜態變量的值對所有的實例來說都是相同的，是一個共享的變量。每個類一個
     * 靜態方法可以存取靜態變量
     * 實例變量是每個實例一個
     * 靜態變量的起始動作
          * 靜態變量會在該類的任何對象創建之前初始化
          * 靜態變量會在該類的靜態方法之前初始化
     * 靜態的final 變量是常數
     
          ```
               
             public static final double PI = 3.141592653589793;

              // public : 可供各方讀取
              // static : 不需要創建實例
              // final  : 圓周率是不變的
              // 常量的名稱一般都是大寫字母
                


           ```
        
            
     * final 不只用在靜態變量上
          * final 關鍵字還可以修飾實例變量，局部變量，方法
          * final 的變量表示不能改變它的值
          * final 的method 表示此方法不能被覆蓋
          * final 的類表示此類不能被繼承，即：不能再創建子類
  

* Math 的方法
* String.format()
     * %,d : 十進制帶有逗號的方式輸出
     * %.2f : 小數兩位顯示浮點數
     * %,.2f : 整數部分用逗號的方式顯示， 小數部分保留兩位小數
     * %tc : 完整的日期與時間
     * %tr : 只有時間
     * %tA : 表示星期幾
     * %tB ：表示幾月
     * %td : 表示幾日
  
          
           
       
        

          



               
      
      
        
      

           
        
          

    

          

        
          

     
   
        
         



  


   



  


  

   



   

        

      


   


    

     
     
      






  


  


         

          
    
       
        

        
        
  




  

  

