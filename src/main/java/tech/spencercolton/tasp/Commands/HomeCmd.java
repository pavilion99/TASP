package tech.spencercolton.tasp.Commands;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tech.spencercolton.tasp.Entity.Person;
import tech.spencercolton.tasp.Util.Message;

import static tech.spencercolton.tasp.Commands.Command.*;
import static tech.spencercolton.tasp.Entity.Person.*;

public class HomeCmd extends TASPCommand {

    @Getter
    private static final String name = "home";

    @Getter
    private final String syntax = "/home";

    @Getter
    private final String consoleSyntax = null;

    @Getter
    private final String permission = "tasp.home";

    @Override
    public void execute(CommandSender sender, String... args) {
        if (sender instanceof ConsoleCommandSender) {
            sendConsoleError(sender);
            return;
        }

        if (args.length != 0) {
            sendSyntaxError(sender, this);
            return;
        }

        Player p = (Player) sender;

        Person p2 = get(p);

        Location l = p2.getHome();

        if (l == null) {
            Message.Home.Error.sendNoHomeMessage(sender);
            return;
        }

        if (l.getWorld().equals(p.getWorld())) {
            p.teleport(l);
        } else {
            Message.Home.Error.sendWorldMessage(sender);
        }
    }

}
