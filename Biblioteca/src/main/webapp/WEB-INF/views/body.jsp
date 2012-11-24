<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="body">

	<div id="filters"></div>
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
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				<tr>
					<th>Coloana1</th>
					<th>Coloana2</th>
					<th>Coloana3</th>
					<th>Coloana4</th>
					<th>Coloana5</th>
				</tr>
				
			</tbody>
		</table>
	
		<div id="controll">
		</div>
	</div>

	<c:if test="${authenticated == 'true'}">
		<div id="extra">
			${user.drepturi}
		</div>
	</c:if>
</div>
