package kr.co.jparangdev.springbootdemo.common.aspect;

import kr.co.jparangdev.springbootdemo.common.annotation.TimeCheck;
import kr.co.jparangdev.springbootdemo.common.constants.TimeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component
public class MethodTimeCheckAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(kr.co.jparangdev.springbootdemo.common.annotation.TimeCheck)")
    private void timeCheckAnnotation(){}

    @Around("timeCheckAnnotation()")
    public void methodRunningTimeCheck(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        MethodSignature sig = (MethodSignature) pjp.getSignature();
        Method method = sig.getMethod();
        TimeCheck timeCheck = method.getAnnotation(TimeCheck.class);
        TimeEnum unit = timeCheck.unit();

        stopWatch.start();
        pjp.proceed();
        stopWatch.stop();

        double time;
        String unitStr;

        switch (unit) {
            case NANO:
                time = Math.round(stopWatch.getLastTaskTimeNanos());
                unitStr = "ns";
                break;
            case SECOND:
                time = Math.round((stopWatch.getLastTaskTimeMillis() / 60.0) * 100)/100d;
                unitStr = "sec";
                break;
            case MINUTE:
                time = Math.round(stopWatch.getLastTaskTimeMillis()/60.0/60.0*100)/100d;
                unitStr = "min";
                break;
            default:
                time = stopWatch.getLastTaskTimeMillis();
                unitStr = "ms";
        }
        String str = "Method RunningTime is : "+time+" " +unitStr;
        log.info(str);

    }
}
