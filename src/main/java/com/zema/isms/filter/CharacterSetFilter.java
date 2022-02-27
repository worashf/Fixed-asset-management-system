/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author ewawuye
 */
public class CharacterSetFilter implements Filter{
 
    @Override
    public void init(FilterConfig fc) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest  request, ServletResponse   response, FilterChain next) throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        next.doFilter(request, response);
    }
    @Override
    public void destroy() {
     
    }
}
