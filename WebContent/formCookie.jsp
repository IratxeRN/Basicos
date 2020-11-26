<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario para Cookies</title>
</head>
<body>

<form action="idioma" method="post" method="get">

	<label for="idioma">Elige idioma</label>
	
	<select name="idioma" >
		<option value="ingles" ${cookie.leng.value == 'ingles' ? 'selected' : ''}>Ingles</option>
		<option value="euskera" ${cookie.leng.value == 'euskera' ? 'selected' : ''}>Euskera</option>
		<option value="esperanto" ${cookie.leng.value == 'esperanto' ? 'selected' : ''}>Esperanto</option>
		<option value="arabe" ${cookie.leng.value == 'arabe' ? 'selected' : ''}>Arabe</option>
		<option value="suajili" ${cookie.leng.value == 'suajili' ? 'selected' : ''}>Suajili</option>
		<option value="mandarin" ${cookie.leng.value == 'mandarin' ? 'selected' : ''}>mandarin</option>
	</select>

	<button>Aceptar</button>
</form>

</body>
</html>