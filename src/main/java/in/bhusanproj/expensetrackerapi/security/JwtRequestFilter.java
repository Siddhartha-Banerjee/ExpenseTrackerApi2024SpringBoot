//package in.bhusanproj.expensetrackerapi.security;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		final String requestTokenHeader=request.getHeader("authorizetion");
//		
//		String jwtToken;
//		String username;
//		
//		if((requestTokenHeader != null)&&(requestTokenHeader.startsWith("Bearer ")))
//		{
//			jwtToken=requestTokenHeader.substring(7);
//		
//		
//		
//		
//			try {
//				username=jwtTokenUtil.getUsernameFromToken(jwtToken);
//			}
//			catch(IllegalArgumentException e)
//			{
//				throw new RuntimeException("unable to get jwt token");
//			}
//		}
//		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
//		{
//			UserDetails userDetails=userDetailsService.loadUserByUsername(username);
//			
//			if(jwtTokenUtil.validateToken(jwtToken,userDetails))
//			{
//				UserNmaePasswordAuthenticationToken authToken=
//						new UserNmaePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				
//				SecurityContextHolder.getContext().setAuthentication(authToken);
//			}
//		}
//		
//		filterChain.doFilter(request, response);
//	}
//
//}
