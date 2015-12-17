package tech.spencercolton.tasp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.generator.InternalChunkGenerator;
import org.bukkit.entity.Player;
import tech.spencercolton.tasp.Util.Config;
import tech.spencercolton.tasp.Util.M;

public class SetspawnCmd extends TASPCommand {

    public static final String syntax = "/setspawn [<x> <y> <z>] [world]";
    public static final String consoleSyntax = "/setspawn <x> <y> <z> <world>";
    public static final String name = "setspawn";
    public static final String permission = "tasp.setspawn";

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            if(args.length != 4) {
                Command.sendConsoleSyntaxError((ConsoleCommandSender)sender, this);
                return;
            }

            try {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                int z = Integer.parseInt(args[2]);

                World w = Bukkit.getWorld(args[3]);

                if(w == null) {
                    sendWorldNotFoundMessage(sender, args[3]);
                    return;
                }
                
                w.setSpawnLocation(x, y, z);
                sendSpawnSetMessage(sender, x, y, z, w.getName());
            } catch(NumberFormatException e) {
                Command.sendConsoleSyntaxError((ConsoleCommandSender)sender, this);
            }
        } else {
            switch(args.length) {
                case 0:
                    Location l = ((Player)sender).getLocation();
                    World w = ((Player)sender).getWorld();

                    w.setSpawnLocation(l.getBlockX(), l.getBlockY(), l.getBlockZ());
                    sendSpawnSetMessage(sender, l.getBlockX(), l.getBlockY(), l.getBlockZ(), w.getName());
                    break;
                case 3:
                    try {
                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        int z = Integer.parseInt(args[2]);

                        World w2 = ((Player)sender).getWorld();

                        w2.setSpawnLocation(x, y, z);
                        sendSpawnSetMessage(sender, x, y, z, w2.getName());
                    } catch(NumberFormatException e) {
                        Command.sendSyntaxError(sender, this);
                    }
                    break;
                case 4:
                    try {
                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        int z = Integer.parseInt(args[2]);

                        World w2 = Bukkit.getWorld(args[3]);

                        if(w2 == null) {
                            sendWorldNotFoundMessage(sender, args[3]);
                            return;
                        }

                        w2.setSpawnLocation(x, y, z);
                        sendSpawnSetMessage(sender, x, y, z, w2.getName());
                    } catch(NumberFormatException e) {
                        Command.sendSyntaxError(sender, this);
                    }
                    break;
                default:
                    Command.sendSyntaxError(sender, this);
                    break;
            }
        }
    }

    private void sendWorldNotFoundMessage(CommandSender s, String w) {
        s.sendMessage(Config.err() + "Couldn't find world \"" + w + "\"");
    }

    private void sendSpawnSetMessage(CommandSender s, int x, int y, int z, String world) {
        if(Command.messageEnabled(this, false))
            s.sendMessage(M.m("command-message-text.setspawn", Integer.toString(x), Integer.toString(y), Integer.toString(z), world));
    }

    @Override
    public String getSyntax() {
        return syntax;
    }

    @Override
    public String getConsoleSyntax() {
        return consoleSyntax;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean predictOthers(String[] args) {
        return false;
    }

}