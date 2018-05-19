package com.j.aop;

import com.j.common.BaseResponse;
import com.j.common.CodeConstraint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class ControllerInterceptor {

   /* @Value("${spring.profiles}")
    private String env;
*/
    /**
     * 定义拦截规则：拦截com.j.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.j.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     */
    @Around(value = "execution(* com.j.controller.*.*(..)) && args(..,bindingResult)")
    public Object doBefore(ProceedingJoinPoint joinPoint,BindingResult bindingResult) {
        Object retVal = null;
        if (bindingResult.hasErrors()) {
            BaseResponse response = new BaseResponse();
            List<ObjectError> list = bindingResult.getAllErrors();
            String errorMessage="";
            for(ObjectError  error:list){
                errorMessage+=error.getDefaultMessage()+"---";
            }
            response.setCode(CodeConstraint.ParamError);
            response.setInfo(errorMessage);
            return response;
        } else {
            try {
                retVal = joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return retVal;
    }

}
