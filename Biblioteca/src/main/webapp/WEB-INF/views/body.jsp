<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="body">
	<input type="hidden" id="drepturi-user" value="${user.drepturi}"/>

	<div id="export-pdf">
		<c:if test="${user.drepturi == 2}">
			<img id="import-books-img" alt="import" title="Incarca lista cartilor din fisier" src="<c:url value='/resources/img/import.png'/>" />
			<img id="add-book-img" alt="add" title="Adauga o carte noua" src="<c:url value='/resources/img/add.png'/>" />
		</c:if>
		<img id="export-pdf-img" alt="salveaza" title="Salveaza lista cartilor ca PDF" src="<c:url value='/resources/img/save.png'/>" />
	</div>
	
	<div id="filters">
		<input type="hidden" id="input-filter-page" name="input-filter-page" />
		<div id="filter-titlu">
			<input id="input-filter-titlu" type="text" name="input-filter-titlu"/>
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>" />
		</div>
		<div id="filter-autori">
			<input id="input-filter-autori" type="text" name="input-filter-autori"/>
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>" />
		</div>
		<div id="filter-an">
			<input id="input-filter-an" type="text" name="input-filter-an"/>
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>" />
		</div>
		<div id="filter-editura">
			<input id="input-filter-editura" type="text" name="input-filter-editura"/>
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>" />
		</div>
		<div id="filter-disponibil">
			<input id="input-filter-disponibil" type="text" name="input-filter-disponibil"/>
			<img alt="filter" src="<c:url value='/resources/img/filter.png'/>" />
		</div>
		<div class="clearFloat"></div>
	</div>
	
	<div id="divTableCarti">
		<table id="tabelCarti">
			<thead>
				<tr>
					<th id="main-head-titlu">Titlu</th>
					<th id="main-head-autori">Autori</th>
					<th id="main-head-an">An Aparitie</th>
					<th id="main-head-editura">Editura</th>
					<th id="main-head-disponibil">Disponibil</th>
					<th id="main-head-extra">Extra</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>">
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Coloana1</td>
					<td>Coloana2</td>
					<td>Coloana3</td>
					<td>Coloana4</td>
					<td>Coloana5</td>
					<td class="book-menu book-menu-td-hidden">
						<img id="book-details" class="book-menu-img book-details-img" alt="Detalii" title="Detalii" src="<c:url value='/resources/img/edit.png'/>" />
						<c:if test="${user.drepturi == 2}">
							<img id="book-delete" class="book-menu-img" alt="Sterge" title="Sterge cartea" src="<c:url value='/resources/img/delete.png'/>" />
						</c:if>
						
						<c:if test="${user.drepturi == 1}">
							<img id="book-lend" class="book-menu-img" alt="Imprumuta" title="Imprumuta" src="<c:url value='/resources/img/lend.png'/>" />
						</c:if>
					</td>
				</tr>
				
			</tbody>
		</table>
	
		<div id="controll">
			<div id="previous-page">
				<img alt="previous page" title="Pagina anterioara" src="<c:url value='/resources/img/previous.png'/>">
			</div>
			
			<div id="pages">
				<div id="previous-more">...</div>
				<div id="previous-2" class="page-button">1</div>
				<div id="previous-1" class="page-button">2</div>
				<div id="current">3</div>
				<div id="next-1" class="page-button">4</div>
				<div id="next-2" class="page-button">5</div>
				<div id="next-more">...</div>
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

<div id="dialog-add-carte">
	<!-- form id="add-carte-form" method="POST" action="/Biblioteca/books/add"-->
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Titlu cartii:</div>
			<input type="text" id="add-carte-titlu" class="input-add-carte" name="add-carte-titlu"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Autori:</div>
			<input type="text" id="add-carte-autori" class="input-add-carte" name="add-carte-autori"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Editura:</div>
			<input type="text" id="add-carte-editura" class="input-add-carte" name="add-carte-editura"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Anul publicarii:</div>
			<input type="text" id="add-carte-an" class="input-add-carte" name="add-carte-an"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Locul publicarii:</div>
			<input type="text" id="add-carte-loc" class="input-add-carte" name="add-carte-loc"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Perioada de imprumut:</div>
			<input type="text" id="add-carte-durata" class="input-add-carte" name="add-carte-durata"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">ISBN:</div>
			<input type="text" id="add-carte-isbn" class="input-add-carte" name="add-carte-isbn"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Cota:</div>
			<input type="text" id="add-carte-cota" class="input-add-carte" name="add-carte-cota"/>
		</div>
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Observatii:</div>
			<textarea rows="10" cols="50" id="add-carte-obs" name="add-carte-obs"></textarea>
		</div>
	<!-- /form-->
</div>

<div id="dialog-import-books">
	<form id="form-import-books" method="post" action="/Biblioteca/books/import" enctype="multipart/form-data">
		<div class="line-add-carte">
			<div class="eticheta-add-carte">Fisier:</div>
			<input type="file" id="books-file" name="books-file"/>
		</div>
	</form>
</div>