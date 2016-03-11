package tech.spencercolton.tasp.Commands;

import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static java.lang.Integer.*;
import static org.bukkit.Bukkit.*;
import static tech.spencercolton.tasp.Commands.Command.*;
import static tech.spencercolton.tasp.Util.Message.Starve.*;

/**
 * @author Spencer Colton
 * @since 0.0.3
 */
public class StarveCmd extends TASPCommand {

    @Getter
    private final String syntax = "/starve [player] [amount]";

    @Getter
    private static final String name = "starve";

    @Getter
    private final String consoleSyntax = "/starve <player> [amount]";

    @Getter
    private final String permission = "tasp.feed";

    @Override
    public CommandResponse execute(CommandSender sender, String[] args) {
        if (sender instanceof ConsoleCommandSender && (args.length < 1 || args.length > 2)) {
            sendConsoleSyntaxError(sender, this);
            return CommandResponse.SYNTAX;
        }

        Player p = null;
        Integer amount = null;
        switch (args.length) {
            case 2: {
                try {
                    amount = parseInt(args[1]);
                    if (amount < 0) {
                        sendNegativeMessage(sender);
                        return CommandResponse.FAILURE;
                    }
                } catch (NumberFormatException e) {
                    sendGenericSyntaxError(sender, this);
                    return CommandResponse.SYNTAX;
                }
            }
            case 1: {
                p = getPlayer(args[0]);
                if (p == null) {
                    sendPlayerMessage(sender, args[0]);
                    return CommandResponse.PLAYER;
                }
            }
            case 0: {
                if (p == null) {
                    assert sender instanceof Player;
                    p = (Player) sender;
                }

                if (amount == null)
                    amount = p.getFoodLevel();
                if (amount > p.getFoodLevel())
                    amount = p.getFoodLevel();

                p.setFoodLevel(p.getFoodLevel() - amount);
                sendStarvedMessage(sender, amount, p);
                return CommandResponse.SUCCESS;
            }
            default: {
                sendConsoleSyntaxError(sender, this);
                return CommandResponse.SYNTAX;
            }
        }
    }

    @Override
    public String predictRequiredPermission(CommandSender sender, String... args) {
        return (args.length == 2 && !sender.equals(getPlayer(args[1]))) ? permission + ".others" : permission;
    }

}
