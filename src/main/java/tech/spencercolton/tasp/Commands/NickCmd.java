package tech.spencercolton.tasp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import lombok.Getter;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tech.spencercolton.tasp.Util.ColorChat;

/**
 * @author Spencer Colton
 */
public class NickCmd extends TASPCommand {

    @Getter
    private final String syntax = "/nick [name] [player] OR /nick [name] OR /nick";

    @Getter
    public static final String name = "nick";

    @Getter
    private final String consoleSyntax = "/nick <name> <player>";

    @Getter
    private final String permission = "tasp.nickname";

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 2 && sender instanceof ConsoleCommandSender) {
            Command.sendConsoleSyntaxError(sender, this);
            return;
        }

        Player p = null;
        String name = "@@RESET@@";
        switch (args.length) {
            case 2: {
                p = Bukkit.getPlayer(args[0]);
                if (p == null) {
                    Command.sendPlayerMessage(sender, args[0]);
                    return;
                }
            }
            case 1: {
                name = args[1];
            }
            case 0: {
                if (p == null) {
                    assert sender instanceof Player;
                    p = (Player) sender;
                }

                if(name.equalsIgnoreCase("@@RESET@@")) {
                    p.setDisplayName(p.getName());
                    return;
                }

                p.setDisplayName(ColorChat.color(name));
                // TODO Add message for nicknaming

                return;
            }
            default: {
                Command.sendGenericSyntaxError(sender, this);
            }
        }
    }

}
