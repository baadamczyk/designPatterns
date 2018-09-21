package pl.baadamczyk.designpatterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

/*
    Proxy class has to implement InvocationHandler!
*/

public class SecurityProxy implements InvocationHandler {

  private Object object;

  private SecurityProxy(Object object) {
    this.object = object;
  }

  public static Object newInstance(Object object) {
    return newProxyInstance(
        object.getClass().getClassLoader(),
        object.getClass().getInterfaces(),
        new SecurityProxy(object));
  }

  /*
    This method implements the logic that will act as 'security check'
  */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Object result;
    try {
      if (method.getName().contains("setPassword")) {
        throw new FuntionalityDisabledException("Functionality disabled!");
      } else {
        result = method.invoke(object, args);
      }
    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return result;
  }
}
