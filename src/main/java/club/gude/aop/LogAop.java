package club.gude.aop;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Gude
 * @Date 2016/1/5.
 */
@Component
@Aspect
public class LogAop {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void log(){

    }

    @Around("log()")
    public Object  aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
      //  System.out.println(joinPoint.getKind()+"   "+joinPoint.getSignature()+" "+joinPoint.getSourceLocation());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String method=request.getMethod();
        String path=request.getServletPath();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = Class.forName(targetName);
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath ccpath = new ClassClassPath(targetClass);
        pool.insertClassPath(ccpath);
        CtClass cc = pool.get(targetName);
        CtMethod methodX = cc.getDeclaredMethod(methodName);
        int xlineNumber = methodX.getMethodInfo().getLineNumber(0);
        StackTraceElement element= new StackTraceElement(targetName,methodName,targetName+".java",xlineNumber);
        System.out.println(element+": "+method+"----"+path);
        return  joinPoint.proceed();
    }

}
