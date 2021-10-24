import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import sensitive.Token;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws LoginException {
        Token token = new Token();

        JDA jda = JDABuilder.createDefault(token.getToken()).build();

    }
}
