package pers.henglin.java8.reflection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.java8.Constant;
import pers.henglin.java8.annotation.Exec;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by linheng on 23/10/2019.
 */
public class ClazzTest {
    private static Logger logger = LoggerFactory.getLogger(ClazzTest.class);

    @Test
    public void testClazz(){
        try {
            Object obj = initClazz(Constant.DEFAULT_IDENTIFICATION_CLAZZ_PATH);
            invokeMethodByAnnotation(obj, Exec.class);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            logger.info(e.getMessage(), e);
        }
    }

    private Object initClazz(String clazzPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader clazzLoader = ClazzTest.class.getClassLoader();
        Class<?> clazz = clazzLoader.loadClass(clazzPath);
        return clazz.newInstance();
    }

    private void invokeMethodByAnnotation(Object obj, Class<? extends Annotation> annotationClazz) {
        Class clazz = obj.getClass();
        if(!annotationClazz.isAnnotation()){
            logger.warn("this annotation is not find: {}", annotationClazz.getClass().getName());
            return;
        }
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(annotationClazz)){
                method.setAccessible(true);
                try {
                    method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    logger.warn(e.getMessage(), e);
                }
            }
        }
    }
}
