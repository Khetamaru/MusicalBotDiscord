package fr.school.yisan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.jagrosh.jdautilities.command.CommandClientBuilder
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity

@SpringBootApplication
class YisanApplication

private const val TOKEN = "token" //Jeton Bot obtenu
private const val COMMAND_PREFIX = "!" //Préfixe de commande

suspend fun main() {
	val kord = Kord(TOKEN)

	kord.on<MessageCreateEvent> {//runs every time a message is created that our bot can read

		//ignore other bots, even ourselves. We only serve humans here!
		if(message.author?.isBot != false) return@on

		//check if our command is being invoked
		if(message.content != "!ping") return@on

		//all clear, give them the pong!
		message.channel.createMessage("pong!")
	}

	kord.login()
}