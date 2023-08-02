package mainpackage;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class main {

    public static void main(String[] args) throws InterruptedException {

        String token = "MTEzNTg2MjQ3MzM4NDI3NTk2OA.GH9h7f.3L_Bd0W-fXUYrCq4QZFyH2O3ZFLDAAqU4K0l0M";
        String activity = "\uD83D\uDCDA | mit der Technik";

        JDABuilder b = JDABuilder.createDefault(token);
        b.setStatus(OnlineStatus.ONLINE);
        b.setActivity(Activity.playing(activity));

        b.addEventListeners(new gewinnspielbot());

        JDA jda = b.build();
        Guild server = jda.awaitReady().getGuildById("1135230702066090064");
        server.updateCommands().addCommands(
                Commands.slash("send-kodex", "Sende den Kodex."),
                Commands.slash("start-giveaway", "Starte ein Gewinnspiel")
        ).queue();
    }

}
