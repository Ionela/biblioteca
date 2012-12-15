<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="body">
	<div id="export-pdf">
		<c:if test="${user.drepturi == 2}">
			<img id="import-books-img" alt="import" title="Incarca lista cartilor din fisier" src="<c:url value='/resources/img/import.png'/>" />
			<img id="add-book-img" alt="add" title="Adauga o carte noua" src="<c:url value='/resources/img/add.png'/>" />
		</c:if>
		<img id="export-pdf-img" alt="salveaza" title="Salveaza lista cartilor ca PDF" src="<c:url value='/resources/img/save.png'/>" />
	</div>
	
	<div id="filters">
		<div id="filter-titlu">
			<input id="input-filter-titlu" type="text" />
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>">
		</div>
		<div id="filter-autori">
			<input id="input-filter-autori" type="text" />
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>">
		</div>
		<div id="filter-an">
			<input id="input-filter-an" type="text" />
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>">
		</div>
		<div id="filter-editura">
			<input id="input-filter-editura" type="text" />
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>">
		</div>
		<div id="filter-disponibil">
			<input id="input-filter-disponibil" type="text" />
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>">
		</div>
		<div class="clearFloat"></div>
	</div>
	
	<div id="divTableCarti">
		<table id="tabelCarti">
			<thead>
				<tr>
					<th>Titlu</th>
					<th>Autori</th>
					<th>An Aparitie</th>
					<th>Editura</th>
					<th>Disponibil</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
				</tr>
				
			</tbody>
		</table>
	
		<div id="controll">
			<div id="previous-page">
				<img alt="previous page" title="Pagina anterioara" src="<c:url value='/resources/img/previous.png'/>">
			</div>
			
			<div id="pages">
				... 1 2 3 ...
			</div>
			
			<div id="next-page">
				<img alt="next page" title="Pagina urmatoare"src="<c:url value='/resources/img/next.png'/>">
			</div>
		</div>
	</div>

	<c:if test="${authenticated == 'true'}">
		<%@include file="extra.jsp"%>
	</c:if>
</div>
