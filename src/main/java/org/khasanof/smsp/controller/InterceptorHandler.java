package org.khasanof.smsp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:59 AM
 * <br/>
 * Package: org.khasanof.smsp.controller
 */
@Slf4j
public class InterceptorHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
                + "]" + request.getRequestURI());

        return true;
    }
}
