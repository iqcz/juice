package com.packt.mvneclipse.javainanutshell;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 更加强大的日志拦截器
 *
 * @author LiYanxue
 *
 */
public class LoggerInterceptor implements Interceptor {

     /**
      *
      */
     private static final long serialVersionUID = 7128757235275604447L;

     @Override
     public void destroy() {

     }

     @Override
     public void init() {

     }

     @Override
     public String intercept(ActionInvocation invocation) throws Exception {
          System.out.println("Begin---------------------------------");

          // 获取 action 的名称
          System.out.println("[Action Name: " + invocation.getAction().getClass().getName() + "]");

          // 打印要运行的方法名
          System.out.println("[Method: " + invocation.getProxy().getMethod() + "]");

          // 找到这次 request 请求中的 parameter 参数，并打印
          Map<String, Object> params = invocation.getInvocationContext().getParameters();

          for (String key : params.keySet()) {
               Object obj = params.get(key);

               if (obj instanceof String[]) {
                    String[] arr = (String[]) obj;
                    System.out.print("[Param: key=" + key);
                    for (String value : arr) {
                         System.out.print(", value=" + value);
                    }
                    System.out.println("]");
               }
          }

          String resultCode = invocation.invoke();

          Result rresult = invocation.getResult();

          if (rresult instanceof ServletDispatcherResult) {
               ServletDispatcherResult result = (ServletDispatcherResult) rresult;
               System.out.println("JSP: " + result.getLastFinalLocation());
          }

          System.out.println("End---------------------------------");

          return resultCode;

     }

}
