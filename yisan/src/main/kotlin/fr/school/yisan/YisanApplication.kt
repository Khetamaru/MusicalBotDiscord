package fr.school.yisan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.jagrosh.jdautilities.command.CommandClientBuilder
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity

@SpringBootApplication
class YisanApplication

private lateinit var jda: JDA
private const val TOKEN = "MY_TOKEN" //Jeton Bot obtenu
private const val COMMAND_PREFIX = "!" //Préfixe de commande

fun main(args: Array<String>) {

	runApplication<YisanApplication>(*args)
	//Générer un écouteur d'événements qui gère les commandes
	val commandClient = CommandClientBuilder()
			.setPrefix(COMMAND_PREFIX) //Préfixe de commande
			.setStatus(OnlineStatus.ONLINE) //Paramètres d'état en ligne
			.setActivity(Activity.watching("YouTube")) //Paramètres d'état (regarder, jouer, etc.)
			.build()

	jda = JDABuilder(AccountType.BOT)
			.setToken(TOKEN) //Définir le jeton
			.addEventListeners(commandClient) //set commandClient
			.build()
}
