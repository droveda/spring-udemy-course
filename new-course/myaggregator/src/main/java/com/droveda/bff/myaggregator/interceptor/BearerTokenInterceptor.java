package com.droveda.bff.myaggregator.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class BearerTokenInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(BearerTokenInterceptor.class);

    private final BearerTokenDecoder<BearerToken, String> decoder;

    public BearerTokenInterceptor(final BearerTokenDecoder<BearerToken, String> decoder) {
        this.decoder = decoder;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("interceptor called - handler: {}", handler);

        if (handler instanceof HandlerMethod handlerMethod) {
            if (handlerMethod.getBean() instanceof ErrorController) {
                log.info("Skipping ErrorController");
            } else {
                String authorizationHeader = request.getHeader("Authorization");
                if (Objects.isNull(authorizationHeader) || authorizationHeader.trim().isEmpty()) {
                    log.warn("Authorization header is missing or empty");
                } else if (authorizationHeader.startsWith("Bearer ")) {
                    decoder.decode(authorizationHeader);
                }
            }
        }

        return true;
    }
}
