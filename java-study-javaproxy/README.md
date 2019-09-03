# 1.牢记动态代理的特点
在java中动态代理只能代理有接口的类（需要写个接口，并实现接口）,不能使用抽象
使用 Proxy.newProxyInstance 实现
# 2.编写动态代理
## 1、创建代理类的接口类 HelloPrint
```java

public class HelloPrintImpl implements Hell

public interface HelloPrint {
 void printStr(String str1,String str2);
}
```
## 2、编写HelloPrint实现HelloPrintImpl
```java

public class HelloPrintImpl implements HelloPrint {
 @Override
 public void printStr(String str1,String str2){
 System.out.println("Hello "+str1+" , "+str2);
 }
}
```
## 3、编写main测试
```java

/**
 * java 动态打理
 * */
public class HelloProxy {
 public static void main(String [] args){
 HelloPrintImpl helloPrint1=new HelloPrintImpl();
 HelloPrint helloPrint=(HelloPrint)Proxy.newProxyInstance(helloPrint1.getClass().getClassLoader(),
 helloPrint1.getClass().getInterfaces(),
 new InvocationHandler() {
 @Override
 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 return method.invoke(helloPrint1,args);
 }
 });
 helloPrint.printStr("fishpro","welcome to 今日头条");
 }
}
```
运行结果

Hello fishpro , welcome to 今日头条

Process finished with exit code 0

# 3、如何理解代理
你上网是一个类，正常可以直接上。但有些公司内部的网站需要vpn才能上，

你把上网行为委托给vpn，vpn成了你的代理。

# 4、代理有何好处
多出来一层代理，代理可以做很多事情，struts，Spring等都用到了动态代理。
