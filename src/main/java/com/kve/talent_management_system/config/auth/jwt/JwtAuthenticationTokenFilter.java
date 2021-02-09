package com.kve.talent_management_system.config.auth.jwt;

import com.kve.talent_management_system.config.auth.MyUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        // 从请求头中获取jwt信息
        String jwtToken = request.getHeader(jwtTokenUtil.getHeader());
        if(jwtToken != null && (!StringUtils.isEmpty(jwtToken))){
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken); //获取username的过程也相当于检测jwt令牌的合法性

            // 如果可以正确的从JWT中提取用户信息，并且该用户未被授权
            if(username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null){
                // 获取角色、权限等信息
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

                // 如果令牌在有效期内
                if(jwtTokenUtil.validateToken(jwtToken,userDetails)){
                    //给使用该JWT令牌的用户进行授权
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,
                                                                userDetails.getAuthorities());

                    // 将jwt令牌转换为spring security认识的token对象，交给spring security管理
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        }
        // 让过滤器链继续
        filterChain.doFilter(request,response);

    }
}