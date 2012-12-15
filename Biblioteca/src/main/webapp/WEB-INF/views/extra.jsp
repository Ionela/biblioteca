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
					<!-- TODO: Administrator -> butoare pentru CRUD user -->
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
						<th>Data retur</th>
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