package com.bortnichuk;

import com.bortnichuk.annotation.MyAnnotation;
import com.bortnichuk.entity.IWindow;
import com.bortnichuk.entity.MyInvocationHandler;
import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import com.bortnichuk.exception.SetterCalledException;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WindowTest {

    @Test
    @SneakyThrows
    public void shouldCallMethodWithAnnotations() {
        Window windowImpl = createWindow();
        for (Method method : windowImpl.getClass().getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                method.invoke(windowImpl);
            }
        }

        assertEquals("red", windowImpl.getColor());

    }

    @Test
    public void getLength(){
        Window windowImpl = createWindow();

        assertEquals(16, windowImpl.getPublicLength());
    }

    @Test
    public void shouldCallTextWindowClass() {
        TextWindow textWindow = new TextWindow();

        String actual = textWindow.getClass().getSimpleName();

        assertEquals("TextWindow", actual );
    }

    @Test
    public void shouldCallMethodsWithAccessSpecifiersAndParameterTypes() {
        Window windowImpl = createWindow();

        Arrays.stream(windowImpl.getClass().getDeclaredMethods())
                .map(method -> Modifier.toString(method.getModifiers()) +
                        " " + method.getReturnType().getName() +
                        " " + method.getName() +
                        "(" + getParameters(method) + ")")
                .forEach(System.out::println);

        int actual = windowImpl.getClass().getDeclaredMethods().length;

        assertEquals(18, actual);

    }

    @Test
    public void shouldCallSuperClassName(){
        TextWindow textWindow = new TextWindow();

        String superClass = textWindow.getClass().getSuperclass().getSimpleName();

        assertEquals("Window", superClass);
    }

    @Test
    public void shouldThrowExceptionProxy(){
        Window window = createWindow();

        IWindow windowProxy = (IWindow) Proxy.newProxyInstance(
                Window.class.getClassLoader(),
                Window.class.getInterfaces(),
                new MyInvocationHandler(window));

        String color = windowProxy.getColor();
        System.out.println(color);

        assertThrows(SetterCalledException.class, () -> windowProxy.setColor("blue"));
    }

    private String getParameters(Method method) {
        return Arrays.stream(method.getParameters())
                .map(parameter -> parameter.getType().getName() + " " + parameter.getName())
                .collect(Collectors.joining(","));
    }


    private Window createWindow() {
        return Window.builder()
                .left(5)
                .top(6)
                .right(2)
                .bottom(3)
                .color("white")
                .build();
    }


}
