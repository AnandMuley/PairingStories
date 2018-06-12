package com.abm.pairingstories.controllers.resolvers;

import com.abm.pairingstories.model.Authentication;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationArgumentResolver implements WebArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (Authentication.class.equals(methodParameter.getParameterType())) {
            ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
            HttpServletRequest request = servletWebRequest.getRequest();
            String emailId = request.getParameter("emailId");
            String password = request.getParameter("password");
            int yearsOfExperience = Integer.parseInt(request.getParameter("yearsOfExperience"));
            return new Authentication(emailId, password, Authentication.YearsOfExperience.FIVE);
        }
        return null;
    }
}
