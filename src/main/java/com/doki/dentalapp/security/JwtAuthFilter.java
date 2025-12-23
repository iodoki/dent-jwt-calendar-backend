package com.doki.dentalapp.security;
import com.doki.dentalapp.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // ❌ No Authorization header → continue as anonymous
        if (!StringUtils.hasText(authHeader) || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {
            // ⬅ Extract claims safely
            var claims = jwtService.getClaims(token);

          //  String userId = claims.get("userId", String.class);
            String username = claims.get("username", String.class);
            String role = claims.get("role", String.class);
            String clinicId = claims.get("clinicId", String.class);

            // ❌ If claims missing, reject token
            if (clinicId == null) {
                filterChain.doFilter(request, response);
                return;
            }

            // 🟢 Create your custom authentication token
            MyJwtAuthenticationToken authentication =
                    new MyJwtAuthenticationToken(
                            username,
                            role,
                            clinicId,
                            true // authenticated
                    );

            // 🟢 Set authentication for this request only (stateless)
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            // ❌ JWT invalid or expired → ignore and continue
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}