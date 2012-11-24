<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="header">
	<div id="left-header">
		<img src="<c:url value="/resources/img/logo.gif"/>"/>
	</div>
	
	<div id="central-header">
		<h1>Universitatea Babes Bolyai</h1>
		<h2>Facultatea de Matematica si Informatica</h2>
		<h3>Biblioteca</h3>
	</div>
	
	<div id="right-header">
		<div id="authentication-header">
			<c:if test="${authenticated == 'false'}">
				<form action="/Biblioteca/users/logIn" method="POST">
					<input type="text" id="userName" name="userName"/>
					<input type="password" id="password" name="password"/>
					<input type="submit" value="Log In" id="logIn">
				</form>
			</c:if>

			<c:if test="${authenticated == 'true'}">
				<div id="numeUtilizator">${user.nume}</div>
				<form action="/Biblioteca/users/logOut" method="POST">
					<input type="submit" value="Log Out" id="logOut">
				</form>
			</c:if>
		</div>	
	</div>
	
</div>
