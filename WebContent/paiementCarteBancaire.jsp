<h1>Coordonnées bancaire</h1>
<form method="post" action="reglement">
	<input type="hidden" name="typePaiement" value="Carte Bancaire" />
	<table>
		<tr>
			<td>Numéro de carte</td>
			<td><input type="text" name="numeroCarte" /></td>
		</tr>
		
		<tr>
			<td>Date d'expiration</td>
			<td><input type="text" name="dateExpiration" /></td>
		</tr>
		
		<tr>
			<td>Cryptogramme</td>
			<td><input type="text" name="cryptogramme" /></td>
		</tr>
	
		<tr>
			<td colspan="2"><input type="submit" value="Paiement" /></td>
		</tr>
	</table>
</form>