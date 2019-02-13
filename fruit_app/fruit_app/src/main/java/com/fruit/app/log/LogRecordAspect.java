package com.fruit.app.log;

import com.alibaba.fastjson.JSON;
import com.fruit.app.component.LocaleMessageSource;
import com.fruit.app.constant.MessageConstants;
import com.fruit.app.exception.BusinessException;
import com.fruit.app.util.LogUtil;
import com.fruit.common.dto.result.AppJsonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * 日志记录
 * Created by zoyation on 2017-09-05.
 */
@Aspect//定义一个切面
@Configuration
public class LogRecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);
    @Resource
    protected LocaleMessageSource localeMessageSource;
    // 定义切点Pointcut
    @Pointcut("execution(* com.fruit.app.controller.*Controller.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        Object result;
        try {
            //取参数，如果没参数，那肯定不校验了
            Object[] objects = pjp.getArgs();
            if (objects.length > 0) {
                /**************************校验封装好的javabean**********************/
                //寻找带BindingResult参数的方法，然后判断是否有error，如果有则是校验不通过
                String valResult = valParams(objects, pjp);
                if(valResult!=null){
                    return valResult;
                }
            }
            // result的值就是被拦截方法的返回值
            result = pjp.proceed();
        } catch (Throwable e) {
            AppJsonResult jsonResult = new AppJsonResult();
            jsonResult.setSuccess(false);
            if (e instanceof BusinessException) {
                BusinessException exception = (BusinessException) e;
                jsonResult.setMsg(exception.getMessage());
            } else {
                jsonResult.setMsg(localeMessageSource.getMessage(MessageConstants.UNKNOWN_EXCEPTION));
                jsonResult.setError(LogUtil.getStackMsg(e));
            }
            result = jsonResult;
        }
        logger.info("请求结束，controller的返回值是 " + JSON.toJSONString(result));
        return result;
    }

    /**
     * 校验参数取值
     * @param objects 参数
     * @param pjp
     * @return
     */
    private String valParams(Object[] objects,ProceedingJoinPoint pjp) {
        for (Object object : objects) {
            if (object instanceof BeanPropertyBindingResult) {
                //有校验
                BeanPropertyBindingResult result = (BeanPropertyBindingResult) object;
                if (result.hasErrors()) {
                    List<ObjectError> list = result.getAllErrors();
                    for (ObjectError error : list) {
                        System.out.println(error.getCode() + "---" + error.getArguments() + "--" + error.getDefaultMessage());
                        //返回第一条校验失败信息。也可以拼接起来返回所有的
                        return error.getDefaultMessage();
                    }
                }
            }
        }

        /**************************校验普通参数*************************/
        //  获得切入目标对象
        Object target = pjp.getThis();
        // 获得切入的方法
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        // 执行校验，获得校验结果
        Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, objects);
        //如果有校验不通过的
        if (!validResult.isEmpty()) {
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method); // 获得方法的参数名称

            for(ConstraintViolation<Object> constraintViolation : validResult) {
                PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();  // 获得校验的参数路径信息
                int paramIndex = pathImpl.getLeafNode().getParameterIndex(); // 获得校验的参数位置
                String paramName = parameterNames[paramIndex];  // 获得校验的参数名称

                System.out.println(paramName);
                //校验信息
                System.out.println(constraintViolation.getMessage());
            }
            //返回第一条
            return validResult.iterator().next().getMessage();
        }
        return null;
    }

    private ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator validator = factory.getValidator().forExecutables();

    private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object[] params) {
        return validator.validateParameters(obj, method, params);
    }
//    @Pointcut("execution(public * com.itsoft.action..*.*(..))")
//    public void recordLog(){}
//
//    @Before("recordLog()")
//    public void before() {
//        this.printLog("已经记录下操作日志@Before 方法执行前");
//    }
//
//    @Around("recordLog()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable{
//        this.printLog("已经记录下操作日志@Around 方法执行前");
//        pjp.proceed();
//        this.printLog("已经记录下操作日志@Around 方法执行后");
//    }
//
//    @After("recordLog()")
//    public void after() {
//        this.printLog("已经记录下操作日志@After 方法执行后");
//    }
//
//    private void printLog(String str){
//        System.out.println(str);
//    }
}
