package project2.HRService.global.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdminAspect {

    public AdminAspect(){

    }

    @Pointcut("execution(* project2.HRService.domain.admin.service.*.*(..))")
    private void adminService(){}

    @Before("adminService()")
    public void verifyAdmin(JoinPoint joinPoint) throws  Throwable{
    }
}
