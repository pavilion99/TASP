package tech.spencercolton.tasp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * The {@link TASPCommand} object containing the runtime information for the {@code fly} command.
 *
 * <table summary="Properties">
 *     <tr>
 *         <th style="font-weight:bold;">Property</th>
 *         <th style="font-weight:bold;">Value</th>
 *     </tr>
 *     <tr>
 *         <td>
 *             Name
 *         </td>
 *         <td>
 *             {@value name}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Permission
 *         </td>
 *         <td>
 *             {@code tasp.fly}
 *             <br>
 *             {@code tasp.fly.others}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Syntax
 *         </td>
 *         <td>
 *             {@value syntax}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Console Syntax
 *         </td>
 *         <td>
 *             /fly &lt;user&gt;
 *         </td>
 *     </tr>
 * </table>
 */
public class FlyCmd extends TASPCommand {

    /**
     * String containing the command's name.
     */
    public static final String name = "fly";


    /**
     * String containing the command's syntax.
     */
    public static final String syntax = "/fly [user]";


    /**
     * String containing the command's console syntax.
     */
    public static final String consoleSyntax = "/fly <user>";

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            if(args.length != 1) {
                Command.sendConsoleSyntaxError((ConsoleCommandSender)sender, this);
                return;
            }

            Player p = Bukkit.getPlayer(args[0]);

            if(p == null) {
                sender.sendMessage(ChatColor.RED + "Couldn't find player \"" + args[0] + ".\"  Please try again.");
                return;
            }

            p.setAllowFlight(true);

            p.setFlying(!p.isFlying());

            sendFlyingMessage(sender, p.isFlying(), p.getDisplayName());
        } else {
            switch(args.length) {
                case 0:
                    Player p = (Player)sender;
                    p.setAllowFlight(true);
                    p.setFlying(!p.isFlying());
                    sendFlyingMessage(sender, p.isFlying());
                    return;
                case 1:
                    Player p2 = Bukkit.getPlayer(args[0]);
                    if(p2 == null) {
                        sender.sendMessage(ChatColor.RED + "Couldn't find player \"" + args[0] + ".\"  Please try again.");
                        return;
                    }
                    p2.setAllowFlight(true);
                    p2.setFlying(!p2.isFlying());
                    sendFlyingMessage(sender, p2.isFlying(), p2.getDisplayName());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSyntax() {
        return syntax;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getConsoleSyntax() {
        return consoleSyntax;
    }


    private void sendFlyingMessage(CommandSender sender, boolean flying) {
        sender.sendMessage(ChatColor.GOLD + "Flying was " + ChatColor.DARK_RED + (flying ? "enabled" : "disabled") + ChatColor.GOLD + ".");
    }

    private void sendFlyingMessage(CommandSender sender, boolean flying, String n) {
        sender.sendMessage(ChatColor.GOLD + "Flying was " + ChatColor.DARK_RED + (flying ? "enabled" : "disabled") + ChatColor.GOLD + " for " + ChatColor.DARK_RED + n + ChatColor.GOLD + ".");
        Player p = Bukkit.getPlayer(n);
        if(p != null)
            p.sendMessage(ChatColor.GOLD + "Flying was " + ChatColor.DARK_RED + (flying ? "enabled" : "disabled") + ChatColor.GOLD + " by " + ChatColor.DARK_RED + sender.getName() + ChatColor.GOLD + ".");
    }

}