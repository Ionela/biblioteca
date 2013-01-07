<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="extra">
	<hr>
	<div id="user-info">
		<img src="<c:url value='/resources/img/user.png'/>">
		<input type="hidden" value="${user.idUser}">
	
		<c:if test="${user.drepturi == 0}">
			<div id="select-user">Cartile Mele</div>
		</c:if>
		
		<c:if test="${user.drepturi != 0}">
			<div id="select-user">
				<select id="user-drop-down">
				  <option value="usedId1">User name 1</option>
				  <option value="usedId2">User name 2</option>
				  <option value="usedId3">User name 3</option>
				  <option value="usedId4">User name 4</option>
				</select>
				
				<c:if test="${user.drepturi == 2}">
					<img class="user-menu-img" id="edit-user" title="Modifica informatiile" src="<c:url value='/resources/img/edit.png'/>">
					<img class="user-menu-img" id="add-user" title="Adauga user nou" src="<c:url value='/resources/img/add_user.png'/>">
					<img class="user-menu-img" id="delete-user" title="Sterge user-ul selectat" src="<c:url value='/resources/img/delete.png'/>">
				</c:if>
			</div>
		</c:if>
	</div>
	
	<div class="clearFloat"></div>
	
	<div id="user-status">
		<div id="carti-imprumutate">
			<div id="header-imprumut">Carti Imptumutate</div>
			<table id="tabel-imprumuturi">
				<thead>
					<tr>
						<th class="head-titlu">Titlu</th>
						<th class="head-autori">Autori</th> 
						<th class="head-data">Data retur</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Titlu1</td>
						<td>Autor1, Autor2</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>Autor1, Autor2</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>Autor1, Autor2</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>Autor1, Autor2</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>Autor1, Autor2</td>
						<td>10-Feb-2012</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id="rezervari">
			<div id="header-rezervari">Carti Rezervate</div>
			<table id="tabel-rezervari">
				<thead>
					<tr>
						<th class="head-titlu">Titlu</th>
						<th>Din data</th>
						<th>Pana in data</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Titlu1</td>
						<td>5-Ian-2012</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>5-Ian-2012</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>5-Ian-2012</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>5-Ian-2012</td>
						<td>10-Feb-2012</td>
					</tr>
					<tr>
						<td>Titlu1</td>
						<td>5-Ian-2012</td>
						<td>10-Feb-2012</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div id="dialog-confirm-delete-user" title="Stergeti acest utilizator?">
    <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Utilizatorul selectat va fi sters definitiv. Toate imprumuturile si rezervarile sale vor fi anulate. Continuati?</p>
</div>

<div id="dialog-add-user">
	<!-- form id="add-carte-form" method="POST" action="/Biblioteca/books/add"-->
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Username:</div>
			<input type="text" id="add-user-username" class="input-add-carte" name="add-user-username"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Parola:</div>
			<input type="text" id="add-user-password" class="input-add-carte" name="add-user-password"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Nume complet</div>
			<input type="text" id="add-user-nume" class="input-add-carte" name="add-user-nume"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">E-mail</div>
			<input type="text" id="add-user-email" class="input-add-carte" name="add-user-email"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Telefon</div>
			<input type="text" id="add-user-telefon" class="input-add-carte" name="add-user-telefon"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Adresa</div>
			<input type="text" id="add-user-adresa" class="input-add-carte" name="add-user-adresa"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Drepturi</div>
			<input type="text" id="add-user-drepturi" class="input-add-carte" name="add-user-drepturi"/>
		</div>
	<!-- /form-->
</div>