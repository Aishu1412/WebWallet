  
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #00203FFF">
		<div>
			<a href="<%= request.getContextPath() %>/RegisterController" class="navbar-brand"> QR Registration
			</a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%= request.getContextPath() %>/LoginController" class="nav-link">Login</a></li>
			<li><a href="<%= request.getContextPath() %>/SignUpController" class="nav-link">Signup</a></li>
			<li><a href="<%= request.getContextPath() %>/RegisterController" class="nav-link">Apply QR</a></li>
			<li><a href="<%= request.getContextPath() %>/AdminController" class="nav-link">Admin</a></li>
		</ul>
	</nav>
</header>