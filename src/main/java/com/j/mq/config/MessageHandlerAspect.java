package com.j.mq.config;

/**
 * @Author Administrator
 * #Date 03
 */
/*@Aspect
@Component*/
public class MessageHandlerAspect {
    /*private final static Logger log = LoggerFactory.getLogger(MessageHandlerAspect.class);
    @Around("@annotation(handler)")
    public Object doAspect(ProceedingJoinPoint joinPoint, RabbitHandler handler) throws Throwable {
        Object object[] = joinPoint.getArgs();
        log.info("mq通知："+ JSON.toJSONString(object));
        Object result = null;
        try {
            result = joinPoint.proceed();
            log.info("mq通知：{}。处理mq通知结果：{}", JSON.toJSONString(JSON.toJSONString(object)), JSON.toJSONString(result));

        } catch (Exception e) {
            log.info("【RabbitMQ监听】业务异常{}，参数{}", e.toString(), JSON.toJSONString(object));
        }
        return result;
    }*/
}
