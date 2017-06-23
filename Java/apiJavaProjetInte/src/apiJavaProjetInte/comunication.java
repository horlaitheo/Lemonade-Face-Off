/**
 * @date 21/06/2017
 * @author Adrien Corre
 *
 */
/**
 * import necessaire au bon fonctionnement du programme.
 */
package apiJavaProjetInte;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * 
 * @author Adrien Corre
 * Déclaration de la classe communication
 */
public class comunication {
	
	private final String USER_AGENT = "Mozilla/5.0"; 					/**Parametre pris en compte pour les requête http */
	
	public static void main(String[] args) throws Exception {			/** Main pour run et/ou tester les requêtes*/

		comunication http = new comunication();							/**Déclaration d'une nouvelle instance de la classe communication  */

		//System.out.println("Testing 1 - Send Http GET request");		/**Affiche l'intérieur des parenthèses sur la console */
	//	http.sendGet();													/**Utilisation de la fonction sendGet() de l'objet http */ 

	////	System.out.println("\nTesting 2 - Send Http POST request");		/**Affiche l'intérieur des parenthèses sur la console */
	///	http.sendPost();												/**Utilisation de la fonction sendPost() de l'objet http */ 

		

		System.out.println("\nTesting 2 - Send Http POST request");		/**Affiche l'intérieur des parenthèses sur la console */
		http.GetWeather();												/**Utilisation de la fonction sendPost() de l'objet http */ 

	}
	
	
	/**
	 * Définitionn de la fonction sendGet()
	 * @throws Exception capture les exeptions qui peuvent apparaitre et envoie un message qui est directement pris de la classe mere
	 * int responseCode variable qui récupère le code retour émise par le serveur lors de la requête
	 */
	private void sendGet() throws Exception {

			String url = "http://limonade-equipe7.herokuapp.com/rdm";    	 /** url utilisé plus loin pour les requêtes prend le sting url */
			URL obj = new URL(url);                  						 /** Déclaration d'une nouvelle instance de la classe importé URL */
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();/** */
			con.setRequestMethod("GET");									 /** Utilisation de l'option (Passe en 'mode' GET) */
			con.setRequestProperty("User-Agent", USER_AGENT);				 /** Ajoute un header à la requête */
			int responseCode = con.getResponseCode();						 /**Déclare un int et Récupère la reponse du Get envoyé par le serveur et la stock dans une varibale*/
			
			System.out.println("\nSending 'GET' request to URL : " + url);	/** Affiche la requête envoyé  */
			System.out.println("Response Code : " + responseCode);			/**Affiche la réponse à la requête stocké dans la variable 'responseCode'*/
			
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));			/** Déclaration d'un nouvelle objet 'in' de type BuffereReader qui va contenir le flux de données entrant   */ 
			
			String inputLine;												/** Déclare un string pour stocker le conten lu du bufferReader */ 
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) { 
				response.append(inputLine);
			}																/** Boucle qui écrit dans response tant que inputLine (qui contient in.readLine) n'est pas  NULL */ 						
			in.close();

			
			System.out.println(response.toString());						/** Affiche le resultat en string de 'response'*/
	
	
	
	
		}
	
	/**
	 * Définitionn de la fonction Getmap()
	 * @throws Exception capture les exeptions qui peuvent apparaitre et envoie un message qui est directement pris de la classe mere
	 * int responseCode variable qui récupère le code retour émise par le serveur lors de la requête
	 */
	private void Getmap() throws Exception {

			String url = "http://limonade-equipe7.herokuapp.com/map";    	 /** url utilisé plus loin pour les requêtes prend le sting url */
			URL obj = new URL(url);                  						 /** Déclaration d'une nouvelle instance de la classe importé URL */
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();/** */
			con.setRequestMethod("GET");									 /** Utilisation de l'option (Passe en 'mode' GET) */
			con.setRequestProperty("User-Agent", USER_AGENT);				 /** Ajoute un header à la requête */
			int responseCode = con.getResponseCode();						 /**Déclare un int et Récupère la reponse du Get envoyé par le serveur et la stock dans une varibale*/
			
			System.out.println("\nSending 'GET' request to URL : " + url);	/** Affiche la requête envoyé  */
			System.out.println("Response Code : " + responseCode);			/**Affiche la réponse à la requête stocké dans la variable 'responseCode'*/
			
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));			/** Déclaration d'un nouvelle objet 'in' de type BuffereReader qui va contenir le flux de données entrant   */ 
			
			String inputLine;												/** Déclare un string pour stocker le conten lu du bufferReader */ 
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) { 
				response.append(inputLine);
			}																/** Boucle qui écrit dans response tant que inputLine (qui contient in.readLine) n'est pas  NULL */ 						
			in.close();

			
			System.out.println(response.toString());						/** Affiche le resultat en string de 'response'*/
	
	
	
	
		}
	

	/**
	 * Définitionn de la fonction Getmap()
	 * @return une liste de string contenant le temps
	 * @throws Exception capture les exeptions qui peuvent apparaitre et envoie un message qui est directement pris de la classe mere
	 * int responseCode variable qui récupère le code retour émise par le serveur lors de la requête
	 */
	private ArrayList GetWeather() throws Exception {

			String url = "http://localhost:5000/GET/metrology"/**"http://limonade-equipe7.herokuapp.com/GET/metrology"*/;    	 /** url utilisé plus loin pour les requêtes prend le sting url */
			URL obj = new URL(url);                  						 /** Déclaration d'une nouvelle instance de la classe importé URL */
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();/** */
			con.setRequestMethod("GET");									 /** Utilisation de l'option (Passe en 'mode' GET) */
			con.setRequestProperty("User-Agent", USER_AGENT);				 /** Ajoute un header à la requête */
			int responseCode = con.getResponseCode();						 /**Déclare un int et Récupère la reponse du Get envoyé par le serveur et la stock dans une varibale*/
			
			System.out.println("\nSending 'GET' request to URL : " + url);	/** Affiche la requête envoyé  */
			System.out.println("Response Code : " + responseCode);			/**Affiche la réponse à la requête stocké dans la variable 'responseCode'*/
			
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));			/** Déclaration d'un nouvelle objet 'in' de type BuffereReader qui va contenir le flux de données entrant   */ 
			
			String inputLine;												/** Déclare un string pour stocker le conten lu du bufferReader */ 
			StringBuffer response = new StringBuffer();
			
			
			
			while ((inputLine = in.readLine()) != null) { 
				response.append(inputLine);
			}																/** Boucle qui écrit dans response tant que inputLine (qui contient in.readLine) n'est pas  NULL */ 						
			in.close();
			
			System.out.println(response);
			ArrayList Weather = new ArrayList();
			JSONObject currentWeather= new JSONObject(response.toString());
			 Weather.add( currentWeather.getString("weather"));
			System.out.println(Weather);
			
			return  Weather;
			//System.out.println(response.toString());						/** Affiche le resultat en string de 'response'*/
	
	
	
	
		}
	
	
	
	
	
	/**
	 * 
	 * @throws Exception capture les exeptions qui peuvent apparaitre et envoie un message qui est directement pris de la classe mere
	 * Déclaration de la fonction sendPost
	 */
	
		private void sendPost() throws Exception {
			
			JSONObject sales= new JSONObject("{'sales':{'player':'toto','items':'limonade','quantity':'20'}}"); /**Déclaration d'une nouvelle instance de la classe JSONObject */
			
			
					
			String url = "http://limonade-equipe7.herokuapp.com/sales";											/**Définiton de la nouvelle route  */
			URL obj = new URL(url);																				/** Déclaration  d'une nouvelle instance de la classe URL */
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();									/**Déclaration d'une instance de la classe HttpURLConnection à qui on insére le cast de la fonction l'objet obj.openConnection() */
			con.setRequestMethod("POST");								 										/** Utilisation de l'option (Passe en 'mode' POST) */
			con.setRequestProperty("User-Agent", USER_AGENT);													/** Paramétre de la requête http (nav, safarie, mozilla...)  */
			con.setRequestProperty("Content-Type", "application/json");											/**Paramétrage du type de data  */
			
			
			con.setDoOutput(true);																				/**On utilise la fonction setDoOutput() de l'objet con avec le parametre true */
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(sales.toString());																	/**Envoie le contenue de sales stringifier */
			wr.flush();																							/**Nettoie le buffer  */
			wr.close();																							/**Ferme le link qui stream les datas reçu */

			int responseCode = con.getResponseCode();															/**Déclare un int et Récupère la reponse du Get envoyé par le serveur et la stock */ 
			System.out.println("\nSending 'POST' request to URL : " + url);										/**Affiche dans la console'\nSending 'POST' request to URL' puis le contenu de url */
			System.out.println("Post parameters : " + sales );													/**Affiche dans la console 'Post parameter' et le contenu de sales */
			System.out.println("Response Code : " + responseCode);												/**Affiche dans la console 'Response Code' plus le contenu de responseCode */ 
			

			
			con.disconnect();																					/**Met fin à la reqête http */

			
			

		}
	
}
	
	